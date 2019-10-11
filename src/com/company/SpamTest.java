package com.company;

import java.io.*;
import java.util.*;

public class SpamTest {
    private Set<String> tableFinal = new HashSet<>();

    public Set<String> testMailToSet(String s) throws IOException {
        tableFinal.clear();
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/spam-test/" + s));

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

        //write into the ham-test.txt all the set
        BufferedWriter visualisation = new BufferedWriter(new FileWriter("spam-test.txt"));
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

    public Set<String> getTableFinal(String testMail) throws IOException {
        this.testMailToSet(testMail);
        return tableFinal;
    }
}