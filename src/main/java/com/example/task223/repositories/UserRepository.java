package com.example.task223.repositories;

import com.example.task223.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManagerFactory;

    public List<User> getAllUsers() {
        return entityManagerFactory.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void addUser(User user) {
        entityManagerFactory.persist(user);
        System.out.println("User " + user + " has been added");
    }
    public User getUserById(Long id) {
        System.out.println("User with id: " + id + " has been found");
        return entityManagerFactory.find(User.class, id);
    }
    public void updateUser(User user) {
        entityManagerFactory.merge(user);
        System.out.println("User " + user + " has been updated");
    }
    public void deleteUser(Long id) {
        User user = entityManagerFactory.find(User.class, id);
        if(user != null) {
            entityManagerFactory.remove(user);
            System.out.println("User with id " + id + " has been deleted");
        }
    }
}
