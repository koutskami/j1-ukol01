package cz.czechitas.java.ukol01;

import cz.czechitas.java.ukol01.engine.Turtle;

public class HlavniProgram {
  private Turtle zofka;
  public static void main(String[] args) {
    new HlavniProgram().start();
  }

  public void start() {
    zofka = new Turtle();

    //TODO implementace domácího úkolu

    //Cast 3 - rada domku:
    //presun zofky na levou stranu plochy
    odchodVlevo(450);

    //cyklus pro nakresleni rady domku
    for (int i = 0; i < 5; i++) {
      nakresliDomek(100, 60);
      popojdiDoprava(90,60);
    }

    //zofka nakresli posledni dva domky o radu nize
    zofka.turnRight(90); //Zofka kouka dolu
    zofka.move(200); //Zofka se posunula dolu
    zofka.turnLeft(180); //Zofka kouka nahoru
    odchodVlevo(100+60); //Zofka se zarovna s hornim domkem - jde o soucet strCtverce a pixels z popojdiDoprava
    nakresliDomek(100,60); //Zofka skonci a kouka dolu
    zofka.turnLeft(180); //Zofka kouka nahoru
    odchodVlevo(((5 * (100 + 60)) - 30)); //presun pod prvni domek - odpovida priblizne strCverce + pixels z popojdiDoprava * pocet iteraci
    nakresliDomek(100,60); //rada domku je hotova, Zofka kouka dolu
    zofka.penUp();
    zofka.move(100); //Zofka sejde po strane ctverce, kouka dolu
    zofka.turnLeft(90); //chci aby koukala doleva
    //TODO zjistit jak vyrobit promennou z parametru metod

    //Cast 1 - nakresleni prasete
    popojdiDoprava(0, 150);
    zofka.turnLeft(90); //potrebuju aby Zofka koukala nahoru, nez zacne kreslit prase
    nakresliPrasatko(); //Zofka nakresli prase a kouka nahoru

    //TODO slunicko nakreslit nad domy
    //Cast 2 - dva mnohouhelniky a slunicko
    //nakresliKolecko(100,8); //osmiuhelnik
    //nakresliKolecko(100,30);
    //nakresliKolecko(100,20);
    zofka.move(400);
    nakresliSlunicko(100,20);
    popojdiDoprava(0, 30); //Zofka kouka doleva

//    //TODO podepsat se pod domky a prase - MISA
    zofka.turnLeft(90);
    zofka.move(650); //presun dolu
    zofka.turnLeft(180); //aby Zofka koukala nahoru
    podpisMisa(80);
  }


  //Seznam metod:
  public void nakresliCtverec(int strCtverce) {
    zofka.penDown();
    for (int i = 0; i < 4; i++) {
      zofka.move(strCtverce);
      zofka.turnRight(90);
    }
  }

  public void nakresliObdelnik() {
    zofka.penDown();
    for (int i = 0; i < 2; i++) {
      zofka.move(100);
      zofka.turnRight(90);
      zofka.move(150);
      zofka.turnRight(90);
    }
  }

  /** *Metoda nakreslí čáru o 30 px z výchozího bodu pod vybraným úhlem.* **/
  public void nakresliCaru (int byAngle) {
    int pixels = 30;
    zofka.penDown();
    zofka.turnLeft(byAngle);
    zofka.move(pixels);
    zofka.turnLeft(180);
    zofka.penUp();
    zofka.move(pixels);
  }
  /** * Metoda nakreslí stříšku z jednoho výchozího bodu. Např. nakreslí nohy praseti.* **/
  public void nakresliNozicky() {
    nakresliCaru(60);
    nakresliCaru(270);
  }

  /** *Prase je složeno z obdélníku, hlavy (střechy), ocasu a nožiček. Žofka skončí hlavou nahoru* **/
  public void nakresliPrasatko() {
    nakresliObdelnik();
    nakresliStrechu(60);
    zofka.penUp();
    zofka.move(150);//hodnota strB
    nakresliCaru(30);
    zofka.turnLeft(60);
    zofka.move(100);//hodnota strA
    zofka.turnRight(90);
    nakresliNozicky();
    zofka.turnLeft(30);
    zofka.move(150);
    nakresliNozicky();
    zofka.turnRight(60);
  }

  /** *Metoda nakreslí dvě stěny trojúhelníku bez báze s úhlem 60°.
   * Parametr je délka strany. Pro čtverec o 100 px je vhodná délka strany střechy 60 px* **/
  public void nakresliStrechu(int strStrechy) {
    zofka.turnLeft(30);
    for (int i = 0; i < 2; i++) {
      int uhelTrojuhelniku = 60;
      zofka.move(strStrechy);
      zofka.turnRight(uhelTrojuhelniku);
      //TODO druhá strana trochu přesahuje, šlo by vylepšit
    }
  }

  /** * Aby Žofka odešla vlevo, tak musí být otočená nahoru.
   * Parametr je vzdálenost, kterou Žofka ujde.
   * Po použití metody je Žofka nachystaná na metodu nakresliDomek
   * Z půlky pole je to cca 450 pixelů. * **/
  public void odchodVlevo(int pixels) {
    zofka.penUp();
    zofka.turnLeft(90);
    zofka.move(pixels);
    zofka.turnLeft(180);
  }

  /** * Metoda nakreslí čtverec se střechou.
   * Žofka zůstane koukat dolů pod 30° úhlem od horní stěny čtverce * **/
  public void nakresliDomek(int strCtverce, int strStrechy) {
    nakresliCtverec(strCtverce);
    nakresliStrechu(strStrechy);
  }

