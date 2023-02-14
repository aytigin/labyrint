public abstract class Rute {
  protected int rad;
  protected int kol;

  public Rute nord;
  public Rute syd;
  public Rute vest;
  public Rute oest;



  protected Labyrint lab;

  public Rute(Labyrint lab, int rad, int kol){
    this.lab = lab;
    this.rad = rad;
    this.kol = kol;

    nord = null;
    syd = null;
    vest = null;
    oest = null;
  }

  public abstract void gaa(Rute forrige, String vei);


  public void finnUtvei(){
    gaa(this, "");
  }

  public boolean erAapning() {
    return false;
  }

  public abstract char tilTegn();
}
