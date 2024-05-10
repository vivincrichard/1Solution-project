package cretioproject.try1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Getter
//@Setter
//
//public class AuthorEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    private String biography;
//
//    @ManyToMany(mappedBy = "authors")
//    @JsonBackReference // This breaks the circular reference in JSON serialization
//    private List<BookEntity> books;
//
//}

@Getter
@Setter

public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String biography;

    @ManyToMany(mappedBy = "authors")
    @JsonBackReference
    private List<BookEntity> books;

    // Getter for bookIsbn
    public List<Long> getBooksIsbn() {
        List<Long> isbnList = new ArrayList<>(); // Create a list to store ISBNs
        for (BookEntity book : books) { // Iterate over the list of books
            isbnList.add(book.getIsbn()); // Add the ISBN of each book to the list
        }
        return isbnList; // Return the list of ISBNs
    }

}