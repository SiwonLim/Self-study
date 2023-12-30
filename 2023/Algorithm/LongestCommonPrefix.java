package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LongestCommonPrefix {
    static public void main(String[] args) throws Exception{
        String[] strs = {"reflower","flow","flight"};
        System.out.println("result : " + longestCommonPrefix(strs));
    }
    
    static public String longestCommonPrefix(String[] strs) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++){
            sorted.add(strs[i]);
        }
        Collections.sort(sorted, Comparator.comparing(String::length));
        int maxLength = 0;
        for(int j = 1 ; j < sorted.get(0).length()+1 ; j++){
                String newWord = sorted.get(0).substring(0, j);
                if(isContains(newWord, sorted) == true){
                    words.add(newWord);
                    if(maxLength < newWord.length()){
                        maxLength = newWord.length();
                    }
                }
            }
        if(words.size() == 0){
            return "";
        }else{
            Collections.sort(words, Comparator.comparing(String::length));
            return words.get(words.size()-1);
        }
    }
    static public boolean isContains(String word, ArrayList<String> strs){
        for(int i = 1 ; i < strs.size() ; i++){
            if(strs.get(i).startsWith(word) == false){
                return false;
            }
        }
        return true;
    }
}
