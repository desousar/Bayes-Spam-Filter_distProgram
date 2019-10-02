package com.company;

import java.io.*;
import java.util.*;

public class HamAnlern {

    private HashMap<String, Integer> tableFinal = new HashMap<>(); //List von alle Wörter von alle Mail max: 2551-126 =2425

    public HashMap<String, Integer> getTableFinal(){
        return tableFinal;
    }

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
                        if (!tableEnCours.containsKey(str))
                        {
                            tableEnCours.put(str, 1);
                        }

                    }
                }
                in.close();

                Set<Map.Entry<String,Integer>> setMap = tableEnCours.entrySet();

                for (Iterator<Map.Entry<String, Integer>> it = setMap.iterator(); it.hasNext();){
                    Map.Entry<String,Integer> map =it.next();
                    if(tableFinal.containsKey(map.getKey())) {
                        tableFinal.put(map.getKey(), tableFinal.get(map.getKey()) + 1);
                    }
                    else{
                        tableFinal.put(map.getKey(),1);
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
        while (it.hasNext()){
            Object key = it.next();
            str = key + " " + tableFinal.get(key) + "\n";
            visualisation.write(str);
        }
    }

}
