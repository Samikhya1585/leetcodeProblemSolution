class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int count=0;
        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }

        return count;

        
    }

    public static void dfs(int row,int col,char[][]grid,boolean[][]visited){

        //boundary check
        if(row<0||col<0||row>=grid.length||col>=grid[0].length){
            return ;
        }

        //water and visited 
        if(grid[row][col]=='0' || visited[row][col]){
            return ;
        }

        visited[row][col]=true;

        //visit all 4 sides
        dfs(row-1,col,grid,visited);
        dfs(row+1,col,grid,visited);
        dfs(row,col-1,grid,visited);
        dfs(row,col+1,grid,visited);

    }
}