package MainClasses;

import API.DetailsAPI;

interface IBill {
    public DetailsAPI getBillDetails(String BillID);
    public boolean payBill(String BillID);
}
