package kurs25;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCheck implements Check{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(IsDouble("5"));
	}
//класс проверяет строку на наличие только цифр, на цифровой тип Double
	@Override
    public boolean IsDouble(String d) {
        try {
            Double.parseDouble(d);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


	@Override
	public boolean isInteger(String d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Strahovka() {
		// TODO Auto-generated method stub
		return null;
	}


}
