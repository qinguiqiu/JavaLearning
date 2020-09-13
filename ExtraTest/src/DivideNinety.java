import java.util.Scanner;

public class DivideNinety {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int zero = 0;
        int five = 0;
        for(int i = 0; i < n; i++){
            if (in.nextInt()==0){
                zero++;
            }else {
                five++;
            }
        }
        if(zero==0){
            System.out.println(-1);
        }else if (five<9){
            System.out.println(0);
        }else {
            String five_s = "555555555";
            StringBuilder res = new StringBuilder();
            for(int i=0;i<five/9;i++){
                res.append(five_s);
            }
            for(int i=0;i<zero;i++){
                res.append(0);
            }
            System.out.println(res);
        }
    }
}
