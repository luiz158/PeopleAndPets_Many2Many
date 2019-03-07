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
    private Set<OwnersAndPets> owners;

//    private
//    @ManyToMany
//    private Set<Owner> owners;

    public Pet() {
       //owners = new HashSet<>();
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

 //   public Set<Owner> getOwners() {
 //       return owners;
 //   }

//    public void setOwners(Set<Owner> owners) {
//        this.owners = owners;
//    }

    public Set<OwnersAndPets> getOwners() {
        return owners;
    }

    public void setOwners(Set<OwnersAndPets> owners) {
        this.owners = owners;
    }
}
