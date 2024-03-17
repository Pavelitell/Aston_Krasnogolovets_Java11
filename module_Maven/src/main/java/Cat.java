public class Cat extends Animals{
    private static int count;
    public Cat(String type, String name, int run,int appetite, boolean fullness) {
        this.type = type;
        this.name = name;
        this.run = run;
        this.appetite = appetite;
        this.fullness = fullness;
        count++;
    }
    public static int getCount() {
        return count;
    }

}
