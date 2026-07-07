class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long x;
        int d=0;
        int rev=0;
        long temp=0;

        while(n!=0){
            d=n%10;
            
            if(d!=0){
                rev=rev*10+d;
                sum+=d;
            }
            n/=10;
        }
        while(rev!=0){
            d=rev%10;
            temp=temp*10+d;
            rev/=10;

        }

        return temp*sum;


    }
        
}
    
