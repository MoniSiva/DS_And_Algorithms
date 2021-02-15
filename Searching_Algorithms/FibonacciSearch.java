import java.util.Scanner;

public class FibonacciSearch {
	
	public static int min(int x, int y) {
        return (x <= y) ? x : y;
    }
 
    public static int fibonacciSearch(int arr[], int x,int n)   {
        int fibMMm2 = 0; 
        int fibMMm1 = 1; 
        int fibM = fibMMm2 + fibMMm1; 

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }
 
        int offset = -1; 
        while (fibM > 1) {
            int i = min(offset + fibMMm2, n - 1); 
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
             } 
             else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
             } 
             else
                return i;
        }
 
        if (fibMMm1 == 1 && arr[n-1] == x)
            return n-1;
 
        return -1;
    }

	public static void main(String[] args) {
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
		int position = fibonacciSearch(arr, ele,len); 
  
		if(position > 0) 
			System.out.println("Element is present in " +(position+1) +"th position");
		else
			System.out.println("Element is not found in the array");
		scan.close(); 

	}

}
