import java.util.*;
import java.util.ArrayList;

public class TriesHomework {
    static class Node{
        char data;
        Node children[];
        boolean isEnd;
        String word;

        public Node(char data){
            this.data = data;
            this.children = new Node[26];
            this.isEnd = false;
            this.word = null;
        }
    }

    public static Node root = new Node('/');
    public static String ans = "";
    // public static ArrayList<ArrayList<String>> ans;

    // public static ArrayList<ArrayList<String>> printAnagram(String strs[]){
    //     ans = new ArrayList<>();
    //     root = new Node();

    //     for(String word: strs){
    //         insert(word);
    //     }

    //     dfs(root);

    //     return ans;
    // }

    // public static void insert(String s){
    //     Node temp = root;
    //     char[] word = s.toCharArray();
    //     Arrays.sort(word);

    //     for(char c : word){
    //         Node child = temp.children[c - 'a'];
    //         if(child == null){
    //             temp.children[c - 'a'] = new Node();
    //         }
    //         temp = temp.children[c - 'a'];
    //     }
    //     temp.isEnd = true;
    //     temp.data.add(s);
    // }

    // public static void dfs(Node root){
    //     if(root.isEnd){
    //         ans.add(root.data);
    //     }

    //     for(int i = 0; i< 26; i++){
    //         if(root.children[i] != null){
    //             dfs(root.children[i]);
    //         }
    //     }
    // }

    public static void insert(String word){
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node(word.charAt(i));
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    public static void dfs(Node node){
        if(node == null){
            return;
        }

        if(node.word != null){
            if(node.word.length() > ans.length()){
                ans = node.word;
            }else if(node.word.length() == ans.length() && node.word.compareTo(ans) < 0){
                ans = node.word;
            }
        }

        for(Node child : node.children){
            if(child != null && child.word != null){
                dfs(child);
            }
        }
    }

    public static String largestNumber(String[] words){
        for(String word : words){
            insert(word);
        }

        Node curr = root;
        dfs(curr);
        return ans;
    }
    public static void main(String[] args) {
        // String strs[] = {"eat" , "tea" , "tan" , "ate" , "nat" , "bat"};

        // System.out.println(printAnagram(strs));

        String words[] = {"w" , "wo" , "wor" , "worl" , "world"};
        System.out.println(largestNumber(words));
    }
}
