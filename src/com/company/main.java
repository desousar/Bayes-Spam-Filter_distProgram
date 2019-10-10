package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {

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
        //-----Test with a ham kallibrate----------
      HamKallibrate mailToTest = new HamKallibrate();
        String pathName = "0002.2fe846db6e3249836abdbfcae459bf2a"; //choose the ham kallibrate and copy paste the file
        mailToTest.kallibrateMailToSet(pathName);
        //Pour le 1er ham kallibrate : 0001.ea7e79d3153e7469e7a9c3e0af6a357e; P(S)=52.99%
        //Pour le 2eme ham kallibrate : 0001.f0cf04027e74802f09f723cb8916b48e; P(S)=59.01% (en 3min43)
        //Pour le 3eme ham kallibrate : 0002.2fe846db6e3249836abdbfcae459bf2a; P(S)=58.87% (en 5min19)

        //-----Test with a spam kallibrate-----
/*        SpamKallibrate mailToTest = new SpamKallibrate();
        String pathName = "00041.f1b3402799046db3c1f143a911dc085d"; //choose the spam kallibrate and copy paste the file
        mailToTest.kallibrateMailToSet(pathName);
        //Pour le 1er spam kallibrate : 00040.949a3d300eadb91d8745f1c1dab51133; P(S)=57.32% (en 5min20)
        //Pour le 2eme spam kallibrate :  00041.f1b3402799046db3c1f143a911dc085d; P(S)=56.67% (en 5min17)
*/

        double numerateurS = 0.0;
        double denominateurS = 0.0;
        double denominateurH = 0.0;
        for (String str : mailToTest.getTableFinal(pathName)) {
            if (h.containWord(str) && s.containWord(str)) {
                numerateurS += s.pourcentageForOneWordInSpamAnlern(str);
                denominateurS += s.pourcentageForOneWordInSpamAnlern(str);
                denominateurH += h.pourcentageForOneWordInHamAnlern(str);
            }
        }
        double resultat = 0.0;
        resultat = (numerateurS / (denominateurS + denominateurH) * 100 );
        System.out.println("the resultat with the Bayes formul: probility that this mail is a spam : " + resultat + " %");

    }
}