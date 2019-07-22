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
    public String index(Model model)
    {
        model.addAttribute("people", personRepository.findAll());

        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("peoplePets", peoplePetsRepository);
        return "index";
    }

    @GetMapping("/addpet")
    public String addPet(Model model)
    {
        model.addAttribute("pet", new Pet());
        model.addAttribute("people", personRepository.findAll());
        return "pet";
    }


    @PostMapping("/processpet")
    public String processForm(@ModelAttribute("pet") Pet pet,
                              @RequestParam("peoplePets") long... ids)
    {
        // for multiple selection
        for (long id : ids){
            Person person = personRepository.findById(id).get();
            PeoplePets peoplePets = new PeoplePets(person, pet);
            petRepository.save(pet);
            peoplePetsRepository.save(peoplePets);
        }
        return "redirect:/";
    }

//    @GetMapping("/addowner")
//    public String ownerForm(Model model){
//        model.addAttribute("person", new Person());
//        return "owner";
//    }
//
//    @PostMapping("/processowner")
//    public String saveOwner(@Valid Person person, Model model)
//    {
//        personRepository.save(person);
//        return "redirect:/";
//    }

    @PostConstruct
    public void fillTables()
    {
        Person person = new Person();
        person.setPersonName("Graham Norton");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Michael McIntyre");
        personRepository.save(person);

        person= new Person();
        person.setPersonName("Gary Barlow");
        personRepository.save(person);
    }
}
