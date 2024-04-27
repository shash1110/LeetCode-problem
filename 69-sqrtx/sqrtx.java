class Solution {
  public int mySqrt(long x) {
    if(x==0||x==1)
        return (int)x;
    long l=1, r=x/2;
    long ans=0;
    while(l<=r){
        long m= l+(r-l)/2;
        if(m==x/m)
            return (int)m;
        if(m<x/m){
            ans=m;
            l=m+1;
        }    
        else    
            r=m-1;
    }
    return (int) ans;
  }
}