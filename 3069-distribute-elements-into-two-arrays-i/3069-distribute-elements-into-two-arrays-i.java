class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer>arr1=new ArrayList<>();
        ArrayList<Integer>arr2=new ArrayList<>();

        int n=nums.length;

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2;i<n;i++){
            int list1=arr1.get(arr1.size()-1);
            int list2=arr2.get(arr2.size()-1);

            if(list1>list2){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }

        int res[]=new int[n];
        int idx=0;

        for(int num:arr1){
            res[idx++]=num;
        }

        for(int num:arr2){
            res[idx++]=num;
        }

        return res;
        
    }
}