  ####Alternative Approach
  ###Java
PetController.java

  ```
        Map<Owner, List<Pet>>  map = new HashMap<>();

        for(Owner owner :ownerRepository.findAll()){
            List<Pet> list = new ArrayList<>();
            for(OwnersAndPets op :ownersAndPetsRepository.findAllByOwner_Id(owner.getId())){ //get the id from view
                System.out.println("Owner = " + owner.getOwnerName() + ", Pet = " + op.getPet().getPetName() +"\n");
                list.add(op.getPet());
            }
            map.put(owner,list);
        }
        model.addAttribute("aMap", map);

        for (Owner key : map.keySet()) {
            System.out.println("Key = " + key.getOwnerName());
            for (Pet pet : map.get(key)) {
                System.out.println("Value = " + pet.getPetName());
            }
        }
  ```
  
  OwnerAndPetRepository.java
  
 ```
   Iterable<OwnersAndPets> findAllByPet_Id(Long owner_id);
 ```
  ####ThymeLeaf
  
  pets.html
  
  ```
  
      <div th:each="key:${aMap.keySet()}">
          <h2 th:text="${key.name}"></h2>
          <h3 th:text="${aMap.get(key).size()>0}?'My Pets':'No pets for me'"></h3>
          <div th:each="eachPet:${aMap.get(key)}">
              <p th:text="${eachPet.name}"></p>
          </div>
      </div>
  ```
  
  index.html
  
  ``` 
      <h1>Owners and their Pets</h1>
      <div th:each="pet:${pets}">
          <h2 th:text="${pet.name}"></h2>
          <h3 th:text="${#lists.size(ownersandpets.findAllByPet_Id(pet.id))>0}?'My Owners':'No Owners for me'"></h3>
          <div th:each="ownerandpets :${ownersandpets.findAllByPet_Id(pet.id)}">
              <p th:text="${ownerandpets.owner.name}"></p>
          </div>
      </div>
  ```