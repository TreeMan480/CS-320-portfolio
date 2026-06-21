import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1001", "Tymon", "Theriot", "9855551234", "123 Main St");

        service.addContact(contact);

        assertEquals("Tymon", service.getContact("1001").getFirstName());
    }

    @Test
    public void testDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1001", "Tymon", "Theriot", "9855551234", "123 Main St");
        Contact contact2 = new Contact("1001", "Mike", "Smith", "5045552222", "456 Oak St");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1001", "Tymon", "Theriot", "9855551234", "123 Main St");

        service.addContact(contact);
        service.deleteContact("1001");

        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("1001");
        });
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1001", "Tymon", "Theriot", "9855551234", "123 Main St");

        service.addContact(contact);

        service.updateFirstName("1001", "Mike");
        service.updateLastName("1001", "Smith");
        service.updatePhone("1001", "5045552222");
        service.updateAddress("1001", "456 Oak St");

        assertEquals("Mike", service.getContact("1001").getFirstName());
        assertEquals("Smith", service.getContact("1001").getLastName());
        assertEquals("5045552222", service.getContact("1001").getPhone());
        assertEquals("456 Oak St", service.getContact("1001").getAddress());
    }
}
