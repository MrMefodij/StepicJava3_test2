package account;

public interface AccountService {
    void singUp(String login, String password);
    boolean signIn(String login, String password);
    boolean signIn(String login, String password, String email);
}
