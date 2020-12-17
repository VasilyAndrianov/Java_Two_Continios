package Work_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String name;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final Chat chat;


    public ClientHandler(Socket socket, Chat chat) {
        this.chat = chat;
        name = String.valueOf(socket.getPort());
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }

        listen();
    }

    public String getName() {
        return name;
    }

    private void listen() {
        new Thread(() -> {
            doAuth();
            receiveMessage();
        }).start();
    }

    private void doAuth() {
        sendMessage("Please enter credentials. Sample [-auth login password]");
        try {
            /**
             * -auth login password
             * sample: -auth l1 p1
             **/
            while (true) {
                String mayBeCredentials = in.readUTF();
                if (mayBeCredentials.startsWith("-auth")) {
                    String[] credentials = mayBeCredentials.split("\\s");
                    String mayBeNickname = chat.getAuthenticationService()
                            .findNicknameByLoginAndPassword(credentials[1], credentials[2]);
                    if (mayBeNickname != null) {
                        if (!chat.isNicknameOccupied(mayBeNickname)) {
                            sendMessage("[INFO] Auth OK");
                            name = mayBeNickname;

                            chat.broadcastMessage(String.format("[%s] logged in", name));
                            chat.subscribe(this);


                            return;
                        } else {
                            sendMessage("[INFO] Current user is already logged in.");
                        }
                    } else {
                        sendMessage("[INFO] Wrong login or password.");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
                String message = in.readUTF();
                if (message.startsWith("/")){
                    if (message.startsWith("/exit")) {
                        chat.unsubscribe(this);
                        chat.broadcastMessage(String.format("[%s] logged out", name));
                        break;
                    }
                    if (message.startsWith("/")) {
                        String[] tokens = message.split("\\s");
                        String nickname = tokens[1];
                        String mess = message.substring(4 + nickname.length());
                        chat.clientToClientMessage(this, nickname, mess);
                    }
                    continue;
            }
            chat.broadcastMessage(String.format("[%s]: %s", name, message));

            } catch (IOException e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }
}
