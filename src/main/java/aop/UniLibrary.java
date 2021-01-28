package aop;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary extends AbstractLibrary {
    public void getBook() {
        System.out.println("Берем книгу из UniLabrary");
    }

    public void getMagazine() {
        System.out.println("Берем журнал из UniLabrary");
    }

    public void returnMagzine() {
        System.out.println("Возвращаем журнал в UniLabrary");
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу в UniLabrary");
    }

    public void addMagzine() {
        System.out.println("Добавляем журнал в UniLabrary");
    }

    public void addBook() {
        System.out.println("Добавляем книгу в UniLabrary");
    }

}
