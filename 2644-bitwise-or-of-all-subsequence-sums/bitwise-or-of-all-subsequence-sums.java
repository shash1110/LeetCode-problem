class Solution {
    public long subsequenceSumOr(int[] nums) {
        long pf=0, res=0;
        for(int n: nums){
            pf += n;
            res |= n |pf;
        }
        return res;
    }
}