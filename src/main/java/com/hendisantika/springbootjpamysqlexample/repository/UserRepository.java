package com.hendisantika.springbootjpamysqlexample.repository;

import com.hendisantika.springbootjpamysqlexample.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-jpa-mysql-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-02
 * Time: 19:33
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
