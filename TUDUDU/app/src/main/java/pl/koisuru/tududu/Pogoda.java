package pl.koisuru.tududu;

/**
 * Created by uczen on 2017-10-07.
 */

public class Pogoda {
    private String miasto;
    private String data;
    private String opis;
    private Double temp;
    private String icon;
    public Pogoda (String miasto, String data, String opis, Double temp, String icon){
        this.setMiasto(miasto);
        this.setData(data);
        this.setOpis(opis);
        this.setTemp(temp);
        this.setIcon(icon);
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
