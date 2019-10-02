package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) throws IOException {
        /*HashMap<String, Integer> tableFinal = new HashMap<>(); //List von alle Wörter von alle Mail max: 2551-126 =2425
        HashMap<String, Integer> tableEnCours = new HashMap<>(); //List von jede einzelne Mail mit Wörter max :1
        String line;

        File repertoire = new File("Programmieraufgabe1/ham-anlern");
        String liste[] = repertoire.list();

        for (String s : liste) {
            System.out.println("une liste :" + s);

            try {
                BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-anlern/" + s));

                while ((line = in.readLine()) != null) {
                    line = line.toLowerCase();
                    StringTokenizer st = new StringTokenizer(line, " "); //split line
                    while (st.hasMoreTokens()) {
                        String str = st.nextToken();
                        if (!tableEnCours.containsKey(str))
                        {
                            tableEnCours.put(str, 1);
                        }
                    }
                }
                in.close();

                Set listkeys = tableFinal.keySet();
                Iterator it = listkeys.iterator();
                String str = " ";
                while (it.hasNext()){
                    Object key = it.next();
                    if (tableFinal.containsKey(key)){
                        tableFinal.put((String) key, tableFinal.get(key)+1);
                    }
                }

                tableFinal.putAll(tableEnCours);
                tableEnCours.clear();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        BufferedWriter visualisation = new BufferedWriter(new FileWriter("test.txt"));
        Set listkeys = tableFinal.keySet();
        Iterator it = listkeys.iterator();
        String str = " ";
        while (it.hasNext()){
            Object key = it.next();
            str = key + " " + tableFinal.get(key) + "\n";
            visualisation.write(str);
        }*/

        hamAnlern h = new hamAnlern();
        h.anlern();
        Set<Map.Entry<String , Integer>> setMap = h.getTableFinal().entrySet();


        spamAnlern s = new spamAnlern();
        s.anlern();


    }
}