class Solution {

    public String encode(List<String> strs) {
        List<String> resultant = new ArrayList<>();
        if(strs.size()==0){
            return "[]";
        }
        for(String s : strs) {
            if(s.equals("")) {
                resultant.add("$");
            } else {
                resultant.add(s);
            }
        }

        return String.join("-", resultant);
    }

    public List<String> decode(String str) {
    
        List<String> res = new ArrayList<>();
          if(str.equals("[]")) {
            return res;
        }
        String[] strs = str.split("-");
        for(String s: strs) {
            if(s.equals("$")) {
                res.add("");
            } else {
                res.add(s);
            }
        }
        return res;
    }
}
