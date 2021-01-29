package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("BeforeGetStudentsLoggingAdvice: логтруем получение"
//                + "списка студентов перед методом getStudents");
//    }
//    @AfterReturning(pointcut = "execution(* getStudents())",returning = "students")
//    public void afterGetStudentsLoggingAdvice(List<Student> students) {
//        Student first = students.get(0);
//        first.setName("Mr." + first.getName());
//        double avgGrade = first.getAvgGrade();
//        first.setAvgGrade(++avgGrade);
//
//
//
//        System.out.println("afterGetStudentsLoggingAdvice: логтруем получение"
//                + "списка студентов после работы метода getStudents");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())",throwing = "throwable")
//    public void afterThrowingGetStudentsAdvice(Throwable throwable){
//        System.out.println("afterThrowingGetStudentsAdvice: логируем выброс исключения");
//        System.out.println("было выброшено исключение: " +throwable);
//    }
    @After("execution(* getStudents())")
    public void afterGetsStudentsAdvice(){
        System.out.println("afterGetsStudentsAdvice: метод нормально закончил работу" +
                " или выбросил исключение");
    }
}
