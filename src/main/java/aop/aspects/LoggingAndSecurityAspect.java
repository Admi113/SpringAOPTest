package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class LoggingAndSecurityAspect {

    @Pointcut("execution(* *(..))")
    private void absoluteAnyMethodFromAnywhere() {

    }

    @Pointcut("absoluteAnyMethodFromAnywhere()&&!execution(* addMagzine())")
    private void notAddMagzine() {
    }

    @Pointcut("execution (* aop.UniLibrary.get*())")
    private void allGetMethodsFromUnilibrary() {
    }

    @Pointcut("execution (* aop.UniLibrary.add*())")
    private void allAddMethodsFromUnilibrary() {
    }

    @Pointcut("allAddMethodsFromUnilibrary()||allGetMethodsFromUnilibrary()")
    private void allAddAndGetMethodsFromUniLibrary() {

    }

    @Before("allGetMethodsFromUnilibrary()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: + log#1");
    }

    @Before("allAddMethodsFromUnilibrary()")
    public void beforeAddLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: + log#2");
    }

    @Before("allAddAndGetMethodsFromUniLibrary() ")
    public void beforeAddAndGetLoggiingAdvice() {
        System.out.println("beforeGetLoggingAdvice: + log#3");
    }

    @Before("notAddMagzine()")
    public void beforeAlmostAllExceptAddMagzine(){
        System.out.println("beforeGetLoggingAdvice: + log#33");
    }


//    @Pointcut("execution(* get*())   ")
//    private void allGetMethods() {
//    }
//
////            ТАК БЫЛО  ДО ОБЪЕДИНЕНИЯ ПОД ОДНИМ ПОИНТКАТОМ
////    @Before("execution(* get*())   ")
////    public void beforeGetLoggingAdvice() {
////        System.out.println("beforeGetLoggingAdvice: попытка получить журнал/книгу");
////    }
////
////    @Before("execution(* get*())   ")
////    public void beforeGetSecurityAdvice() {
////        System.out.println("beforeGetSecurityAdvice: попытка прав на получение " +
////                "книги/журнала");
////    }
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: попытка получить журнал/книгу");
//    }
//
//    @Before("allGetMethods() ")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: попытка прав на получение " +
//                "книги/журнала");
//
//    }
}
