class Solution {
    public void rotate(int[][] matrix) {
        //pehle transpose karo
    for(int i=0;i<matrix.length;i++){
        for(int j=i;j<matrix[0].length;j++){
            int temp =matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
        
        //aab bss har row ke elements kon swap kardo
        
        for(int i=0;i<matrix.length;i++){
            int left =0;
            int right =matrix.length-1;
            while(left<right){
                int temp =matrix[i][left];
                matrix[i][left] =matrix[i][right];
                matrix[i][right] =temp;
                left++;
                right--;
            }
        }
    }
}