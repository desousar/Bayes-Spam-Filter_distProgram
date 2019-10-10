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
        System.out.println("Add in spam");


        //Test phase
        //-----Test with a ham kallibrate----------
        HamKallibrate hk = new HamKallibrate();
        String kallibrateMail = "0001.ea7e79d3153e7469e7a9c3e0af6a357e"; //choose the ham kallibrate and copy paste the file
        hk.kallibrateMailToSet(kallibrateMail);
        double numerateurS = 0.0;
        double denominateurS = 0.0;
        double denominateurH = 0.0;
        numerateurS = s.pourcentageForOneWordInSpamAnlern("been");
        denominateurS = s.pourcentageForOneWordInSpamAnlern("been");
        denominateurH = h.pourcentageForOneWordInHamAnlern("been");
        double resultat = 0.0;
        resultat = numerateurS / (denominateurS + denominateurH );
        System.out.println("the resultat with the Bayes formul for the word been is : " + resultat);//a la calculatrice j'ai 0.611605

        //-----Test with a spam kallibrate-----
        /*SpamKallibrate sk = new SpamKallibrate();
        sk.kallibrateMailToSet("00040.949a3d300eadb91d8745f1c1dab51133"); //choose the spam kallibrate and copy paste the file
        */


   /*     System.out.println(h.numberOfFileHamAnlern() ); //Count the number of file Ham Anlern
        System.out.println("procent of the word frowning : "+ h.pourcentageForOneWordInHamAnlern("frowning"));// Give the procent of the word frowning in the ham
*/

    }
}