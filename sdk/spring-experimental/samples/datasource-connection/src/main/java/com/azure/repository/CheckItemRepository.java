package com.azure.repository;


import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.azure.model.CheckItem;

public class CheckItemRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CredentialFree");
	private EntityManager em;

	public CheckItemRepository() {
		em = emf.createEntityManager();
	}

	public CheckItem save(CheckItem item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		return item;
	}

	public Optional<CheckItem> findById(Long id) {
		em.getTransaction().begin();
		CheckItem item = em.find(CheckItem.class, id);
		em.getTransaction().commit();
		return item != null ? Optional.of(item) : Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CheckItem> findAll() {
		return em.createQuery("from CheckItem").getResultList();
	}

	public CheckItem update(CheckItem item) {
		em.getTransaction().begin();
		item = em.merge(item);
		em.getTransaction().commit();
		return item;
	}

	public void deleteById(Long id) {
		em.getTransaction().begin();
		em.remove(em.find(CheckItem.class, id));
		em.getTransaction().commit();
	}

	public void close() {
		emf.close();
	}
}
