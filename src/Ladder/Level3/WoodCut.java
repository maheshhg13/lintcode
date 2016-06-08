package Ladder.Level3;

import java.util.Arrays;

public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if(L==null || L.length==0){
            return 0;
        }
        int len = 0;
        Arrays.sort(L);
        int start = 1;
        int end = L[L.length-1];
        
        while(start<=end){
            int mid = start + (end - start)/2;
            if(pieces(L, mid)<k){
                end = mid-1;
            }else{
                len = mid;
                start = mid+1;
            }
        }
        return len;
    }
    private int pieces(int[] L, int len){
        int temp = 0;
        for(int x:L){
            temp+=x/len;
        }
        return temp;
    }
}