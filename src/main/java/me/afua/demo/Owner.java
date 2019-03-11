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
    private Set<OwnersAndPets> ownerAndPets;

    public Owner() {
        ownerAndPets = new HashSet<>();
    }

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

    public Set<OwnersAndPets> getOwnerAndPets() {
        return ownerAndPets;
    }

    public void setOwnerAndPets(Set<OwnersAndPets> ownerAndPets) {
        this.ownerAndPets = ownerAndPets;
    }
}
