import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        Arrays.sort(h);
        int l = h.length, s = 0;
        long a = 0, b = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (h[i] - b >= 0) a += h[i] - b;
            b++;
            if (b == k) break;
        }
        return a;
    }
}
