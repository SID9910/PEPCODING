class Solution {
    final String[] codes ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

              List<String> res=new ArrayList<>();
        if(digits.length()==0)
            return res;
       return findComb(digits);

    }
    public List<String> findComb(String digits)
    {
                if(digits.length()==0){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch =digits.charAt(0);
        String ros =digits.substring(1);
        List<String> ans =findComb(ros);
        List<String> man = new ArrayList<>();
        String codesfor =codes[ch-'0'];
        for(int i=0;i<codesfor.length();i++){
            char chode =codesfor.charAt(i);
            for(String val:ans){
            man.add(chode + val);
            }
        }
       
        return man;
    }
}