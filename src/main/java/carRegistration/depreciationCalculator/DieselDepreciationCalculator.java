package carRegistration.depreciationCalculator;

import org.springframework.stereotype.Component;

@Component
public class DieselDepreciationCalculator implements DepreciationCalculator{

    private double yearlyDepreciationRate = 0.10;

    @Override
    public double calculate(int years, double initialValue) {
        double totalDepreciation = 0;
        double newValue = initialValue;
        for(int i = 0; i<years;i++){
            double depreciationAmount = newValue * yearlyDepreciationRate;
            totalDepreciation += depreciationAmount;

            newValue -= depreciationAmount;
        }
        return totalDepreciation;
    }
}
