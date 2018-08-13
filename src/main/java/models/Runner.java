package models;

import db.DBAuthor;
import db.DBBook;

public class Runner {
    public static void main(String[] args) {
        // create new author and books
        Author author = new  Author("Stoo");
        DBAuthor.save(author);
        Book book = new Book("On The Road");
        DBBook.save(book);
    }
}
