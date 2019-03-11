package me.afua.demo;

import org.springframework.data.repository.CrudRepository;

public interface OwnersAndPetsRepository extends CrudRepository<OwnersAndPets,Long> {
    Iterable<OwnersAndPets> findAllByOwner_Id(Long owner_id);
    Iterable<OwnersAndPets> findAllByPet_Id(Long owner_id);
}
