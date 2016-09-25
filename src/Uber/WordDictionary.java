package Uber;


public class WordDictionary {

    // Adds a word into the data structure.
    Trie trie = new Trie();
    public void addWord(String word) {
        trie.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	boolean result = trie.search(word);
    	System.out.println("Returning "+result+" for search: "+word);
        return result;
    }
    
    public static void main(String[] args) {
		WordDictionary temp = new WordDictionary();
		temp.addWord("at");
		temp.addWord("and");
		temp.addWord("an");
		temp.addWord("add");
		temp.search("a");
		temp.search(".at");
		temp.addWord("bat");
		temp.search(".at");
		temp.search("an.");
		temp.search("a.d.");
		temp.search("b.");
		temp.search("a.d");
		temp.search(".");
	}
}
class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

class Trie{
    TrieNode head;
    public Trie(){
        head = new TrieNode();
    }
    
    public void add(String word){
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(temp.children[index]==null){
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isWord=true;
    }
    
    public boolean search(String word){
        return help(head, word.toCharArray(), -1);
    }
    
    private boolean help(TrieNode node, char[] word, int i){
        if(i>=word.length-1){
            return true;
        }
        
        if(node==null){
            return false;
        }
        
        char ch = word[i+1];
        System.out.println("\t got: "+ch);
        if(ch=='.'){
            for(TrieNode child:node.children){
                if(child!=null){
                    if(help(child, word, i+1)){
                        return true;
                    } 
                }
            }
            return false;
        }else{
            int index = ch-'a';
            if(node.children[index]==null){
                return false;
            }else{
                return help(node.children[index], word, i+1);
            }
        }
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");