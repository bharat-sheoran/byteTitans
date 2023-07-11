public class GreedyAlgoHomework {

    public static int maxBalStrPar(String str , int n){
        if (n == 0){
            return 0;
        }

        int r = 0, l = 0;
        int ans = 0;
        for(int i = 0; i< n; i++){
            if (str.charAt(i) == 'R'){
                r++;
            }else if(str.charAt(i) == 'L'){
                l++;
            }
            if (l == r){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int n = str.length();

        System.out.println(maxBalStrPar(str, n));
    }
}
