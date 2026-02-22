class Solution {
    public int binaryGap(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') indices.add(i);
        }
        if (indices.size() == 1) return 0;
        int ans = 0;
        for (int i = 0; i < indices.size()-1; i++) {
            ans = Math.max(ans, indices.get(i+1)-indices.get(i));
        }
        return ans;
    }
}