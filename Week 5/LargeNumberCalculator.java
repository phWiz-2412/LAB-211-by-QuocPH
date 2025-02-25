import java.util.Scanner;

public class LargeNumberCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        String num1 = scanner.next();
        System.out.print("Nhập số thứ hai: ");
        String num2 = scanner.next();

        String sum = addLargeNumbers(num1, num2);
        String product = multiplyLargeNumbers(num1, num2);

        System.out.println("Tổng: " + sum);
        System.out.println("Tích: " + product);

        scanner.close();
    }

    private static String addLargeNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

    private static String multiplyLargeNumbers(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder product = new StringBuilder();
        for (int num : result) {
            if (!(product.length() == 0 && num == 0)) {
                product.append(num);
            }
        }

        return product.length() == 0 ? "0" : product.toString();
    }
}
