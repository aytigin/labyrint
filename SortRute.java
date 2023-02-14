public class SortRute extends Rute {
  public SortRute(Labyrint l, int rad, int kol) {
    super(l, rad, kol);
  }
  public char tilTegn(){
    return '#';
  }

  @Override
  public void gaa(Rute forrige, String vei){
  }
}
