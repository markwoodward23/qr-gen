package generate;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * The <tt>MakeQR</tt> class provides the method to generate a QR code that points to a URL
 * <p>
 *
 * @author Mark Woodward
 * @version v1.1
 */
public class MakeQR {

	/** 
	 * <tt>MakeQRCode</tt> uses Google's ZXing and the QRGen library to create QR code images
	 * 	 
	 * @param qrUrl String: URL of intended target of QR Code
	 * @return BufferedImage the image containing QR code
	 */	
	public static BufferedImage MakeQRCode (String qrUrl, boolean alertOn, int xSize, int ySize)	{

		// Instantiate required variables
		byte[] QRbyByte = null;
		BufferedImage QRCodeReturn = null;

		// Create QR code of desired size
        ByteArrayOutputStream byteOutputStream = QRCode.from(qrUrl).withSize(xSize,ySize).to(ImageType.PNG).stream();
        try {
        	
        	// Convert output stream to byte array and close
			QRbyByte = byteOutputStream.toByteArray();
			byteOutputStream.close();
			
			// Convert byte array to Buffered Image
			InputStream byteInputStream = new ByteArrayInputStream(QRbyByte);
			QRCodeReturn = ImageIO.read(byteInputStream);

		// Catch exceptions 
		} catch (IOException e) {
			
			// Print error message and show alert
			e.printStackTrace();
			
			// Print error message if requried
			if (alertOn)	{
				Alert sourceFileAlert = new Alert(AlertType.ERROR);
				sourceFileAlert.setTitle("Error");
				sourceFileAlert.setContentText("Could not generate QRCode");
				sourceFileAlert.showAndWait();
			}
			
		}
        
        // Return buffered image 
        return QRCodeReturn;
    }
}
