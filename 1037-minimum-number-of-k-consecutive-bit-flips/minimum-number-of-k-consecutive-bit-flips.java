class Solution {
        public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] ans = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= ans[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                ans[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}