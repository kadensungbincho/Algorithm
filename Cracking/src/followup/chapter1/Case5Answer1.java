package followup.chapter1;

public class Case5Answer1 {
    public static void main(String[] args) {
        System.out.println(compressBad("aaaabbbb"));
        System.out.println(compressBad("aabb"));
        System.out.println(compressBad("aabbcccccdaaaa"));
    }

    public static String compressBad(String str) {
        String myStr = "";
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                myStr += last + String.valueOf(count);

                last = str.charAt(i);
                count = 1;
            }
        }

        myStr += last + String.valueOf(count);

        if (myStr.length() < str.length()) {
            return myStr;
        }

        return str;
    }
}
