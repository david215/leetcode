class Solution {
    public boolean isHappy(int n) {
        int tortoise = n;
        int hare = n;
        do {
            tortoise = digitSquareSum(tortoise);
            hare = digitSquareSum(digitSquareSum(hare));
            if (tortoise == 1 || hare == 1) { return true; }
        } while (tortoise != hare);
        return false;
    }
    
    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
