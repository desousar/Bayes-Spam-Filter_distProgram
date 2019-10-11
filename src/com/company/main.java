package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
//Answer for ham-test => line 162 AND Answer for spam-test => line 204
        //Set up
        HamAnlern h = new HamAnlern();
        System.out.println("Constructor Ham");
        SpamAnlern s = new SpamAnlern();
        System.out.println("Constructor Spam");
        h.addWordFromSpamAnlernNotInHamAnlern(s);
        System.out.println("Add In Ham");
        s.addWordFromHamAnlernNotInSpamAnlern(h);
        System.out.println("Add in Spam");


        //Test phase
        //Test with all ham kallibrate AND Test with all spam kallibrate => use to define the SCHWELLENWERT
//-----Test with all ham kallibrate--------------------
/*//122        int ihk=1;
        List<Integer> listEnCoursHamKallibrate = new ArrayList<>();
        HamKallibrate hamKallibrateToTest = new HamKallibrate();
        File hamKallibrateRepertoire = new File("Programmieraufgabe1/ham-kallibrierung");
        String[] listeHamKallibrate = hamKallibrateRepertoire.list();
        assert listeHamKallibrate!=null;
        for( String pathName : listeHamKallibrate) {
            hamKallibrateToTest.kallibrateMailToSet(pathName);
            double numerateurS = 0.0;
            double denominateurS = 0.0;
            double denominateurH = 0.0;
            for (String strhk : hamKallibrateToTest.getTableFinal(pathName)) {
                if (h.containWord(strhk) && s.containWord(strhk)) {
                    numerateurS += s.pourcentageForOneWordInSpamAnlern(strhk);
                    denominateurS += s.pourcentageForOneWordInSpamAnlern(strhk);
                    denominateurH += h.pourcentageForOneWordInHamAnlern(strhk);
                }
            }
            double resultat = 0.0;
            resultat = (numerateurS / (denominateurS + denominateurH) * 100);
            System.out.println("ham Kallibrate the resultat with the Bayes formul: probability that this mail "+ihk+" is a spam : " + resultat + " %");
            ihk++;
            listEnCoursHamKallibrate.add((int) resultat);
        }
        Map<Integer,Integer> duplicateshk = new HashMap<>();
        for (int entier: listEnCoursHamKallibrate){
            if (duplicateshk.containsKey(entier)){
                duplicateshk.put(entier, duplicateshk.get(entier) + 1);
            }else{
                duplicateshk.put(entier,1);
            }
        }

        BufferedWriter visualisationhk = new BufferedWriter(new FileWriter("Resultat-ham-kallibrate.txt"));
        Set listkeyshk = duplicateshk.keySet();
        Iterator ithk = listkeyshk.iterator();
        String strWriteHk = " ";
        while (ithk.hasNext()) {
            Object key = ithk.next();
            strWriteHk = key + " " + duplicateshk.get(key) + "\n";
            visualisationhk.write(strWriteHk);
            System.out.println("write "+strWriteHk);
        }
        visualisationhk.close();
//in Resultat-ham-kallibrate.txt we can see the division of all the ham kallibrate with (int) percentage
//-----END Test with all ham kallibrate--------------------


//-----Test with all spam kallibrate--------------------
        int isk=1;
        List<Integer> listEnCoursSpamKallibrate = new ArrayList<>();
        SpamKallibrate spamKallibrateToTest = new SpamKallibrate();
        File spamKallibrateRepertoire = new File("Programmieraufgabe1/spam-kallibrierung");
        String[] listeSpamKallibrate = spamKallibrateRepertoire.list();
        assert listeSpamKallibrate!=null;
        for( String pathName : listeSpamKallibrate) {
            spamKallibrateToTest.kallibrateMailToSet(pathName);
            double numerateurS = 0.0;
            double denominateurS = 0.0;
            double denominateurH = 0.0;
            for (String strsk : spamKallibrateToTest.getTableFinal(pathName)) {
                if (h.containWord(strsk) && s.containWord(strsk)) {
                    numerateurS += s.pourcentageForOneWordInSpamAnlern(strsk);
                    denominateurS += s.pourcentageForOneWordInSpamAnlern(strsk);
                    denominateurH += h.pourcentageForOneWordInHamAnlern(strsk);
                }
            }
            double resultat = 0.0;
            resultat = (numerateurS / (denominateurS + denominateurH) * 100);
            System.out.println("spam Kallibrate the resultat with the Bayes formul: probability that this mail "+isk+" is a spam : " + resultat + " %");
            isk++;
            listEnCoursSpamKallibrate.add((int) resultat);
        }
        Map<Integer,Integer> duplicatessk = new HashMap<>();
        for (int entier: listEnCoursSpamKallibrate){
            if (duplicatessk.containsKey(entier)){
                duplicatessk.put(entier, duplicatessk.get(entier) + 1);
            }else{
                duplicatessk.put(entier,1);
            }
        }

        BufferedWriter visualisationsk = new BufferedWriter(new FileWriter("Resultat-spam-kallibrate.txt"));
        Set listkeyssk = duplicatessk.keySet();
        Iterator itsk = listkeyssk.iterator();
        String str = " ";
        while (itsk.hasNext()) {
            Object key = itsk.next();
            str = key + " " + duplicatessk.get(key) + "\n";
            visualisationsk.write(str);
            System.out.println("write "+str);
        }
        visualisationsk.close();
//in Resultat-spam-kallibrate.txt we can see an approximation of the division of all the spam kallibrate with (int) percentage
//-----END Test with all spam kallibrate--------------------

//----------SCHWELLENWERT----------
//CONCLUSION as see in the 2 resultat.txt => if P(S)>=56% = Spam
*/


