package algorithms.patterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

class LongestSubstrAllDistinct {
    // O(N) time, O(k<=N) space, k<=26 ==> O(1) space
    private static int findLongestSubstrWithAllDistinctChars(String str) {
        int windowStart =0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd=0; windowEnd<str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                //cant simply slide the window and update windowStart by 1
                //it is possible that when we encounter this repeat char, current windowStart is already ahead 
                //of the last seen index of this char. So, we will keep windowStart.
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar)+1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstrAllDistinct.findLongestSubstrWithAllDistinctChars("aabccbb"));
        System.out.println("Length of the longest substring: " + LongestSubstrAllDistinct.findLongestSubstrWithAllDistinctChars("abbbb"));
        System.out.println("Length of the longest substring: " + LongestSubstrAllDistinct.findLongestSubstrWithAllDistinctChars("abccde"));
      }
}
