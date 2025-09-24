package r5a08.tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserGreetingTest {

    @Test
    public void testFormatGreeting_withNormalName() throws UserGreetingFailureException {
        // Arrange
        String nom = "Alice";

        // Act
        String result = UserGreeting.formatGreeting(nom);

        // Assert
        assertEquals("Bonjour, Alice", result);
    }

    @Test
    public void testFormatGreeting_withAnotherName() throws UserGreetingFailureException {
        // Arrange
        String nom = "Bob";

        // Act
        String result = UserGreeting.formatGreeting(nom);

        // Assert
        assertEquals("Bonjour, Bob", result);
    }

    @Test
    public void testFormatGreeting_withEmptyName() {
        // Arrange
        String nom = "";

        // Act / Assert
        UserGreetingFailureException exception = assertThrows(UserGreetingFailureException.class, () -> {
            UserGreeting.formatGreeting(nom);
        });
        assertEquals("Le nom ne peut pas être vide.", exception.getMessage());
    }

    @Test
    public void testFormatGreeting_withLongName() {
        // Arrange
        String nom = "ThisIsTooLong";

        // Act / Assert
        UserGreetingFailureException exception = assertThrows(UserGreetingFailureException.class, () -> {
            UserGreeting.formatGreeting(nom);
        });
        assertEquals("Le nom ne doit pas dépasser 10 caractères.", exception.getMessage());
    }

    @Test
    public void testFormatGreeting_withSpecialCharacters() {
        // Arrange
        String nom = "Alice@123";

        // Act / Assert
        UserGreetingFailureException exception = assertThrows(UserGreetingFailureException.class, () -> {
            UserGreeting.formatGreeting(nom);
        });
        assertEquals("Le nom ne doit contenir que des lettres et des chiffres.", exception.getMessage());
    }

    @Test
    public void testFormatGreeting_withSpaceInName() {
        // Arrange
        String nom = "Alice Dupont";

        // Act / Assert
        UserGreetingFailureException exception = assertThrows(UserGreetingFailureException.class, () -> {
            UserGreeting.formatGreeting(nom);
        });
        assertEquals("Le nom ne doit contenir que des lettres et des chiffres.", exception.getMessage());
    }


    @Test
    public void testFormatGreeting_withNullName() {
        // Arrange
        String nom = null;

        // Act / Assert
        UserGreetingFailureException exception = assertThrows(UserGreetingFailureException.class, () -> {
            UserGreeting.formatGreeting(nom);
        });
        assertEquals("Le nom ne peut pas être vide.", exception.getMessage());
    }
}
