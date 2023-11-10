public enum Bill {
    ELECTRICITY("Electricity", 100.0),
    WATER("Water", 50.0),
    INTERNET("Internet", 75.0);

    private final String type;
    private final double amount;

    // Constructor for each enum constant
    Bill(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
