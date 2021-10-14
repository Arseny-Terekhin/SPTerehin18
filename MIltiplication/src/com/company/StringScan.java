package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringScan {
    private String str;
    StringScan(String s){
        this.str= s;
    }
    public int[] Reg(){
        Pattern p = Pattern.compile("\\*");
        Matcher m = p.matcher(str);
        int sim = 0;
        while (m.find()){
            sim = m.start();
        }
        String str_num1 = str.substring(0, sim);
        String str_num2 = str.substring(sim + 1);
        int num1 = Integer.parseInt(str_num1);
        int num2 = Integer.parseInt(str_num2);
        int[] mas = new int[2];
        mas[0] = num1;
        mas[1] = num2;
        return mas;
    }
}