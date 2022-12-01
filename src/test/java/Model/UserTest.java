package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void checkVillagerProfession () {
        User user =new User("yeb","123","yeb@gmail.com","Younes","M","03-11-1999","ADMIN");

        assertEquals("yeb",user.getUsername());
        assertEquals("yb@gmail.com",user.getEmail());
        assertEquals("123",user.getPassword());


    }
}