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
    public String index(Model model) {
        model.addAttribute("petlist", petRepository.findAll());
        model.addAttribute("ownerlist", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("aPet", new Pet());
        model.addAttribute("ownerlist", personRepository.findAll());
        return "pet";
    }

    @RequestMapping("/savepet")
    public String savePet(@ModelAttribute("aPet") Pet pet,
                          Model model) {
        petRepository.save(pet);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables() {
        Person p = new Person();
        p.setMyName("John Smith");
        personRepository.save(p);

        p = new Person();
        p.setMyName("Owen Richards");
        personRepository.save(p);

        p = new Person();
        p.setMyName("Ama Baidoo");
        personRepository.save(p);
    }
}
