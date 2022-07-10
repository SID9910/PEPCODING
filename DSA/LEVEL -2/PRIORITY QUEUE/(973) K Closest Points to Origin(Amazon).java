class Solution {            //again practice karo iski thoda difficult hsi
    public int[][] kClosest(int[][] points, int k) {
        //aaagr point nhi to null kardo
        //a
        if(points ==null){
            return null;
        }
        //priority queue main bss distance dalenge aaray main store kar kar
        //and min heap pq banaenge kyuki humme sabse pass vala chaheye
        //comparator ka use karenge kyuiki height ke base per difference karenge
        PriorityQueue<int[] > pq = new PriorityQueue<int[]>(new Comparator<int[]>()
        { //comparator ka kaam 
            //humme ye distance origin se karna hai 
            //calculate so euclidian ki help se nikal denge
            //sqt ki jagah p2-p1 karke compare karenge
            //given two points hai 
            //humme input main so indexing 0,1 karke use karenge
            //x ko 0 and uy
            public int compare(int [] p1, int[] p2){
                return (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]);//distance is se nikalenge
            }
             });       
        
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            //bss k taak he daalo 
            //baaki dalne ka faida nhi
            if(pq.size()>k){
                pq.remove();
            }
        }
        //reuslt main bss k taak chaheye
        int[][] result =new int[k][2];
        int i=0;
        //pq khali karo or print bss  
        while(pq.size()>0){
            result[i]=pq.remove();
            i++;
        }
        //bss result main vo closest value return kardo
        return result;
                                                           
                                                           
                                                           }
}