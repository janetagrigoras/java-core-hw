package hw_javacore1;

public class task2 {
    public String reverseLoop(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public String stringBuilder(String str) {
        StringBuilder result = new StringBuilder(str).reverse();
        return result.toString();
    }

    public String reverseChars(String str) {
        char[] char_str = str.toCharArray();
        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = char_str[str.length() - 1 - i];
        }
        return new String(result);
    }
}
