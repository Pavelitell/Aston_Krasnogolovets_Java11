package lesson_5.zoo;

public class Cat extends Animal {
    public String name;
    public int appetite;
    public boolean fullness;


    static int countCat = 0;

    public Cat(String name,int appetite,boolean fullness){
        super();
        countCat++;
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }



    @Override
    public void run(int range) {
        if (range > 200) {
            System.out.println(name+ " не может бежать больше двухста метров");
        } else {
            System.out.println(name + " пробежал(а) " + range + " метров");
        }
    }

    @Override
    public void swim(int range) {
        System.out.println("Кошки не умеют плавать.");
    }

    public void eat(Bowl i) {
        i.decreaseFood(appetite);
    }

    public static int getCountCat(){
        return countCat;
    }
}
