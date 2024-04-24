class Solution {
    public int tribonacci(int n) {
        int zero  = 0, first = 1, second = 1;
        if(n<3){
            return n>0 ?1:0;
        }
        for(int i=0;i<n-2;i++){
            int next = zero + first + second;
            zero = first;
            first = second; 
            second = next;
        }
        return second;
    }
}