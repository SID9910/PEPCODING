class Solution {
    //approach-1   baad main dp sikhne ke baad isko karunga
        //iterative 
        public int fib(int N) { if(N <= 1) return N; 
         int a = 0, b = 1;
        while(N-- > 1) {
          int sum = a + b;
         a = b;
         b = sum;
          }
        return b;
                              }                          
        
        //approach-2
        //  public int fib(int N)
        // {
        //     if(N <= 1)
        //         return N;
        //     else
        //         return fib(N - 1) + fib(N - 2);
        // }
    }