package LinkedIn.Interview;

public class FlowerBed {
	public boolean canPlace(int[] bed, int k){
		int count=0;
		
		for(int i=0;i<bed.length;i++){
			if(bed[i]==1){
				continue;
			}
			if(i==0){
				if(i+1<bed.length && bed[i+1]==0){
					++count;
					bed[i]=1;
				}
			}else if(bed[i-1]==0){
				if(i+1==bed.length || bed[i+1]==0){
					++count;
					bed[i]=1;
				}
			}
			if(count==k){
				return true;
			}
		}
		return false;
	}
}
