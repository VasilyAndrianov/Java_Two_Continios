package Work_7;

public interface Chat {
    void broadcastMessage(String message);
    void clientToClientMessage(ClientHandler client, String nickname, String message);
    boolean isNicknameOccupied(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();
}
