package methods;
//take n and r as input and print no. of combinations usign concept of
//using factorial of nums concept
import java.util.Scanner;
public class Combination {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
        System.out.println("Enter n");
         int n=sc.nextInt();
        System.out.println("Enter r");
         int r=sc.nextInt();

         int nFact=1;
        for (int i = 1; i <=n ; i++) {
            nFact*=i;
        }
        int rFact=1;
        for (int i = 1; i <=r ; i++) {
            rFact*=i;
        }
        int nminusrFact=1;
        for (int i = 1; i <=n-r ; i++) {
            nminusrFact*=i;
        }
        int ncr=nFact/(rFact*nminusrFact);  //this is the formula of the combination
        System.out.println(ncr);
    }
}
