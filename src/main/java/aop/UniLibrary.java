package aop;

import aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary extends AbstractLibrary {
    public void getBook() {
        System.out.println("Берем книгу из UniLabrary");
        System.out.println("_____________________________________");
    }

    public void getMagazine() {
        System.out.println("Берем журнал из UniLabrary");
        System.out.println("_____________________________________");

    }

    public void returnMagzine() {
        System.out.println("Возвращаем журнал в UniLabrary");
        System.out.println("_____________________________________");

    }

    public String returnBook() {
        int err = 10 / 0;
        System.out.println("Возвращаем книгу в UniLabrary");
        return "SomeBookName";
    }

    public void addMagzine() {
        System.out.println("Добавляем журнал в UniLabrary");
        System.out.println("_____________________________________");

    }

    public void addBook(String presonName, Book book) {
        System.out.println("Добавляем книгу в UniLabrary");
        System.out.println("_____________________________________");

    }

}
