package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class PetController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model)
    {

        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/addpet")
    public String addPet(Model model)
    {
        model.addAttribute("people", personRepository.findAll());

        model.addAttribute("pet", new Pet());
        return "pet";
    }

    @RequestMapping("/processpet")
    public String savePet(@ModelAttribute("pet") Pet pet, Model model)
    {
        petRepository.save(pet);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables()
    {
        Person p = new Person();
        p.setPersonName("John Smith");
        personRepository.save(p);

        p = new Person();
        p.setPersonName("Owen Richards");
        personRepository.save(p);

        p= new Person();
        p.setPersonName("Ama Baidoo");
        personRepository.save(p);
    }
}
