package br.com.mariojp.solid.srp;

public class ReceiptService {

    private final TaxCalculator taxCalculator;
    private final ReceiptFormatter receiptFormatter;

    public ReceiptService() {
        this.taxCalculator = new TaxCalculator();
        this.receiptFormatter = new ReceiptFormatter();
    }

    public ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter receiptFormatter) {
        this.taxCalculator = taxCalculator;
        this.receiptFormatter = receiptFormatter;
    }


    public String generate(Order order) {
        double subtotal = calculateSubtotal(order);

        double tax = taxCalculator.calculateTax(subtotal);

        double total = subtotal + tax;

        return receiptFormatter.format(order.getItems(), subtotal, tax, total);
    }

    private double calculateSubtotal(Order order) {
        return order.getItems().stream()
                .mapToDouble(item -> item.getUnitPrice() * item.getQuantity())
                .sum();
    }
}
