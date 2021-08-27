package autocorrect_project;

import implentation.Trie;
import implentation.TrieNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    Trie trie = new Trie();
    JComboBox<String> searchBox;

    public GUI() {
        try {
            addWordsToTrie("H:\\Huzaifa\\Python\\Project\\JAVA_Projects\\Data_Structures_And_Algos_Using_Java\\data_structures\\trie\\autocorrect_project\\words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.setVisible(true);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        searchBox = new JComboBox<>();
        searchBox.setPreferredSize(new Dimension(100, 100));
        searchBox.setBounds(20, 50, 250, 50);
        searchBox.setEditable(true);
        searchBox.getEditor().getEditorComponent().addKeyListener(new searchKey());
        this.add(searchBox);


        TrieNode node = trie.searchNodeUsingPrefix("az");
        System.out.println(node);
//        ArrayList<String> searchResults = trie.displayAllWordsUsingPrefix("az");
//        for (String result :
//                searchResults) {
////            searchBox.addItem(result);
//            System.out.println(result);
//        }


    }

    private class searchKey implements KeyListener {
        int time = 1;

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                String s = (String) searchBox.getEditor().getItem(); //TODO
                if (!s.equalsIgnoreCase("") && e.getKeyCode() != KeyEvent.VK_BACK_SPACE && time == 1) {
                    time = 0; //wait until function is finished
                    time = addSearchedWordsToComboBox(s);
                }
            }
        }
    }


    public int addSearchedWordsToComboBox(String prefix) {
        searchBox.removeAllItems();
        ArrayList<String> searchResults = trie.displayAllWordsUsingPrefix(prefix); //add words to combo using tire
        if (searchResults != null) {
            for (String result :
                    searchResults) {
                searchBox.addItem(result);
            }
        }
        return 1;
    }

    public void addWordsToTrie(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not Found, Plz check filepath");
        }
        //inserting words using trie insert()
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while ((line = reader.readLine()) != null) {
            trie.insert(line);
        }
    }
}
