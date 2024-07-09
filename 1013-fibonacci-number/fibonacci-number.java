class Solution {
    public int fib(int N) {
        if(N <= 1)
            return N;
        int[] ans = new int[N + 1];
		ans[1] = 1;

		for(int i = 2; i <= N; i++)
		{
			ans[i] = ans[i - 1] + ans[i - 2];
		}
		return ans[N];
    }
}