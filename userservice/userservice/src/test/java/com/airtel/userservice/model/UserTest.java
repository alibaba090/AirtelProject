package com.airtel.userservice.model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserTest {

    @InjectMocks
    User user = Mockito.spy(User.class);

    @Test
    public void testGetUserId(){
        user.setUserId(1);
        int id = user.getUserId();
        Assert.isTrue(id == 1, "Incorrect user Id");
    }

    @Test
    public void testGetName(){
        user.setName("TEST_NAME");
        String name = user.getName();
        Assert.isTrue(name.equals("TEST_NAME"), "Incorrect user Name");
    }

    @Test
    public void testGetDepartment(){
        user.setDepartment("TEST_DEPARTMENT");
        String department = user.getDepartment();
        Assert.isTrue(department.equals("TEST_DEPARTMENT"), "Incorrect user Department");
    }
}
