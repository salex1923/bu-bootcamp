import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 
  private Contact c;

  @BeforeEach
  void setUp() {
    c = new Contact("Ada Lovelace", "+1 617 555 0101");
  }
 
  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    assertEquals("Ada Lovelace", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(c.toString().contains("Ada Lovelace"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(c.toString().contains("555 0101"));
  }

  @Test
  void constructor_sameNameHandling() {
    Contact co = new Contact("Ada Lovelace", "555-555-5555");
    co = new Contact("Ada Lovelace", "444-444-4444");
    assertNotEquals(c, co);
  }
}
