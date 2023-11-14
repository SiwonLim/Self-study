package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class prac_20231113 {
    public static void main(String[] args) throws Exception {
        //01. Bubble Sort
        ArrayList<Integer> dataList = makeRandom();
        System.out.println("Bubble Sort : " + bubbleSort(dataList));

        //02. Selection Sort
        dataList = makeRandom();
        System.out.println("Selection Sort : " + selectionSort(dataList));

        //03. Insertion Sort
        dataList = makeRandom();
        System.out.println("Insertion Sort : " + insertionSort(dataList));
    }
    static ArrayList<Integer> makeRandom(){
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            dataList.add((int)(Math.random() * 100));
        }
        return dataList;
    }

    /***
     * time complexity : (worst-case) (n * (n-1)) / 2
     * @param dataList
     * @return sorted integer array
     */
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> dataList){
        for(int index = 0 ; index < dataList.size()-1; index++){
            boolean swap = false;
            for(int index2 = 0 ; index2 < dataList.size()-index-1; index2++){
                if(dataList.get(index2) > dataList.get(index2+1)){
                    Collections.swap(dataList, index2, index2+1);
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }
        return dataList;
    }
    /***
     * time complexity : (n * (n-1)) / 2
     * @param dataList
     * @return sorted integer array
     */
    static ArrayList<Integer> selectionSort(ArrayList<Integer> dataList){
        int lowest;
        for(int index = 0 ; index < dataList.size()-1 ; index++){
            lowest  = index;
            for(int index2 = index+1 ; index2 < dataList.size() ; index2++){
                if(dataList.get(lowest) > dataList.get(index2)){
                    lowest = index2;
                }
            }
            Collections.swap(dataList, index, lowest);
        }
        return dataList;
    }
    /***
     * time complexity : (n * (n-1)) / 2
     * @param dataList
     * @return sorted integer array
     */
    static ArrayList<Integer> insertionSort(ArrayList<Integer> dataList){
        for(int index = 0; index < dataList.size()-1 ; index++){
            for(int index2 = index+1 ; index2 > 0 ; index2--){
                if(dataList.get(index2) < dataList.get(index2-1)){
                    Collections.swap(dataList, index2, index2-1);
                }else{
                    break;
                }
            }
        }
        return dataList;
    }
}