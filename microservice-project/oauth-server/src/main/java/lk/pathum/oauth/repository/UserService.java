package lk.pathum.oauth.repository;

import lk.pathum.oauth.model.User;

public interface UserService {
    User save(String user_name, String email, String password,String role);
    User findById(Integer id);
    User findByUsername(String username);
}
