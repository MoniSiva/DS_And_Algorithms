import java.util.Scanner;

public class JumpSearch {

	public static int jumpSearch(int[] arr, int x) { 
        int n = arr.length; 
        int step = (int)Math.floor(Math.sqrt(n)); 
  
        // Finding the block where element is present (if it is present) 
        int prev = 0; 
        while (arr[Math.min(step, n)-1] < x) { 
            prev = step; 
            step += (int)Math.floor(Math.sqrt(n)); 
            if (prev >= n) 
                return -1; 
        } 
  
        // Doing a linear search for x in block beginning with prev. 
        while (arr[prev] < x) { 
            prev++; 
  
            // If we reached next block or end of array, element is not present. 
            if (prev == Math.min(step, n)) 
                return -1; 
        } 
  
        // If element is found 
        if (arr[prev] == x) 
            return prev; 
  
        return -1; 
    } 
  
    public static void main(String [ ] args)  { 
    	Scanner scan = new Scanner(System.in);
		System.out.println("Number of elements:");
		int len = scan.nextInt();
		System.out.println("Enter elements:");
		int arr[] = new int[len];
		for (int i = 0;i<len;i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Enter the element:");
		int ele = scan.nextInt();
		int position = jumpSearch(arr, ele); 
  
		if(position > 0) 
			System.out.println("Element is present in " +(position+1) +"th position");
		else
			System.out.println("Element is not found in the array");
		scan.close(); 
    } 

}
