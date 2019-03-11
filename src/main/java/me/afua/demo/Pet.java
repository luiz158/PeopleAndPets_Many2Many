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

    @OneToMany(mappedBy = "owner")//, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OwnersAndPets> petAndOwners;

    public Pet() {
        petAndOwners = new HashSet<>();
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

    public Set<OwnersAndPets> getPetAndOwners() {
        return petAndOwners;
    }

    public void setPetAndOwners(Set<OwnersAndPets> petAndOwners) {
        this.petAndOwners = petAndOwners;
    }
}
