package pl.koisuru.johncena;

/**
 * Created by uczen on 2017-09-30.
 */

public class Album {

    private String tytul;
    private String wydawnictwo;
    private String rok;
    private int okladka;

    public Album(String tytul, String wydawnictwo, String rok, int okladka) {
        this.tytul = tytul;
        this.wydawnictwo = wydawnictwo;
        this.rok = rok;
        this.okladka = okladka;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public int getOkladka() {
        return okladka;
    }

    public void setOkladka(int okladka) {
        this.okladka = okladka;
    }
}
