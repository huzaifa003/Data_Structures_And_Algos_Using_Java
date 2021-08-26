/*
    * Trie data structure is used to give search results
    * ROOT is EMPTY when initialized
    * LATER it points to all characters as starting character
    * it has allot of nodes (arrays) pointing to one another to represent a word
    * TO GET INDEX OF char we can subtract it from the ascii value of 'a'
    * * for example: if we subtract 'a' from 'a' we get 0, which is gonna be the index value of trieNode Array
    *
 */
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(); //ROOT IS EMPTY
    }

    /*
        * Insertion means making allot of trieNods and pointing them to one another
        * THERE ARE 3 cases of inserting any word
        *
        * CASE -1 :- Trie is empty
        * -> we simply keep creating triedNodes and keep em pointing to one another until each character is entered
        * -> When end is reached we make isWord as true
        *
        * Case -2 :- Non-Empty Trie but no prefix to the previous word
        * -> we create another branch and repeat the case#1
        *
        * Case-3 :- Non-Empty Trie but WITH prefix matching the previous word
        * -> we simply use the all the common letters of common word and when there are no longer common words (in sequence) we create another branch to add remaining words
        *
        * Case-4 :- Non-Empty Trie WITH word already present
        * -> Now in this case if word is already present such as if we want to insert "dad" but trie already has word "daddy"
        * -> we mark the d (where dad ends) as isWord as well
     *
     */

    public void insert(String word)
    {
        word = word.toLowerCase(); //converting to lower case cause we have only made node of 26 characters (for only 1 case)

        TrieNode current = root; //whenever we initialize the root its empty;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i); //getting char from string
            int index = getIndex(character);

            if (current.children[index] == null) //if index of current children is empty where index is based on letter no for example 'c' will have index 2, 'a' will have index 0
            {
                current.children[index] = new TrieNode();  //then we create another TrieNode at the index indicating that there is a letter present
                current = current.children[index]; // moving current ahead of root to insert the  next letter
            }
            else
            {
                current = current.children[index]; //if node is already present (means letter is already there) we simply jump
            }
        }

        current.isWord = true; //representing end of the word
    }

    private int getIndex(char character)
    {
            // TO GET INDEX OF char we can subtract it from the ascii value of 'a'
            // for example: if we subtract 'a' from 'a' we get 0, which is gonna be the index value of trieNode Array
        return character - 'a';
    }
}
