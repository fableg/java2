package hw3;

import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        IPhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Abuzyarov", "926-554-99-89");
        phoneBook.add("Hamzina", "926-666-555-9999");
        phoneBook.add("Abuzyarov", "966-112-1484");
        phoneBook.add("Solid Snake", "966-545-2132");

        Set<String> allSurname = phoneBook.getAllSurnames();
        for (String surname : allSurname) {
            Set<String> phone = phoneBook.get(surname);
            System.out.printf("%s: %s%n", surname, phone);
        }
    }
}
