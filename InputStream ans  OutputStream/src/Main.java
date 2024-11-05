import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        Contact contact1 = new Contact("Willie", "+1234567890");
        Contact contact2 = new Contact("Johny", "+2234567890");
        Contact contact3 = new Contact("Kris", "+3234567890");
        Contact contact4 = new Contact("Waylon", "+4234567890");
        Contact contact5 = new Contact("Alan", "+5234567890");
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt")))
        {
            for (Contact strc : contactList){
                writer.write(strc.toString() + "\n");
                writer.flush();
                System.out.println("Data is flushed to the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        readAllContacts();
    }
    
    public static List<Contact> readAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String lineRead;
            while ((lineRead = reader.readLine()) != null) {
                String[] words = lineRead.split(",");
                contactList.add(new Contact(words[0], words[1]));
            }
            System.out.println("Data in the file: ");
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactList;
    }
}


//В main створити List<Contact > з 5 контактами
//Записати до файлу список контактів які мають телефон і імя
//Використовуючи 
//try (BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))) { ... }
//
//Після цього створити метод readAllContacts - який буде читати список контактів з файлу і конвертувати іх до
//List<Contact> - метод повинен повертати  List<Contact> Використовуючи
//try (BufferedReader reader=new BufferedReader(new FileReader(fileName))) { ... } з trycatch