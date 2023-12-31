import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class GreedyAlgorithms {

    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i , int d , int p){
            deadline = d;
            id = i;
            profit = p;
        }
    }
    public static void main(String[] args) {
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};   // End time basis sorted activity

        // // Sorting
        // int activities[][] = new int [start.length][3];
        // for (int i = 0; i < start.length; i++){
        //     activities[i][0] = i;
        //     activities[i][1] = start[i];
        //     activities[i][2] = end[i];
        // }

        // // lambda function --> short form
        // Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // maxAct = 1;
        // ans.add(activities[0][0]);
        // int lastEnd = activities[0][2];

        // for (int i = 1; i < end.length; i++){
        //     if (activities[i][1]>= lastEnd){
        //         // Select activity
        //         maxAct++;
        //         ans.add(activities[i][0]);
        //         lastEnd = activities[i][2];
        //     }
        // }
        // System.out.println("Maximum Activities " + maxAct);
        // for (int i = 0; i< ans.size(); i++){
        //     System.out.print("A" + ans.get(i) + " ");
        // }
        // System.out.println();


        // Fractional Knapsack question
        // int val[] = {60,100,120};
        // int weight[] = {10,20,30};
        // int W = 50;

        // double ratio[][] = new double[val.length][2];
        // // 0th --> idx ;     1st --> ratio;

        // for (int i = 0; i < val.length; i++){
        //     ratio[i][0] = i;
        //     ratio[i][1] = val[i]/(double)weight[i];
        // }

        // // Ascending order sorting
        // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // int capacity = W;
        // int finalVal = 0;

        // for (int i = ratio.length - 1; i >= 0; i--){
        //     int idx = (int)ratio[i][0];
        //     if (capacity >= weight[idx]){  // When full part is taken
        //         finalVal += val[idx];
        //         capacity -= weight[idx];
        //     }else{  // When fractional part is taken
        //         finalVal += ratio[i][1] * capacity;
        //         capacity = 0;
        //         break;
        //     }
        // }
        // System.out.println(finalVal);

        // find sum of minimum absoluete difference

        // int A[] = {4,1,8,7};
        // int B[] = {2,3,6,5};

        // Arrays.sort(A);
        // Arrays.sort(B);

        // int minDiff = 0;
        // for (int i = 0; i < A.length; i++){
        //     minDiff += Math.abs(A[i] - B[i]);
        // }
        // System.out.println(minDiff);

        // Max length chain of pairs
        // int pairs[][] = {{5,24},
        //                 {39,60},
        //                 {5,28},
        //                 {27,40},
        //                 {50,90}};

        // Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));

        // int chainLength = 1;
        // int chainEnd = pairs[0][1];

        // for (int i = 0; i< pairs.length; i++){
        //     if (pairs[i][0] > chainEnd){
        //         chainLength++;
        //         chainEnd = pairs[i][1];
        //     }
        // }
        // System.out.println(chainLength);

        // Give exchange of indian coins
        // Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        // Arrays.sort(coins, Comparator.reverseOrder());

        // int countOfCoins = 0;
        // int amount = 1068;
        // ArrayList<Integer> ans = new ArrayList<>();

        // for (int i = 0; i< coins.length; i++){
        //     if (coins[i] <= amount){
        //         while(coins[i] <= amount){
        //             countOfCoins++;
        //             ans.add(coins[i]);
        //             amount -= coins[i];
        //         }
        //     }
        // }
        // System.out.println(countOfCoins);
        // System.out.println(ans);

        // Job sequence problem
        // int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        // ArrayList<Job> jobs = new ArrayList<>();

        // for (int i = 0; i < jobsInfo.length; i++){
        //     jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        // }

        // Collections.sort(jobs , (a,b) -> b.profit - a.profit);  // Lambda functions   // Descending order

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;

        // for (int i = 0; i< jobs.size(); i++){
        //     Job curr = jobs.get(i);
        //     if (curr.deadline > time){
        //         seq.add(curr.id);
        //         time++;
        //     }
        // }

        // System.out.println(seq.size());
        // for (int i= 0; i< seq.size(); i++){
        //     System.out.print(seq.get(i) + " ");
        // }

        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer , Collections.reverseOrder());
        Arrays.sort(costHor , Collections.reverseOrder());

        int h = 0 , v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < costHor.length && v < costVer.length){
            if (costHor[h] >= costVer[v]){
                cost += costHor[h] * vp;
                hp++;
                h++;
            }else{
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
        }

        while(h < costHor.length){
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        while(v < costVer.length){
            cost += costVer[v] * hp;
            vp++;
            v++;
        }
        System.out.println("Min Cost of Cuts is " + cost);

    }
}
