# PeopleAndPets_Many2Many

## Important annotations

```@Entity```

```@OneToMany``` Defines a many-vaued association with one-to-many multiplicity

```@ManyToOne``` Defines a single-valued association to another entity class that has many-to-one multiplicity

```@OneToMany``` Defines a single-valued association to another entity class that has one-to-many multiplicity

```@ManyToMany``` defines a many-valued association with many-to-many multiplicity

```mappedBy``` references the field that ```owns``` the relationship in the referenced entity. This is generally required.


## Fetching Strategies - define how object hierarchies are loaded

```EAGER``` - loads all related objects immediately

```LAZY``` - loads the related objects only if they are accessed for the first time


## This project contains three branches (plus master):
* One2Many_Redo

* One2Many

* Many2Many

The master branch is the default project which is the same as Many2Many. It illustrates how to create a ManyToMany relationship where one pet has many owners and each owner can own many pets.

The One2Many_Redo branch illusrates how to work around the complications of the Many2Many relationship by creating two one2many relationships.

use ```git checkout One2Many_Redo``` to checkout that branch and observe how the project changes when designing the database this way.
