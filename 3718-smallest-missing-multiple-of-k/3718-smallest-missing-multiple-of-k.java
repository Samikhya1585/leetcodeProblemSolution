class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }

        int multiple=k;

        while(set.contains(multiple)){
            multiple+=k;
        }
        return multiple;
    }
}