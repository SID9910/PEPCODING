class Solution {
    //approach tle de rahi hai .but not confirm about solution
//      int count=0;
//     public int numPairsDivisibleBy60(int[] time) {
//        int n =time.length;
       
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if((time[i]+time[j])%60==0){
//                     count++;
//                 }else{
                    
//                 }
//             }
//         }
//         return count;
//     }
    //solution nhi samaja aaya aabhi code implementation
      public int numPairsDivisibleBy60(int[] time){
          int[] fmap = new int[60];
          int res =0;
          for(int t:time){
              int rem=t%60; //basically remainder hai isme
              if(rem ==0){
                  res+=fmap[0];
                  
              }else{
                  res +=fmap[60-rem];
              }
              fmap[rem]++;
              
          }
          return res;
      }
}