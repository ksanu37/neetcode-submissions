class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        if(s.equals(t))
            return s;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            if(i<t.length()) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0) + 1);
            }
            
        }

        int left = 0;
        String res = "";
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right<s.length(); right++) {
            // System.out.printf("CHECKING %s AND %s%n", left, right);
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0) + 1);
            while(AreMapsEqual(sMap, tMap)) {
                if(minLength > right-left) {
                    res = s.substring(left, right+1);
                    minLength = right-left;
                }
                // System.out.printf("Found %s AND %s%n", left, right);
                sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }
        }
        return res;
    }

    public boolean AreMapsEqual(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        for(Map.Entry<Character, Integer> entry: tMap.entrySet()) {
            if(sMap.get(entry.getKey()) == null)
                return false;
            if(sMap.get(entry.getKey()) < tMap.get(entry.getKey()))
                return false;
        }
        // System.out.println("EQUAL MAPS %n");

        return true;
    }
}
