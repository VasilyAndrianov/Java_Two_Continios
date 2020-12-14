package Work_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        start();
    }

    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server is up and run...");
            System.out.println("Server info: " + serverSocket);

            System.out.println("Server is waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());


            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("-exit")){
                            System.out.println("Server close");
                            break;
                        }
                        //В дальнейшем "Client" хаменить на имя, которое будет приносить сокет
                        System.out.println(new Date() + " Client: " + message);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String mess = scanner.nextLine();
                out.writeUTF(mess);
            }
        } catch (IOException e) {
            close();
        }
    }

    private void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
