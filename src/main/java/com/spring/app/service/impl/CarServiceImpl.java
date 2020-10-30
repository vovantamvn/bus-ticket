package com.spring.app.service.impl;

import com.spring.app.entity.Car;
import com.spring.app.repository.CarRepository;
import com.spring.app.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    /**
     *
     * @param carRepository
     */
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(int id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
