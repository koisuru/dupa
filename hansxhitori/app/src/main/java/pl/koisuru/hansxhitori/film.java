package pl.koisuru.hansxhitori;

public class film {
    private String tytul;
    private int dlugosc;
    public film(String tytul, int dlugosc){
        this.setTytul(tytul);
        this.setDlugosc(dlugosc);

    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }
}
