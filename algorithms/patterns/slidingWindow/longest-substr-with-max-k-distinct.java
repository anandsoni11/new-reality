package algorithms.patterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

class LongestSubstrMaxKDistinct {
    // O(N) Time, O(k) Space
    private static int findLongestSubstrMaxK(int k, String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        int maxLength = 0, windowStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int windowEnd=0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0)+1);
            while (charMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                if (charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstrMaxKDistinct.findLongestSubstrMaxK(2, "araaci"));
        System.out.println("Length of the longest substring: " + LongestSubstrMaxKDistinct.findLongestSubstrMaxK(1, "araaci"));
        System.out.println("Length of the longest substring: " + LongestSubstrMaxKDistinct.findLongestSubstrMaxK(3, "cbbebi"));
      }
}