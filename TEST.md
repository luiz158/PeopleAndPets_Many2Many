``` 
    <h1>Owners and their Pets</h1>
    <div th:each="pet:${pets}">
        <h2 th:text="${pet.name}"></h2>
        <h3 th:text="${#lists.size(pet.owners)>0}?'My Owners':'No Owners for me'"></h3>
        <div th:each="owner:${pet.owners}">
            <p th:text="${owner.name}"></p>
        </div>
    </div>
```