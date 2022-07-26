class Solution {
    public int maxDistToClosest(int[] seats) {
      int j=-1;//mtlb j isley le rahe hai taaki hum closest nikal sake
               // i and j ke bich ka
               //starting main j=-1 isley hoga kyuki pehle closest milne se pehle usse
               //-1 per per rakhenge baaki main jaab pehle closest mill jaega .taab us se badal                //denge
        int res =0; //isme jiska distance max hoga vo deenge
        for(int i=0;i<seats.length;i++){
            //jaise he seat milli pehli
            if(seats[i]==1){
                int ans =0;
                //iska mtlb aabhhi taak koi bhi closest nhi milla 
                //pehla closest milla then bss usse j main daal denge
                if(j<0){
                    ans =i;//pehle closest main j he hoga distance 
                    
                }else{//agar mill jao dusra bhi then
                    ans =(i-j)/2; //aab isme dono closest honge so mid nikal lenge uska
                    
                }
                res =Math.max(res,ans);//aab max dekhenge sabke bich ka 
                                        //jiska distance max hoga usse lenge
                j=i;//aab naya j purana i se aage ka dhundega distance ke ley
            }
        }
        int ans = seats.length-1-j;//ye isley akhri main 1 nhi milla then uska or 
                                   //us se pehle vale ka closest nikal kar max main compare kara
                                   //lenge
        res = Math.max(res,ans); //max aagya isme closest ka
        
        return res;
        
        
    }
}