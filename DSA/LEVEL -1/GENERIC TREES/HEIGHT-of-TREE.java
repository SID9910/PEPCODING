
import java.io.*;
import java.util.*;

public class Main {

    // main code hai ye
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int height(Node node) {

        int height = -1;
        for (Node child : node.children) {
            int recAns = height(child);
            height = Math.max(recAns, height);
        }
        return height + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int h = height(root);
        System.out.println(h);
        // display(root);
    }

}
