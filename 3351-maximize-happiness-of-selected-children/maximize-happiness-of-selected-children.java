class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
       Arrays.sort(happiness);
        int len = happiness.length;
        long ans = 0;
        long sub = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (happiness[i] - sub >= 0)
                ans += happiness[i] - sub;
            sub++;
            if (sub == k)
                break;
        }
        return ans;
    }
}