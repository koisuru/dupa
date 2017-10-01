package pl.koisuru.johncena;

/**
 * Created by uczen on 2017-10-01.
 */

public class Ksiazka {

    private String tytul;

    private String streszczenie;
    public Ksiazka(String tytul, String streszczenie){

        this.setTytul(tytul);
        this.setStreszczenie(streszczenie);
    }


    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getStreszczenie() {
        return streszczenie;
    }

    public void setStreszczenie(String streszczenie) {
        this.streszczenie = streszczenie;
    }
}
