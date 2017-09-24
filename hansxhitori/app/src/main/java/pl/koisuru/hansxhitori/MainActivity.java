package pl.koisuru.hansxhitori;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private TextView tekst;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hwdp);
        tekst = (TextView) findViewById(R.id.jd);
        String napis = tekst.getText().toString();


        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);
        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);

        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);

        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);

        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);

        filmy.add(movie);
        filmy.add(mowie1);
        filmy.add(movie2);
        filmy.add(movie3);
        filmy.add(movie4);
        filmy.add(movie5);


        for(int i=0; i<filmy.size();i++){
            tekst.append("tytuł " + filmy.get(i).getTytul() + "posiada odcinków " + filmy.get(i).getDlugosc()+ "\n");
        }
    }

    public film movie = new film("boku no pico",3);
    public film mowie1 = new film(" ore no nounai sentakushi ga gakuen love comedy wo zenryoku de jama shiteiru",12);
    public film movie2 = new film("uragiri wa boku no namae wo shiteiru",24);
    public film movie3 = new film("ore no imoto wa konna ni kawai wake ga nai",24);
    public film movie4 = new film("watashi ga motenai no wa dou kangaetemo omaera ga warui",12);
    public film movie5 = new film("ore no kanojo to osananajimi ga shuraba sugiru",12);
    LinkedList<film> filmy = new LinkedList<>();


}
