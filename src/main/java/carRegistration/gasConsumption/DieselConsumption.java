package carRegistration.gasConsumption;

import org.springframework.stereotype.Component;

@Component
public class DieselConsumption implements GasConsumptionCalculator{

    @Override
    public double calculate(int kiloMeters) {
        double gasEfficiency = 0.055;
        return gasEfficiency * kiloMeters;
    }
}
