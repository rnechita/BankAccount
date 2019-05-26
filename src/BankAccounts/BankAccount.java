package BankAccounts;

public interface BankAccount {
    int counter = 1;
    int getId();
    //String ownerName;
    String getOwnerName();
    double getSold();
    double getSumaRetrasa();
    double getSumaRetrasaConv();
    double getSumaDepusa();
    double getSumaDepusaConv();

}
