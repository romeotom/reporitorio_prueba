package ec.gob.educacion.activos.resources;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class EventBackground extends PdfPageEventHelper{

	public void onEndPage(PdfWriter writer,Document document) {		
		Image background;
		try {
			background = Image.getInstance(getClass().getResource(Constantes.PATH_IMG_BACKGROUND));
			float width = document.getPageSize().getWidth();
	        float height = document.getPageSize().getHeight();
	        try {
				writer.getDirectContentUnder()
				        .addImage(background, width, 0, 0, height, 0, 0);
				Rectangle rect = writer.getBoxSize("art");
				Integer number = writer.getPageNumber();				
		        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("- "+number.toString()+" -"), (document.getPageSize().getWidth()/2), rect.getBottom(), 0);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     
	}
}
