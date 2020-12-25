package followup.chapter1;

public class Case5Answer2 {
    public static void main(String[] args) {
        System.out.println(compressBetter("aaaabbbbbb"));

    }

    public static String compressBetter(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuffer myStr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                myStr.append(last);
                myStr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        myStr.append(last);
        myStr.append(count);
        return myStr.toString();
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
