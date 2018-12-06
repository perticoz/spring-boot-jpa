package com.wildcodeschool.example.queteSpring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.example.queteSpring.entity.Animal;

@Repository
public interface AnimalDAO extends JpaRepository<Animal, Long> {

}
