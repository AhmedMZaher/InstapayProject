package MainClasses;
import API.DetailsAPI;
import API.GasDetails;
import java.util.HashMap;


public class GasBill implements IBill {
    private HashMap<String, GasDetails> gasBillDetails;
    private static GasBill instance;

    private GasBill() {
        gasBillDetails = new HashMap<>();
        gasBillDetails.put("G001", new GasDetails("Domestic", 100.0, 100));
        gasBillDetails.put("G002", new GasDetails("Commercial", 200.0, 200));
        gasBillDetails.put("G003", new GasDetails("Industrial", 300.0, 300));
        gasBillDetails.put("G004", new GasDetails("Domestic", 400.0, 400));
    }

    public static GasBill getInstance() {
        if (instance == null) {
            instance = new GasBill();
        }
        return instance;
    }


    @Override
    public DetailsAPI getBillDetails(String BillID) {
        return gasBillDetails.get(BillID);
    }

    @Override
    public boolean payBill(String BillID) {
        if (gasBillDetails.containsKey(BillID)) {
            gasBillDetails.remove(BillID);
            return true;
        }
        return false;
    }
}