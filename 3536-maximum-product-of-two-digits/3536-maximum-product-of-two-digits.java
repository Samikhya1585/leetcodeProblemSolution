class Solution {
    public int maxProduct(int n) {
        int largest=0;
        int secLargest=0;

        while(n>0){
            int digit=n%10;

            if(digit>=largest){
                secLargest=largest;
                largest=digit;
            }
            else if(digit>secLargest){
                secLargest=digit;
            }
            n=n/10;

        }
        return largest*secLargest;
        
    }
}