package com.javacourse.project.HibernateAndJPA.DAL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacourse.project.HibernateAndJPA.Entities.City;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// JPA - ORM
@Repository
public class HibernateCityDal implements ICityDal {

    private final EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        TypedQuery<City> query = entityManager.createQuery("SELECT c FROM City c", City.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void add(City city) {
        entityManager.persist(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        entityManager.merge(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        entityManager.remove(entityManager.contains(city) ? city : entityManager.merge(city));
    }

    @Override
    @Transactional
    public City getById(int id) {
        return entityManager.find(City.class, id);
    }
}
