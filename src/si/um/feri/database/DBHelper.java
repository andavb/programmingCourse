package si.um.feri.database;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Artikel_racun.Artikli;
import Artikel_racun.Helper;
import Artikel_racun.JsonSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBHelper{

    private static BasicDataSource dataSource;
    private static Gson podatki;
    private Povezava con;

    public static class Povezava{
        private String povezava;
        private String uporabnik;
        private String geslo;

        public Povezava(String povezava, String uporabnik, String geslo) {
            this.povezava = povezava;
            this.uporabnik = uporabnik;
            this.geslo = geslo;
        }

        public String getPovezava() {
            return povezava;
        }

        public void setPovezava(String povezava) {
            this.povezava = povezava;
        }

        public String getUporabnik() {
            return uporabnik;
        }

        public static Povezava pridobiPovezavo(){
            try{
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/andrejavbelj/IdeaProjects/vaja1/JSON_files/povezava.json"));

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Povezava p = gson.fromJson(bufferedReader, Povezava.class);

                return p;
            }
            catch (Exception e){
                System.out.println("napaaka");
            }
            return null;
        }
    }


    public static BasicDataSource getDataSource()
    {
        Povezava con = Povezava.pridobiPovezavo();

        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(con.povezava);
            ds.setUsername(con.uporabnik);
            ds.setPassword(con.geslo);


            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }

        return dataSource;
    }


}
