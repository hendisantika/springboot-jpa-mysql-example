package com.hendisantika.springbootjpamysqlexample.service;

import com.hendisantika.springbootjpamysqlexample.entity.User;
import com.hendisantika.springbootjpamysqlexample.exception.ResourceNotFoundException;
import com.hendisantika.springbootjpamysqlexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-jpa-mysql-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-02
 * Time: 19:34
 */
@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
    }

    public List<User> getUser() {
        // TODO Auto-generated method stub
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    public User update(User user, long l) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    public void deleteUserById(long id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }

    public User updatePartially(User user, long id) {
        // TODO Auto-generated method stub
//        Optional<User> usr = findById(id);
//        usr.isPresent(){
//            usr.get();
//        }
//        usr.get().setCountry(user.getCountry());
//        return userRepository.save(usr);
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setCountry(user.getCountry());
                    return userRepository.save(user1);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }
}
