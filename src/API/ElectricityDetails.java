package API;

public class ElectricityDetails implements DetailsAPI {
    private String category;
    private double ratePerUnit;
    private int unitsConsumed;

    public ElectricityDetails(String category, double ratePerUnit, int unitsConsumed) {
        this.category = category;
        this.ratePerUnit = ratePerUnit;
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    public boolean equals(DetailsAPI other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        ElectricityDetails otherElectricityDetails = (ElectricityDetails) other;

        return this.category.equals(otherElectricityDetails.category)
                && this.ratePerUnit == otherElectricityDetails.ratePerUnit
                && this.unitsConsumed == otherElectricityDetails.unitsConsumed;
    }

    // Getter methods for category, ratePerUnit, and unitsConsumed

    public String getCategory() {
        return category;
    }

    public double getRatePerUnit() {
        return ratePerUnit;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}
