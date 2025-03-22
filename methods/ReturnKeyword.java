package methods;
public class ReturnKeyword {
    public static void greet (int time) {
        if (time > 12)
            System.out.println("Good morning");
        else
            System.out.println("Good afternoon");
    }

    public static void main(String[] args) {
        greet(13);
    }
}
