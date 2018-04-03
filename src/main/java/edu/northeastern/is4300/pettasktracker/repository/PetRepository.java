package edu.northeastern.is4300.pettasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.northeastern.is4300.pettasktracker.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}