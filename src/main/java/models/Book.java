package models;


import javax.persistence.*;

@Entity
@Table(name = "books")

public class Book {
    private String name;
    private int id;

    public Book(){
    }

    public Book(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public int getId() {
        return id;
    }
    @Column(name = "book_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
