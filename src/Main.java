import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int n = 10;
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
        double total = Factorial(n)*CalcD(n);

        if(total<l.size()+0.1&&total>l.size()-0.1)
            return true;
        else return false;
    }

    public static int Factorial(int n){
        if(n==0) return 1;
        int f=1;
        for(int i =1;i<=n;i++)
            f*=i;
        return f;
    }

    public static double CalcD(int n){
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
