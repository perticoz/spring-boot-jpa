package com.wildcodeschool.example.queteSpring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.example.queteSpring.entity.Animal;
import com.wildcodeschool.example.queteSpring.repositories.AnimalDAO;

@Component
public class Outputter implements CommandLineRunner {
	
	private Logger LOG = LoggerFactory.getLogger("Florent");
	
	@Autowired
    private AnimalDAO animalDAO;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("test");
        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + animalDAO.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Animal animal1 = new Animal("minou", "moir");
        LOG.info("******************");
        LOG.info(animal1 + " has been created !");
        animalDAO.save(animal1);
        LOG.info(animal1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Animal animal2 = new Animal("Nonoss", "rouquin");
        LOG.info("******************");
        LOG.info(animal2 + " has been created !");
        animalDAO.save(animal2);
        LOG.info(animal2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        Animal tempAnimal = animalDAO.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second animal's Name is " + tempAnimal.getName());
        LOG.info("Second animal's color is " + tempAnimal.getCouleur());
        
        // modifie le nom du deuxième Animal
        
        Animal Animal = animalDAO.findById(2L).get();
        Animal.setName("Crocro");
        LOG.info("******************");
        LOG.info("Second animal's Name is " + Animal.getName());
        animalDAO.save(Animal);
        
    
        LOG.info("******************");
        LOG.info("Second animal's Name is " + Animal.getName());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Animal in list are ");
        for(Animal myAnimal : animalDAO.findAll()) {
            LOG.info(myAnimal.toString());
        };

        // Supprime le second utilisateur de la BDD
        animalDAO.deleteById(1L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(Animal myUser : animalDAO.findAll()) {
            LOG.info(myUser.toString());
        };
    } 
	}


