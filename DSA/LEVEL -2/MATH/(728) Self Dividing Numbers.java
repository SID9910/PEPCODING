class Solution {
    //function bna lo
    private boolean isSelfDividingInteger(int num){
        int n=num;
        while(n>0){
            int rem =n%10;//last rem nikalo
                        
        n=n/10;
            if(rem == 0 || num%rem !=0){  //aagr rem zero mtlb zero hai akri main //and
                                          //num divide ho rha hai but zzero nhi aarha
                                         //mltb self dividing nhi hai to false return kardo
                return false;
            }
            
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isSelfDividingInteger(i)==true){ //bss aagar true aagay mtlb self dividing hai
                result.add(i);
            }
        }
        return result;
    }
}