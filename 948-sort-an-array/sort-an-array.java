class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int n : nums){
            p.add(n);
        }
        int i=0;
        while(!p.isEmpty()){
            nums[i] = p.remove();
            i++;
        }
        return nums;
    }
}