package pl.koisuru.powtorka;

import java.io.Serializable;

/**
 * Created by uczen on 2017-11-04.
 */

public class Klasa  implements Serializable{
    private String tytul;
    private String logo;
    private String opis;
    private float ocena;
    public Klasa(String tytul, String logo, String opis, float ocena){
        this.setTytul(tytul);
        this.setLogo(logo);
        this.setOpis(opis);
        this.setOcena(ocena);
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
