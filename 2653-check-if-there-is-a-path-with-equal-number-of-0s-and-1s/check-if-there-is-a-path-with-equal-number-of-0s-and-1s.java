class Solution {
    Boolean[][][] memo;
    int n, m, k;
    public boolean isThereAPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if ((n+m) % 2 == 0) return false;
        k = (n+m) / 2; 
        memo = new Boolean[n][m][k+1];
        return isThereAPath(grid, 0, 0, 0);
    }

    public boolean isThereAPath(int[][] grid, int x, int y, int sum) {
        if (x >= n || y >= m) return false;
        sum += grid[x][y];
        if (sum > k || n+m-x-y < k-sum) return false; // Optimization/Optional
        if (x == n-1 && y == m-1) return memo[x][y][sum] = sum == k;
        if (memo[x][y][sum] != null) return memo[x][y][sum];
        return memo[x][y][sum] = isThereAPath(grid, x+1, y, sum) || isThereAPath(grid, x, y+1, sum);
    }
}