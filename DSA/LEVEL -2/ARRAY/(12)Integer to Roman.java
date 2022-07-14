class Solution {
    public String intToRoman(int num) {
        //SAARE COMBINATIONS
        //1000-M
        //900-CM //(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //500-D
        //400-CD//(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //100-C
        //90-XC//(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //50-L
        //40-XL//(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //10-X
        //9-IX//(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //5-V
        //4-IV//(EXTRA)YE CASE EXTRA ADD HAI STATEMENT MAIN DEA HUA HAI
        //1-I
        int[] arr ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            //aagr num bda ya value ke barabar taab kaam hoga
            while(num>=arr[i]){ 
                //obvious hai aagr ye loop chala to pehli value
                //1000 se badi hogi so index append kardo
                sb.append(code[i]);//string builder main string daali and
                num =num-arr[i]; //fhir vo number ko kum kar dea actual number se
                //so that hum age find out kare like ex-1024 =1000+10+10+4 aaise aage kaam kare 
            }
        }
        return sb.toString(); //isko string main karke return karo
    }
}