package contribuabili; /*calea catre .java
Pachetul = mod coerent de grupare

- ierarhiile una langa alta
- in acelasi pachet nu este nevoie de import, dar in pachete separate trebuie facut import
- in pachete diferite pot exista clase denumite la fel

O interfata = entitate ce are doar partea de comportament, fara stare

- declara metodele pe care ceilalti sunt obligati sa le utilizeze, un comportament ce trebuie indeplinit
- poate fi considerata drept un contract
- ea nu exista pana nu apare o clasa care sa foloseasca comportamentul respectiv

*/

public interface Contribuabil {
    int counter = 1;
    int getId();
    double getVenituri();//cine va implementa interfata va spune intr-o alta clasa cum sa getVenituri, getTaxe, getId...
    double getTaxePlatite();
    double getTaxeNeplatite();
    /* metodele set, get sunt ptr a modifica un parametru declarat private - se acceseaza din afara */
}
