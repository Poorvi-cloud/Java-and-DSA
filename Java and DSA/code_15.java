//Number of Substrings Containing All Three Characters

class Solution {
    public int numberOfSubstrings(String s) {
        int[] d = new int[] {-1, -1, -1}; // Stores last seen indices of 'a', 'b', 'c'
        int ans = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            d[c - 'a'] = i; // Update last seen index of character
            
            // Add the number of substrings ending at index i that contain at least one 'a', 'b', and 'c'
            ans += Math.min(d[0], Math.min(d[1], d[2])) + 1;
        }
        
        return ans;
    }
}
