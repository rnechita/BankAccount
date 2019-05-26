import BankAccounts.*;
public class MainBank {
    public static void main(String[] args) {

        PersonalBankAccount a1 = new PersonalBankAccount(Currency.USD, "Nechita");
        PersonalBankAccount a2 = new PersonalBankAccount(Currency.RON, "Octavian");

        Bank.ING.addAccount(a1);
        Bank.ING.addAccount(a2);

        PersonalBankAccount a3 = new PersonalBankAccount(Currency.EUR, "Roberto");
        Bank.ING.addAccount(a3);
        System.out.println(a3);

        a3.Sold(1000);
        System.out.println(a3.toString());

        a3.depositMoney(100);
        System.out.println(a3);

        a3.depositMoney(-100);
        System.out.println(a3);

        a3.depositMoney(10, Currency.USD);//conversie directa
        System.out.println(a3);

        a3.depositMoney(15, Currency.EUR);//acelasi currency
        System.out.println(a3);

        a3.depositMoney(20, Currency.RON);//conversie prin USD
        System.out.println(a3);

        a3.withdrawMoney(99999);
        System.out.println(a3);

        a3.withdrawMoney(3000,Currency.USD);
        System.out.println(a3);

        a3.withdrawMoney(100,Currency.RON);
        System.out.println(a3);

        a3.withdrawMoney(50,Currency.USD);
        System.out.println(a3);

        a3.withdrawMoney(-1,Currency.USD);
        System.out.println(a3);


    }
}
