package day01.recursive;

public class R0_ArrayShift {
	
	static int arr1[] = {1, 2, 3, 4};
	static int arr2[] = {1, 2, 3, 4};
	static int temp = -1;
	
	private static void rightShift() {
		
		temp = arr1[arr1.length -1];
		for(int i = arr1.length -1; i > 0; i--) {
			arr1[i] = arr1[i - 1];
		}
		arr1[0] = temp;
		
		System.out.print("right shift : ");
		for (int j = 0; j < arr1.length; j++) {
			System.out.print(arr1[j] + " ");
		}
	}
	
	private static void leftShift() {
		temp = arr2[0];
		for (int i = 1; i < arr2.length; i++) {
			arr2[i - 1] = arr2[i];
		}
		arr2[arr2.length -1] = temp;
		
		System.out.print("left shift : ");
		for (int j = 0; j < arr2.length; j++) {
			System.out.print(arr2[j] + " ");
		}
	}
	

	public static void main(String[] args) {
		rightShift();
		System.out.println();
		leftShift();
	}

}
