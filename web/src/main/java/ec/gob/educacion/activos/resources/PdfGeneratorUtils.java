package ec.gob.educacion.activos.resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfGeneratorUtils {

	/**
	 * Método que permite generar un documento en pdf con itex, se envía el texto o el html como string y se genera un pdf
	 * @param text
	 * @param amieIE
	 */
	public void generateDocumentItextBrowser(String text, String amieIE) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();		
		String fileName = "Formulario_activos_"+amieIE+".pdf";

		try {
			//se crea el documento con el tipo de hoja y sus margenes
			Document document = new Document(PageSize.A4,50, 50, 143, 72);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);
			writeInDocument(text, document, pdfWriter);
			byte[] pdfBytes = byteArrayOutputStream.toByteArray();
			showInBrowser(pdfBytes, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void writeInDocument(String text, Document document, PdfWriter pdfWriter){
		Rectangle rect = new Rectangle(30, 50, 517, 800);
		pdfWriter.setBoxSize("art", rect);
		EventBackground event = new EventBackground();
		pdfWriter.setPageEvent(event);
		document.open();
		document.addAuthor("MINEDUC");
		document.addCreationDate();
		XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
		try {
			worker.parseXHtml(pdfWriter, document, new StringReader(text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}

	
	private void showInBrowser(byte[] data, String nombreArchivo) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext
				.getExternalContext().getResponse();
		try {
			OutputStream responseStream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentLength(data.length);
			responseStream.write(data);
			response.flushBuffer();
			responseStream.close();
		} catch (IOException e) {
			
		}
		facesContext.responseComplete();
	}

}
