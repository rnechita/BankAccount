package contribuabili;

public enum RatieTaxa { //constructor implicit privat, constante - constantele se scriu cu MAJUSCULE
    GENERAL(0.16),
    IT(0.10),
    CONSTRUCTII(0.06),
    CONSTRUCTII_2020(0.2)
    ;

    private double ratieTaxa;//declar field-ul ratieTaxa
    /*variabilele din clase sunt initializate default; variabilele din metode trebuie sa le initializam noi*/

    public double getRatieTaxa(){//getter ca sa accesez valoarea field-ului privat ratieTaxa (private e vizibil din clasa si din ce extinde)
        return ratieTaxa;
    }

    private RatieTaxa(double ratieTaxa){//am getter ca sa pot accesa field-ul privat ratieTaxa, il pot folosi acum ca parametru in metoda
        this.ratieTaxa = ratieTaxa;//this apeleaza un constructor din aceeasi clasa, se refera la obiectul care e in curs de creere
    }

}
