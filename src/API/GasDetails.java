package API;

public class GasDetails implements DetailsAPI{
    private double price;
    private String type;
    private int amount;

    public GasDetails(String type, double price, int amount) {
        this.type = type;
        this.price = price;
        this.amount = amount;
    }
    @Override
    public boolean equals(DetailsAPI other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        WalletDetails otherUser = (WalletDetails) other;

        return this.price == ((GasDetails) other).price && this.type.equals(((GasDetails) other).type) && this.amount == ((GasDetails) other).amount;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
