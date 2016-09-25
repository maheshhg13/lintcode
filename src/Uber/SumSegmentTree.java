package Uber;

public class SumSegmentTree {
	int[] tree;
	int n;
	public SumSegmentTree(int[] nums){
		if(nums.length>0){
			n = nums.length;
			tree = new int[n*2];
			buildRec(nums, 1, 0, n-1);
			System.out.println("After Build: ");
			print();
		}
	}
	public void buildRec(int[] nums, int node, int l, int h){
		if(l==h){
			tree[node] = nums[l];
		}else{
			int mid = l + (h-l)/2;
			buildRec(nums, node*2, l, mid);
			buildRec(nums, 1+node*2, mid+1, h);
			tree[node] = tree[node*2] + tree[1+node*2];
		}
	}
	
	public void updateRec(int pos, int val){
		updt(1, 0, n-1, pos, val);
	}
	
	private void updt(int node, int l, int h, int pos, int val){
		if(l==h){
			tree[node] = val;
		}
		int mid = l+(h-l)/2;
		if(pos>mid){
			updt(1+node*2, mid+1, h, pos, val);
		}else{
			updt(2*node, l, mid, pos, val);
		}
		tree[node] = tree[node*2] + tree[1+node*2];
	}
	
	public int sumRangeRec(int i, int j){
		return sumRec(1, 0, n-1, i, j);
	}
	
	private int sumRec(int node, int l, int h, int i, int j){
		if(l>j || h<i){
			return 0;
		}
		if(i<=l && j>=h){
			return tree[node];
		}
		int mid = l+(h-l)/2;
		return sumRec(2*node, l, mid, i, j)+sumRec(2*node+1, mid+1, h, i, j);
		
	}
	
	private void build(int[] nums) {
		for(int i=n,j=0;i<n*2;i++,j++){
			tree[i]=nums[j];
		}
		for(int i=n-1;i>0;i--){
			tree[i] = tree[i*2]+tree[i*2+1];
		}
	}
	
	public int sumRange(int i, int j){
		int sum = 0;
		i+=n;
		j+=n;
		while(i<=j){
			if((i%2)==1){
				sum+=tree[i];
				i++;
			}
			if((j%2)==0){
				sum+=tree[j];
				j--;
			}
			i/=2;
			j/=2;
		}
		return sum;
	}
	
	public boolean update(int pos, int val){
		if(pos+1>=n){
			return false;
		}
		pos+=n;
		tree[pos] = val;
		while(pos>0){
			int l = pos;
			int r = pos;
			if(pos%2==0){
				r = pos+1;
			}else{
				l = pos-1;
			}
			pos=pos/2;
			tree[pos] = tree[l]+tree[r];
		}
		System.out.println("After update: ");
		print();
		return true;
	}
	
	private void print(){
		for(int i=0;i<tree.length;i++){
			System.out.print(tree[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] nums=new int[]{1,2,3, 4, 5};
		SumSegmentTree tre = new SumSegmentTree(nums);
		//tre.update(3, 6);
		System.out.println(tre.sumRangeRec(2, 4));
		//nums=new int[]{1,2,7, 4, 5};
		//new SumSegmentTree(nums);
	}
}
