package Ladder.Level3;

public class FirstBadVersion {
	public int findFirstBadVersion(int n) {
        if(n<=1){
            return n;
        }
        
        int start=0;
        int end=n;
        while(end>=start){
            int mid = (start+end)/2;
            if(SVNRepo.isBadVersion(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end+1;
    }
}

class SVNRepo {

	public static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

}
