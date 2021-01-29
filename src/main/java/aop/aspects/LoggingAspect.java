package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* *(..))")
//    private void absoluteAnyMethodFromAnywhere() {
//
//    }
//
//    @Pointcut("absoluteAnyMethodFromAnywhere()&&!execution(* addMagzine())")
//    private void notAddMagzine() {
//    }
//
//    @Pointcut("execution (* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUnilibrary() {
//    }
//
//    @Pointcut("execution (* aop.UniLibrary.add*())")
//    private void allAddMethodsFromUnilibrary() {
//    }
//
//    @Pointcut("allAddMethodsFromUnilibrary()||allGetMethodsFromUnilibrary()")
//    private void allAddAndGetMethodsFromUniLibrary() {
//
//    }
//
//    @Before("allGetMethodsFromUnilibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: + log#1");
//    }
//
//    @Before("allAddMethodsFromUnilibrary()")
//    public void beforeAddLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: + log#2");
//    }
//
//    @Before("allAddAndGetMethodsFromUniLibrary() ")
//    public void beforeAddAndGetLoggiingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: + log#3");
//    }
//
//    @Before("notAddMagzine()")
//    public void beforeAlmostAllExceptAddMagzine(){
//        System.out.println("beforeGetLoggingAdvice: + log#33");
//    }


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
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature" + signature);
        System.out.println("signature.getMethod() ="
                + signature.getMethod());
        System.out.println("signature.getReturnType() ="
                + signature.getReturnType());
        System.out.println("signature.getName() ="
                + signature.getName());

        if(signature.getName().equals("addBook")){
            Object[] arguments  = joinPoint.getArgs();
            for(Object obj:arguments){
                if(obj instanceof Book){
                    Book myBook = (Book)obj;
                    System.out.println("Информация о книге: название "
                            + myBook.getName());
                } else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет " +obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: попытка получить журнал/книгу");
        System.out.println("_____________________________________");

    }

//    @Before("allGetMethods() ")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: попытка прав на получение " +
//                "книги/журнала");
//
//    }
}
