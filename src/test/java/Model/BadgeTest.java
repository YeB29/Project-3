package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {
    @Test
    void BadgeTest(){
        User user =new User("yeb","123","yeb@gmail.com","Younes","M","03-11-1999","ADMIN");
        Badge rank = new Badge(user);

        assertFalse("silver".equals(rank.getRank()));
        assertFalse("Bronze".equals(rank.getRank()));
        assertFalse("Gold".equals(rank.getRank()));
    }

}