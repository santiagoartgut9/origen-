package edu.eci.cvds.tdd.library.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void ShouldEqualsConstructorWithName(){
        User user = new User("Diego", "123");
        assertEquals(user.getName(), "Diego");
    }

    @Test
    public void ShouldEqualsIdCompareWithConstructorMethod(){
        User user = new User("Andres", "312");
        user.setId("312");
        assertEquals(user.getId(), "312");
    }

    @Test
    public void ShouldEqualsSettersWithIdAndName(){
        User user = new User("Sebastian", "100087651");
        user.setId("18338");
        user.setName("Cardona");
        assertEquals("18338", user.getId());
        assertEquals("Cardona", user.getName());
    }


}
