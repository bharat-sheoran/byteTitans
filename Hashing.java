import java.security.Key;
import java.util.*;
public class Hashing {

    class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    class Info{
        Node node;
        int hd;

        Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    // static class HashMap<K,V> {   // Generic
    //     private class Node{
    //         K key;
    //         V value;

    //         public Node(K key , V value){
    //             this.key = key;
    //             this.value = value;
    //         }
    //     }

    //     private int n;  // n
    //     private int N;
    //     private LinkedList<Node> buckets[];  // N

    //     @SuppressWarnings("Unchecked")
    //     public HashMap(){
    //         this.N = 4;
    //         this.buckets = new LinkedList[4];

    //         for (int i = 0; i< 4; i++){
    //             this.buckets[i] = new LinkedList<>();
    //         }
    //     }

    //     private int hashFunction(K key){
    //         int hc = key.hashCode();
    //         return Math.abs(hc) % N;
    //     }

    //     private int searchInLL(K key , int bi){
    //         LinkedList<Node> ll = buckets[bi];
    //         int di = 0; 

    //         for (int i = 0; i < ll.size(); i++){
    //             Node node = ll.get(i);
    //             if (node.key == key){
    //                 return di;
    //             }
    //             di++;
    //         }
    //         return -1;
    //     }

    //     @SuppressWarnings("unchecked")
    //     private void rehash(){
    //         LinkedList<Node> oldBuck[] = buckets;
    //         buckets = new LinkedList[N * 2];

    //         N = N * 2;

    //         for (int i = 0; i< buckets.length; i++){
    //             buckets[i] = new LinkedList<>();
    //         }

    //         // Nodes add in new bucket
    //         for (int i = 0; i< oldBuck.length; i++){
    //             LinkedList<Node> ll = oldBuck[i];
    //             for (int j = 0; j < ll.size(); j++){
    //                 Node node = ll.remove();
    //                 put(node.key, node.value);
    //             }
    //         }
    //     }

    //     public void put(K key , V value){
    //         int bi = hashFunction(key);  // 0 to 3
    //         int di = searchInLL(key , bi);   // valid or -1

    //         if (di != -1){
    //             Node node = buckets[bi].get(di);
    //             node.value = value;
    //         }else{
    //             buckets[bi].add(new Node(key, value));
    //             n++;
    //         }

    //         double lambda = (double)(n/N);
    //         if (lambda > 2.0){
    //             rehash();
    //         }
    //     }

    //     public boolean containsKey(K key){
    //         int bi = hashFunction(key);  // 0 to 3
    //         int di = searchInLL(key , bi);   // valid or -1

    //         if (di != -1){
    //             return true;
    //         }else{
    //             return false;
    //         }
    //     }

    //     public V get(K key){
    //         int bi = hashFunction(key);  // 0 to 3
    //         int di = searchInLL(key , bi);   // valid or -1

    //         if (di != -1){
    //             Node node = buckets[bi].get(di);
    //             return node.value;
    //         }else{
    //             return null;
    //         }
    //     }

    //     public V remove(K key){
    //         int bi = hashFunction(key);  // 0 to 3
    //         int di = searchInLL(key , bi);   // valid or -1

    //         if (di != -1){
    //             Node node = buckets[bi].remove(di);
    //             n--;
    //             return node.value;
    //         }else{
    //             return null;
    //         }

    //     }

    //     public ArrayList<K> keySet(){
    //         ArrayList<K> keys = new ArrayList<>();

    //         for (int i = 0; i< buckets.length; i++){
    //             LinkedList<Node> ll = buckets[i];
    //             for (Node node : ll) {
    //                 keys.add(node.key);
    //             }
    //         }
    //         return keys;
    //     }

    //     public boolean isEmpty(){
    //         return n==0;
    //     }
    // }

