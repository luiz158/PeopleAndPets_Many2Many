package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String personName;

    @OneToMany(mappedBy = "owner")
    private Set<PeoplePets> peoplePets;

    public Person(){
        peoplePets = new HashSet<>();
    }

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

    public Set<PeoplePets> getPeoplePets() {
        return peoplePets;
    }

    public void setPeoplePets(Set<PeoplePets> peoplePets) {
        this.peoplePets = peoplePets;
    }
}
