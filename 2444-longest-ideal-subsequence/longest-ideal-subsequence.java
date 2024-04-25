class Solution {
        public int longestIdealString(String s, int k) {
        int res = 0, n = s.length();
        int dp[] = new int[150];
        for (int ch = 0; ch < n; ++ch) {
            int i = s.charAt(ch);
            for (int j = i - k; j <= i + k; ++j)
                dp[i] = Math.max(dp[i], dp[j]);
            res = Math.max(res, ++dp[i]);
        }
        return res;
    }
}