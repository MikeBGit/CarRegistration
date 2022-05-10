package carRegistration.vehicleTypes;

import carRegistration.depreciationCalculator.DepreciationCalculator;
import carRegistration.gasConsumption.GasConsumptionCalculator;
import carRegistration.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")

public class Truck implements ICar {

    private String model;
    private int year;
    private double value;

    @Autowired
    @Qualifier("truckConsumption")
    private GasConsumptionCalculator gasConsumptionCalculator;

    @Autowired
    @Qualifier("truckDepreciationCalculator")
    private DepreciationCalculator depreciationCalculator;

    @Override
    public void printReport() {
        System.out.println("SUV Report");
        System.out.println(" For 1000kms it consumes  " + gasConsumptionCalculator.calculate(1000) + " Litres");
        System.out.println(" In 5 years This " + year + " " + model + " will depreciate by " + depreciationCalculator.calculate(5,value));

    }

    @PostConstruct
    private void postConstruct() {
        this.model = "Siverado";
        this.year = 2011;
        this.value = 18000;
        System.out.println("Truck Created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Truck Destroyed");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", value=" + value +
                ", " +
                gasConsumptionCalculator.calculate(1) + "/KiloMeter"+
                "}\n";
    }
}
