package src.co.edu.unbosque.test;

import java.util.Date;

import co.edu.unbosque.model.Toolkit;
import junit.framework.TestCase;

public class ToolkitTest extends TestCase{

	public void testCheckData() {
		assertTrue(Toolkit.checkData("Ejemplo"));
		assertFalse(Toolkit.checkData("Ejemplo1"));
	}
	public void testIsFullName() {
		assertTrue(Toolkit.isFullName("Nombre Apellido Apellido"));
		assertFalse(Toolkit.isFullName("Ejemplo"));
		assertFalse(Toolkit.isFullName("Nombre Nombre Apellido Apellido"));
	}
	public void testCheckNumber() {
		assertTrue(Toolkit.checkNumber("1234"));
		assertFalse(Toolkit.checkNumber("hola"));
	}
	/*
	public void testParseDateAsString() {
		String dateAsString = "29/11/2004";
		Date dateAsDate = new Date(2004, 11, 29);
		assertEquals("Debería retornar ", dateAsDate, Toolkit.parseDateAsString(dateAsString));
	}
	*/
}
