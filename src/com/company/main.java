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
        Set<Map.Entry<String , Integer>> setMap = h.getTableFinal().entrySet();
        for (Map.Entry<String, Integer> s:setMap){

        }

        SpamAnlern s = new SpamAnlern();
        s.anlern();
        HamKallibrate hk = new HamKallibrate();
        System.out.println(hk.kallibrateMailToSet("0001.ea7e79d3153e7469e7a9c3e0af6a357e"));
        SpamKallibrate sk = new SpamKallibrate();
        System.out.println(sk.kallibrateMailToSet("00040.949a3d300eadb91d8745f1c1dab51133"));

    }
}