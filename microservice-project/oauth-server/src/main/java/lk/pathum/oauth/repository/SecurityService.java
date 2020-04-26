package lk.pathum.oauth.repository;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
