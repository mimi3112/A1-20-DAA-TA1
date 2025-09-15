//Problem Statement 3
import java.util.Scanner;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

public class DistinctSubstrings {

    TrieNode root = new TrieNode();
    int count = 0;

    public void insertSuffixes(String s) {
        for (int i = 0; i < s.length(); i++) {
            insert(s.substring(i));
        }
    }

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                count++;
            }
            node = node.children[index];
        }
    }

    public int countDistinctSubstrings(String s) {
        insertSuffixes(s);
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        sc.close();

        DistinctSubstrings ds = new DistinctSubstrings();
        System.out.println("Number of Distinct Substrings: " + ds.countDistinctSubstrings(s));
    }
}
