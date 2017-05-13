package com.mikerussell.conjugation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mrussell on 5/12/17.
 */
public class VerbInventory implements IVerbInventory{

    private List<Verb> verbs;

    VerbInventory(String filename){
     loadVerbsFromFile(filename);
    }



    public void loadVerbsFromFile(String filename){


        //TODO: Load CSV File

        List<Verb> vl = new ArrayList<Verb>();
        //TODO: For each row, add verb to verb array

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] vs = line.split(cvsSplitBy);
                vl.add(new Verb(vs[0],vs[1],vs[2],vs[3],vs[4], vs[5].equalsIgnoreCase("true")));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            verbs = vl;
        }



    }

    public List<Verb> getVerbs(){
        return verbs;
    }

    public List<Verb> getIrregularVerbs(){
        return getVerbs().stream().filter(v -> v.getIrregular() == true).collect(Collectors.toList());
    }
}
