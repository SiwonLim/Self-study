package Algorithm.Java;

public class RemoveDuplicates {
    static public void main(String[] args) throws Exception{
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
    static public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
