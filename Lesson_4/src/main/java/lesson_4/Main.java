package lesson_4;

public class Main {
    public static void main(String[] args) {

        Employe[] minion = new Employe[5];
        minion[0] = new Employe("Petrov Valera", "Engineer", "ivivan@mailbox.com", "892312312",50000,41);
        minion[1] = new Employe("Loginov Artem", "Creator", "petrov@mailbox.com", "892312314",50000,32);
        minion[2] = new Employe("Lakin Pavel", "Water pot", "sidorov@mailbox.com", "892312315",10000,43);
        minion[3] = new Employe("Pikachev Achmed", "EnvelopeLicker", "pupkina@mailbox.com", "892312316",5000,18);
        minion[4] = new Employe("Rabbit", "pet", "Rabbit doesnt have Email", "Rabbit doesnt have Phone",1000,5);

        for (Employe employe:minion){
            System.out.println(employe);
        }
//      Проверка методов вложенного класса
        Park park = new Park();
        Park.Attrections attrections = new Park.Attrections(123,123,"first");
        System.out.println(attrections.getAttractionCost());
        attrections.setAttractionName("second");
        System.out.println(attrections.getAttractionName());



    }
}
