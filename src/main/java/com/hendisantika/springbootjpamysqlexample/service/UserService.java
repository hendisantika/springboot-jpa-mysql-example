package com.hendisantika.springbootjpamysqlexample.service;

import com.hendisantika.springbootjpamysqlexample.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-jpa-mysql-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-02
 * Time: 19:33
 */
public interface UserService {
    void createUser(User user);

    List<User> getUser();

    User findById(long id);

    User update(User user, long l);

    void deleteUserById(long id);

    User updatePartially(User user, long id);
}
