package implentation;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        //----------------------- Trial of Insertion in Trie-----------------------\\
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("ca");
        trie.insert("cassy");

        //--------------------- Trial of contains() in Trie------------------------\\

        System.out.println(trie.contains("cass"));

        //-------------------- Trial of displayAllWords() in Trie aka using root -----------------\\

        ArrayList<String> words = trie.displayAllWords();
        for (String word :
                words) {
            System.out.println(word);
        }

        //------------------- Trial of searchNodeUsingPrefix() -------------------\\

        TrieNode temp = trie.searchNodeUsingPrefix("ca");
        System.out.println(temp.children[1]); //since this index 1 which represents b is not empty it means b is present as in "cab"

        //------------------- Trial of displayAllWords(String prefix) using searchNodeUsingPrefix() for autocomplete -------\\

        trie.insert("bossy");
        trie.insert("boss");

        words = trie.displayAllWordsUsingPrefix("ca");
        for (String word :
                words) {
            System.out.println(word);
        }

        words = trie.displayAllWordsUsingPrefix("boss");
        for (String word :
                words) {
            System.out.println(word);
        }


    }
}
