package hw01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1244_스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   public static void main(String[] args) throws IOException {

	      int switchSize = Integer.parseInt(br.readLine());
	      String[] input = br.readLine().split(" ");
	      boolean[] switchArray = new boolean[switchSize + 1];

	      for (int i = 1; i <= switchSize; i++) {
	         switchArray[i] = Integer.parseInt(input[i - 1]) != 0;
	      }

	      int studentSize = Integer.parseInt((br.readLine()));

	      for (int i = 0; i < studentSize; i++) {
	         String[] info = br.readLine().split(" ");
	         int sex = Integer.parseInt(info[0]);
	         int number = Integer.parseInt(info[1]);

	         switch (sex) {
	            case 1:
	               for (int j = number; j < switchArray.length; j += number) {
	                  switchArray[j] = !switchArray[j];
	               }
	               break;
	            case 2:
	               int left = number - 1;
	               int right = number + 1;
	               while(true){
	                  if (left < 1 || right > switchArray.length - 1) {
	                     break;
	                  }
	                  if ((switchArray[left] ^ switchArray[right])) {
	                     break;
	                  } else {
	                     switchArray[left] = !switchArray[left--];
	                     switchArray[right] = !switchArray[right++];
	                  }
	               }
	               switchArray[number] = !switchArray[number];
	               break;
	         }
	      }
	      
	      StringBuilder stringBuilder = new StringBuilder();

	      for (int i = 1; i < switchArray.length; i++) {
	         stringBuilder.append(switchArray[i] ? "1" : "0");
	         stringBuilder.append(i % 20 == 0 ? "\n" : " ");
	      }
	      System.out.print(stringBuilder);
	   }


}
