package me.afua.demo;

import javax.persistence.*;

@Entity
public class OwnersAndPets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne//(fetch = FetchType.EAGER)//@JoinColumn(name = "owner")
    private Owner owner;

    @ManyToOne//(fetch = FetchType.EAGER)//@JoinColumn(name = "petid")
    private Pet pet;

    public OwnersAndPets() {
        owner = new Owner();
        pet = new Pet();
    }

    public OwnersAndPets(Owner owner, Pet pet) {
        this.owner = owner;
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
