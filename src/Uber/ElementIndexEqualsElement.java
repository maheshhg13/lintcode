package Uber;

public class ElementIndexEqualsElement {
	public int find(int[] arr){
		if(arr==null || arr.length==0){
			return -1;
		}
		int lo=0;
		int high = arr.length-1;
		while(lo<=high){
			int mid = lo+(high-lo)/2;
			if(arr[mid]==mid){
				return mid;
			}else if(mid>arr[mid]){
				lo=mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] temp = {-10, -5, 3, 4, 7, 9};
		System.out.println(new ElementIndexEqualsElement().find(temp));
	}

}
