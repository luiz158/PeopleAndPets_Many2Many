package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnersAndPetsRepository ownersAndPetsRepository;

    @GetMapping("/")
    public String index( Model model) {
        model.addAttribute("owners", ownerRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("petsbyowner", ownersAndPetsRepository.findAllByOwner_Id(1L) );

       // model.addAttribute("ownersandpets", ownersAndPetsRepository.findAll());
        return "index";
    }

    @RequestMapping("/{id}")
    public String index2( @PathVariable("id") long id, Model model) {
        model.addAttribute("owners", ownerRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("petsbyowner", ownersAndPetsRepository.findAllByOwner_Id(id) );
        return "index";
    }

    @GetMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("aPet", new Pet());
        model.addAttribute("owners", ownerRepository.findAll());
        return "pet";
    }

    @RequestMapping("/savepet")
    public String savePet(@ModelAttribute("aPet") Pet pet, //coming from object
                          @RequestParam("owners") long id,//coming from field.
                          Model model) {
        petRepository.save(pet);
        Owner owner = ownerRepository.findById(id).get();
        OwnersAndPets ownersAndPets = new OwnersAndPets(owner, pet);
        ownersAndPetsRepository.save(ownersAndPets);
        return "redirect:/"+id;
    }

    //It works as a DataLoader. It runs once after the constructor.
    @PostConstruct
    public void fillTables() {
        Owner owner = new Owner();
        owner.setOwnerName("John Smith");
        ownerRepository.save(owner);

        owner = new Owner();
        owner.setOwnerName("Owen Richards");
        ownerRepository.save(owner);

        owner = new Owner();
        owner.setOwnerName("Ama Baidoo");
        ownerRepository.save(owner);
    }
}