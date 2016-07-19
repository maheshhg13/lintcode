package extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    Map<Integer, List<String>> digitMap = new HashMap<Integer, List<String>>();
    LetterCombinations() {
        digitMap.put(2, Arrays.asList(new String[] {"a", "b", "c"}));
        digitMap.put(3, Arrays.asList(new String[] {"d", "e", "f"}));
        digitMap.put(4, Arrays.asList(new String[] {"g", "h", "i"}));
        digitMap.put(5, Arrays.asList(new String[] {"j", "k", "l"}));
        digitMap.put(6, Arrays.asList(new String[] {"m", "n", "o"}));
        digitMap.put(7, Arrays.asList(new String[] {"p", "q", "r", "s"}));
        digitMap.put(8, Arrays.asList(new String[] {"t", "u", "v"}));
        digitMap.put(9, Arrays.asList(new String[] {"w", "x", "y", "z"}));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits==null || digits.length()==0){
            return ret;
        }
        if(digits.length()==1){
            return digitMap.get(digits.charAt(0)-'0');
        }
        char[] temp = new char[digits.length()];
        helper(digits, digitMap, temp, 0, ret);
        return ret;
    }
    private void helper(String digits, Map<Integer, List<String>> digitMap, char[] temp, int pos, List<String> ret){
        if(pos==digits.length()){
            ret.add(new String(temp));
            return;
        }
        int curr = digits.charAt(pos)-'0';
        List<String> neighbours = digitMap.get(curr);
        
        for(String chr:neighbours){
           temp[pos] = chr.charAt(0);
           helper(digits, digitMap, temp, pos+1, ret);
        }
    }
}
