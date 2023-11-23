package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class prac_20231123 {
    static public void main(String[] args) throws Exception{
        System.out.println("(1) factorial with a recursive call : " + facto1(5) + " / " + facto2(5));
        System.out.println("(2) Summing all elements in an array with a recursive call : " +
        sum(new ArrayList<>(Arrays.asList(1,2,3,4,5))));
        System.out.println("(2) Counting numbers created using only 1, 2, or 3 for a particular value with a recursive call : " + countingNumbers(5));
    }

    //Recursive call type 1
    static public int facto1(int n){
        if(n > 1){
            return n * facto1(n-1);
        }else{
            return 1;
        }
    }
    //Recursive call type 2
    static public int facto2(int n){
        if(n <= 1){
            return 1;
        }else{
            return n * facto2(n-1);
        }
    }
    //Summing all elements in an ArrayList
    static public int sum(ArrayList<Integer> dataList){
        if(dataList.size() <= 0){
            return 0;
        }else{
            return dataList.get(0) + sum(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
        }
    }

    //Counting numbers created using only 1, 2, or 3 for a particular value
    static public int countingNumbers(int data){
        if(data == 1 || data == 2){
            return data;
        }else if(data == 3){
            return 4;
        }else{
            return countingNumbers(data-1) +
            countingNumbers(data-2) +
            countingNumbers(data-3);
        }
    }
}
