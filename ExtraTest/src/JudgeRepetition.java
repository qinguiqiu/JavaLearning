import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JudgeRepetition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s=in.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            if(!list.contains(s[i])){
                list.add(s[i]);
                if(i==s.length-1){
                    System.out.println("false");
                }
            }else{
                System.out.println("true");
                break;
            }
        }
    }
}
