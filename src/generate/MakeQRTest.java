package generate;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class MakeQRTest {

	
	@Test
	public void shouldReturnBufferedImageType() {
		assertEquals(BufferedImage.class, MakeQR.MakeQRCode("http://www.google.co.uk", false, 150, 150).getClass());
	}

}
