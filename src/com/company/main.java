package com.company;

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {


        hamAnlern h = new hamAnlern();
        h.anlern();
        Set<Map.Entry<String , Integer>> setMap = h.getTableFinal().entrySet();


        spamAnlern s = new spamAnlern();
        s.anlern();


    }
}