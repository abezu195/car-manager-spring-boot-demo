package md.tekwill.carmanager.controller;

import md.tekwill.carmanager.entity.Car;
import md.tekwill.carmanager.entity.LuxuryCar;
import md.tekwill.carmanager.entity.RegularCar;
import md.tekwill.carmanager.exception.CarAlreadyExistsException;
import md.tekwill.carmanager.exception.CarNotExistsException;
import md.tekwill.carmanager.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping//localhost:8080/cars
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/regular")//localhost:8080/cars/regular
    public ResponseEntity<List<RegularCar>> getAllRegularCars() {
        List<RegularCar> allRegularCars = carService.getAllRegularCars();
        return ResponseEntity.ok(allRegularCars);
    }

    @GetMapping("/luxury")//localhost:8080/cars/luxury
    public ResponseEntity<List<LuxuryCar>> getAllLuxuryCars() {
        List<LuxuryCar> allLuxuryCars = carService.getAllLuxuryCars();
        return ResponseEntity.ok(allLuxuryCars);
    }

    @GetMapping("/price-less-than/{price}")
    public ResponseEntity<List<Car>> getWithPriceLessThan(@PathVariable("price") double price) {
        List<Car> cars = carService.getWithPriceLessThan(price);
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/regular")
    public ResponseEntity<String> createNewRegularCar(@RequestBody RegularCar car) {
        carService.create(car);
        return ResponseEntity.ok("Regular car successfully created!");
    }

    @PostMapping("/luxury")
    public ResponseEntity<String> createNewLuxuryCar(@RequestBody LuxuryCar car) {
        carService.create(car);
        return ResponseEntity.ok("Luxury car successfully created!");
    }

    @ExceptionHandler(CarAlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExistsException(CarAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(CarNotExistsException.class)
    public ResponseEntity<String> handleNotExistsException(CarNotExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PutMapping("/{id}") //localhost:8080/cars/1?price=2050
    public ResponseEntity<String> updatePrice(@PathVariable("id") long id, @RequestParam("price") double price) {
        carService.updatePrice(id, price);
        return ResponseEntity.ok("Car price successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCar(@PathVariable("id") long id) {
        carService.remove(id);
        return ResponseEntity.ok("Car successfully removed from system");
    }
}
