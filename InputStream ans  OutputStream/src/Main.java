import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

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


        Path filePath = Path.of("contacts.txt");
        if (!(Files.exists(filePath))){
            try {
                Files.createFile(filePath);
                System.out.println("File created successfully: " + filePath.toAbsolutePath());
            } catch (IOException exception) {
                System.out.println("Error creating file.");
                exception.printStackTrace();
            }
        }
        
        try {
            System.out.println("Contact created successfully!");
            Files.write(filePath, contactList.toString().getBytes(), StandardOpenOption.WRITE);
        } catch (IOException exception) {
            System.out.println("Error writing contact list.");
            exception.printStackTrace();
        }
        readAllContacts();

    }
    public static List<Contact> readAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        Path filePath = Path.of("contacts.txt");

        try {
            List<String> string = Files.readAllLines(filePath);

            for (String contact : string) {
                String[] words = contact.split(",");
                contactList.add(new Contact(words[0], words[1]));
                System.out.println("The contacts in the file: "+ contact);
            }

        } catch (IOException exception) {
            System.out.println("Error with reading contact list.");
            exception.printStackTrace();
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