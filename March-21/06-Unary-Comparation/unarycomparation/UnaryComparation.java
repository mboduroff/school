package unarycomparation;

import java.util.Scanner;

class UnaryComparator {

    static Scanner sc = new Scanner(System.in);

    public static boolean compareUnary(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int countA = 0, countB = 0;

        for (char c : strA.toCharArray()) {
            if (c == '1') {
                countA++;
            }
        }

        for (char c : strB.toCharArray()) {
            if (c == '1') {
                countB++;
            }
        }

        if (countA > countB) {
            return false;
        } else if (countA == countB) {
            return a <= b;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Въведете числа:");

        String[] numStrings = sc.nextLine().split("\\s+");


        int[] nums = new int[numStrings.length];
        try {
            for (int i = 0; i < numStrings.length; i++) {
                nums[i] = Integer.parseInt(numStrings[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Невалиден вход! Моля, рестартирайте програмата.");
            System.exit(0);
        }

        int n = nums.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (compareUnary(nums[j], nums[j+1])) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
