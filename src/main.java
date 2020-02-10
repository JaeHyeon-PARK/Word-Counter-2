import java.io.*;
import java.util.*;

public class main{
	public static void main(String args[]) {
		HashMap<String, Integer> wList = new HashMap<String, Integer>(); // �ܾ�� Ƚ���� HashMap�� ����
		StringTokenizer stok; // Line �������� �ܾ� ������ ���� ����
		String word;
		try {
			BufferedReader bReader = new BufferedReader(new FileReader("HW1.txt")); // Line ������ ������ ���� "BufferedReader" ���
			FileWriter writer = new FileWriter("Result.txt"); // ����� ����
			
			String str;
			
			while((str = bReader.readLine())!=null) { // Line ������ ����
				if(!str.equals("")) { // ������ Line�� ������ �ƴ� ���
					stok = new StringTokenizer(str);
					while(stok.hasMoreTokens()) { // StringTokenizer�� ���� �ܾ� ����� ���ÿ� �ҹ��ڷ� ����
						word = stok.nextToken().toLowerCase();
						if(wList.containsKey(word)) // ������ Key���� ������ Value�� 1�� ���� ���� ����
							wList.put(word, wList.get(word) + 1);
						else // ������ Value�� 1�� �� ���� ����
							wList.put(word, 1);
					}
				}
			}
			Iterator<String> it = wList.keySet().iterator(); // ������ ���� Key���� ������ keySet()�� iterator()�� ���
			
			while(it.hasNext()) { // Key���� Value���� ���� �� Result.txt�� ����
				String w = it.next();
				int count = wList.get(w);
				
				writer.write(w + ": " + count + "��\r\n");
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