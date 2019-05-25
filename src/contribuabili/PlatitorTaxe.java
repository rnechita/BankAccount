package contribuabili;

public class PlatitorTaxe implements Contribuabil{ /*relatie: PlatitorTaxe is a Contribuabil*/
    //contract: ca in ContribuabilTest, declar variabilele private si le accesez cu un getter

    private int id;//nu mai am final, vreau sa pot modifica id-ul
    private double venituri;
    private double taxePlatite;
    private double taxeDePlatit;
    private RatieTaxa ratieTaxa;
    private static int counter = 1; //linia din clasa se executa o singura data cand am static


    public int getId(){
        return id;
    }

    public double getVenituri(){
        return venituri;
    }

    public double getTaxePlatite(){
        return taxePlatite;
    }

    public double getTaxeNeplatite(){
        return taxeDePlatit;
    }

    public PlatitorTaxe(RatieTaxa ratieTaxa){//constructor; se uita in fisierul RatieTaxa din pachetul contribuabili, care contine constructorul(implicit privat daca nu modificam) enum RatieTaxa, cu field-ul double ratieTaxa
        id = counter;
        counter++;
        this.ratieTaxa = ratieTaxa;
    }

    public void declaraVenit(double venit){
        this.venituri += venit;
        this.taxeDePlatit += venit * ratieTaxa.getRatieTaxa();
    }

    public void platesteTaxa(double valoare){//void nu returneaza nimic, metoda contine o validare pentru valoare si setarea
        if (valoare <=0) {
            System.out.println("Valoarea trebuie sa fie mai mare ca zero: " + valoare);
            return;//iese din metoda cand valoarea nu e valida
        }

        if (taxeDePlatit < valoare) {
            System.out.println("Ati dorit sa platiti mai mult: " +
                    valoare + " > " + taxeDePlatit);
            return;
        }

        this.taxePlatite += valoare;
        this.taxeDePlatit -= valoare;
    }

    public String toString(){//pentru afisare, situatia platitorului de taxe
        return "PlatitorTaxe{ " +
                "id=" + id +
                ", venituri=" + venituri +
                ", taxePlatite=" + taxePlatite +
                ",taxeDePlatit=" + taxeDePlatit +
                '}';
    }






}
