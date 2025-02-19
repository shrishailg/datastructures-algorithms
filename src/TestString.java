public class TestString {

    public static void main(String... args) {
        Person p = new Person();

        p.print();
    }
}

class Person {
    String name = "batman";
    String fullName = init();

    public Person() {
        this.name = "superman";
    }

    private String init() {
        return name;
    }

     void print() {
        System.out.println(fullName);
    }
}

class Person1 extends Person {

    protected void print() {
        System.out.println("Shrishail1");
    }
}
