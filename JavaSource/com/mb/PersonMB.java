package com.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.DogFacade;
import com.facade.PersonFacade;
import com.model.Dog;
import com.model.Person;
import com.sun.faces.context.flash.ELFlash;

@ViewScoped
@ManagedBean
public class PersonMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String SELECTED_PERSON = "selectedPerson";

	private Dog dog;
	private Person person;
	private Person personWithDogs;
	private Person personWithDogsForDetail;

	private List<Dog> allDogs;
	private List<Person> persons;

	private DogFacade dogFacade;
	private PersonFacade personFacade;

	public void createPerson() {
		try {
			getPersonFacade().createPerson(person);
			closeDialog();
			displayInfoMessageToUser("Usu�rio criado com sucesso.");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao tentar criar usu�rio.");
			e.printStackTrace();
		}
	}

	public void updatePerson() {
		try {
			getPersonFacade().updatePerson(person);
			closeDialog();
			displayInfoMessageToUser("Usu�rio atualizado com sucesso.");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao tentar atualizar usu�rio.");
			e.printStackTrace();
		}
	}

	public void deletePerson() {
		try {
			getPersonFacade().deletePerson(person);
			closeDialog();
			displayInfoMessageToUser("Usu�rio exclu�do com sucesso.");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao tentar excluir usu�rio.");
			e.printStackTrace();
		}
	}

	public void setPersonWithDogsForDetail(Person person) {
		personWithDogsForDetail = getPersonFacade().findPersonWithAllDogs(person.getId());
	}

	public Person getPersonWithDogsForDetail() {
		if (personWithDogsForDetail == null) {
			personWithDogsForDetail = new Person();
			personWithDogsForDetail.setDogs(new ArrayList<Dog>());
		}

		return personWithDogsForDetail;
	}

	public void resetPersonWithDogsForDetail() {
		personWithDogsForDetail = new Person();
	}

	public String editPersonDogs() {
		ELFlash.getFlash().put(SELECTED_PERSON, person);
		return "/pages/protected/defaultUser/personDogs/personDogs.xhtml";
	}

	public List<Dog> complete(String name) {
		List<Dog> queryResult = new ArrayList<Dog>();

		if (allDogs == null) {
			dogFacade = new DogFacade();
			allDogs = dogFacade.listAll();
		}

		allDogs.removeAll(personWithDogs.getDogs());

		for (Dog dog : allDogs) {
			if (dog.getName().toLowerCase().contains(name.toLowerCase())) {
				queryResult.add(dog);
			}
		}

		return queryResult;
	}

	public PersonFacade getPersonFacade() {
		if (personFacade == null) {
			personFacade = new PersonFacade();
		}

		return personFacade;
	}

	public Person getPerson() {
		if (person == null) {
			person = new Person();
		}

		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getAllPersons() {
		if (persons == null) {
			loadPersons();
		}

		return persons;
	}

	private void loadPersons() {
		persons = getPersonFacade().listAll();
	}

	public void resetPerson() {
		person = new Person();
	}

	public Dog getDog() {
		if (dog == null) {
			dog = new Dog();
		}

		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void resetDog() {
		dog = new Dog();
	}

	private void reloadPersonWithDogs() {
		personWithDogs = getPersonFacade().findPersonWithAllDogs(person.getId());
	}
}