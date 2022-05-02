package Code;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Mine11 {

    public static void main(String[] args) {
        // Creating a list of Strings
        List<String> list = Arrays.asList("Geeks", "FOR", "GEEKSQUIZ",
                "Computer", "Science", "gfg");
        List<String> nList =list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(nList);
    }
}
