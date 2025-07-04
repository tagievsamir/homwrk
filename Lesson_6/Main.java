import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

//Задание 1
//
//Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов
//со средним баллом < 3, а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
//Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
//Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.

        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Chemistry", 5);
        grades.put("English", 4);
        grades.put("Math", 3);

        Student student1 = new Student("Sergey Bogrov", "B-2", 1, grades);

        StudentManager manager = new StudentManager();
        manager.addStudent(student1);
        student1.upCourse();
        manager.printStudents(new HashSet<>(manager.getStudents()), 2);

//Задание 2
//
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
//телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//тогда при запросе такой фамилии должны выводиться все телефоны.

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("ivan", 799999);
        phoneBook.get("ivan");
    }
}