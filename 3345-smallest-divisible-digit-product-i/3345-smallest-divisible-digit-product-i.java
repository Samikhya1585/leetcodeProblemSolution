class Solution {
    public int findProd(int n){
        int mul=1;

        while(n>0){
            int d=n%10;
            mul*=d;
            n=n/10;
        }
        return mul;
    }
    public int smallestNumber(int n, int t) {
       while(true){
         int mul=findProd(n);
        if(mul%t==0){
            return n;
        }
        n++;
       }
        
    
        
    }
}