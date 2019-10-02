package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class spamAnlern {

    private HashMap<String, Integer> tableFinal = new HashMap<>(); //List von alle Wörter von alle Mail max: 2551-126 =2425

    public HashMap<String, Integer> getTableFinal(){
        return tableFinal;
    }

    public void anlern() throws IOException {


        HashMap<String, Integer> tableEnCours = new HashMap<>(); //List von jede einzelne Mail mit Wörter max :1
        String line;

        File repertoire = new File("Programmieraufgabe1/spam-anlern");
        String liste[] = repertoire.list();

        for (String s : liste) {
            System.out.println("une liste :" + s);

            try {
                BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/spam-anlern/" + s));

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

        BufferedWriter visualisation = new BufferedWriter(new FileWriter("spam-anlern.txt"));
        Set listkeys = tableFinal.keySet();
        Iterator it = listkeys.iterator();
        String str = " ";
        while (it.hasNext()){
            Object key = it.next();
            str = key + " " + tableFinal.get(key) + "\n";
            visualisation.write(str);
        }
    }

}
