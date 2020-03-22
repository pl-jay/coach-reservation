package lk.pathum.user.service;

import lk.pathum.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
    User fetchUser(Integer id);

    User update(Integer id);
}
