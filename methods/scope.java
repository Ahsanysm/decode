package methods;
//local and global variable
public class scope {
    static int i;// this is global variable
    public static void main(String[] args) {
       i=16;
        System.out.println(i);
        int i=23;//this i is local to main function
        System.out.println(i);
        fun();
    }
        public static void fun(){
        System.out.println(i);
    }
}

