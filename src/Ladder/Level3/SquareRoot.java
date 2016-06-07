package Ladder.Level3;

public class SquareRoot {
	public int sqrt(int x) {
        if(x<=0){
            return 0;
        }
        if(x==1)
            return x;
        
        long a = 0;
        long b=x;
        
         while(b>=a){
            long num = (a+b)/2;
            if(num*num>x){
                b=num-1;
            }
            else if(num*num<x){
                a=num+1;
            }
            else{
                return (int)num;
            }
           
        }
         return (int)b;
        
        
    }

}
