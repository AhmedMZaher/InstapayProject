package MainClasses;

import API.DetailsAPI;
import API.ElectricityDetails;

import java.util.HashMap;

public class ElectricityBill implements IBill {
    private HashMap<String, ElectricityDetails> electricityBillDetails;

    public ElectricityBill() {
        electricityBillDetails = new HashMap<>();
        electricityBillDetails.put("E001", new ElectricityDetails("Residential", 50.0, 100));
        electricityBillDetails.put("E002", new ElectricityDetails("Commercial", 100.0, 200));
        electricityBillDetails.put("E003", new ElectricityDetails("Industrial", 150.0, 300));
        electricityBillDetails.put("E004", new ElectricityDetails("Residential", 200.0, 400));
    }

    @Override
    public DetailsAPI getBillDetails(String BillID) {
        return electricityBillDetails.get(BillID);
    }

    @Override
    public boolean payBill(String BillID) {
        if (electricityBillDetails.containsKey(BillID)) {
            electricityBillDetails.remove(BillID);
            return true;
        }
        return false;
    }
}
