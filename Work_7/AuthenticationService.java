package Work_7;

import java.util.Set;

public class AuthenticationService {
    private final Set<CredentialsEntry> entries;

    public AuthenticationService() {
        entries = Set.of(
                new CredentialsEntry("l1", "p1", "nick1"),
                new CredentialsEntry("l2", "p2", "nick2"),
                new CredentialsEntry("l3", "p3", "nick3")
        );
    }

    public String findNicknameByLoginAndPassword(String login, String password) {
        for (CredentialsEntry entry : entries) {
            if (entry.getLogin().equals(login) && entry.getPassword().equals(password)) {
                return entry.getNickname();
            }
        }
        return null;
    }



    public static class CredentialsEntry {
        private final String login;
        private final String password;
        private final String nickname;

        public CredentialsEntry(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }


        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getNickname() {
            return nickname;
        }
    }
}

