package com.javacourse.project.HibernateAndJPA.BLL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.HibernateAndJPA.DAL.ICityDal;
import com.javacourse.project.HibernateAndJPA.Entities.City;

@Service
public class CityManager implements ICityService{

	private ICityDal city;
	
	@Autowired
	public CityManager(ICityDal city) {
		super();
		this.city = city;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return this.city.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		this.city.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.city.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.city.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.city.getById(id);
	}
	
}
