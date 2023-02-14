public class HvitRute extends Rute {
  public HvitRute(Labyrint l, int rad, int kol) {
    super(l, rad, kol);
  }
  public char tilTegn(){
    return '.';
  }

  @Override
  public void gaa(Rute forrige, String vei){

    String minVei = vei + "(" + rad + ", " + kol + ") --> ";
    
    if (nord != forrige) {
      nord.gaa(this, minVei);
    }
    if (syd != forrige) {
      syd.gaa(this, minVei);
    }
    if (vest != forrige) {
      vest.gaa(this, minVei);
    }
    if (oest != forrige) {
      oest.gaa(this, minVei);
    }
  }
}
