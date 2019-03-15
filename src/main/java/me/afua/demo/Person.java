package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "pet")
    private Set<PeoplePets> peoplePets;

    public Person() {
        peoplePets = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PeoplePets> getPeoplePets() {
        return peoplePets;
    }

    public void setPeoplePets(Set<PeoplePets> peoplePets) {
        this.peoplePets = peoplePets;
    }
}
