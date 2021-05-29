package hw3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

public class PhoneBook implements IPhoneBook{

    private final Map<String, Set<String>> phoneBySurname;

    public PhoneBook() {
        phoneBySurname = new TreeMap<>();
    }

    @Override
    public void add(String surname, String phoneNumber) {
        Set<String> phones = getPhones(surname);
        phones.add(phoneNumber);
    }

    private Set<String> getPhones(String surname) {
        Set<String> phones = phoneBySurname.getOrDefault(surname, new HashSet<>());
        if (phones.isEmpty()) {
            phoneBySurname.put(surname,phones);
        }

           return phones;




    }

    @Override
    public Set<String> get(String surname) {
        return getPhones(surname);
    }

    @Override
    public Set<String> getAllSurnames() {
        return phoneBySurname.keySet();
    }
}
