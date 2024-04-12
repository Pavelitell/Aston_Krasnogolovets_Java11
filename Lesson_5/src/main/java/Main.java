import lesson_5.Animal;
import lesson_5.Bowl;
import lesson_5.Cat;
import lesson_5.Dog;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Cat barsik = new Cat("Барсик", 10, false);
        Dog tuzik = new Dog("Тузик");

        barsik.run(150);
        barsik.run(201);
        barsik.swim(200);
        tuzik.run(500);
        tuzik.run(501);
        tuzik.swim(10);
        tuzik.swim(11);


        int action;
        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Барсик", 5, false);
        allCats[1] = new Cat("Снежок", 30, false);
        allCats[2] = new Cat("Мурзик", 10, false);
        allCats[3] = new Cat("Чернышка", 45, false);

        Bowl bowl = new Bowl(50);
        bowl.info();
        for (int i = 0; i < allCats.length; i++) {
            if (allCats[i].fullness == false && allCats[i].appetite < bowl.food) {
                allCats[i].eat(bowl);
                allCats[i].fullness = true;
                System.out.println("Котик " + allCats[i].name + " покушал!");
            } else {
                System.out.println("Котик " + allCats[i].name + " не поел!");
            }
        }
        bowl.info();
        System.out.println("Сколько грамм вискаса добавить еще в миску?");
        action = scanner.nextInt();
        bowl.increaseFood(action);
        bowl.info();

        System.out.println("Всех животных " + Animal.getCountAnimal());
        System.out.println("Всех котов: " + Cat.getCountCat());
        System.out.println("Всех собак: " + Dog.getCountDod());
    }
}
