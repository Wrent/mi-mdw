import java.text.DateFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akucera on 10/5/15.
 */
public class Convertor {

    private String name;
    private String surname;
    private String accountPrefix;
    private String accountSuffix;
    private String expMonth;
    private String expYear;

    public String convertFirstToSecond(String str) {
        readFirst(str);
        return printSecond();
    }
    public void main( String args[] ){
        this.convertFirstToSecond("owner_surname: \"SURNAME\"\n" +
                "owner_name: \"NAME\"\n" +
                "bank_account: \"XXXX-XXXX/XXXX\"\n" +
                "expiration: \"JAN/2020\"");
    }

    private void readFirst(String src) {
        String pattern = "owner\\_surname: \\\"(.*)\\\"";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);

        surname = m.group(0);

        pattern = "owner\\_name: \\\"(.*)\\\"";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        name = m.group(0);

        pattern = "bank\\_account: \\\"(.*)/(.*)\\\"";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        accountPrefix = m.group(0);
        accountSuffix = m.group(1);

        pattern = "expiration: \\\"(.*)/(.*)\\\"";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        String[] shortMonths = new DateFormatSymbols().getShortMonths();
        for (int i = 0; i < shortMonths.length; i++) {
            if (shortMonths[i] == m.group(0)) {
                expMonth = String.format("%02d", i);
            }
        }
        expMonth = m.group(0);
        expYear = m.group(1);
    }

    /*private void readSecond(String src) {
        String pattern = "<accountPrefix>(.*)</accountPrefix>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);

        accountPrefix = m.group(0);

        pattern = "<accountSuffix>(.*)</accountSuffix>";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        accountSuffix = m.group(0);

        pattern = "<owner>(.*) (.*)</owner>";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        name = m.group(0);
        surname = m.group(1);

        pattern = "<expiration>(.*)/(.*)</expiration>";
        r = Pattern.compile(pattern);
        m = r.matcher(src);

        String[] shortMonths = new DateFormatSymbols().getShortMonths();
        expMonth = shortMonths[Integer.parseInt(m.group(0))];
        expYear = m.group(1);
    }*/

    public String printSecond() {
        String str = new String();
        str.concat("<bankAccount>\n");
        str.concat("\t<accountPrefix>"+accountPrefix+"</accountPrefix>\n");
        str.concat("\t<accountSuffix>"+accountSuffix+"</accountSuffix>\n");
        str.concat("\t<owner>"+name+" "+surname+"</owner>\n");
        str.concat("\t<exp>"+expMonth+"/"+expYear+"</exp>\n");

        return str;
    }
}
