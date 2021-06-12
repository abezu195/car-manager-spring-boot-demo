package md.tekwill.carmanager.entity;

import java.util.Objects;

public abstract class Car {

    protected long id;
    protected String make;
    protected String model;
    protected int productionAge;
    protected long mileage;
    protected EngineType engineType;
    protected double price;

    public Car() {

    }

    protected Car(String make, String model, int productionAge, long mileage, EngineType engineType, double price) {
        this.make = make;
        this.model = model;
        this.productionAge = productionAge;
        this.mileage = mileage;
        this.engineType = engineType;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getProductionAge() {
        return productionAge;
    }

    public long getMileage() {
        return mileage;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionAge == car.productionAge &&
                mileage == car.mileage &&
                Double.compare(car.price, price) == 0 &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, productionAge, mileage, engineType, price);
    }
}
