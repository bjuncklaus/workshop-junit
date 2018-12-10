package br.com.workshop.exceptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

	@Test(expected = FileNotFoundException.class) 
	public void testReadFile() throws IOException {
		FileReader reader = new FileReader("test.txt");
		reader.read();
		reader.close();
	}

	@Test
	public void testReadFileWithTryCatch() { 
		try {
			FileReader reader = new FileReader("test.txt");
			reader.read();
			reader.close();
			fail("Expected an IOException to be thrown");
		} catch (IOException e) {
														//Essa mensagem depende do OS!
			assertThat(e.getMessage(), is("test.txt (O sistema não pode encontrar o arquivo especificado)"));
		}
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReadFileWithRules() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage(is("test.txt (O sistema não pode encontrar o arquivo especificado)"));
        FileReader reader = new FileReader("test.txt");
        reader.read();
        reader.close();
    }

}
