import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
    //sab isme store karna 
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        // for row coordinates
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    row.add(r);
                }
            }
        }

        // for col coordinates
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1) {
                    col.add(c);
                }
            }
        }
//uper se saari 1 jga store hai rows ke arralist main aajegi 
//rows vise and aaise he column arraylist main bhi jha column main
//store hai vo bhi aajenge column main kha kha hai col arraylist main
//aab mid nikalo dono ka 
//and subtract kardo and uska sum karke dusre ke sath jodkar return
        int x = row.get(row.size() / 2);
        int y =col.get(col.size() / 2);
       int d1=0;
       int d2=0;
       for(int r=0;r<row.size();r++){
           d1+=Math.abs(row.get(r)-x);
       }
       for(int c=0;c<col.size();c++){
           d2+=Math.abs(col.get(c)-y);
       }
       
        return d1+d2;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}