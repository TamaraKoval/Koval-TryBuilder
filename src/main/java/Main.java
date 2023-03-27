public class Main {

    public static void main(String[] args) {
        Person antoshka = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .setAge(48)
                .build();

        System.out.println("Наш Антошка: " + antoshka);

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает имени
            new PersonBuilder().setSurname("Потеряшка").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает фамилии
            new PersonBuilder().setName("Потеряшка").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
