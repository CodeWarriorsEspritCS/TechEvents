package server;

/* --!!!Important!!!-- Delete lines containing a comment that says 'for debugging' for improving a performance*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Server {
    Map<String, DataOutputStream> clients;

    Server() {
        clients = Collections.synchronizedMap
                (new HashMap<String, DataOutputStream>());
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(10001);
            System.out.println("Server Started");
            while(true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress()
                        + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");

                ServerReceiver serverReceiver = new ServerReceiver(socket);
                ServerReceiver thread = serverReceiver;
                thread.start();
            }
        } catch(IOException e) {
            System.out.println("Conncetion Failed");
        } finally {
            SocketUtil.close(serverSocket);
        }
    }//start()

    public void broadCast(String msg) {
        Iterator<String> it = clients.keySet().iterator();

        while(it.hasNext()) {
            try {
                String name = it.next();
                DataOutputStream out = clients.get(name);
                out.writeUTF(msg);
            } catch(IOException e) {
                System.out.println("Map Failed");
            }
        } //while()
    } //broadCast

    public static void main(String[] args) {
        new Server().start();
    }

    /*-----------------------------------------------------------------------------------*/

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;

        ServerReceiver(Socket _socket) {
            this.socket = _socket;

            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch(IOException e) {
                System.out.println("Stream Failed");
            }
        }//constructor

        @Override
        public void run() {
            String name = "Unknown";
            try {
                name = dis.readUTF();
                broadCast(name + " : Connected");
                clients.put(name, dos);
                System.out.println("Current User : " + clients.size());

                while (dis != null) {
                    broadCast(name + " : " + dis.readUTF());
                } //while
            } catch(IOException e) {
                System.out.println("Read Failed");
            } finally {
                //it means client has disconnected
                broadCast(name + " : Disconnected");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() //
                        + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
            }//finally
        }//run
    }//ServerReceiver
}//ServerClass