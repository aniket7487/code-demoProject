import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchNumberIndex {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Number of Elelment in Array: ");
		int sizearr=Integer.parseInt(br.readLine());
		
		System.out.println(sizearr);
		System.out.println("Enter Number : ");
		int num=Integer.parseInt(br.readLine());
		System.out.println("Enter Number in Array : ");
		int arr []=new int[sizearr];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]== num) {
				System.out.println("index"+i);
				break;
			}
		}
	}

}
