public class Aapning extends HvitRute {
  public Aapning(Labyrint l, int rad, int kol) {
    super(l, rad, kol);

  }

  @Override
  public boolean erAapning(){
    return true;
  }

  @Override
  public void gaa(Rute forrige, String vei){
    String minVei = vei + "(" + rad + ", " + kol + ")";
    lab.leggTilUtvei(minVei);
  }
}
