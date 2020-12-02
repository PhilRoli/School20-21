public class Person {
    // Eigenschaften einer Person
    public String name;
    public int alter;

    public Person(String n, int a) {
        name = n;
        alter = a;
    }

    public String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int a) {
        alter = a;
    }
}
