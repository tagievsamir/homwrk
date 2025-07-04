//Задание 1
//
//Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов
//со средним баллом < 3, а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
//Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
//Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.

import java.util.ArrayList;
import java.util.Set;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        try {
            if (student.averageGrade() < 3) {
                students.remove(student);
            }
        } catch (IllegalStateException e) {
            System.out.println("Cannot delete student " + student.getName() + ": no grades available.");
        }
    }

    public void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
