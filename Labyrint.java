import java.util.Scanner;
import java.io.*;

public class Labyrint {
  public int rad;
  public int kol;
  protected Rute[][] lab;

  public Lenkeliste<String> utVei = new Lenkeliste<String>();

  private Labyrint(Rute[][] ruter, int rader, int kolonner){
    lab = ruter;
    rad = rader;
    kol = kolonner;
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner sc = new Scanner(fil);
    Rute[][] ruter = null;
    Labyrint labyrint = null;
    int raderInt = 0;
    int kolonnerInt = 0;
    String raderOgKolonner = sc.nextLine();
    String[] rOgK = raderOgKolonner.split(" ");
    raderInt = Integer.parseInt(rOgK[0]);
    kolonnerInt = Integer.parseInt(rOgK[1]);
    ruter = new Rute[raderInt][kolonnerInt];
    labyrint = new Labyrint(ruter, raderInt, kolonnerInt);


    // 1. Lag Ruter
    for(int i=0; i < ruter.length; i++) {
      Rute[] ruteArray = ruter[i];
      String linje = sc.nextLine();
      for (int j = 0; j<ruteArray.length; j++){
        char tegn = linje.charAt(j);
        if(tegn == '#'){
          ruteArray[j] = new SortRute(labyrint, i, j);
        } else if (tegn == '.' && (i == 0 || i == ruter.length - 1 || j == 0 || j == ruteArray.length -1)) {
          ruteArray[j] = new Aapning(labyrint, i, j);
        } else {
          ruteArray[j] = new HvitRute(labyrint, i, j);
        }
      }
    }

    // 2. Koble sammen
    for(int i=0; i < ruter.length; i++) {
      for (int j = 0; j< ruter[0].length; j++){
        Rute denne = ruter[i][j];
        if (i > 0) {
          denne.nord = ruter[i - 1][j];
        }
        if (i < ruter.length-1) {
          denne.syd = ruter[i + 1][j];
        }
        if (j > 0) {
          denne.oest = ruter[i][j - 1];
        }
        if (j < ruter[0].length-1) {
          denne.vest = ruter[i][j + 1];
        }
      }
    }

    return labyrint;
  }

  public void leggTilUtvei(String s) {
    utVei.leggTil(s);
  }
  public Lenkeliste<String> finnUtveiFra(int kol, int rad){
    lab[rad][kol].finnUtvei();
    return utVei;
  }

  public Rute hentRute(int r, int k){
    return lab[r][k];
  }

  @Override
  public String toString(){
    StringBuffer aString = new StringBuffer();
    for(int row = 0; row < lab.length; row++) {
     for(int col = 0; col < lab[row].length; col++) {
        aString.append(" " + lab[row][col].tilTegn());
     }
     aString.append("\n");
    }
  return aString.toString();
  }

}
