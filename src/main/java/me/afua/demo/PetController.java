package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PetController {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnersAndPetsRepository ownersAndPetsRepository;

    @RequestMapping("/")
    public String index( Model model) {
        model.addAttribute("petlist", petRepository.findAll());
        model.addAttribute("ownerlist", ownerRepository.findAll());
        model.addAttribute("ownersandpetlist", ownersAndPetsRepository.findAll());
        return "index";
    }

   /* @RequestMapping("/{id}")
    public String index2( @PathVariable("id") long id, Model model) {
        List<OwnersAndPets> result = (ArrayList<OwnersAndPets>) ownersAndPetsRepository.findByOwner_Id(id);
        for(OwnersAndPets o : result){
            System.out.println("First Element = " +o.getPet().getPetName());
        }
        model.addAttribute("petlistbyowner", result );
        model.addAttribute("petlist", petRepository.findAll());
        model.addAttribute("ownerlist", ownerRepository.findAll());
        return "index";
    }
*/
    @RequestMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("aPet", new Pet());
        model.addAttribute("petowners", ownerRepository.findAll());
        return "pet";
    }

    @RequestMapping("/savepet")
    public String savePet(@ModelAttribute("aPet") Pet pet, //for object
                          @RequestParam("owners") long id,//value of html field.
                          Model model) {
        petRepository.save(pet);
        Owner owner = ownerRepository.findById(id).get();
        OwnersAndPets ownersAndPets = new OwnersAndPets(owner, pet);
        ownersAndPetsRepository.save(ownersAndPets);
        return "redirect:/";
    }

    //It works as a DatLoader. It runs one time after the constructor.
    @PostConstruct
    public void fillTables() {
        Owner p = new Owner();
        p.setOwnerName("John Smith");
        ownerRepository.save(p);

        p = new Owner();
        p.setOwnerName("Owen Richards");
        ownerRepository.save(p);

        p = new Owner();
        p.setOwnerName("Ama Baidoo");
        ownerRepository.save(p);
    }
}