package lesson_5;

import lesson_5.zoo.Animal;
import lesson_5.zoo.Bowl;
import lesson_5.zoo.Cat;
import lesson_5.zoo.Dog;
import lesson_5.math.Circle;
import lesson_5.math.Rectangle;
import lesson_5.math.Triangle;

import java.util.Scanner;


/* Задание 1:
Создать классы Собака и Кот с наследованием от класса Животное.

Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).

Добавить подсчет созданных котов, собак и животных.

Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
+ Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
+ Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
+Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
+Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
+ Добавить метод, с помощью которого можно было бы добавлять еду в миску.
Задание 2:
Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
Задать для каждой фигуры цвет заливки и цвет границы.
Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.


Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.
*/
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Animal leapold = new Cat("Леапольд", 10, false);
        Animal graph = new Dog("Граф");

        leapold.run(150);
        leapold.swim(200);
        graph.run(500);
        graph.run(501);
        graph.swim(10);
        graph.swim(11);

        int firstAction;
        int action;
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Кузя", 10, false);
        cats[1] = new Cat("Маруся", 10, false);
        cats[2] = new Cat("Рыжик", 10, false);
        cats[3] = new Cat("Толстячок", 20, false);

//      Сколько изначанльно должно быть корма в миске  ?
        System.out.println("Коты пришли поесть, сколько грамм хотите положить ?");
        firstAction = scanner.nextInt();
        Bowl bowl = new Bowl(firstAction);

        //Если в миске есть еда
        if (Bowl.food >= 0) {
            //Для каждого кота
            for (Cat cat : cats) {
                //если в миске меньше еды чем рацион кота, тот к ней не подойдет
                if (cat.getAppetite() > Bowl.food) {
                    System.out.println("Котик " + cat.getName() + " ходит вокруг да около миски, потому что там недостаточно еды");
                    break;
                }
                //Если кот голоден
                if (!cat.isFullness()) {
                    //кот ест и насыщается
                    cat.eat(bowl);
                    cat.setFullness(true);
                    System.out.println("Сытость котов " + cat.isFullness());
                }
            }
        }
        bowl.info();
        System.out.println("Можно добавить еду, сколько ?");
        action = scanner.nextInt();
        bowl.increaseFood(action);
        bowl.info();

        System.out.println("Всех животных " + Animal.getCountAnimal());
        System.out.println("Всех котов: " + Cat.getCountCat());
        System.out.println("Всех собак: " + Dog.getCountDod());
//------------------------------------------------------------------------------------------------------------
        Circle circle = new Circle(5, "Red", "Black");
        Rectangle rectangle = new Rectangle(4, 6, "Blue", "Green");
        Triangle triangle = new Triangle(3, 4, 5, "Yellow", "Brown");

        System.out.println("Круг: Периметр - " + circle.calculatePerimeter() + ", Площадь - " + circle.calculateArea() + ", Цвет заливки - " + circle.getFillColor() + ", Цвет границы - " + circle.getBorderColor());
        System.out.println("Прямоугольник: Периметр - " + rectangle.calculatePerimeter() + ", Площадь - " + rectangle.calculateArea() + ", Цвет заливки - " + rectangle.getFillColor() + ", Цвет границы - " + rectangle.getBorderColor());
        System.out.println("Треугольник: Периметр - " + triangle.calculatePerimeter() + ", Площадь - " + triangle.calculateArea() + ", Цвет заливки - " + triangle.getFillColor() + ", Цвет границы - " + triangle.getBorderColor());
    }
}
