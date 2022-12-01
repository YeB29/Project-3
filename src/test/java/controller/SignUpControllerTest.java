package controller;

import Model.Database;
import Model.Login;
import Model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SignControllerTest {
    @Test
    void test() {
        User user1 = new User("yeb", "123", "yeb@gmail.com", "Younes", "M", "03-11-1999", "ADMIN");
        ArrayList<User> users = Database.getInstance().getUsers();
        for (User user : users) {
            if (user.getUsername().equals("yeb")) {
                assertTrue(Login.getInstance().userExist("yeb", "123"));
            }
        }

    }
}