class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[] dp = new int[27];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);
        dp[26] = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int cur  = word.charAt(i)     - 'A';  
            int next = word.charAt(i + 1) - 'A';  
            int moveCost = dist(cur, next);
            int[] ndp = new int[27];
            Arrays.fill(ndp, INF);
            
            for (int j = 0; j <= 26; j++) {
                if (dp[j] == INF) continue;
                ndp[j] = Math.min(ndp[j], dp[j] + moveCost);
                int otherCost = (j == 26) ? 0 : dist(j, next);
                ndp[cur] = Math.min(ndp[cur], dp[j] + otherCost);
            }

            dp = ndp;
        }
        
        int ans = INF;

        for (int j = 0; j <= 26; j++) 
            ans = Math.min(ans, dp[j]);
        
        return ans;
    }
    
    private int dist(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}