package Algorithm.Java;

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
}
