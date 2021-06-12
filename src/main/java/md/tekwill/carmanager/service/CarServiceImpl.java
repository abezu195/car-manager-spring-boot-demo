package md.tekwill.carmanager.service;

import md.tekwill.carmanager.entity.Car;
import md.tekwill.carmanager.entity.LuxuryCar;
import md.tekwill.carmanager.entity.RegularCar;
import md.tekwill.carmanager.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<RegularCar> getAllRegularCars() {
        List<RegularCar> regularCars = new ArrayList<>();
        for (Car car : getAll()) {
            if (car instanceof RegularCar) {
                RegularCar regularCar = (RegularCar) car;
                regularCars.add(regularCar);
            }
        }
        return regularCars;
    }

    @Override
    public List<LuxuryCar> getAllLuxuryCars() {
        List<LuxuryCar> luxuryCars = new ArrayList<>();
        for (Car car : getAll()) {
            if (car instanceof LuxuryCar) {
                LuxuryCar luxuryCar = (LuxuryCar) car;
                luxuryCars.add(luxuryCar);
            }
        }
        return luxuryCars;
    }

    @Override
    public List<Car> getWithPriceLessThan(double price) {
        List<Car> cars = new ArrayList<>();
        for (Car car : getAll()) {
            if (car.getPrice() < price) {
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public void create(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updatePrice(long id, double price) {
        carRepository.update(id, price);
    }

    @Override
    public void remove(long id) {
        carRepository.delete(id);
    }
}
