import Artikel_racun.Artikel;
import Artikel_racun.Artikli;
import Artikel_racun.Podjetje;
import Artikel_racun.Racun;
import Barcode.Barcode_PDF;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



public class Main {

    public static void main(String[] args) {

        Podjetje tus = new Podjetje("Engrotuš d. o. o.", "87927497", "5494516000", true);
        Podjetje spar = new Podjetje("SPAR SLOVENIJA d.o.o.", "32156782", "5571693000", true);
        Podjetje mercator = new Podjetje("MERCATOR, d.d.", "45884595", "5300231000", true);

        Artikel kruh = new Artikel("Kruh", new BigDecimal("2.34"),9.5, "Slovenija");
        Artikel zobnaPasta = new Artikel("Zobna pasta", new BigDecimal("3.19"),9.5, "Nemčija");
        Artikel argetaPasteta = new Artikel("Pašteta Argeta", new BigDecimal(".99"),9.5, "Nemčja");
        Artikel sampon = new Artikel("Šampon", new BigDecimal("4.79"),9.5, "Hrvaška");
        Artikel kosmici = new Artikel("Kosmiči", new BigDecimal("3.55"),9.5, "Italija");
        Artikel ciki = new Artikel("Ciki", new BigDecimal("3.60"),22, "Avstrija");

        Artikli zaRacun1 = new Artikli();
        List<Racun> seznamRacunov = new ArrayList<>();

        zaRacun1.dodajArtikel(new Artikel(kruh));
        zaRacun1.dodajArtikel(new Artikel(zobnaPasta));
        zaRacun1.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun1.dodajArtikel(new Artikel(sampon));
        zaRacun1.dodajArtikel(new Artikel(kosmici));
        zaRacun1.dodajArtikel(new Artikel(ciki));
        zaRacun1.dodajArtikel(new Artikel(ciki));

        seznamRacunov.add(new Racun(new Date(), zaRacun1, tus, tus.getDavcnaStevilka()));

        Artikli zaRacun2 = new Artikli();

        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kosmici));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.odstraniArtikel(new Artikel(ciki));

        seznamRacunov.add(new Racun(new Date(), zaRacun2, spar, spar.getDavcnaStevilka()));

        for (Racun racuni: seznamRacunov){
            racuni.printajRacun();
            System.out.println("Search for SPAR SLOVENIJA d.o.o.: " + racuni.search("SPAR SLOVENIJA d.o.o."));
        }

        System.out.println("Search for Šampon: " + sampon.search("Šampon"));
        System.out.println("Search for Šadmpon: " + sampon.search("Šadmpon"));


        sampon.setEAN(12037761534L);

        System.out.println(sampon.getEAN());
        System.out.println(Artikel.checkDigit(sampon.getEAN(), 5));

    }
}
