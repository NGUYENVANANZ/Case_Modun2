package Case.DinhDangChuoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DinhDang {

    public String DinhDang_KyUser(String str) {
        Pattern parameter = Pattern.compile("^[A-Z]+[\\w]{3,}@([a-z]+\\.+[a-z]+)$");
        Matcher matcher = parameter.matcher(str);
        if (matcher.find()) {
            return str.substring(matcher.start(), matcher.end());
        } else {
            System.out.println("Sai định dạng " + "Ví dụ: vanan@gmail.com");
            return null;
        }
    }

    public String DinhDang_KyPass(String str) {
        Pattern parameter = Pattern.compile("[\\w]{3,}");
        Matcher matcher = parameter.matcher(str);
        if (matcher.find()) {
            return str.substring(matcher.start(), matcher.end());
        } else {
            System.out.println("Sai định dạng " + "an0607");
            return null;
        }
    }
}
