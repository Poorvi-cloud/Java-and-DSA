//Count of Substrings Containing Every Vowel and K Consonants II

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countOfSubstrings(String word, int k) {
        return f(word, k) - f(word, k + 1);
    }

    private long f(String word, int k) {
        long ans = 0;
        int l = 0, x = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        
        for (char c : word.toCharArray()) {
            if (vowel(c)) {
                cnt.merge(c, 1, Integer::sum);
            } else {
                ++x;
            }

            while (x >= k && cnt.size() == 5) {
                char d = word.charAt(l++);
                if (vowel(d)) {
                    cnt.put(d, cnt.get(d) - 1);
                    if (cnt.get(d) == 0) {
                        cnt.remove(d);
                    }
                } else {
                    --x;
                }
            }
            ans += l;
        }
        return ans;
    }

    private boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
