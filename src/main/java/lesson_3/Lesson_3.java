package lesson_3;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Lesson_3 {
    public static boolean firstTask(int a, int b) {
        int summ = a + b;
        return summ >= 10 && summ <= 20;
    }

    public static void secondTask(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean thirdTask(int a) {
        return a < 0;
    }

    public static void fourthTask(String string, int howMuch) {
        System.out.println(string.repeat(howMuch));
    }

    public static boolean fiveTask() {
        GregorianCalendar calendar = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я определяю вискосный год. Введите год:");
        int year = scanner.nextInt();
        return calendar.isLeapYear(year);
    }

    public static String SixTask() {
        int[] array = new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                System.out.print(0);
            } else if (array[i] == 0) {
                System.out.print(1);
            }
        }
        return array + "|";
    }

    public static int[] SevenTask() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i]++;
            System.out.print(i + "|");
        }
        return array;
    }

    public static int[] eightTask() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                a = array[i] * 2;
                System.out.println(a);
            } else {
                System.out.println(array[i]);
            }
        }
        return array;
    }

    public static int[][] nineTask() {
        int[][] array = new int[5][5];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static int[] tenTask(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
            System.out.println(array[i]);
        }
        return array;
    }

}
