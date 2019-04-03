package Artikel_racun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    public static <T> void pisanjeJSONdatotek(Class<T> generic, T input)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();



        String JSON = gson.toJson(input);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/andrejavbelj/IdeaProjects/vaja1/JSON_files/file.json"));
            writer.write(JSON);
            writer.close();
        }catch (IOException e){

        }
    }

    public static String branjeJSONdatotek(String filename)
    {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Object json = gson.fromJson(bufferedReader, Object.class);

            return json.toString();
        }
        catch (Exception e){
            System.out.println("napaaka");
        }
        return null;
    }
}
