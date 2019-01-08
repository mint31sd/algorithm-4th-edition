package qr2_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Insertion {
    private Insertion() {
    }

    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
        String[] a = {"12", "ed", "rf", "4r", "y5", "na"};
        sort(a);
        show(a);
    }

    public static void sort(Comparable[] a) { // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) { // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; ++i) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); --j) {
                exch((Object[]) a, j, j - 1);
            }
        }

        assert isSorted(a, lo, hi);

    }

    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); --j) {
                exch(a, j, j - 1);
            }

            assert isSorted(a, 0, i, comparator);
        }

        assert isSorted(a, comparator);

    }

    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i < hi; ++i) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); --j) {
                exch(a, j, j - 1);
            }
        }

        assert isSorted(a, lo, hi, comparator);

    }

    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];

        int i;
        for (i = 0; i < n; index[i] = i++) {
            ;
        }

        for (i = 0; i < n; ++i) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); --j) {
                exch(index, j, j - 1);
            }
        }

        return index;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; ++i) {
            if (less(a[i], a[i - 1], comparator)) {
                return false;
            }
        }

        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; ++i) {
            StdOut.println(a[i]);
        }

    }

}
