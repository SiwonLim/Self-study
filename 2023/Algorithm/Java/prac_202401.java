package Algorithm.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class prac_202401 {
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
      public static TreeNode generateTree(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new prac_202401().new TreeNode(values[0]);
        queue.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode current = queue.poll();

            if (values[i] != Integer.MIN_VALUE) {
                current.left = new prac_202401().new TreeNode(values[i]);
                queue.offer(current.left);
            }

            if (++i < values.length && values[i] != Integer.MIN_VALUE) {
                current.right = new prac_202401().new TreeNode(values[i]);
                queue.offer(current.right);
            }
        }

        return root;
    }
    static public void main(String[] args) throws Exception{
        int[] values = {1,2,2,2,-100,2};
        TreeNode root = generateTree(values);
        isSymmetric(root);
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

    static public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    static public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
