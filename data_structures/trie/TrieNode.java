/*
    * trieNode has an array of itself called children these children contain all possible values
    * For example: To store English words a-z we use 26 as size of array
    * isWord represents the end of the word, means last character
    * by default is false
 */
public class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26]; //for english characters
        this.isWord = false;
    }
}
