import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.RunElement;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class Arraylist {

    public static void swapping(ArrayList<Integer> list , int idx1 , int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2 , temp);
        System.out.println(list);
    }
    // Bruette force
    public static void maxTrapWater(ArrayList<Integer> height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.size(); i++){
            for (int j = i + 1; j < height.size(); j++){
                int wallWidth = j - i;
                int wallHeight = Math.min(height.get(i), height.get(j));
                int area = wallWidth * wallHeight;
                maxArea = Math.max(area, maxArea);
            }
        }
        System.out.println(maxArea);
    }

    // 2 Pointer Approach
    public static int twoPointTrapWater(ArrayList<Integer> height) {
        int lp = 0;
        int rp = height.size() - 1;
        int maxArea = 0;

        while(lp < rp){
            // Calculate water area
            int width = rp - lp;
            int wallHeight = Math.min(height.get(lp), height.get(rp));
            int area = width * wallHeight;
            maxArea = Math.max(area, maxArea);

            // Update pointer
            if (height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxArea;
    }

    // Bruette Force
    public static boolean pairSum(ArrayList<Integer> list , int target) {
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoPointerPairSum(ArrayList<Integer> list , int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp){
            if (list.get(lp) + list.get(rp) == target){
                return true;
            }else if (list.get(lp) + list.get(rp) < target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list2 , int target) {
        int bp = -1;
        for (int i = 0; i < list2.size(); i++){
            if (list2.get(i) > list2.get(i + 1)){
                bp = i;
                break;
            }
        }

        int lp = bp + 1; int rp = bp;
        while(lp != rp){
            if (list2.get(lp) + list2.get(rp) == target){
                return true;
            }else if (list2.get(lp) + list2.get(rp) < target){
                lp = (lp + 1) % list2.size();
            }else{
                rp = (list2.size() + rp - 1) % list2.size();
            }
        }
        return false;
    }

    public static boolean isMonotone(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i) > list.get(i+1)){
                inc = false;
            }else if (list.get(i) < list.get(i + 1)){
                dec = false;
            }
        }
        return inc || dec;
    }

    public static ArrayList<Integer> printAlone(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 1; i < list.size() - 1; i++){
            if (list.get(i - 1) + 1 < list.get(i) && list.get(i) + 1 < list.get(i + 1)){
                result.add(list.get(i));
            }
        }

            if (list.size() == 1){
                result.add(list.get(0));
            }
            if (list.size() > 1){
                if (list.get(0) + 1 < list.get(0)){
                    result.add(list.get(0));
                }
                if (list.get(list.size()-2) + 1 < list.get(list.size()-1)) {
                    list.add(list.get(list.size()-1));
                }
            }
        return result;
    }
    public static void main(String[] args) {
        // Arraylist is part of java Collection framework
        // Syntax
        // ArrayList <Integer> list = new ArrayList<>();
        // ArrayList <String> list2 = new ArrayList<>();
        // ArrayList <String> list3 = new ArrayList<>();

        // operations on ArrayList
        // To add an Element
        // list.add(2); // O(1)
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);

        // To get an Element
        // System.out.println(list.get(2));

        // To Remove an Element
        // list.remove(3);
        // System.out.println(list);

        // To set an Element at an index
        // list.set(2, 6);
        // System.out.println(list);

        // To check the number is in list or not
        // System.out.println(list.contains(6));
        // System.out.println(list.contains(10));
        // System.out.println(list.size());

        // print the array list
        // for (int i = 0; i < list.size(); i++){
        //     System.out.print(list.get(i) + " ");
        // }

        // Print reverse of a number
        // for (int i = list.size() - 1; i >= 0 ; i--){
        //     System.out.print(list.get(i) + " ");
        // }

        // int maxValue = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++){
        //     if (list.get(i) >= maxValue){
        //         maxValue = list.get(i);
        //     }
        // }
        // System.out.println(maxValue);

        // Swapping
        // int idx1 = 1 , idx2 = 3;
        // swapping(list, idx1, idx2);

        // Collections.sort(list); // For Ascending order
        // Collections.sort(list, Collections.reverseOrder()); //descending order
        // System.out.println(list);
        // Comparators are those in which inbuilt functions logic can be changed

        // Multidimensional array list
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();

        // for (int i = 1; i <= 5; i++){
        //     list.add(i * 1);
        //     list1.add(i * 2);
        //     list2.add(i * 3);
        // }

        // mainList.add(list);
        // mainList.add(list1);
        // mainList.add(list2);

        // System.out.println(mainList);
        // for (int i = 0; i < mainList.size(); i++){
            // ArrayList<Integer> currList = mainList.get(i);
            // for (int j = 0; j < currList.size(); j++){
            //     System.out.print(currList.get(j) + " ");
            // }
            // System.out.println();
        // }

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1); height.add(8); height.add(6); height.add(2); height.add(5); height.add(4); height.add(8); height.add(3); height.add(7);
        // maxTrapWater(height);
        // System.out.println(twoPointTrapWater(height));

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
        // System.out.println(pairSum(list, 5));
        // System.out.println(twoPointerPairSum(list, 50));
        // ArrayList<Integer> list2 = new ArrayList<Integer>();
        // list2.add(11); list2.add(15); list2.add(6); list2.add(8); list2.add(9); list2.add(10);
        // System.out.println(pairSum2(list2, 5));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10); list.add(6); list.add(5); list.add(8);
        // System.out.println(isMonotone(list));
        System.out.print(printAlone(list));
    }
}
