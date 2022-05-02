package Code;

public class User {
    int age;

    void setAge(int a) {
        if (a > 35)
            throw new IllegalArgumentException();
        age = a;

    }
}
