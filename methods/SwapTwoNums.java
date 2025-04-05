package methods;
//swap two numbers with and without using third varibale
import java.util.Scanner;
public class SwapTwoNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp = a;//storing value of a in temporary
        a = b;
        b = temp;
        System.out.println(a + " " + b);
        withouttemp();
    }
    public static void withouttemp(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter num1");
            int num1 = sc.nextInt();
            System.out.println("Enter num2");
            int num2 = sc.nextInt();
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
            System.out.println(num1);
            System.out.println(num2);
        }
    }
