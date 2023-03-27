import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String city;
    public static final String MISSING_DATA = "данных нет";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
        this.city = MISSING_DATA;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = MISSING_DATA;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        if (age >= 0) {
            return String.valueOf(age);
        } else {
            return MISSING_DATA;
        }
    }

    public String getCity() {
        return city;
    }

    public void setAge(int age) {
        if (this.age == -1) {
            if (age >= 0) {
                this.age = age;
            }
        }
    }

    public void happyBirthday() {
        if (age != -1) {
            age++;
        }
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean hasAddress() {
        return !city.equals(MISSING_DATA);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setCity(city);
    }

    @Override
    public String toString() {
        if (age >= 0) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + MISSING_DATA +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
