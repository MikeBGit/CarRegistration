package carRegistration.gasConsumption;

import org.springframework.stereotype.Component;

@Component("suvGas")
public class SUVConsumption implements GasConsumptionCalculator {

    @Override
    public double calculate(int kiloMeters) {
        double gasEfficiency = 0.085;
        return gasEfficiency * kiloMeters;
    }
}
