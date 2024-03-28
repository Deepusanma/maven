package org.mobin.first;

import jakarta.persistence.*;

@Entity
@Table(name = "persons_tbl")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "firstname",nullable = false)
    private String fName;


    @Column(name = "lastname",nullable = false)
    private String lName;

    @Column(name = "email" , unique = true )
    private String email;


    @Column(name = "is_active")
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
