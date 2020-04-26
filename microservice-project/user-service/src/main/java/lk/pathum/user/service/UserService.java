package lk.pathum.user.service;

import lk.pathum.user.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAll();
    UserModel save(UserModel user);
    UserModel fetchUser(Integer id);

    UserModel update(Integer id);
}
