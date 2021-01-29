package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();
    public void addStudents(){
        Student student1= new Student("FirstName",5,5.5);
        Student student2 = new Student("SecondName",4,6.5);
        Student student3 = new Student("ThirdName",2,6.5);
        students.add(student3);
        students.add(student2);
        students.add(student1);
    }
    public List<Student> getStudents(){
        System.out.println("Начало выполнения метода getStudents");
        System.out.println(students.get(3));
        System.out.println("Info from method getStudents:");
        System.out.println(students);
        return students;
    }
}
