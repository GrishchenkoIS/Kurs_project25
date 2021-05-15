package kurs25;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestToChange {
	static boolean status = false;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws IOException {

		write("pasword","123");

	}

	public static void write(String fileName, String text) {
		//Определяем файл
		File file = new File(fileName);
	
		try {
			//проверяем, что если файл не существует то создаем его
			if(!file.exists()){
				file.createNewFile();
			}
	
		//PrintWriter обеспечит возможности записи в файл
			FileWriter out = new FileWriter(file.getAbsoluteFile(), false);
	
		try {
			//Записываем текст у файл
			out.write(text);
		} finally {
			//После чего мы должны закрыть файл
			//Иначе файл не запишется
			out.close();
		}
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String word;
		word = br.readLine();
		if (word.equals("123")) {
			status = true;
			assertTrue(status);
		}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
