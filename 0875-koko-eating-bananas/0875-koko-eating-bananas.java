class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = 0;
    for (int p : piles) r = Math.max(r, p);
    
    while (l < r) {
      int m = l + (r - l) / 2;
      
      if (isEdiable(m, piles, h)) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    
    return l;
  }
  
  private boolean isEdiable(int k, int[] piles, int h) {
    int eatingHour = 0;
    for (int p : piles) {
      eatingHour += p / k + (p % k != 0 ? 1 : 0);
      if (eatingHour > h) return false;
    }
    
    return true;
  }
}