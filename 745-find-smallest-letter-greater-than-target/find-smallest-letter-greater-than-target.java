class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(letters[m]<=target){
                l=m+1;
            }
            else 
                r = m-1;
        }
        return l==letters.length?letters[0]:letters[l];
    }
}