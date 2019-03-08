package me.afua.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ownerName;

    @OneToMany(mappedBy = "pet")//, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OwnersAndPets> pets;

    public Owner() {
        //pets = new HashSet<>();
    }

//    @ManyToMany(mappedBy = "owners")
//    private Set<Pet> pets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Set<OwnersAndPets> getPets() {
        return pets;
    }

    public void setPets(Set<OwnersAndPets> pets) {
        this.pets = pets;
    }
}
