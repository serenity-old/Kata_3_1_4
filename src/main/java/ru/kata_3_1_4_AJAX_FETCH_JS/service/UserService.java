package ru.kata_3_1_4_AJAX_FETCH_JS.service;

import ru.kata_3_1_4_AJAX_FETCH_JS.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll ();
    User getById(long id);
    void save(User user);

    void deleteById(long id);

    void update(User user);
    User findByUsername(String username);
    void addDefaultUser();
    User passwordCoder(User user);
}


