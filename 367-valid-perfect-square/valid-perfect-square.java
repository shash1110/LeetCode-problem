class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long n = 1;
        while (n * n < num) {
            n++;
        }
        return (n * n == num);
        
    }
}