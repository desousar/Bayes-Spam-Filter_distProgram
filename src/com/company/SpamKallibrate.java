package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SpamKallibrate {
    private Set<String> tableFinal = new HashSet<>();

    public Set<String> kallibrateMailToSet(String s) throws IOException {
        tableFinal.clear();
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/spam-kallibrierung/" + s));

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
