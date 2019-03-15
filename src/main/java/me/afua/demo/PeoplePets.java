package me.afua.demo;

import javax.persistence.*;

@Entity
public class PeoplePets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne//(fetch = FetchType.EAGER)//@JoinColumn(name = "owner_id")
    private Person owner;

    @ManyToOne//(fetch = FetchType.EAGER)//@JoinColumn(name = "pet_id")
    private Pet pet;

    public PeoplePets() {
        owner = new Person();
        pet = new Pet();
    }

    public PeoplePets(Person owner, Pet pet) {
        this.owner = owner;
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
