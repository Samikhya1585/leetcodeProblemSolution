class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int max=nums[0];
        for(int i=1;i<n;i++){

            if(min>nums[i]){
                min=nums[i];
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return gcd(min,max);
        
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}