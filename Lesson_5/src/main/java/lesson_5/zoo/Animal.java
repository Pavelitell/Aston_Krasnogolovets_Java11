package lesson_5.zoo;

public class Animal {
    static int countAnimal = 0;
    public Animal(){
        countAnimal++;
    }
    void run (int range) {
        System.out.println("Животное пробежало " + range + "  метров");
    }

    void swim (int range){
        System.out.println("Животное проплыло " + range + " метров");
    }

    public static int getCountAnimal(){
        return countAnimal;
    }
}
