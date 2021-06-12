package md.tekwill.carmanager.entity;

import java.util.Objects;

public class LuxuryCar extends Car {

    private LuxuryLevel luxuryLevel;

    public LuxuryCar() {

    }

    public LuxuryCar(String make, String model, int productionAge, long mileage, EngineType engineType, double price, LuxuryLevel luxuryLevel) {
        super(make, model, productionAge, mileage, engineType, price);
        this.luxuryLevel = luxuryLevel;
    }

    public LuxuryLevel getLuxuryLevel() {
        return luxuryLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LuxuryCar luxuryCar = (LuxuryCar) o;
        return luxuryLevel == luxuryCar.luxuryLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), luxuryLevel);
    }

    @Override
    public String toString() {
        return "LuxuryCar{" +
                "luxuryLevel=" + luxuryLevel +
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
