package lk.pathum.repository;

import lk.pathum.model.User;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
}
