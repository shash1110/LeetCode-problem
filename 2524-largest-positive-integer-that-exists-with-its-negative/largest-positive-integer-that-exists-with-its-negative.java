class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1;
        HashSet<Integer> s = new HashSet<>();
        for(int n: nums){
            s.add(n);
        }
        for(int n: nums){
            if(n>0 && s.contains(-n))
                ans = Math.max(ans, n);
        }
        return ans;
    }
}