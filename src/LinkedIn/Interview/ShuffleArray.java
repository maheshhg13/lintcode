package LinkedIn.Interview;

import java.util.Random;

public class ShuffleArray {
	Random rand = new Random();
	public void shuffle(int[] arr){
		if(arr==null || arr.length==0){
			return;
		}
		for(int i=arr.length-1;i>0;i--){
			int index = rand.nextInt(i+1);
			System.out.println("Index: "+index);
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] temp = {1,4,5,2,3,0};
		new ShuffleArray().shuffle(temp);
		for(int x:temp){
			System.out.print(x+" ");
		}
	}
}
