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

    @OneToMany(mappedBy = "owner")
    private Set<OwnersAndPets> owners;

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

    public Set<OwnersAndPets> getOwners() {
        return owners;
    }

    public void setOwners(Set<OwnersAndPets> owners) {
        this.owners = owners;
    }
}
