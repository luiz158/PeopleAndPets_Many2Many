package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
public class PetController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    PeoplePetsRepository peoplePetsRepository;

    @RequestMapping("/")
    public String index( Model model) {
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("people", personRepository.findAll());
        model.addAttribute("peoplepets", peoplePetsRepository);
        return "index";
    }

    @RequestMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("people", personRepository.findAll());
        return "pet";
    }

    @RequestMapping("/processpet")
    public String savePet(@ModelAttribute("pet") Pet pet, //coming from view's object
                          @RequestParam("peoplePets") long... ids //coming from field of view's object.
                          ) {
        for(long id : ids){
            Person person = personRepository.findById(id).get();
            PeoplePets peoplePets = new PeoplePets(person, pet);
            petRepository.save(pet);
            peoplePetsRepository.save(peoplePets);
        }
        return "redirect:/";
    }

    //It works as a DataLoader. It runs once after the constructor.
    @PostConstruct
    public void fillTables() {
        Person person = new Person();
        person.setName("John Smith");
        personRepository.save(person);

        person = new Person();
        person.setName("Owen Richards");
        personRepository.save(person);

        person = new Person();
        person.setName("Ama Baidoo");
        personRepository.save(person);
    }
}