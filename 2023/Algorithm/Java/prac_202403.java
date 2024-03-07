package Algorithm.Java;

import java.util.ArrayList;

public class prac_202403 {
    public static void main(String[] args) throws Exception{
        int[] arr = new int[]{2,2,3,3,4};
        singleNumber(arr);
    }

    /**
     * @param nums
     * @return
     * Given a non-empty array of integers nums,
     * every element appears twice except for one. Find that single one.
     */
    public static int singleNumber(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(arr.contains(nums[i]) && arr.size() > 0){
                arr.remove((Object)nums[i]);
            }
            else{
                arr.add(nums[i]);
            }
        }
        return arr.get(0);
    }

    public static int singleNumber2(int[] nums) {
        int result = 0;
        for(int i = 0 ; i < nums.length ; i++){
            result = result^nums[i];
        }
        return result;
    }
}
