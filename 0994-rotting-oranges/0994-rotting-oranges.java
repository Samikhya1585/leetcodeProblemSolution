class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q=new LinkedList<>();

        int rows=grid.length;
        int cols=grid[0].length;

        int fresh=0;
        boolean[][] visited = new boolean[rows][cols];

        //store all rotten oranges in queue
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    visited[i][j]=false;
                    fresh++;
                }

            }
        }
        int ans=0;

        while(!q.isEmpty()){
            Pair curr=q.poll();

            int row=curr.row;
            int col=curr.col;
            int time=curr.time;

            ans=Math.max(ans,time);

            //upper
            if(row+1<rows && !visited[row+1][col] && grid[row+1][col]==1){
                visited[row+1][col]=true;
                fresh--;
                q.offer(new Pair(row+1,col,time+1));
            }

            //bottom
            if(row-1>=0 && !visited[row-1][col] && grid[row-1][col]==1){
                visited[row-1][col]=true;
                fresh--;
                q.offer(new Pair(row-1,col,time+1));

            }

            //left
            if(col-1>=0 && !visited[row][col-1] && grid[row][col-1]==1){
                visited[row][col-1]=true;
                fresh--;
                q.offer(new Pair(row,col-1,time+1));

            }

            //right
            if(col+1<cols && !visited[row][col+1] && grid[row][col+1]==1){
                visited[row][col+1]=true;
                fresh--;
                q.offer(new Pair(row,col+1,time+1));
            }
        }

        if(fresh>0){
            return -1;
        }
        else{
            return ans;
        }


        
    }
}