import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tess {
    public static void main(String[] args) {
        String s = "assa-20200910_202020-assq.sw.aas";
        String ss = "[^0-9]";
        Pattern p = Pattern.compile(ss);
        Matcher m = p.matcher(s);
        String sss= m.replaceAll("");

    }
}

