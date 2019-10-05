package com.company;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.io.*;
import java.util.*;

public class HamAnlern {

    private HashMap<String, Integer> tableFinal = new HashMap<>(); //List von alle Wörter von alle Mail

    public void anlern() throws IOException {

        String line;

        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String[] liste = repertoire.list();

        assert liste != null;
        for (String s : liste) {
            HashMap<String, Integer> tableEnCours = new HashMap<>();//List von jede einzelne Mail mit Wörter max :1
            //System.out.println("une liste :" + s);


            try {
                BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-anlern/" + s));

                while ((line = in.readLine()) != null) {
                    line = line.toLowerCase();
                    StringTokenizer st = new StringTokenizer(line, " "); //split line
                    while (st.hasMoreTokens()) {
                        String str = st.nextToken();
                        if (!tableEnCours.containsKey(str)) {
                            tableEnCours.put(str, 1);
                        }

                    }
                }
                in.close();

                Set<Map.Entry<String, Integer>> setMap = tableEnCours.entrySet();

                for (Iterator<Map.Entry<String, Integer>> it = setMap.iterator(); it.hasNext(); ) {
                    Map.Entry<String, Integer> map = it.next();
                    if (tableFinal.containsKey(map.getKey())) {
                        tableFinal.put(map.getKey(), tableFinal.get(map.getKey()) + 1);
                    } else {
                        tableFinal.put(map.getKey(), 1);
                    }
                }
                tableEnCours.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

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

    /* sert uniquement au test :
    < System.out.println("the ham-table " + h.getTableFinal(h)); //this is the correct map of all word from ham.anlern >
    dans le main
    */
    public HashMap<String, Integer> getTableFinal(HamAnlern h) throws IOException {
        h.anlern();
        return tableFinal;
    }

    //method to check if hamAnlern contains a word
    public boolean containWord(String wordKallibrate) {
        Set<Map.Entry<String, Integer>> setMap = tableFinal.entrySet();
        for (Map.Entry<String, Integer> setHam : setMap) {
            if (setHam.getKey().equals(wordKallibrate)) {
                System.out.println("le mot " + wordKallibrate + " est present dans les deux sous " + setHam.getKey() + " et " + wordKallibrate);
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

    public double pourcentageForOneWordInHamAnlern(HamAnlern h, String word) throws IOException {
        int allFile =0;
        allFile = h.numberOfFileHamAnlern(); //number of file
        int numberForWord = 0;
        numberForWord = h.getTableFinal(h).get(word); //value of map from hamAnlern
        double result;
        result = (double) numberForWord/allFile;
        //System.out.println("the result is " + result);
        return result;
    }

}
