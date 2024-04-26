class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int [n][n];
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int min = helper(0,-1,n,grid,dp);
        return min;
    }
    public int helper(int curr_row, int prev_col, int n, int [][] mat, int dp[][]){
        if(curr_row==n) return 0;
        if(prev_col != -1 && dp[curr_row][prev_col] != -1) return dp[curr_row][prev_col];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i==prev_col) continue;
            int curr = mat[curr_row][i]+ helper(curr_row+1, i, n, mat, dp);
            ans = Math.min(ans, curr);
        }
        if(prev_col != -1) dp[curr_row][prev_col]=ans;
        return ans;
    }
}