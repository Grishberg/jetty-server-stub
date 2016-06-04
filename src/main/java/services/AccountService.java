package services;

/**
 * Created by g on 03.06.16.
 */
public interface AccountService {
    String auth(String login, String password);
    boolean checkToken(String accessToken);
}
