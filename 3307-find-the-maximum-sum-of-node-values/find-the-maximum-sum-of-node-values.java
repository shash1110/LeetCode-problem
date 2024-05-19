import java.util.*;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> lis = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lis.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lis.get(edge[0]).add(edge[1]);
            lis.get(edge[1]).add(edge[0]);
        }
        List<Integer> inc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long val = (long) nums[i] ^ k;
            if (val > nums[i]) {
                inc.add(i);
            }
        }
        int sz = inc.size();
        if (sz % 2 == 0) {
            long ans = 0;
            for (int num : nums) {
                ans += num;
            }
            for (int i = 0; i < inc.size(); i++) {
                ans -= nums[inc.get(i)];
                long add = (long) nums[inc.get(i)] ^ k;
                ans += add;
            }
            return ans;
        } else {
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (long) nums[i];
            }
            long hue = ans;
            for (int i = 0; i < inc.size(); i++) {
                ans -= nums[inc.get(i)];
                long add = (long) nums[inc.get(i)] ^ k;
                ans += add;
            }
            for (int i = 0; i < sz; i++) {
                long add = (long) nums[inc.get(i)] ^ k;
                long curr_ans = ans - add + nums[inc.get(i)];
                hue = Math.max(hue, curr_ans);
            }
            boolean[] vis = new boolean[n];
            Arrays.fill(vis, false);
            for (int i = 0; i < sz; i++) {
                vis[inc.get(i)] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    long add = (long) nums[i] ^ k;
                    long curr_ans = ans - nums[i] + add;
                    hue = Math.max(hue, curr_ans);
                }
            }
            return hue;
        }
    }
}
