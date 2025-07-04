//Задание 1
//
//Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов
//со средним баллом < 3, а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
//Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
//Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.

import java.util.HashMap;

public class Student {
    private String name;
    private String group;
    private int course;
    private HashMap<String, Integer> grades;

    public Student(String name, String group, int course, HashMap<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public int averageGrade() {
        if (grades.size() == 0) {
            throw new IllegalStateException("No grades available");
        }
        int sum = 0;
        for (Integer grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void upCourse() {
        try {
            if (averageGrade() >= 3) {
                course++;
            }
        } catch (IllegalStateException e) {
            System.out.println("Cannot delete student " + getName() + ": no grades available.");
        }
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public HashMap<String, Integer> getGrades() {
        return new HashMap<>(grades);
    }
}
