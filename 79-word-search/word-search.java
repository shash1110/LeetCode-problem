class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] seen = new boolean[n][m];
        boolean ans = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    ans = backtrack(board, word, seen, i, j, 0);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, boolean[][] seen, int i, int j, int index){
        if(index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        seen[i][j] = true;

        if (backtrack(board, word, seen, i + 1, j, index + 1) ||
            backtrack(board, word, seen, i - 1, j, index + 1) ||
            backtrack(board, word, seen, i, j + 1, index + 1) ||
            backtrack(board, word, seen, i, j - 1, index + 1)) {
            return true;
        }
        seen[i][j] = false;
        return false;
    }
}



