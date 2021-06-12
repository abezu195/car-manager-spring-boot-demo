package md.tekwill.carmanager.repository;

import md.tekwill.carmanager.entity.Car;
import md.tekwill.carmanager.entity.EngineType;
import md.tekwill.carmanager.entity.LuxuryCar;
import md.tekwill.carmanager.entity.LuxuryLevel;
import md.tekwill.carmanager.entity.RegularCar;
import md.tekwill.carmanager.exception.CarAlreadyExistsException;
import md.tekwill.carmanager.exception.CarNotExistsException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public CarRepositoryImpl() {
        RegularCar daciaLogan = new RegularCar("Dacia", "Logan", 2016, 85000, EngineType.GAS, 8500.0, 7.5);
        daciaLogan.setId(1);
        RegularCar daciaSander = new RegularCar("Dacia", "Sandero", 2013, 120000, EngineType.PETROL, 5800.0, 8.5);
        daciaSander.setId(2);
        RegularCar opel = new RegularCar("Opel", "Astra", 2012, 123000, EngineType.DIESEL, 6000.0, 6.5);
        opel.setId(3);
        cars.add(daciaLogan);
        cars.add(daciaSander);
        cars.add(opel);

        LuxuryCar mercedes = new LuxuryCar("Mercedes", "Maybach S500", 2015, 75000, EngineType.PETROL, 40000.0, LuxuryLevel.HIGH);
        mercedes.setId(4);
        LuxuryCar bmw = new LuxuryCar("BMW", "750L", 2016, 71000, EngineType.DIESEL, 35000.0, LuxuryLevel.MEDIUM);
        bmw.setId(5);
        cars.add(mercedes);
        cars.add(bmw);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    @Override
    public Car findById(long id) {
        Car car = null;
        for (Car c : cars) {
            if (c.getId() == id) {
                car = c;
            }
        }
        if (car == null) {
            throw new CarNotExistsException("Car with ID " + id + " does not exist in our system!");
        }
        return car;
    }

    @Override
    public void save(Car car) {
        if (cars.contains(car)) {
            throw new CarAlreadyExistsException("This car is already in our system!");
        }
        car.setId(getMaxId() + 1);
        cars.add(car);
    }

    public long getMaxId() {
        long maxId = 0;
        for (Car car : cars) {
            if (car.getId() > maxId) {
                maxId = car.getId();
            }
        }
        return maxId;
    }

    @Override
    public void update(long id, double newPrice) {
        Car car = findById(id);
        car.setPrice(newPrice);
    }

    @Override
    public void delete(long id) {
        Car car = findById(id);
        cars.remove(car);
    }
}
