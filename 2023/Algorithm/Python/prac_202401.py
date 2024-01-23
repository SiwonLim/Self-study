class Solution(object):
    def mySqrt(self, x):
        if x < 0:
            return -1
        low=1
        high=x
        res=0
        while low <= high:
            mid = low + (high-low)/2
            if mid <= x/mid:
                res = mid
                low = mid+1
            else:
                high = mid-1
        return res
    def climbStairs(self, n):
        if n < 3:
            return n
        else:
            dp = [0] * n
            dp[0] = 1
            dp[1] = 2
            for i in range(2, n):
                dp[i] = dp[i-1] + dp[i-2]
            print(dp[n-1])
            return dp[n-1]
        
    def generate(self, numRows):
        result = []
        if numRows == 0:
            return result
        first_row = [1]
        result.append(first_row)

        for i in range(1, numRows):
            prev_row = result[i-1]
            current_row = [1]

            for j in range(1,i):
                current_row.append(prev_row[j-1]+prev_row[j])
            
            current_row.append(1)
            result.append(current_row)
        return result
    
def main():
    solution = Solution()
    solution.generate(10)

if __name__ == "__main__":
    main()