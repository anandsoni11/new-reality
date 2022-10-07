package algorithms.patterns.slidingWindow;

class SmallestSubarraySum {
    private static int findSmallestSubArrayWithSum(int S, int[] arr) { //O(N)
        int lenSmallestSubArray = Integer.MAX_VALUE, windowSum = 0;
        int n = arr.length;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                lenSmallestSubArray = Math.min(lenSmallestSubArray, windowEnd-windowStart+1);
                windowSum -= arr[windowStart];
                windowStart++;     
            }
        }

        return lenSmallestSubArray == Integer.MAX_VALUE ? 0 : lenSmallestSubArray;
    }

    public static void main(String[] args) {
        int result = SmallestSubarraySum.findSmallestSubArrayWithSum(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubarraySum.findSmallestSubArrayWithSum(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubarraySum.findSmallestSubArrayWithSum(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
      }
}
