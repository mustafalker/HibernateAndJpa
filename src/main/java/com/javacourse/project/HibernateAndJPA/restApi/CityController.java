package com.javacourse.project.HibernateAndJPA.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javacourse.project.HibernateAndJPA.BLL.ICityService;
import com.javacourse.project.HibernateAndJPA.Entities.*;

@RestController
@RequestMapping("/api")
public class CityController {

    private final ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAll();
    }
    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public void addCity(@RequestBody City city) {
        cityService.add(city);
    }

    @PutMapping("/update/{id}")
    public void updateCity(@PathVariable int id, @RequestBody City city) {
        City existingCity = cityService.getById(id);
        if (existingCity != null) {
            city.setId(id);
            cityService.update(city);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCity(@PathVariable int id) {
        City existingCity = cityService.getById(id);
        if (existingCity != null) {
            cityService.delete(existingCity);
        }
    }
}
