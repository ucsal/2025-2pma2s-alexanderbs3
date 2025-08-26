package br.com.mariojp.solid.srp;

public class TaxCalculator {
    public double calculateTax(double subtotal){
        double taxRate = getTaxRate();
        return subtotal * taxRate;
    }

    private double getTaxRate(){
        String taxRateProperty = System.getProperty("tax.rate");
        if (taxRateProperty != null && !taxRateProperty.isEmpty()){
            try{
                return Double.parseDouble(taxRateProperty);
            }catch (NumberFormatException e){
                return 0.10;
            }
        }
        return 0.10;
    }
}
