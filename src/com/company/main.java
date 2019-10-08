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

        System.out.println(h.numberOfFileHamAnlern() ); //Count the number of file Ham Anlern
        System.out.println("procent of the word frowning : "+ h.pourcentageForOneWordInHamAnlern("frowning"));// Give the procent of the word frowning


    }
}