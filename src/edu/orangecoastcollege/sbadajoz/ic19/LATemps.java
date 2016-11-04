package edu.orangecoastcollege.sbadajoz.ic19;
/*
Badajoz, Seve
CS A170
November 4, 2016

IC19
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class LATemps {
    public static void main(String[] args) {
        HashMap<Integer, Integer> temperatures = new HashMap<>();
        ArrayList<Integer> modes = new ArrayList<>();
        
        int max = Integer.MIN_VALUE, temp, frequency = 0, most = 0;
        double avg = 0.0;
        boolean found = false;

        Scanner input = new Scanner(System.in);
        DecimalFormat twoDP = new DecimalFormat("#.0#");

        for(int i = 1; i <=30; i++) {
            System.out.print("Please enter daily high for September " + ((i < 10)? "0": "") + i + ": ");
            temp = input.nextInt();
            for(int entry: temperatures.keySet()){
                if (entry == temp)
                    found = true;                   
            }
            if (found)temperatures.put(temp, temperatures.get(temp)+1);
            else temperatures.put(temp, 1);
            
            if (temp > max) max = temp; 
            found = false;
        }
        
        for(Entry<Integer, Integer > entry: temperatures.entrySet()){
            if (entry.getValue() > frequency) {
                most = entry.getKey();
                frequency = entry.getValue();
            }
            avg += entry.getKey() * entry.getValue();
        }
        for(Entry<Integer, Integer > entry: temperatures.entrySet()){
            if(entry.getValue() == temperatures.get(most)){
                modes.add(entry.getKey());
            }
        }
        avg /= 30;
        
        System.out.print("~~~~~~~~~~Temperature Statistics~~~~~~~~~~"
                       + "\nSeptember's highest daily temperature was: " + max 
                       + "\nSeptember's average high temperature was:  " + twoDP.format(avg) 
                       + "\nSeptember's most frequent " + ((modes.size() > 1)? "high temps were:  ":"high temp was:   "));
        for(int i = 0 ; i < modes.size(); i ++) {
            System.out.print(modes.get(i) + " ");
        }
    }
}
