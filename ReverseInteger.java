public class ReverseInteger {
    public static int solution(int n) {
        int reversed = 0;
        try {
            while (n != 0) {
                int tail = n % 10;
                reversed = Math.multiplyExact(reversed, 10);
                reversed = Math.addExact(reversed, tail);
                n = n / 10;
            }
        } catch (ArithmeticException e) {
            reversed = 0;
        } finally {
            return reversed;
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("%d is 321", solution(123)));
        System.out.println(String.format("%d is -321", solution(-123)));
        System.out.println(String.format("%d is 21", solution(120)));
        System.out.println(String.format("%d is 0", solution(1534236469)));
    }
}
