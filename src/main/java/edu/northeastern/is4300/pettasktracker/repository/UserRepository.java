package edu.northeastern.is4300.pettasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.northeastern.is4300.pettasktracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
