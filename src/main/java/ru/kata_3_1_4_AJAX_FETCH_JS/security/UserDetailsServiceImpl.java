package ru.kata_3_1_4_AJAX_FETCH_JS.security;

import ru.kata_3_1_4_AJAX_FETCH_JS.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata_3_1_4_AJAX_FETCH_JS.model.User;

@javax.transaction.Transactional
@Service()
public class UserDetailsServiceImpl implements UserDetailsService {

    UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}