    public static boolean validAnagram(String s , String t){
        HashMap<Character , Integer> map = new HashMap<>();
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i< t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if (map.get(t.charAt(i)) == 0){
                    map.remove(t.charAt(i));
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }

    public static int countDistinct(int nums[]){
        HashSet<Integer> elements = new HashSet<>();

        for(int i = 0; i< nums.length; i++){
            elements.add(nums[i]);
        }

        return elements.size();
    }

    public static void arrUnion(int arr1[] , int arr2[]){
        HashSet<Integer> elements = new HashSet<>();

        for(int i = 0; i< arr1.length; i++){
            elements.add(arr1[i]);
        }

        for(int i = 0; i< arr2.length; i++){
            elements.add(arr2[i]);
        }
        System.out.print(elements.size() + " (");
        for (Integer print : elements) {
            System.out.print(print + " ");
        }
        System.out.println(")");
    }

    public static void arrIntersection(int arr1[] , int arr2[]){
        HashSet<Integer> elements = new HashSet<>();
        int count = 0;
        for(int i = 0; i<arr1.length; i++){
            elements.add(arr1[i]);
        }

        for(int i = 0; i< arr2.length; i++){
            if (elements.contains(arr2[i])){
                count++;
                elements.remove(arr2[i]);
            }
        }
        System.out.print(count);
    }

    public static String getJourney(HashMap<String , String> tickets){
        HashMap<String , String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)){
                return key; // Starting point
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // Create
        // HashMap<String , Integer> hm = new HashMap<>();

        // // // Insert the data  O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);
        
        // System.out.println(hm);

        // ArrayList<String> keys = hm.keySet();
        // for (String key : keys) {
        //     System.out.println(key);
        // }

        // // Get the data  O(1)
        // System.out.println(hm.get("India"));

        // // Contains key  O(1)
        // System.out.println(hm.containsKey("India"));

        // // Remove the data  O(1)
        // hm.remove("China");
        // System.out.println(hm);

        // // Iterate
        // Set<String> keys = hm.keySet();
        // // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("Keys: " + k + ", Value: " + hm.get(k));
        // }

        // LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>(); 
        // lhm.put("India", 150);
        // lhm.put("china", 200);
        // lhm.put("Nepal", 5);

        // System.out.println(lhm);
        
        // TreeMap<String , Integer> tm = new TreeMap<>();
        // tm.put("India", 100);
        // tm.put("China", 150);
        // tm.put("US", 50);
        // tm.put("Indonesia", 6);
        // tm.put("Nepal", 5);

        // System.out.println(tm);

        // int nums[] = {1,2};
        // HashMap<Integer , Integer> map = new HashMap<>();

        // for (int i = 0; i< nums.length; i++){
        //     int num = nums[i];
        //     // if (map.containsKey(num)){
        //     //     map.put(num, map.get(num) + 1);
        //     // }else{
        //     //     map.put(num, 1);
        //     // }
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // int n = nums.length;
        // Set<Integer> keys = map.keySet();
        // for (Integer key : keys) {
        //     if (map.get(key) > n / 3){
        //         System.out.print(key + " ");
        //     }
        // }

        // String s = "bharat";
        // String t = "keen";

        // System.out.println(validAnagram(s, t));

        // HashSet<Integer> set = new HashSet<>();
        // set.add(1);
        // set.add(4);
        // set.add(3);
        // set.add(2);

        // System.out.println(set);

        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Chandigarh");
        // cities.add("Noida");

        // Iterator itr = cities.iterator();
        // while(itr.hasNext()){
        //     System.out.print(itr.next() + " ");
        // }
        // System.out.println();

        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Chandigarh");
        // lhs.add("Noida");

        // Iterator it = lhs.iterator();
        // while(it.hasNext()){
        //     System.out.print(it.next() + " ");
        // }
        // System.out.println();

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Mumbai");
        // ts.add("Chandigarh");
        // ts.add("Noida");

        // Iterator iter = ts.iterator();
        // while(iter.hasNext()){
        //     System.out.print(iter.next() + " ");
        // }
        // System.out.println();

        // int nums[] = {4,3,2,5,6,7,3,4,2,1};
        // System.out.println(countDistinct(nums));

        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};

        // arrUnion(arr1, arr2);
        // arrIntersection(arr1, arr2);

        // HashMap<String , String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        // String start = getJourney(tickets);
        // System.out.print(start);

        // for (String key : tickets.keySet()) {
        //     System.out.print("-> " + tickets.get(start));
        //     start = tickets.get(start);
        // }

        // int arr[] = {15 , -2,2,-8,1,7,10,23};

        // HashMap<Integer , Integer> map = new HashMap<>();
        // // sum , idx

        // int sum = 0;
        // int len = 0;

        // for (int j = 0; j < arr.length; j++){
        //     sum += arr[j];
        //     if (map.containsKey(sum)){
        //         len = Math.max(len, j - map.get(sum));
        //     }else{
        //         map.put(sum, j);
        //     }
        // }

        // // // System.out.println("Largest subarray with sum 0 is ==> " + len);
        // int arr[] = {10,2,-2,-20,10};
        // int k = -10;

        // HashMap<Integer , Integer> map = new HashMap<>();
        // map.put(0, 1);

        // int sum = 0;
        // int ans = 0;

        // for (int j = 0; j < arr.length; j++){
        //     sum += arr[j];
        //     if (map.containsKey(sum - k)){
        //         ans += map.get(sum - k);
        //     }

        //     map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }
        // System.out.println("The number of subarrays are ==> " + ans);


    }
}
