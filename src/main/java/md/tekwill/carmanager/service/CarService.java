package md.tekwill.carmanager.service;

import md.tekwill.carmanager.entity.Car;
import md.tekwill.carmanager.entity.LuxuryCar;
import md.tekwill.carmanager.entity.RegularCar;

import java.util.List;

public interface CarService {

    List<Car> getAll();

    List<RegularCar> getAllRegularCars();

    List<LuxuryCar> getAllLuxuryCars();

    List<Car> getWithPriceLessThan(double price);

    void create(Car car);

    void updatePrice(long id, double price);

    void remove(long id);
}
