class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m=grid.length;//row
        int n=grid[0].length;//col

        int total=m*n;
        k=k%total;

        int[][] ans=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //curr index
                int indx=i*n+j;

                //shift to new index
                int newIndx=(indx+k)%total;

                //convert back to 2d array
                int newRow=newIndx/n;
                int newCol=newIndx%n;

                ans[newRow][newCol]=grid[i][j];
            }
        }

            List<List<Integer>>res=new ArrayList<>();

            for(int i=0;i<m;i++){
                List<Integer>row=new ArrayList<>();
                for(int j=0;j<n;j++){
                    row.add(ans[i][j]);
                }
                res.add(row);
            }
            return res;
    }
}