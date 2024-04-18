class Solution {
    public int islandPerimeter(int[][] grid) {
        int island = 0;
        int side = 0;
        for(int r=0; r<grid.length; ++r){
            for(int c=0; c<grid[0].length; ++c){
                if(grid[r][c]==1){
                    ++island;
                    if(r-1>=0 && grid[r-1][c] ==1){
                        ++side;
                    }
                    if(c-1>=0 && grid[r][c-1] ==1){
                        ++side;
                    }
                }
            }
        }
        return island * 4 - side * 2;
    }
}