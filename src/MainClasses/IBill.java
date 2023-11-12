package MainClasses;

import API.DetailsAPI;

interface IBill {
    public double getBillDetails(DetailsAPI detailsAPI);
    public void payBill();
}
