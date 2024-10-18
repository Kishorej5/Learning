package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jobid {
	public static void main(String[] args) throws IOException {
		
		String location = "jobid";
		FileReader file = new FileReader(location);
		BufferedReader reader = new BufferedReader(file);
		
		List list = new ArrayList();
		
		String currentline;
		
		while ((currentline=reader.readLine()) != null) {
			list.add(currentline);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
