class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] one=new boolean[2048];
        boolean[] two=new boolean[2048];
        boolean[] three=new boolean[2048];

        for(int x:nums){
            boolean[] newThree=three.clone();

            for(int i=0;i<2048;i++){
                if(two[i]){
                    newThree[i^x]=true;
                }
            }

            boolean[] newTwo = two.clone();
            for(int i=0;i<2048;i++){
                if(one[i]){
                    newTwo[i^x]=true;
                }
            }

            one[x]=true;
            two=newTwo;
            three=newThree;

        }

        //x^x^x=x
        for(int x:nums){
            three[x]=true;
        }
        int ans=0;

        for(boolean b:three){
            if(b){
                ans++;
            }
        }
        return ans;
        
    }
}