

import static java.lang.Math.max;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n==0 && m==0)
            return 0.0;
        if(n>m)
            return findMedianSortedArrays(nums2, nums1);
        int l=0, r=n, total = (n+m+1)/2;
        while (l<=r) {
            int i = (l+r)/2;
            int j = (total - i);
            if(i<n && j>0 && nums1[i] < nums2[j-1])
                l=i+1;
            else if(i>0 && j<m && nums1[i-1] > nums2[j])
                r=i-1;
            else{
                int lmax = 0;
                if(i==0)
                    lmax = nums2[j-1];
                else if(j==0)
                    lmax = nums1[i-1];
                else
                    lmax = Math.max(nums1[i-1], nums2[j-1]);
                if ((n+m)%2==1) return lmax; 

                int rmin=0;
                if(i==n)
                    rmin=nums2[j];
                else if(j==m)
                    rmin=nums1[i];
                else
                    rmin = Math.min(nums1[i], nums2[j]);  

                return (lmax + rmin)/2.0;                      
            }   
        } 
        return 0.0;       
    }
}