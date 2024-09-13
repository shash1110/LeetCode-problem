class Solution {
    public int maxArea(int[] height) {
        int l =0, r=height.length-1;
        int maxArea = 0;
        while(l<r){
            int width = r-l;
            int curr = Math.min(height[l],height[r])*width;
            maxArea = Math.max(maxArea, curr);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}