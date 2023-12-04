class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
    int l = 1, r = 0;
    for (int n : nums) r = Math.max(r, n);

    while (l < r) {
      int m = l + (r - l) / 2;

      if (isSatisfy(m, nums, threshold)) {
        r = m;
      } else {
        l = m + 1;
      }
    }

    return l;
  }

  private boolean isSatisfy(int divisor, int[] nums, int threshold) {
    int sum = 0;
    for (int n : nums) {
      sum += n / divisor + (n % divisor > 0 ? 1 : 0);
      if (sum > threshold) return false;
    }
    return true;
  }
}