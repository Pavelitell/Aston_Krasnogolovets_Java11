package lesson_5.zoo;

public class Dog extends Animal {
    private String name;
    static int countDod = 0;

    public Dog(String name){
        super();
        countDod++;
        this.name = name;
    }

    @Override
    public void run(int range) {
        if (range > 500) {
            System.out.println(name+ " Не может бежать больше 500 метров");
        } else {
            System.out.println(name+ " пробежал " + range + " метров");
        }

    }

    @Override
    public void swim(int range) {
        if (range > 10) {
            System.out.println( name +" не сможет проплыть больше 10ти метров");
        } else {
            System.out.println(name + " проплыл " + range + " метров");
        }
    }

    public static int getCountDod(){
        return countDod;
    }
}

