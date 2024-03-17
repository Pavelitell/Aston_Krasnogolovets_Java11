
public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[5];
        animals[0] = new Cat("Кот сиамский", "Мурзик", 0,10,false);
        animals[1] = new Cat("Кошка абиссинская", "Алиса",  6,10,false);
        animals[2] = new Cat("Кот сиамский", "Мурзик",  0,10,false);
        animals[3] = new Cat("Кошка абиссинская", "Алиса",  6,10,false);
        animals[4] = new Cat("Кошка абиссинская", "Алиса",  6,10,false);

        System.out.println("Характеристики созданных животных");
        System.out.println("---------------------------------------------------------------------------------------");
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Всего котов создано: " + Cat.getCount());



    }
}
