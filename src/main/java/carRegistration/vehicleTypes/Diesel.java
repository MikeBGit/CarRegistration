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

public class Diesel implements ICar {

    private String model;
    private int year;
    private double value;

    @Autowired
    @Qualifier("dieselConsumption")
    private GasConsumptionCalculator gasConsumptionCalculator;

    @Autowired
    @Qualifier("dieselDepreciationCalculator")
    private DepreciationCalculator depreciationCalculator;


    @Override
    public void printReport() {
        System.out.println(year + " " + model + " Report");
        System.out.println(" For 1000kms it consumes " + gasConsumptionCalculator.calculate(1000) + " Litres");
        System.out.println(" In 5 years This " + year + " " + model + " will depreciate by " + depreciationCalculator.calculate(5,value));
    }

    @PostConstruct
    private void postConstruct() {
        this.model = "Jetta";
        this.year = 2004;
        this.value = 5000;
        System.out.println("Diesel Car Created");
}

    @PreDestroy
    public void preDestroy() {
        System.out.println("Diesel Destroy");
    }

    @Override
    public String toString() {
        return "Diesel{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", value=" + value + ", " +
                gasConsumptionCalculator.calculate(1) + "/KiloMeter" +
                "} \n";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
