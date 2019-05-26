package BankAccounts;

public class PersonalBankAccount implements BankAccount {

    private int id;
    private String ownerName;
    private double sold;
    private double sumaRetrasa;
    private double sumaRetrasaConv;
    private double sumaDepusa;
    private double sumaDepusaConv;
    private Currency currency;
    private static int counter = 1;

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getSold() {
        return sold;
    }

    public double getSumaRetrasa() {
        return sumaRetrasa;
    }

    public double getSumaRetrasaConv() {
        return sumaRetrasaConv;
    }

    public double getSumaDepusa() {
        return sumaDepusa;
    }

    public double getSumaDepusaConv() {
        return sumaDepusaConv;
    }

    public PersonalBankAccount(Currency currency, String ownerName) {
        id = counter;
        counter++;
        this.currency = currency;
        this.ownerName = ownerName;
    }

    public void Sold(double sold) {
        this.sold += sold;
    }

    public void depositMoney(double sum) {
        if (sum <= 0) {
            System.out.println("Suma depusa trebuie sa fie mai mare ca zero: " + sum);
            this.sumaDepusa = 0;
            return;
        }

        this.sumaDepusa = sum;
        this.sumaDepusaConv = 0;//pentru operatia curenta vreau sa afisez doar ce s-a modificat
        this.sumaRetrasa = 0;
        this.sumaRetrasaConv = 0;
        this.sold += sum;
    }

    public void depositMoney(double sum, Currency currency) {
        if (sum <= 0) {
            System.out.println("Suma depusa trebuie sa fie mai mare ca zero: " + sum);
            this.sumaDepusaConv = 0;
            return;
        }
        System.out.println(this.currency + "-" + currency);

        this.sumaDepusa = 0;
        if (this.currency != currency && currency.toString() == "USD") {
            this.sumaDepusaConv = sum / this.currency.getCurrency();//
            this.sold += this.sumaDepusaConv;
        } else if (this.currency != currency && currency.toString() != "USD") {
            this.sumaDepusaConv = (sum * currency.getCurrency()) / this.currency.getCurrency();
            this.sold += this.sumaDepusaConv;
        } else {
            this.sold += sum;
            this.sumaDepusa = sum;
            this.sumaDepusaConv = 0;
        }
        this.sumaRetrasa = 0;
        this.sumaRetrasaConv = 0;
    }

    public void withdrawMoney(double sum) {

        if (sum <= 0) {
            System.out.println("Suma retrasa trebuie sa fie mai mare ca zero: " + sum);
            this.sumaRetrasa = 0;
            return;
        }

        if (sum > this.sold) {
            System.out.println("Sold insuficient: " + sum + " solicitat, " + this.sold + " disponibil.");
            this.sumaRetrasa = 0;
            return;
        }
        this.sumaDepusa = 0;
        this.sumaDepusaConv = 0;
        this.sumaRetrasa = sum;
        this.sumaRetrasaConv = 0;
        this.sold -= sum;
    }

    public void withdrawMoney(double sum, Currency currency) {

        if (sum <= 0) {
            System.out.println("Suma retrasa trebuie sa fie mai mare ca zero: " + sum);
            this.sumaRetrasa = 0;
            return;
        }

        this.sumaDepusa = 0;
        this.sumaDepusaConv = 0;
        this.sumaRetrasa = 0;
        System.out.println(this.currency + "-" + currency);

        if (this.currency != currency && currency.toString() == "USD") {//cand scot USD am conversie directa
            this.sumaRetrasaConv = sum / this.currency.getCurrency();
        } else if (this.currency != currency && currency.toString() != "USD") {//cand scot altceva decat USD, convertesc intai in USD
            this.sumaRetrasaConv = (sum * currency.getCurrency()) / this.currency.getCurrency();
        }


        if (this.currency != currency) {
            if (this.sumaRetrasaConv <= this.sold) {
                this.sold -= this.sumaRetrasaConv;
            } else {
                System.out.println("Sold insuficient: " + this.sumaRetrasaConv + " solicitat, " + this.sold + " disponibil.");
                this.sumaRetrasaConv = 0;
                return;
            }
        } else if (sum <= this.sold) { //scot bani cu acelasi currency in care e si contul bancar
            this.sold -= sum;
        } else {
            System.out.println("Sold insuficient: " + sum + " solicitat, " + this.sold + " disponibil.");
            this.sumaRetrasaConv = 0;
            return;
        }
    }




    public String toString(){//pentru afisare, situatia platitorului de taxe
        return "PersonalBankAccount{ " +
                "id=" + id +
                ", ownerName=" + ownerName +
                ", sold=" + sold +
                ", sumaDepusa=" + sumaDepusa +
                ", sumaDepusaConv=" + sumaDepusaConv +
                ", sumaRetrasa=" + sumaRetrasa +
                ", sumaRetrasaConv=" + sumaRetrasaConv +
                '}';
    }

}
