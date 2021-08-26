public class Runner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("ca");
        trie.insert("cassy");
        System.out.println(trie.contains("cass"));
    }
}
