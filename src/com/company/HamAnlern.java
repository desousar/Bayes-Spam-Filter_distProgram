package com.company;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.io.*;
import java.util.*;

public class HamAnlern {

    private HashMap<String, Double> tableFinal = new HashMap<>(); //List von alle Wörter von alle Mail

    public HamAnlern() throws IOException {

        String line;

        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String[] liste = repertoire.list();

        assert liste != null;
        for (String s : liste) {
            HashMap<String, Double> tableEnCours = new HashMap<>();//List von jede einzelne Mail mit Wörter max :1
            //System.out.println("une liste :" + s);


            try {
                BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-anlern/" + s));

                while ((line = in.readLine()) != null) {
                    line = line.toLowerCase();
                    StringTokenizer st = new StringTokenizer(line, " "); //split line
                    while (st.hasMoreTokens()) {
                        String str = st.nextToken();
                        if (!tableEnCours.containsKey(str)) {
                            tableEnCours.put(str, 1.0);
                        }

                    }
                }
                in.close();

                Set<Map.Entry<String, Double>> setMap = tableEnCours.entrySet();

                for (Iterator<Map.Entry<String, Double>> it = setMap.iterator(); it.hasNext(); ) {
                    Map.Entry<String, Double> map = it.next();
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

        this.write();
    }

    /* sert uniquement au test :
    < System.out.println("the ham-table " + h.getTableFinal(h)); //this is the correct map of all word from ham.anlern >
    dans le main
    */
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
    public int numberOfFileHamAnlern(){
        int number = 0;
        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String[] liste = repertoire.list();
        number = liste.length;
        return number;
    }

    public double pourcentageForOneWordInHamAnlern(String word) throws IOException {
        int allFile =0;
        allFile = this.numberOfFileHamAnlern(); //number of file
        double numberForWord = 0;
        numberForWord = this.getTableFinal().get(word); //value of map from hamAnlern
        double result;
        result = numberForWord/allFile;
        //System.out.println("the result is " + result);
        return result;
    }
    public void addWordNotInSpamAnlern(SpamAnlern s) throws IOException{
        Set<Map.Entry<String, Double>> setMap = s.getTableFinal().entrySet();
        for (Map.Entry<String, Double> e : setMap) {
            if (!this.containWord(e.getKey())) {
                tableFinal.put(e.getKey(), 0.01);
            }
        }
    }
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
