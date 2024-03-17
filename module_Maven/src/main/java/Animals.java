public class Animals {

    protected String type;
    protected String name;
    protected int swims;
    protected int run;
    public int appetite;
    public boolean fullness;

    private static int count;

    public Animals() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    protected void run(int distance) {
        if (run >= distance) {
            System.out.println(this.type + " по кличке  - УСПЕШНО пробежал(а) " + distance + "м.");
        } else {
            System.out.println(this.type + " по кличке   ---- сошел(а) с дистанции ---- ");
        }
    }

    protected void swim(int distance) {
        if (swims >= distance) {
            System.out.println(this.type + " по кличке   - УСПЕШНО проплыл(а) " + distance + "м.");
        } else {
            System.out.println(this.type + " по кличке  ---- не выполнил норматив ---- ");
        }


    }

    @Override
    public String toString() {
        return "Animals{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", swims=" + swims +
                ", run=" + run +
                ", appetite=" + appetite +
                ", fullness=" + fullness +
                '}';
    }
}

