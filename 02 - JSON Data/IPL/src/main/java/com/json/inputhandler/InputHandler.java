package com.json.inputhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.censored.Censor;
import com.json.classes.Matches;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


import java.io.BufferedWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class InputHandler {

    public static void jsonFile(String filePath){
        String filePath_json = "src/main/java/com/json/content/censor/iplout.json";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath_json))) {
            ObjectMapper mapper = new ObjectMapper();

            Matches[] matches = mapper.readValue(new File(filePath), Matches[].class);

            for (Matches match : matches) {
                match.setTeam1(Censor.apply(match.getTeam1()));
                match.setTeam2(Censor.apply(match.getTeam2()));
                match.setPlayer_of_match(Censor.redacted(match.getPlayer_of_match()));
            }

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matches);
            bw.write(json);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void csvFile(String filePath){
        String filePath_csv = "src/main/java/com/json/content/censor/iplout.csv";
        try(CSVReader reader = new CSVReader(new FileReader(filePath));
            CSVWriter writer = new CSVWriter(new FileWriter(filePath_csv));
        ){
            String[] header = reader.readNext();
            writer.writeNext(header);

            String[] row;

            while((row = reader.readNext())!= null){
                row[1] = Censor.apply(row[1]);
                row[2] = Censor.apply(row[2]);
                row[6] = Censor.redacted(row[6]);
                writer.writeNext(row);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
