class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(Math.min(nextMultipleOf2, nextMultipleOf3), nextMultipleOf5);
            uglyNumbers[i] = nextUgly;
            
            if (nextUgly == nextMultipleOf2) {
                idx2++;
                nextMultipleOf2 = uglyNumbers[idx2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                idx3++;
                nextMultipleOf3 = uglyNumbers[idx3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                idx5++;
                nextMultipleOf5 = uglyNumbers[idx5] * 5;
            }
        }
        return uglyNumbers[n - 1];
    }
}
