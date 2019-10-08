package com.company;

import java.io.*;
import java.util.*;

public class HamAnlern {

    private HashMap<String, Double> tableFinal = new HashMap<>(); //List with all words from all mail (ohne Mehrfachzählung in ein Mail)

    public HamAnlern() throws IOException {

        String line;

        //obtain a list with all Files that contain our pathname
        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String[] liste = repertoire.list();

        assert liste != null;
        for (String s : liste) {
            HashMap<String, Double> tableEnCours = new HashMap<>();//List just for one mail

            try {
                BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-anlern/" + s));

                while ((line = in.readLine()) != null) {
                    line = line.toLowerCase();
                    StringTokenizer st = new StringTokenizer(line, " "); //split line
                    while (st.hasMoreTokens()) {
                        String str = st.nextToken();
                        if (!tableEnCours.containsKey(str)) {
                            tableEnCours.put(str, 1.0); //max rate apparition for one word = 1
                        }

                    }
                }
                in.close();

                //convert the map tableEnCours to a set tableEnCours, so that we can work on it
                Set<Map.Entry<String, Double>> setMap = tableEnCours.entrySet();

                for (Iterator<Map.Entry<String, Double>> it = setMap.iterator(); it.hasNext(); ) {
                    Map.Entry<String, Double> map = it.next();
                    //we put all tableEnCours in this map : tableFinal
                    if (tableFinal.containsKey(map.getKey())) {
                        tableFinal.put(map.getKey(), tableFinal.get(map.getKey()) + 1.0);
                    } else {
                        tableFinal.put(map.getKey(), 1.0);
                    }
                }
                tableEnCours.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        //to verify our code, we write the tableFinal in a txt => word + number of apparition in different mail
        this.write();
    }

    // return our map tableFinal
    public HashMap<String, Double> getTableFinal() throws IOException {
        return tableFinal;
    }

    //method to check if hamAnlern contains a word
    public boolean containWord(String wordKallibrate) {
        Set<Map.Entry<String, Double>> setMap = tableFinal.entrySet();
        for (Map.Entry<String, Double> setHam : setMap) {
            if (setHam.getKey().equals(wordKallibrate)) {
                 return true;
            }
        }
        return false;
    }

    //return number of file in the pathname
    public int numberOfFileHamAnlern(){
        int number = 0;
        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String[] liste = repertoire.list();
        number = liste.length;
        return number;
    }

    //return rate of apparition for one word in the tableFinal
    public double pourcentageForOneWordInHamAnlern(String word) throws IOException {
        int allFile =0;
        allFile = this.numberOfFileHamAnlern(); //number of file
        double numberForWord = 0;
        numberForWord = this.getTableFinal().get(word); //value of map from hamAnlern
        double result;
        result = numberForWord/allFile;
        return result;
    }

    /*If spamAnlern contain a word that hamAnlern doesn't contain, we add it with a rate of apparition very small :
    it is for the mathematical formule*/
    public void addWordNotInSpamAnlern(SpamAnlern s) throws IOException{
        Set<Map.Entry<String, Double>> setMap = s.getTableFinal().entrySet();
        for (Map.Entry<String, Double> e : setMap) {
            if (!this.containWord(e.getKey())) {
                tableFinal.put(e.getKey(), 0.01);
            }
        }
    }

    //write the map in a txt, so that we can verify what there is inside (word and rate od apparition)
    public void write() throws IOException {
        BufferedWriter visualisation = new BufferedWriter(new FileWriter("ham-anlern.txt"));
        Set listkeys = tableFinal.keySet();
        Iterator it = listkeys.iterator();
        String str = " ";
        while (it.hasNext()) {
            Object key = it.next();
            str = key + " " + tableFinal.get(key) + "\n";
            visualisation.write(str);
        }
    }
}
