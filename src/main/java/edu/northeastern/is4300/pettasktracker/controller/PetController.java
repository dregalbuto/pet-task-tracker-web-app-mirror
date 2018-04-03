package edu.northeastern.is4300.pettasktracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.is4300.pettasktracker.exception.ResourceNotFoundException;
import edu.northeastern.is4300.pettasktracker.model.Pet;
import edu.northeastern.is4300.pettasktracker.repository.PetRepository;

@RestController
@RequestMapping("/api")
public class PetController {
	@Autowired
	private PetRepository petRepository;
	
	// Get all users
	@GetMapping("/pets")
	public List<Pet> getAllPets() {
	    return petRepository.findAll();
	}
	
	// Create a user
	@PostMapping("/pets")
	public Pet createUser(@Valid @RequestBody Pet pet) {
		return petRepository.save(pet);
	}
	
	// Get user by ID
	@GetMapping("/pets/{id}")
	public Pet getPetById(@PathVariable(value="id") Long petId) {
		return petRepository.findById(petId)
				 .orElseThrow(() -> new ResourceNotFoundException("Pet", "id", petId));
	}
	
	// Update a User
	@PutMapping("/pets/{id}")
	public Pet updatePet(@PathVariable(value = "id") Long petId,
	                                        @Valid @RequestBody Pet petDetails) {

	    Pet pet = petRepository.findById(petId)
	            .orElseThrow(() -> new ResourceNotFoundException("Pet", "id", petId));

	    pet.setName(petDetails.getName());
	    pet.setType(petDetails.getType());

	    return petRepository.save(pet);
	}
	
	// Delete a User
	@DeleteMapping("/pets/{id}")
	public ResponseEntity<?> deletePet(@PathVariable(value = "id") Long petId) {
	    Pet pet = petRepository.findById(petId)
	            .orElseThrow(() -> new ResourceNotFoundException("Pet", "id", petId));

	    petRepository.delete(pet);

	    return ResponseEntity.ok().build();
	}
}
