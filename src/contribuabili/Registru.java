package contribuabili;

public enum Registru {
    REGISTRU,
    REGISTRU_PROVINCIE;

    private int counter = 0;

    private Contribuabil[] contribuabili = new Contribuabil[2]; //un vector contribuabili cu elemente obiecte de tip Contribuabil(tipul de data, in loc de int, char etc)

    private Registru(){

    }

    public void adaugaContribuabil(Contribuabil contribuabil){//parametru un obiect de tip Contribuabil..putea sa se cheme oricum
        if (counter + 1 > contribuabili.length){//la fiecare contribuabil adaugat se incrementeaza c-ul pana se atinge limita listei
            dubleazaArray();
        }
        System.out.println("S-a adaugat un contribuabil " + contribuabil.getId());
        contribuabili[counter] = contribuabil;//se trece in vector contribuabilul, tinand cont de id care e si pozitia in lista
        counter++;
        System.out.println(counter);//e totodata si numarul de contribuabili, in final(id-ul ultimului)
    }

    private void dubleazaArray(){
        Contribuabil[] nouArray = new Contribuabil[contribuabili.length * 2];//array de tipul Contribuabil, de lungime dubla

        for (int i = 0; i < contribuabili.length ; i++) {
            nouArray[i] = contribuabili[i];//se copiaza tot din lista veche in nouArray
        }
        contribuabili = nouArray;//mut referinta vechii liste spre nouArray si acum lista cu dimensiune dubla se cheama tot contribuabili ca inainte
    }

    public void stergeContribuabil(Contribuabil contribuabil){
        int i = gasesteIdContribuabil(contribuabil);//apelez metoda definita mai jos care returneaza -1 cand iterandu-se prin lista de contribuabili si aplicandu-se getId pe fiecare in parte, nu obtin ca rezultat nicio valoare egala cu getId al parametrului dat functiei
        if (i == -1){
            System.out.println("Nu exista acel Contribuabil " + contribuabil);
            return;//iese din metoda
        }
        for (int j = i; j < counter - 1 ; j++) {//merg pana la counter - 1 ca sa pot compara mereu cu valoarea urmatoare fara sa am index out of range
            contribuabili[j] = contribuabili[j + 1];//se muta referinta valorii curente catre valoarea urmatoare, practic pana la i lista e neschimbata, de pe pozitia i dispare vechiul element(tip Contribuabil), si urmatoarele valori sunt shiftate o pozitie mai la stanga
        }
        System.out.println("S-a STERS un contribuabil " + contribuabil.getId());
        contribuabili[counter - 1] = null;//ultimul element devine null (fara nici o referinta, sau referinta catre null)
        counter--;//mai putini cu unul
        System.out.println(counter);
    }

    /*eficientizare cu binary search*/

    public int gasesteIdContribuabil(Contribuabil contribuabil){
        for (int i = 0; i < counter ; i++) {
            if (contribuabil.getId() == contribuabili[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public int getNumarContribuabili(){
        return counter;
    }

}
