
//rotate an array main hamne reversal algorithm se kara hai
//vo reverse karke rotato karte hai notes check karo
//for rotato also check rotate ka number
import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    // swap function array pass karna jaruri hai kyoki ye heap ka change hai
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // reverse an array ka function
    public static void reverse(int[] a, int left, int right) {

        while (left <= right) { // ye condition ye hai ki aaagr jaise he right index se left index
                                // bda hua uss he time stop ho jaega or equal hua taab bhi
            swap(a, left, right);// swap kar dega left index ki value ko right index ki value se

            left++;// left index bdao
            right--;// right index ko gatao
        }

    }

    public static void rotate(int[] a, int k) {
        int n = a.length;
        k = k % n; // aaagr 350 bar roation ka aaise kuch aay to kaam rotations karne ke ley
        if (k < 0) { // aaagr -ve aaya k to use positive main convert kardo or utne he
                     // +ve rotations kardo
            k = k + n;
        }
        // reversal algorithm
        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}