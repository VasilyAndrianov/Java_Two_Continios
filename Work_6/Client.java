package Work_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class Client {
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        start();
    }

    private void start() {
        try {
            System.out.println("Клиент запущен...");
            Socket socket = new Socket("127.0.0.1", 8189);
            System.out.println("Информация о сокете: " + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        //В дальнейшем "Server" хаменить на имя, которое будет приносить сокет
                        System.out.println(new Date() + " Server: " + message);
                    }
                } catch (EOFException e) {
                    System.out.println("Сервер недоступен. Соединение закрыто.");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                if (socket.isClosed()) {
                    System.out.println("Выход! Досвидания.");
                    System.out.println("=======================");
                    break;
                }
                out.writeUTF(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
