package stringExample;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringController stringController = new StringController();
        String s = "Hellllllo Hello my friend my name is Hello Hello Quang";
        String s1 = "Hello";
        char character = 'n';
        List<String> stringList = Arrays.asList("Hello","my","friend");

        System.out.println("Total character: "+stringController.getTotalCharacter(s,character));
        String string = stringController.concatString(stringList);
        System.out.println(string);
        System.out.println(stringController.cutString(string));
        System.out.println(stringController.replaceString(s,"Quang","Smith"));

        stringController.getIndexCharacter(s,character);

        System.out.println("\nTotal string: "+stringController.getTotalString(s,s1));
        stringController.getIndexString(s,s1);

        System.out.println("\n"+stringController.getCharacterMax(s));
        System.out.println(stringController.totalString(s));
        System.out.println(stringController.getListSubString(s));

    }
}
