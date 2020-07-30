package followup.chapter10;

import java.util.Arrays;

public class Case10Dot1 {
    public static void main(String[] args) {
        TestCase10Dot1 tester = new TestCase10Dot1();
        tester.testMerge();
    }
}

class TestCase10Dot1 {
    public TestCase10Dot1() {
    }

    public void testMerge() {
        int[] a = {1, 3, 4};
        int[] b = {2, 4, 9, 12};
        int[] merged = new int[a.length + b.length];
        for (int i=0; i < a.length; i++) {
            merged[i] = a[i];
        }
        System.out.println("merged: " + Arrays.toString(merged));
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("b: " + Arrays.toString(b));
        merge(merged, b, a.length, b.length);
        System.out.println("AFTER - merged: " + Arrays.toString(merged));
    }

    public void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}
