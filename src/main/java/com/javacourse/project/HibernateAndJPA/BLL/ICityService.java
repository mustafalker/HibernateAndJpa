package com.javacourse.project.HibernateAndJPA.BLL;

import java.util.List;

import com.javacourse.project.HibernateAndJPA.Entities.City;

public interface ICityService {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	
	City getById(int id);
}
