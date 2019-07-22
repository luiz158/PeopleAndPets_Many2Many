package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
        model.addAttribute("owners", personRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String petForm(Model model)
    {
        model.addAttribute("pet", new Pet());
        model.addAttribute("owners", personRepository.findAll());
        return "petform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Pet pet, BindingResult result,
                          Model model)
    {
        if (result.hasErrors()){
            model.addAttribute("owners", personRepository.findAll());
            return "petform";
        }
        petRepository.save(pet);
        return "redirect:/";
    }

    @GetMapping("/addowner")
    public String ownerForm(Model model){
        model.addAttribute("person", new Person());
        return "owner";
    }

    @PostMapping("/processowner")
    public String saveOwner(@Valid Person person, BindingResult result,
                            Model model){
        if (result.hasErrors()){
            return "owner";
        }
        personRepository.save(person);
        return "redirect:/";
    }

//    @PostConstruct
//    public void fillTables()
//    {
//        Person p = new Person();
//        p.setPersonName("John Smith");
//        personRepository.save(p);
//
//        p = new Person();
//        p.setPersonName("Owen Richards");
//        personRepository.save(p);
//
//        p= new Person();
//        p.setPersonName("Ama Baidoo");
//        personRepository.save(p);
//    }
}
