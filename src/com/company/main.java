package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {


        HamAnlern h = new HamAnlern();
        h.anlern();
        /*String ligne;
        BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-kallibrierung/0001.ea7e79d3153e7469e7a9c3e0af6a357e"));

        while ((ligne = in.readLine()) != null){

        }*/
  /*      Set<Map.Entry<String , Integer>> setMap = h.getTableFinal().entrySet();
        for (Map.Entry<String, Integer> s:setMap){

        }
*/
        SpamAnlern s = new SpamAnlern();
        s.anlern();
        HamKallibrate hk = new HamKallibrate();
        String kallibrateMail = "0001.ea7e79d3153e7469e7a9c3e0af6a357e";
        //hk.kallibrateMailToSet(kallibrateMail); le paramètre ne permet pas d'écrire dans un doc txt le set
        hk.kallibrateMailToSet("0001.ea7e79d3153e7469e7a9c3e0af6a357e");

        /*   SpamKallibrate sk = new SpamKallibrate();
        System.out.println(sk.kallibrateMailToSet("00040.949a3d300eadb91d8745f1c1dab51133"));
*/
   //     System.out.println("the ham-table " + h.getTableFinal(h)); //this is the correct map of all word from ham.anlern
   //     System.out.println("the hk-table " + hk.getTableFinal(hk, kallibrateMail)); //this is the correct set of the ham kallibrate that we test

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

    }
}