class Solution {
    public int reachNumber(int target) {
        int x =0;
        target =Math.abs(target);//target negative bhi hi sakta hai
        while(true){
            int range =x*(x+1)/2; //range main aaega answer tabhi

            //jaise he range main milla target then break and return target
            if(range>= target && range%2 == target%2){
                break;
            }
            x++;
        }
        return x;//moves
    }
}