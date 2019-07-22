package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String petName;

    @OneToMany(mappedBy = "pet")
    private Set<PeoplePets> peoplePets;

    public Pet(){
        peoplePets = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Set<PeoplePets> getPeoplePets() {
        return peoplePets;
    }

    public void setPeoplePets(Set<PeoplePets> peoplePets) {
        this.peoplePets = peoplePets;
    }
}
