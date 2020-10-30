package com.spring.app.service;

import com.spring.app.entity.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car update(int id, Car car);

    List<Car> findAll();

    void delete(int id);
}
