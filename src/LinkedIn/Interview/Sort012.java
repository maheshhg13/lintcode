package LinkedIn.Interview;

public class Sort012 {
	public static void sort012(int[] arr){
		int lo=0;
		int high=arr.length-1;
		int mid=0;
		while(mid<=high){
			if(arr[mid]==0){
				swap(arr, lo, mid);
				lo++;
				mid++;
			}else if(arr[mid]==1){
				mid++;
			}else{
				swap(arr, mid, high);
				high--;
			}
		}
	}
	public static void swap(int[] arr, int i, int j){
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] temp = {1,0,0,2,2,2,1,1,0,0};
		Sort012.sort012(temp);
		for(int x:temp){
			System.out.print(x+" ");
		}
	}
}
