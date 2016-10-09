package LinkedIn.Interview;

public class MaximumElement {
	public static int maxElement(int[] arr){
		int candidate =0;
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(count==0){
				candidate = arr[i];
				count=1;
			}else if(arr[i]==candidate){
				count++;
			}else{
				count--;
			}
		}
		return candidate;
	}
	public static void main(String[] args) {
		int[] temp = {5,2,5,3,5,6,5};
		System.out.println(MaximumElement.maxElement(temp));
	}
}
