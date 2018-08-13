package models;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {
    private String name;
    private int id;

    public Author(){
    }

    public Author(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "author_name")
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
}
