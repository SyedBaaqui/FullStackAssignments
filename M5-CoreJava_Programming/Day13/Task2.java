/*Day-13 Task 2:
Trie for Prefix Checking
Implement a trie data structure in java that supports insertion of strings and 
provides a method to check if a given string is a prefix of any word in the trie.
*/

//Solution:

package day13.task2;
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming lowercase English letters
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Check if the trie contains the given prefix
    public boolean containsPrefix(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage:
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println("Does trie contain prefix 'app'? " + trie.containsPrefix("app")); // Output: true
        System.out.println("Does trie contain prefix 'bat'? " + trie.containsPrefix("bat")); // Output: false
    }
}
