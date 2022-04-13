package com.hospital.management.system.dao;

import com.hospital.management.system.config.DbConfig;
import com.hospital.management.system.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private final UserDao DAO = new UserDao();

    private static final String TEST_USER_ID = "harrypotter";
    private static final String TEST_PASSWORD = "harry123";
    private static final String TEST_FIRST_NAME = "Harry";

    @Test
    public void testValidateLogin(){
        UserEntity userEntity = DAO.validateLogin(TEST_USER_ID, TEST_PASSWORD);
        assertNotNull(userEntity);
        assertEquals(TEST_USER_ID,  userEntity.getUserId());
        assertEquals(TEST_PASSWORD,  userEntity.getPassword());
    }

    @Test
    public void testCreateAccount(){
        UserEntity userEntity = DAO.createAccount("Jon", "Snow", "12/8/1996", "03333333333", "jonsnow", "jon123", "Doctor");
        assertNotNull(userEntity);
    }

    @Test
    public void testIsUserExist(){
        boolean userExits = DAO.isUserExist(TEST_USER_ID);
        assertTrue(userExits);
    }

    @Test
    public void testIsUserNotExist(){
        boolean userExits = DAO.isUserExist("bob");
        assertFalse(userExits);
    }



}