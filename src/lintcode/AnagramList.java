package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an array of strings, return all groups of strings that are anagrams.
//
//		 Notice
//
//		All inputs will be in lower-case
//
//		Have you met this question in a real interview? Yes
//		Example
//		Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
//
//		Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
//
//		Challenge 
//		What is Anagram?
//		- Two strings are anagram if they can be the same after change the order of characters.


		
public class AnagramList {
	
	private String sortString(String input){
		char[] temp = input.toCharArray();
		Arrays.sort(temp);
		return Arrays.toString(temp);
		
	}
	public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();
        for(String s:strs){
        	String sorted = sortString(s);
        	if(!map.containsKey(sorted)){
        		map.put(sorted, new ArrayList<String>());
        	}
        	map.get(sorted).add(s);
        }
        for(List<String> l : map.values()){
        	result.addAll(l);
        }
        return result;
    }

}
