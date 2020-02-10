import java.io.*;
import java.util.*;

public class main{
	public static void main(String args[]) {
		HashMap<String, Integer> wList = new HashMap<String, Integer>(); // 단어와 횟수를 HashMap에 저장
		StringTokenizer stok; // Line 단위에서 단어 추출을 위해 선언
		String word;
		try {
			BufferedReader bReader = new BufferedReader(new FileReader("HW1.txt")); // Line 단위로 추출을 위해 "BufferedReader" 사용
			FileWriter writer = new FileWriter("Result.txt"); // 결과값 저장
			
			String str;
			
			while((str = bReader.readLine())!=null) { // Line 단위로 추출
				if(!str.equals("")) { // 추출한 Line이 공백이 아닐 경우
					stok = new StringTokenizer(str);
					while(stok.hasMoreTokens()) { // StringTokenizer를 통해 단어 추출과 동시에 소문자로 변경
						word = stok.nextToken().toLowerCase();
						if(wList.containsKey(word)) // 동일한 Key값이 있으면 Value에 1을 더해 새로 저장
							wList.put(word, wList.get(word) + 1);
						else // 없으면 Value를 1로 해 새로 저장
							wList.put(word, 1);
					}
				}
			}
			Iterator<String> it = wList.keySet().iterator(); // 정렬을 위해 Key값을 모으는 keySet()과 iterator()를 사용
			
			while(it.hasNext()) { // Key값과 Value값을 추출 해 Result.txt에 저장
				String w = it.next();
				int count = wList.get(w);
				
				writer.write(w + ": " + count + "번\r\n");
			}
			
			System.out.println("Finished!!! Check 'Result.txt' File");
			
			bReader.close();
			writer.close();
		}catch (FileNotFoundException fnfe) {
			System.out.println("No File");
		}catch (IOException ioe) {
			System.out.println("Can't Read File");
		}
	}
}