import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteRegex {

    private static Pattern pattern;

    public static void main(String[] args) {
    	teste01();
    	teste02();
    }

	private static void teste02() { 
		pattern = Pattern.compile("(\\d{4})(-)(\\d{2})(-)(\\d{2})");
		String data = "2007-12-31";
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()){
			System.out.println(matcher.group() +" || "+
							   matcher.group(1)+" || "+
							   matcher.group(2)+" || "+
							   matcher.group(3)+" || "+
							   matcher.group(4)+" || "+
							   matcher.group(5));
			String ano = matcher.group(1);
			System.out.println(ano);
		}
		String novaData = data.replaceAll("-", "/");
		System.out.println(novaData);
		
	}

	private static void teste01() {
		pattern = Pattern.compile("(\\d\\d)(\\w)");
        Matcher matcher = pattern.matcher("11a22b33c");
        while(matcher.find()) {
            String match = matcher.group();
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);

            int start = matcher.start();
            int end = matcher.end();

            System.out.printf("%s | %s |  %s [%d,%d] %n", match, group1, group2, start, end);
        }
	}
}