package com.azure.repository;

import java.util.List;
import java.util.Optional;

import com.azure.model.Checklist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CheckListRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sample");
	private EntityManager em;

    public CheckListRepository() {
        em = emf.createEntityManager();
    }

    public Checklist save(Checklist checklist) {
        em.getTransaction().begin();
        em.persist(checklist);
        em.getTransaction().commit();
        return checklist;
    }

    public Optional<Checklist> findById(Long id) {
        em.getTransaction().begin();
        Checklist checklist = em.find(Checklist.class, id);
        em.getTransaction().commit();
        return checklist != null ? Optional.of(checklist) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<Checklist> findAll() {
        return em.createQuery("from CheckList").getResultList();
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(Checklist.class, id));
        em.getTransaction().commit();
    }
    
    
}
