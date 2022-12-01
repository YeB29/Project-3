package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeroepTest {
    @Test
            void beroepTest() {
        User user = new User("yeb", "123", "yeb@gmail.com", "Younes", "M", "03-11-1999", "ADMIN");

        Beroep beroep = new Beroep(user, "Carpenter");
        assertEquals("yeb", user.getUsername());
        //assertEquals("Carpenter", beroep.getNaam());
    }

}