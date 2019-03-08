package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerAndPetsService {
    private Set<OwnersAndPets> pairs;

    @Autowired
    public OwnerAndPetsService() {
        pairs = new HashSet<>();
    }

    public Set<OwnersAndPets> getPairs() {
        return pairs;
    }

    public void setPairs(Set<OwnersAndPets> pairs) {
        this.pairs = pairs;
    }

    public void add(OwnersAndPets pair) {
        pairs.add(pair);
    }
}
