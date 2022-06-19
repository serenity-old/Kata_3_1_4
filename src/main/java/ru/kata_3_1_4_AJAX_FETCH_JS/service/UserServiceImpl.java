package ru.kata_3_1_4_AJAX_FETCH_JS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata_3_1_4_AJAX_FETCH_JS.DAO.RoleDAO;
import ru.kata_3_1_4_AJAX_FETCH_JS.DAO.UserDAO;
import ru.kata_3_1_4_AJAX_FETCH_JS.model.Role;
import ru.kata_3_1_4_AJAX_FETCH_JS.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Старый
//
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
        public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(long id) {
        return null;
    }


    @Override
    public void save(User user) {
        userDAO.save(passwordCoder(user));
    }


    @Override
    public void update(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @PostConstruct
    public void addDefaultUser() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(1L).get());
        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(roleDAO.findById(1L).get());
        roleSet2.add(roleDAO.findById(2L).get());
        User user1 = new User("Иван", "Иванов", (byte) 33, "ivan@mail.ru", "user", "user", roleSet);
        User user2 = new User("Анатолий", "Чубайс", (byte) 52, "admin@mail.ru", "admin", "admin", roleSet2);
        save(user1);
        save(user2);
    }
}

