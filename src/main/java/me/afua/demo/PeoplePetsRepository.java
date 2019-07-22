package me.afua.demo;

import org.springframework.data.repository.CrudRepository;

public interface PeoplePetsRepository
        extends CrudRepository<PeoplePets,Long> {
    Iterable<PeoplePets> findAllByOwner_Id(Long owner_id);
}
