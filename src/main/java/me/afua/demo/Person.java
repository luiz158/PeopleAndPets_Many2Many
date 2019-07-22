package me.afua.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String personName;

    @OneToMany(mappedBy = "pet")
    private Set<OwnersAndPets> pets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Set<OwnersAndPets> getPets() {
        return pets;
    }

    public void setPets(Set<OwnersAndPets> pets) {
        this.pets = pets;
    }
}
