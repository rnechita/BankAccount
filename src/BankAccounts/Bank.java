package BankAccounts;

public enum Bank {
    ING,
    BCR,
    BT,
    BRD_SOCGEN
    ;

    private int counter = 0;

    private BankAccount[] BankAccounts = new BankAccount[2];

    private Bank(){

    }

    public void addAccount(BankAccount account){
        //public void adaugaContribuabil(Contribuabil contribuabil){
        if (counter + 1 > BankAccounts.length){
            dubleazaArray();
        }
        System.out.println("S-a adaugat un cont bancar " + account.getId());
        BankAccounts[counter] = account;
        counter++;
        System.out.println(counter);
    }

    private void dubleazaArray(){
        BankAccount[] nouArray = new BankAccount[BankAccounts.length * 2];

        for (int i = 0; i < BankAccounts.length ; i++) {
            nouArray[i] = BankAccounts[i];//se copiaza tot din lista veche in nouArray
        }
        BankAccounts = nouArray;//mut referinta vechii liste spre nouArray si acum lista cu dimensiune dubla se cheama tot contribuabili ca inainte
    }


}
