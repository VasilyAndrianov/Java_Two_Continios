package Work_8.application;

import Work_8.client.ClientChatAdapter;

public class ClientApp {
    public static void main(String[] args) {
        new ClientChatAdapter("localhost", 8888);
    }
}
