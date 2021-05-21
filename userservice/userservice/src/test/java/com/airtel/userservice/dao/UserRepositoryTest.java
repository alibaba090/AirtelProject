package com.airtel.userservice.dao;

import com.airtel.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    public void init(){
        user = new User();
        user.setName("NAME");
        user.setDepartment("DEPARTMENT");
    }

    @Test
    public void itShouldSaveUser(){
        user = testEntityManager.merge(user);
        Assert.isTrue(userRepository.findById(user.getUserId()).get().equals(user), "Users not equal");
    }

    @Test
    public void itShouldFindByName(){
        user = testEntityManager.merge(user);
        Assert.isTrue(userRepository.findByName(user.getName()).get().equals(user), "Users not equal");
    }

    @Test
    public void itShouldFindByDepartment(){
        user = testEntityManager.merge(user);
        Assert.isTrue(userRepository.findByDepartment(user.getDepartment()).get().equals(user), "Users not equal");
    }
}
