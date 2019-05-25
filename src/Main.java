import contribuabili.*;
public class Main {

    public static void main(String[] args) {
        Contribuabil c1 = new ContribuabilTest();
        Contribuabil c2 = new ContribuabilTest();
        Contribuabil c3 = new ContribuabilTest();


        Registru.REGISTRU.adaugaContribuabil(c1);
        Registru.REGISTRU.adaugaContribuabil(c2);
        Registru.REGISTRU.adaugaContribuabil(c3);

        Contribuabil c4 = new ContribuabilTest();
        Registru.REGISTRU.stergeContribuabil(c4);
        Registru.REGISTRU.stergeContribuabil(c1);

        PlatitorTaxe c5 = new PlatitorTaxe(RatieTaxa.CONSTRUCTII);
        System.out.println(c5);
        c5.declaraVenit(100);


        System.out.println(c5.toString());

        c5.platesteTaxa(50);

        System.out.println(c5);

        c5.platesteTaxa(6);

        System.out.println(c5);


        c5.platesteTaxa(-4554);
        System.out.println(c5);
    }
}