package Code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    User user;

    @BeforeEach
    void setUp() {
       user = new User();
    }
    @Test
    void exceptionTesting() {
        // set up user
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> user.setAge(56));
        assertEquals("Age must be an Integer.", exception.getMessage());
    }
}
