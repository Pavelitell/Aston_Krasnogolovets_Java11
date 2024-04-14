public class Main {
    public static void main(String[] args) {
        String[] words = {"яблоко", "груша", "яблоко", "вишня", "слива",
                "вишня", "апельсин", "яблоко", "груша", "вишня",
                "яблоко", "слива", "виноград", "апельсин", "вишня"
        };
        System.out.println("Слово | Кол-во повторений:");
        CountUniqueWords.countUnique(words);


        Phonebook phonebook = new Phonebook();
        phonebook.addNumber("Красноголовец", "+7 951 133-75-97");
        phonebook.addNumber("Павел", "+7 951 123-76-45");
        System.out.println("\nФИО | Номер телефона");
        phonebook.show();
    }
}

