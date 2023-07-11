public class TriesPracticeQues {

    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i< 26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for(int i = 0; i< word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static void main(String[] args) {
        String strs[] = {"eat" , "tea" , "tan" , "ate" , "nat", "bat"};
        for(int i = 0; i< strs.length; i++){
            insert(strs[i]);
        }
    }
}
