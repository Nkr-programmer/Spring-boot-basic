package com.bookrestapi.bookapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="author_id")
private int id;
private String firstName;
private String lastName;
private String language;
@OneToOne(mappedBy = "author")
@JsonBackReference
private Book book;


public Author(int id, String firstName, String lastName, String language) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.language = language;
}
public Author() {
}
public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getLanguage() {
        return language;
    }
@Override
public String toString() {
    return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", language=" + language + "]";
}
public void setId(int id) {
    this.id = id;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public void setLanguage(String language) {
    this.language = language;
}



}
