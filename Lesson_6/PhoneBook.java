//Задание 2
//
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
//телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//тогда при запросе такой фамилии должны выводиться все телефоны.

import java.util.HashSet;
import java.util.TreeMap;

public class PhoneBook {
    private TreeMap<String, HashSet<Integer>> phoneBook = new TreeMap<>();
    private HashSet<Integer> usedPhones = new HashSet<>();


    public void add(String surname, Integer phoneNumber) {
        if (usedPhones.contains(phoneNumber)) {
            System.out.println("This phone number already exists");
            return;
        }
        usedPhones.add(phoneNumber);

        HashSet<Integer> phones = phoneBook.get(surname);
        if (phones == null) {
            phones = new HashSet<>();
            phoneBook.put(surname, phones);
        }
        phones.add(phoneNumber);
    }

    public void get(String surname) {
        HashSet<Integer> phones = phoneBook.get(surname);
        if (phones != null) {
            System.out.println(surname + phones);
        }
    }
}
