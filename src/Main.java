public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String original = Integer.toString(a);
        String result = null;
        for (int i = original.length() - 1; i >= 0; i--) {
            result += original.charAt(i);
        }
        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        String result = "";
        String test = "";
        str += " ";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                char first = test.charAt(0);
                int firstCharAscii = (int) first;
                String rest;

                if (test.length() > 2) {
                    rest = test.charAt(test.length() - 1) + test.substring(2, test.length() - 1) + test.charAt(1);
                } else if (test.length() == 2) {
                    rest = String.valueOf(test.charAt(1));
                } else {
                    rest = "";
                }

                result += firstCharAscii + rest + " ";
                test = "";
            } else {
                test += str.charAt(i);
            }
        }

        return result.trim();
    }


    // 4. decipherThis
    public static String decipherThis(String str) {
        String result = "";
        String word = "";
        int i = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                word += ch;
            } else if (!word.isEmpty()) {
                int code = Integer.parseInt(word);
                result += (char) code;
                word = "";

                if (Character.isLetter(ch)) {
                    result += ch;
                }
            } else {
                result += ch;
            }

            i++;
        }
        System.out.println(result);
        String[] things = result.split("\s+");
        String end = "";

        for (String thing : things) {
            if (thing.length() >= 3) {
                char firstChar = thing.charAt(0);
                char secondChar = thing.charAt(1);
                char lastChar = thing.charAt(thing.length() - 1);

                String swappedWord = lastChar + thing.substring(2, thing.length() - 1) + secondChar;
                end += firstChar + swappedWord + " ";
            } else {
                end += thing + " ";
            }
        }
        System.out.println(end);

        return end.trim();
    }
}

