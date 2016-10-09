package LinkedIn.Interview;

public class ValidStringTriangle {
	public int depth(String tree){
		int depth = -1;
		while(!tree.equals("0")){
			String temp = tree.replace("(00)", "0");
			if(temp.equals(tree)){
				return -1;
			}
			tree = temp;
			depth++;
		}
		return depth;
	}
	public static void main(String[] args) {
		System.out.println(new ValidStringTriangle().depth("((00)(0(0(00))))"));
	}
}
