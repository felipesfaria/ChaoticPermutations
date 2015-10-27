import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int n = 11;
        //Mais que isso não roda na minha maquina.
        //Erro: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //          at java.util.ArrayList.clone(ArrayList.java:334)
        //          at BackTracker.BackTrack(BackTracker.java:33)
        //          at BackTracker.BackTrack(BackTracker.java:40)X12
        for(int i=2;i<n;i++) {
            BackTracker backTracker = new BackTracker(i);
            ArrayList<ArrayList<Integer>> t = backTracker.Run();
            try {
                System.out.print(i + ":"+t.size()+":");
                System.out.println(IsCountValid(t, i));
            }catch(Exception e){
                System.out.println("Could not validate.");
                break;
            }
        }
    }

    public static boolean IsCountValid(ArrayList<ArrayList<Integer>> l,int n){
        double total = Factorial(n)* DivisionsSum(n);
        return total<l.size()+0.1&&total>l.size()-0.1;
    }

    public static int Factorial(int n){
        if(n==0) return 1;
        int f=1;
        for(int i =1;i<=n;i++)
            f*=i;
        return f;
    }

    public static double DivisionsSum(int n){
        double result = 1;
        for(int i=1;i<=n;i++){
            int signal;
            if(i%2==0) signal = 1;
            else signal = -1;
            result+=signal*(1.0/Factorial(i));
        }
        return result;
    }
}
