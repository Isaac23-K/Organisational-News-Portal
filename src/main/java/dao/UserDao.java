package dao;

import models.User;

import java.util.List;

public interface UserDao {
    //create
    void add(User user);

    //read
    List<User> getAll();

    //delete
    void deleteById(int id);
    void clearAll();
}
