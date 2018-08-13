package models;

import db.DBAuthor;
import db.DBBook;

public class Runner {
    public static void main(String[] args) {

        //SAVE AUTHOR
        Author author3 = new  Author("Stoo");
        DBAuthor.save(author3);
        // SAVE BOOK
        Book book = new Book("On The Road");
        DBBook.save(book);
        // FIND BY AUTHOR ID
        Author authorResult = DBAuthor.findById(1);
        System.out.println(authorResult.getName());
        // FIND BY BOOK ID
        Book bookResult = DBBook.findById(1);
        System.out.println(bookResult.getName());

        //LISTS
        //SEED AUTHORS
        Author author = new  Author("Lloyd");
        DBAuthor.save(author);
        Author author2 = new  Author("Peter");
        DBAuthor.save(author2);
        //SEED BOOKS
        Book book2 = new Book("Pragmatic Ruby");
        DBBook.save(book2);
        Book book3 = new Book("Java for beginners");
        DBBook.save(book3);

        //LIST AUTHORS
        System.out.println(DBBook.getAll());
        System.out.println(DBAuthor.getAll());

        //UPDATE AUTHOR BY ID
        DBAuthor.update(1,"Author  1");
        DBAuthor.update(2,"Author No 2");
        DBAuthor.update(3,"Author  3");

        //UPDATE BOOK BY ID
        DBBook.update(1,"Book1");
        DBBook.update(2,"Book 2");
        DBBook.update(3,"Book 3");



    }



}
