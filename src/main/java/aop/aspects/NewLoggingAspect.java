package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(String returnBook())")
    public String aroundReturnBookLoggingAdvice
            (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку" +
                " пытаются вернуть книгу");
        String bookName = null;
        try {
            bookName = (String) proceedingJoinPoint.proceed();

        } catch (Exception e){
            System.out.println("Было выброшено исключение: "+ e.getMessage());
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку" +
                " успешно возвращают книгу");
        return bookName;
    }
}