//-----Test with all ham test--------------------
        int iht=1;
        List<Double> listEnCoursHamTest = new ArrayList<>();
        HamTest hamTestToTest = new HamTest();
        File hamTestRepertoire = new File("Programmieraufgabe1/ham-test");
        String[] listeHamTest = hamTestRepertoire.list();
        assert listeHamTest!=null;
        for( String pathName : listeHamTest) {
            hamTestToTest.testMailToSet(pathName);
            double numerateurS = 0.0;
            double denominateurS = 0.0;
            double denominateurH = 0.0;
            for (String strht : hamTestToTest.getTableFinal(pathName)) {
                if (h.containWord(strht) && s.containWord(strht)) {
                    numerateurS += s.pourcentageForOneWordInSpamAnlern(strht);
                    denominateurS += s.pourcentageForOneWordInSpamAnlern(strht);
                    denominateurH += h.pourcentageForOneWordInHamAnlern(strht);
                }
            }
            double resultat = 0.0;
            resultat = (numerateurS / (denominateurS + denominateurH) * 100);
            System.out.println("ham Test: the resultat with the Bayes formul: probability that this mail "+iht+" is a spam : " + resultat + " %");
            iht++;
            listEnCoursHamTest.add(resultat);
        }
        double howMuchHTIsSpam =0;
        for (double result : listEnCoursHamTest) {
            if (result >= 56){
                howMuchHTIsSpam += 1;
            }
        }
        double totalOfHamTest;
            File repertoireOfHamTest = new File("Programmieraufgabe1/ham-test");
            String[] listeOfHamTest = repertoireOfHamTest.list();
            totalOfHamTest = listeOfHamTest.length;
        double percentageOfHamTestIsSpam = howMuchHTIsSpam / totalOfHamTest;
        percentageOfHamTestIsSpam = percentageOfHamTestIsSpam *100;
        System.out.println("percentage of ham test who is maybe a spam : "+howMuchHTIsSpam+" / "+totalOfHamTest+" = " + percentageOfHamTestIsSpam+" %. We choose Anzahl alpha=0.001; Schwellenwert: P(S)>=56% = Spam.");
//calcul:118/1510*100=7.81456953642384 %
//-----END Test with all ham test--------------------


//-----Test with all spam test--------------------
        int ist=1;
        List<Double> listEnCoursSpamTest = new ArrayList<>();
        SpamTest spamTestToTest = new SpamTest();
        File spamTestRepertoire = new File("Programmieraufgabe1/spam-test");
        String[] listeSpamTest = spamTestRepertoire.list();
        assert listeSpamTest!=null;
        for( String pathName : listeSpamTest) {
            spamTestToTest.testMailToSet(pathName);
            double numerateurS = 0.0;
            double denominateurS = 0.0;
            double denominateurH = 0.0;
            for (String strst : spamTestToTest.getTableFinal(pathName)) {
                if (h.containWord(strst) && s.containWord(strst)) {
                    numerateurS += s.pourcentageForOneWordInSpamAnlern(strst);
                    denominateurS += s.pourcentageForOneWordInSpamAnlern(strst);
                    denominateurH += h.pourcentageForOneWordInHamAnlern(strst);
                }
            }
            double resultat = 0.0;
            resultat = (numerateurS / (denominateurS + denominateurH) * 100);
            System.out.println("spam Test: the resultat with the Bayes formul: probability that this mail "+ist+" is a spam : " + resultat + " %");
            ist++;
            listEnCoursSpamTest.add(resultat);
        }
        double howMuchSTIsSpam =0;
        for (double result : listEnCoursSpamTest) {
            if (result >= 56){
                howMuchSTIsSpam += 1;
            }
        }
        double totalOfSpamTest;
        File repertoireOfSpamTest = new File("Programmieraufgabe1/spam-test");
        String[] listeOfSpamTest = repertoireOfSpamTest.list();
        totalOfSpamTest = listeOfSpamTest.length;
        double percentageOfSpamTestIsSpam = howMuchSTIsSpam / totalOfSpamTest;
        percentageOfSpamTestIsSpam = percentageOfSpamTestIsSpam *100;
        System.out.println("percentage of spam test who is maybe a spam : "+howMuchSTIsSpam+" / "+totalOfSpamTest+" = " + percentageOfSpamTestIsSpam+" %. We choose Anzahl alpha=0.001; Schwellenwert: P(S)>=56% = Spam.");
//calcul:208/222*100=93.69369369369369 %
//-----END Test with all spam test--------------------


    }
}