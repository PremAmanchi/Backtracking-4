// tc : exponental
// sc : exponential
// problem link : https://leetcode.com/problems/brace-expansion/

class Solution {
    List<String> result = new ArrayList<>();

    public String[] expand(String s) {
        helper(s, 0, new StringBuilder());
        String[] res = result.toArray(new String[0]);
        Arrays.sort(res);
        return res;
    }

    private void helper(String s, int ind, StringBuilder sb ){
        //  base case 
        if(ind == s.length())
            result.add(sb.toString());
        // logic
        else if(s.charAt(ind) == '{'){
            int endInd = s.indexOf('}', ind);
            String[] letters = s.substring(ind+1, endInd).split(",");
            for(String letter : letters){
                StringBuilder curr = new StringBuilder(sb);
                helper(s, endInd+1, curr.append('}'));
            }
        }
        else 
            helper(s, ind+1, sb.append(s.charAt(ind)));
    }
}
