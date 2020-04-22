package lk.pathum.repository;

import lk.pathum.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    User findById(Integer id);
    User findByUsername(String username);
}
