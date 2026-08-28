import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Spongebob Squarepants", new Contact("Spongebob Squarepants", "111-111-2322"));
        contacts.put("Patrick Star", new Contact("Patrick Star", "123-232-8847"));
        contacts.put("Sandy Cheeks", new Contact("Sandy Cheeks", "439-235-3425"));
        contacts.put("Gary the Snail", new Contact("Gary the Snail", "325-934-0293"));

        // Step 5: look up a contact 
        String contactName = "Ada Lovelace";

        if(contacts.get(contactName) != null) {
            System.out.println(contacts.get(contactName));
        } else {
            System.out.println("Contact not found.");
        }

        // Step 6: print sorted list 

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println();
        System.out.println("=== All Contacts ===");

        for(int i=0; i<sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
    } 
}
