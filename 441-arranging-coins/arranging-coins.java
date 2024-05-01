class Solution {
    public int arrangeCoins(int n) {
        int l = 0, r= n;
        while(l<=r){
            long m = (l+r)/2;
            if(n>=m*(m+1)/2){
                l= (int)m+1;
            }
            else
                r = (int)m-1;
        }
        return l-1;
    }
}