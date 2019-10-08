package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {


        HamAnlern h = new HamAnlern();
        System.out.println("Constructor Ham");
        SpamAnlern s = new SpamAnlern();
        System.out.println("Constructor Spam");
        HamKallibrate hk = new HamKallibrate();
        h.addWordNotInSpamAnlern(s);
        System.out.println("Add In Ham");
        s.addWordNotInHamAnlern(h);
        System.out.println("Add in spam");
        String kallibrateMail = "0001.ea7e79d3153e7469e7a9c3e0af6a357e";
        hk.kallibrateMailToSet(kallibrateMail); //le paramètre ne permet pas d'écrire le set dans un doc txt
        /*   SpamKallibrate sk = new SpamKallibrate();
        System.out.println(sk.kallibrateMailToSet("00040.949a3d300eadb91d8745f1c1dab51133"));
*/
   //     System.out.println("the ham-table " + h.getTableFinal(h)); //this is the correct map of all word from ham.anlern
   //     System.out.println("the hk-table " + hk.getTableFinal(hk, kallibrateMail)); //this is the correct set of the ham kallibrate that we test
/*
        //count how much word from hamKallibrate is also in hamAnlern
        int countForHam = 0;
            for (String wordKallibrate :hk.getTableFinal(hk,kallibrateMail)) {
                if (h.containWord(wordKallibrate)) {
                    countForHam++;
                }else {
                    System.out.println("non");
                }
            }
        System.out.println("nombre total de correspondance avec Ham = " + countForHam);


        //count how much word from hamKallibrate is also in spamAnlern
        int countForSpam = 0;
        for (String wordKallibrate :hk.getTableFinal(hk,kallibrateMail)) {
            if (s.containWord(wordKallibrate)) {
                countForSpam++;
            }else {
                System.out.println("non");
            }
        }
        System.out.println("nombre total de correspondance avec Spam = " + countForSpam);

        //print the result
        if (countForHam > countForSpam){
            System.out.println("c'est un ham car ham: "+ countForHam +" contre spam: "+countForSpam);
        }else {
            System.out.println("c'est un spam ham: "+ countForHam +" contre spam: "+countForSpam);
        }
*/
        System.out.println(h.numberOfFileHamAnlern() ); //Count the number of file Ham Anlern
        System.out.println(h.pourcentageForOneWordInHamAnlern("frowning")+" ");// Give the procent of the word frowning


    }
}