import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContact() {
        Contact contact = new Contact("12345", "Tymon", "Theriot", "9855551234", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("Tymon", contact.getFirstName());
        assertEquals("Theriot", contact.getLastName());
        assertEquals("9855551234", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testBadContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tymon", "Theriot", "9855551234", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tymon", "Theriot", "9855551234", "123 Main St");
        });
    }

    @Test
    public void testBadFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Theriot", "9855551234", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Longfirstname", "Theriot", "9855551234", "123 Main St");
        });
    }

    @Test
    public void testBadLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", null, "9855551234", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Longlastname", "9855551234", "123 Main St");
        });
    }

    @Test
    public void testBadPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Theriot", null, "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Theriot", "985555123", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Theriot", "98555abcde", "123 Main St");
        });
    }

    @Test
    public void testBadAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Theriot", "9855551234", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tymon", "Theriot", "9855551234", "123 Main Street That Is Way Too Long");
        });
    }
}
