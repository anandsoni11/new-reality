package algorithms.patterns.slidingWindow;

//Brute force O(N*k)
class MaxSumSubarrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++ ) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // Using sliding window O(N)
    public static int findMaxSumSubArraySW(int k, int[] arr) {
        int windowSum =0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd =0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // keep adding to windowSum till first window is reached
            if (windowEnd >= k-1) { // passed the first window
                maxSum = Math.max(maxSum, windowSum); // update maxSum
                windowSum -= arr[windowStart]; // Remove outgoing element from windowSum
                windowStart++; // Slide the window
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubarrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubarrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubarrayOfSizeK.findMaxSumSubArraySW(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
            + MaxSumSubarrayOfSizeK.findMaxSumSubArraySW(2, new int[] { 2, 3, 4, 1, 5 }));
      }
}