package Algorithm;

import java.util.HashMap;

public class RomanToInteger {
    static public void main(String[] args) throws Exception{
        int result = romanToInt("LVIII");
        System.out.println(result);
    }

    static public int romanToInt(String s) {
        HashMap<String, Integer> romanSet = new HashMap<String, Integer>();
        HashMap<String, Integer> romans = new HashMap<String, Integer>();

        romanSet.put("IV", 4);
        romanSet.put("XL", 40);
        romanSet.put("CD", 400);
        romanSet.put("IX", 9);
        romanSet.put("XC", 90);
        romanSet.put("CM", 900);

        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);
        
        int result = 0;
        while(s.length() > 0){
            if(s.length() == 1){
                result += romans.get(String.valueOf(s.charAt(0)));
                return result;
            }else{
                String r = String.valueOf(s.charAt(0))+String.valueOf(s.charAt(1));
                if(romanSet.containsKey(r)){
                    result += romanSet.get(r);
                    s = s.substring(2, s.length());
                }else{
                    result += romans.get(String.valueOf(s.charAt(0)));
                    s = s.substring(1, s.length());
                }
            }
        }
        return result;
    }
}
