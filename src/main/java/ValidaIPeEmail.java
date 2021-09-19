import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaIPeEmail {

    public boolean isValidEmail(String email) {
        if (email == null)
            return false;
        Pattern pat = Pattern.compile("\\S+.+@.+\\.[a-z]+");
        Matcher matcher = pat.matcher(email);
        return matcher.find();
    }

    public boolean isValidIP(String ip) {
        if (ip == null)
            return false;
        if (ip.startsWith("00")) {
            return false;
        }
        Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

        boolean bool = ipPattern.matcher(ip).matches();
        if (bool) {
            String[] ipAry = ip.split("\\.");
            for (int i = 0; i < ipAry.length; i++) {
                int value = Integer.parseInt(ipAry[i]);
                if ((value < 0) || (value > 255)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}