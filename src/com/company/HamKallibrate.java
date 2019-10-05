package com.company;

import java.io.*;
import java.util.*;

public class HamKallibrate {
    private Set<String> tableFinal = new HashSet<>();

    public Set<String> kallibrateMailToSet(String s) throws IOException {
        tableFinal.clear();
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-kallibrierung/" + s));

            while ((line = in.readLine()) != null) {
                line = line.toLowerCase();
                StringTokenizer st = new StringTokenizer(line, " "); //split line
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    tableFinal.add(str);

                }
            }
            //System.out.println("the set : " + tableFinal); //print a correct set
            in.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //write into the ham-kallibrate.txt all the set
        BufferedWriter visualisation = new BufferedWriter(new FileWriter("ham-kallibrate.txt"));
        Iterator it = tableFinal.iterator();
        String str = " ";
        while(it.hasNext()) {
            Object word = it.next();
            str = (String) word;
            visualisation.write(str);
            visualisation.newLine();
        }
        visualisation.close();

        return tableFinal;
    }

    /* sert uniquement au test :
    < System.out.println("the hk-table " + hk.getTableFinal(hk, kallibrateMail)); //this is the correct set of the ham kallibrate that we test >
    dans le main
     */
    public Set<String> getTableFinal(HamKallibrate hk, String kallibrateMail) throws IOException {
        hk.kallibrateMailToSet(kallibrateMail);
        return tableFinal;
    }
}



