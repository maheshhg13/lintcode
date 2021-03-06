package Ladder.Level2;

import java.util.ArrayList;
//Have to do again...
public class ProductExcludingItself {
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<Long>();
         if (A==null || A.size()==0) return res;
         long[] lProduct = new long[A.size()];
         long[] rProduct = new long[A.size()];
         lProduct[0] = 1;
         for (int i=1; i<A.size(); i++) {
             lProduct[i] = lProduct[i-1]*A.get(i-1);
         }
         rProduct[A.size()-1] = 1;
         for (int j=A.size()-2; j>=0; j--) {
             rProduct[j] = rProduct[j+1]*A.get(j+1);
         }
         for (int k=0; k<A.size(); k++) {
             res.add(lProduct[k] * rProduct[k]);
         }
         return res;
    }
}