  /** * Metoda vytvořená pro posun doprava, když Žofka kouká dolů.
   * Pro posun po dokreslení domečku zadej úhel 90° a 60 px. Žofka se tím srovná s horní stěnou čtverce* **/
  public void popojdiDoprava(int byAngle, int pixels) {
    zofka.penUp();
    zofka.turnLeft(byAngle);
    zofka.move(pixels);
  }

  //kolecko prevzato z podkladu
  /**
   * Nakreslí „kolečko“ – pravidelný mnohoúhelník se zadaným „poloměrem“ a počtem stran.
   *
   * Výpočet délky strany se provádí tak, že si mnohoúhelník rozdělím na trojúhelníky tvořené jednou
   * stranou mnohoúhelníku a spojnicí sousedních vrcholů se středem. Jde tedy o rovnoramenný trojúhelík.
   * Tento trojúhelník se rozdělí na dva shodné pravoúhlé trojúhelníky tím, že se vztyčí kolmice ze středu
   * strany mnohoúhelníku, které prochází středem trojúhelníku.
   * Přepona tohoto trojúhelníku je spojnice středu a vrcholu mnohoúhelníku, jedna přepona je polovina strany
   * mnohoúhelníku, druhá přepona je ona kolmice. Známý úhel je úhel u středu mnohoúhelníky, který je polovinou
   * středového úhlu mnohoúhelníku.
   *
   * @param polomer Poloměr kolečka – vzdálenost mezi středem a vrcholem mnohoúhelíku.
   * @param pocetStran Počet stran mnohoúhelníku. Doporučeno volit číslo, které je celočíselným dělitelem 360.
   */
  public void nakresliKolecko(int polomer, int pocetStran) {
    zofka.penUp();
    zofka.move(polomer);
    zofka.penDown();

    // o kolik stupnů se musí želva otočit, když má kreslit další stranu mnohoúhelníku
    // zároven je to velikost úhlu, který má vrchol ve středu mnohoúhelníku a spojuje střed a dva sousedící vrcholy mnohoúhelníku
    int uhel = 360 / pocetStran;

    // sinus úhlu = délka protilehlé odvěsny / délka přepony
    // úhel = polovina vnitřního úhlu
    // přepona = spojnice středu a vrcholu
    // odvěsna = polovina strany mnohoúhelníku
    int delkaStrany = (int) (Math.sin(Math.PI * (double) uhel / 360d) * polomer * 2);

    zofka.turnRight(90);
    for (int i = 0; i < pocetStran; i++) {
      zofka.move(delkaStrany);
      zofka.turnRight(uhel);
    }
    zofka.turnLeft(90);
  }

//nepodarilo se mi poresit jinak, neni to uplne nejstatstnejsi reseni
  public void nakresliSlunicko(int polomer, int pocetStran) {
    zofka.penUp();
    zofka.move(polomer);
    zofka.penDown();

    int uhel = 360 / pocetStran;

    int delkaStrany = (int) (Math.sin(Math.PI * (double) uhel / 360d) * polomer * 2);

    for (int i = 0; i < pocetStran + 3; i++) {
      nakresliCaru(10);
      zofka.move(delkaStrany);
      zofka.turnRight(uhel);
    }
    zofka.turnLeft(90);
  }

  //Nasleduji metody co vypisuji pismena, soucasti metody je popojiti doprava
  public void pismenoM(int vyskaPismene) {
    double uhelStrisky = 120;
    int velikostStrisky = vyskaPismene / 2;
    zofka.penDown();
    zofka.move(vyskaPismene);
    zofka.turnRight(uhelStrisky);
    zofka.move(velikostStrisky);
    zofka.turnLeft(uhelStrisky / 2);
    zofka.move(velikostStrisky);
    zofka.turnRight(uhelStrisky);
    zofka.move(vyskaPismene);
    popojdiDoprava(90,30);
  }
  public void pismenoI(int vyskaPismene) {
    zofka.turnLeft(90);
    zofka.move(vyskaPismene);
    zofka.turnLeft(180);
    zofka.penDown();
    zofka.move(vyskaPismene);
    popojdiDoprava(90,30);
  }
  public void pismenoS(int vyskaPismene) {
    zofka.penDown();
    int polovicniVyska = vyskaPismene / 2;
    zofka.move(polovicniVyska);
    int vnitrniUhel = 90;
      for (int i = 0; i < 2; i++) {
          zofka.turnLeft(vnitrniUhel);
          zofka.move(polovicniVyska);
      }
      for (int i = 0; i < 2; i++) {
          zofka.turnRight(vnitrniUhel);
          zofka.move(polovicniVyska);
      }
    zofka.penUp();
    zofka.turnRight(vnitrniUhel);
    zofka.move(vyskaPismene);
    popojdiDoprava(vnitrniUhel,30);
  }
  public void pismenoA(int vyskaPismene) {
    int delkaStrany = vyskaPismene + (vyskaPismene / 10);
    int vnitrniUhel = 65;
    int sirkaPismene = delkaStrany / 2;
    zofka.penDown();
    zofka.turnLeft(vnitrniUhel);
    zofka.move(delkaStrany);
    zofka.turnRight(vnitrniUhel * 2);
    zofka.move(delkaStrany);
    zofka.turnRight(180);
    zofka.penUp();
    zofka.move(sirkaPismene);
    zofka.turnLeft(vnitrniUhel);
    zofka.penDown();
    zofka.move(sirkaPismene);
    //navrat
    zofka.penUp();
    zofka.turnLeft(180);
    zofka.move(sirkaPismene);
    zofka.turnRight(vnitrniUhel);
    zofka.move(sirkaPismene);
    popojdiDoprava(vnitrniUhel,30);
  }
  public void podpisMisa(int vyskaPismene) {
    pismenoM(vyskaPismene);
    pismenoI(vyskaPismene);
    pismenoS(vyskaPismene);
    pismenoA(vyskaPismene);
  }
}
