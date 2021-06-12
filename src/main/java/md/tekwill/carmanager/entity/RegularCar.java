package md.tekwill.carmanager.entity;

import java.util.Objects;

public class RegularCar extends Car {

    private double mixedFuelConsumption;

    public RegularCar() {

    }

    public RegularCar(String make, String model, int productionAge, long mileage, EngineType engineType, double price, double mixedFuelConsumption) {
        super(make, model, productionAge, mileage, engineType, price);
        this.mixedFuelConsumption = mixedFuelConsumption;
    }

    public double getMixedFuelConsumption() {
        return mixedFuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegularCar that = (RegularCar) o;
        return Double.compare(that.mixedFuelConsumption, mixedFuelConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mixedFuelConsumption);
    }

    @Override
    public String toString() {
        return "RegularCar{" +
                "mixedFuelConsumption=" + mixedFuelConsumption +
                ", id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", productionAge=" + productionAge +
                ", mileage=" + mileage +
                ", engineType=" + engineType +
                ", price=" + price +
                '}';
    }
}
