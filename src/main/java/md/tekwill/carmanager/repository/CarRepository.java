package md.tekwill.carmanager.repository;

import md.tekwill.carmanager.entity.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    Car findById(long id);

    void save(Car car);

    void update(long id, double newPrice);

    void delete(long id);
}
