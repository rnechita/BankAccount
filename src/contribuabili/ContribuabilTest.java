package contribuabili;
/*
- se implementeaza interfata contribuabil-->trebuie sa definesc metodele din interfata
- ori declar clasa ContribuabilTest abstracta ori implementez metodele interfatei aici in clasa ca si metode abstracte

Modificatori de acces:
- protected -> vizibil din clasa si din ce extinde; pot fi in pachete diferite daca extinde o alta clasa
- public -> vizibil de oriunde
- private -> vizibil doar din clasa
- default -> vizibil doar din pachet
(de preferat toate campurile sa fie private)

Fiecare clasa noua extinde clasa Object, apelata prin super() - constructor implicit al clasei
constructorul se apeleaza cand folosim new
this apeleaza un constructor din aceeasi clasa, se refera la obiectul care e in curs de creere
pot sa definesc un constructor care sa apeleze alt constructor in care sunt definite niste fielduri si sa mai adaug in plus alte fielduri
*/
public class ContribuabilTest implements Contribuabil{

    private static int counter = 0;//linia din clasa se executa o singura data cand am static
    private final int id; //final inseamna ca nu poate fi modificat, keyword pentru constanta*/

    public ContribuabilTest(){/*constructor; la fiecare nou contribuabil creat se va apela, incrementeaza c si assigneaza valoarea lui c id-ului*/
        counter++;
        id = counter;
    }

    public int getId(){/*private field is assigned but never accessed; folosesc metoda getId pentru a-l accesa*/
        return id;
    }

    public double getVenituri(){/*metode abstracte - ca sa respect contractul - interfata*/
        return 0;
    }

    public double getTaxePlatite(){
        return 0;
    }

    public double getTaxeNeplatite(){
        return 0;
    }
}
