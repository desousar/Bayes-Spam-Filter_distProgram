package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {


        hamAnlern h = new hamAnlern();
        h.anlern();
        /*String ligne;
        BufferedReader in = new BufferedReader(new FileReader("Programmieraufgabe1/ham-kallibrierung/0001.ea7e79d3153e7469e7a9c3e0af6a357e"));

        while ((ligne = in.readLine()) != null){

        }*/
        Set<Map.Entry<String , Integer>> setMap = h.getTableFinal().entrySet();
        for (Map.Entry<String, Integer> s:setMap){

        }

        spamAnlern s = new spamAnlern();
        s.anlern();


    }
}