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

//    //Cast 3 - rada domku:
//    //presun zofky na levou stranu plochy
//    odchodVlevo(450);
//
//    //cyklus pro nakresleni rady domku
//    for (int i = 0; i < 5; i++) {
//      nakresliDomek(100, 60);
//      popojdiDoprava(90,60);
//    }
//
//    //zofka nakresli posledni dva domky o radu nize
//    zofka.turnRight(90); //Zofka kouka dolu
//    zofka.move(200); //Zofka se posunula dolu
//    zofka.turnLeft(180); //Zofka kouka nahoru
//    odchodVlevo(100+60); //Zofka se zarovna s hornim domkem - jde o soucet strCtverce a pixels z popojdiDoprava
//    nakresliDomek(100,60); //Zofka skonci a kouka dolu
//    zofka.turnLeft(180); //Zofka kouka nahoru
//    odchodVlevo(5*(100+60)-30); //presun pod prvni domek - odpovida priblizne strCverce + pixels z popojdiDoprava * pocet iteraci
//    nakresliDomek(100,60); //rada domku je hotova
//    //TODO zjistit jak vyrobit promennou z parametru metod

    //Cast 1 - nakresli prasatko
    nakresliPrasatko();
    //TODO nakreslit prase mezi poslední dva domky
  }



  //Seznam metod:
  private void nakresliCtverec(int strCtverce) {
    zofka.penDown();
    for (int i = 0; i < 4; i++) {
      zofka.move(strCtverce);
      zofka.turnRight(90);
    }
  }

  private void nakresliObdelnik() {
    zofka.penDown();
    for (int i = 0; i < 2; i++) {
      zofka.move(100);
      zofka.turnRight(90);
      zofka.move(150);
      zofka.turnRight(90);
    }
  }

  /** *Metoda nakreslí čáru z výchozího bodu pod úhlem 30°. Hodí se pro nakreslení ocasu či nohou.* **/
  private void nakresliCaru (int byAngle) {
    int pixels = 30;
    zofka.penDown();
    zofka.turnLeft(byAngle);
    zofka.move(pixels);
    zofka.turnLeft(180);
    zofka.penUp();
    zofka.move(pixels);
  }
  /** * Metoda nakreslí stříšku z jednoho výchozího bodu. Např. nakreslí nohy praseti.* **/
  private void nakresliNozicky() {
    nakresliCaru(60);
    nakresliCaru(270);
  }

  /** *Prase je složeno z obdélníku, hlavy (střechy), ocasu a nožiček. Žofka skončí hlavou nahoru* **/
  private void nakresliPrasatko() {
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
  private void nakresliStrechu(int strStrechy) {
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
  private void odchodVlevo(int pixels) {
    zofka.penUp();
    zofka.turnLeft(90);
    zofka.move(pixels);
    zofka.turnLeft(180);
  }

  /** * Metoda nakreslí čtverec se střechou.
   * Žofka zůstane koukat dolů pod 30° úhlem od horní stěny čtverce * **/
  private void nakresliDomek(int strCtverce, int strStrechy) {
    nakresliCtverec(strCtverce);
    nakresliStrechu(strStrechy);
  }

  /** * Metoda vytvořená pro posun doprava, když Žofka kouká dolů.
   * Pro posun po dokreslení domečku zadej úhel 90° a 60 px. Žofka se tím srovná s horní stěnou čtverce* **/
  private void popojdiDoprava(int byAngle, int pixels) {
    zofka.penUp();
    zofka.turnLeft(byAngle);
    zofka.move(pixels);
  }
}
