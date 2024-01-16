package Algorithm.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class prac_202401 {
    static public void main(String[] args) throws Exception{
        climbStairs(4);
    }
    static public int mySqrt(int x) {
        if(x < 0){
            return -1;
        }
        int low = 1, high = x, res = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid <= (x/mid)){
                res = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
        //return (int)Math.sqrt(x);
    }

    //dp[i] = dp[i-1] + dp[i-2];
    static public int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2 ; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            arr.add(nums1[i]);
        }
        for(int i = 0 ; i < n ; i++){
            arr.add(nums2[i]);
        }
        Collections.sort(arr);
        for(int i = 0 ; i < arr.size() ; i++){
            nums1[i] = arr.get(i);
        }
        //nums1 = arr.stream().mapToInt(i -> i).toArray();
    }
    
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    static List<Integer> arr = new ArrayList<Integer>();
    static public List<Integer> inorderTraversal(TreeNode root) {
        recursiveTravesal(root);
        return arr;
    }
    static public void recursiveTravesal(TreeNode root){
        if(root == null){
            return;
        }
        //left root right
        recursiveTravesal(root.left);
        arr.add(root.val);
        recursiveTravesal(root.right);
    }
}
