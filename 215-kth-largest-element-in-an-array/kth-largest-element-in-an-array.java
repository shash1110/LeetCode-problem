class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int num: nums){
            if(p.size()<k){
                p.offer(num);
            }
            else{
                if(num>p.peek()){
                    p.poll();
                    p.offer(num);
                }
            }
        }
        return p.peek();
    }
}