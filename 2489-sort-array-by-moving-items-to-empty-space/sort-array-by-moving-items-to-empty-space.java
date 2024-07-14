class Solution 
{
    int permute(ArrayList<Integer> npos, int s)
    {
        int cnt = 0, nxt = 1, n = npos.size(), ni;
        while (nxt < n)
        {
            if (npos.get(0) == s * (n-1))
            {
                while (npos.get(nxt) == nxt-s)
                    if (++nxt == n) return cnt;
                ni = nxt;
            } else { ni = npos.get(0) + s; }
            Collections.swap(npos, 0, ni);
            ++cnt;
        }
        return cnt;
    }
    
    public int sortArray(int[] nums) 
    {
        int n = nums.length;
		
        var npos = new ArrayList<Integer>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; ++i) npos.set(nums[i], i);

        // note that here we must pass copies of 'npos' because 
        // the permutation function makes in-place operations
        return Math.min(permute(new ArrayList<>(npos), 0),  
                   permute(new ArrayList<>(npos), 1)); 
    }
}