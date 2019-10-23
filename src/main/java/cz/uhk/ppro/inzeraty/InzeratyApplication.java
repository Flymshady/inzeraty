package cz.uhk.ppro.inzeraty;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class InzeratyApplication {

    public static void main(String[] args) {
        SpringApplication.run(InzeratyApplication.class, args);
    }

    @Bean
    public UlozisteInzeratu uloziste() {
        UlozisteInzeratu u = new PametoveUlozisteInzeratu();

        Inzerat i1 = new Inzerat();
        i1.setKategorie("Prodám");
        i1.setText("iPhone X");
        i1.setCena(new BigDecimal(10000));

        Inzerat i2 = new Inzerat();
        i2.setKategorie("Koupím");
        i2.setText("Pixel 3");

        u.pridej(i1);
        u.pridej(i2);

        return u;
    }
}
