class Solution {
    public int trap(int[] height) {
        if(height==null)
            return 0;
        Stack<Integer> s = new Stack<>();
        int i = 0, max =0, maxbot =0;
        while(i< height.length){
            if(s.isEmpty() || height[i]<=height[s.peek()]){
                s.push(i++);
            }
            else{
                int bot = s.pop();
                maxbot = s.isEmpty() ? 0 : (Math.min (height[s.peek()], height[i])-height[bot])*(i-s.peek()-1);
                max += maxbot;
            }
        }
        return max;
    }
}