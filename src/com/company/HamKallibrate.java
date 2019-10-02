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
            in.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return tableFinal;
    }
}



