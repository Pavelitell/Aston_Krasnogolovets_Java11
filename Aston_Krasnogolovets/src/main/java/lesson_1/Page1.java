package lesson_1;

public class Page1 {
    public static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    public static void checkSumSign() {
        int a = -800;
        int b = 5;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 300;
        if (value < 0) {
            System.out.println("Красный");
        } else if ((value > 0) && (value < 100)) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }


    public static void compareNumbers() {
        int a = 1000;
        int b = 50;
        String output = (a >= b) ? "a >= b" : "a < b";
        System.out.println(output);
    }
}


/*Обьясните пожалуйста, что не так:

public static void printColor() {
    int value = 300;
    switch (value){
        case ((value >0) && (value < 100)):
            System.out.println("Желтый");
            break;
        case (value >100):
            System.out.println("Зеленый");
            break;
        case (value<0):
            System.out.println("Красный");
            break;

    }
}*/

