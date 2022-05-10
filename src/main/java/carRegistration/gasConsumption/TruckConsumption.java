package carRegistration.gasConsumption;

import org.springframework.stereotype.Component;

@Component
public class TruckConsumption implements GasConsumptionCalculator{

    @Override
    public double calculate(int kiloMeters) {
        double gasEfficiency = 0.105;
        return gasEfficiency * kiloMeters;
    }
}
