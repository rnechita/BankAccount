package BankAccounts;

public enum Currency {
    RON(0.2354), // RON/USD = 0.23
    USD(1),//USD/USD = 1
    EUR(1.1206),//EUR/USD = 1.12
    YEN(0.0091)//YEN=USD = 0.0091
    ;

    private double currency;

    public double getCurrency(){
        return currency;
    }

    private Currency(double currency){
        this.currency = currency;
    }
}
