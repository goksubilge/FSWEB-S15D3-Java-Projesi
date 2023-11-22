package com.wit.companyy.main;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountWords {
    public static void main(String[] args) {
        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü,"
                + " due to İsmet Pasha's organization of an irregular militia into a regular army. "
                + " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused."
                + " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks."
                + " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n"
                + " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence."
                + " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties."
                + " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table."
                + " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal."
                + " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased."
                + " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused. ";

        text = text.replaceAll("\\. ","");
        text = text.replaceAll("\\.","");
        text = text.replaceAll(",","");
        text = text.replaceAll("–"," ");
        text = text.replaceAll("-"," ");
        text= text.replaceAll("\n","");
        text= text.replaceAll("I","İ");
        text = text.toLowerCase();
        String[] words = text.split(" ");
        System.out.println(text);

        Arrays.sort(words);
     for(String word: words) {
            System.out.println("Word: " + word);
     }
        System.out.println("*********************");
    // for(int i = 0; i < words.length; i++) {words[i] = words[i].toLowerCase();}
        int count = 0;
        Map<String,Integer> wordMapp = new TreeMap<>();
        String Tword = "";
        String Nword = "";

        for(int i=0; i<words.length ;i++){
            try{                            // try catch'e göre de sondaki tek kalan sayı varsa onu yazdırdım. (ama burda year kelimesiyle ilgili bir durum bununla da çözülmedi)
                Tword = words[i];
                count++;
                Nword = words[i+1];
                if(!Tword.equals(Nword)){
                    wordMapp.put(Tword, count);
                    count = 0;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                if(!wordMapp.containsKey(words[words.length -1])){
                    wordMapp.put(words[words.length -1], 1);
                }
            }
        }
        for(Map.Entry entry: wordMapp.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
