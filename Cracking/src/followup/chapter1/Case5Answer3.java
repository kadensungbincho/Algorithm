package followup.chapter1;

public class Case5Answer3 {
    public static void main(String[] args) {
        System.out.println(compressAlternate("aaaabbbbcd"));
    }

    public static String compressAlternate(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }

        setChar(array, last, index, count);
        return String.valueOf(array);
    }

    public static int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        char[] cnt = String.valueOf(count).toCharArray();

        for (char x : cnt) {
            array[index] = x;
            index++;
        }
        return index;
    }

    public static int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0;

        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        size += 1 + String.valueOf(count).length();
        return size;
    }
}
