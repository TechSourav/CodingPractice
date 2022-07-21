package recursion;

import java.util.function.Consumer;

public class Exercise {

    public static void main(String[] args) {
        System.out.println(first("souRav"));

    }

    static char first(String str) {
        if(str.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        }else {
            return first(str.substring(1, str.length()));
        }
    }

}
