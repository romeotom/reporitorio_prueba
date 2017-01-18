package ec.gob.educacion.activos.resources;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.gob.educacion.acceso.dto.ReporteGeneralDTO;

public class JavaPoiUtils{


    /**
     * Método que genera un archivo excel con los valores de los indicadores y los guarda en un directorio específico. 
     * @param indicadores
     * @return true o false
     */
    @SuppressWarnings("deprecation")
	public boolean generarExcelConsolidado(List<ReporteGeneralDTO> reporte) {
        boolean generacionCorrecta = false;
        try {

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(Constantes.NOMBRE_HOJA_CALCULO_REPORTE);
            CreationHelper createHelper = wb.getCreationHelper();

            CellStyle estilo = wb.createCellStyle();
            XSSFFont letra = wb.createFont();
            letra.setFontHeightInPoints((short) 20);
            letra.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            letra.setColor(IndexedColors.BLACK.getIndex());
            estilo.setFont(letra);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(createHelper.createDataFormat()
                    .getFormat("dd/MM/yyy"));

            cellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
            cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
            

            XSSFFont font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setColor(IndexedColors.BLACK.getIndex());
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);

            CellStyle cellStyleData = wb.createCellStyle();
            cellStyleData.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyleData.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyleData.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderRight(CellStyle.BORDER_THIN);
            cellStyleData.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderTop(CellStyle.BORDER_THIN);
            cellStyleData.setTopBorderColor(HSSFColor.BLACK.index);
            
            CellStyle backgroundIE = wb.createCellStyle();
            backgroundIE.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            backgroundIE.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundIE.setFont(font);
            
            CellStyle backgroundTH = wb.createCellStyle();
            backgroundTH.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            backgroundTH.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundTH.setFont(font);
            
            
            CellStyle backgroundLAB = wb.createCellStyle();
            backgroundLAB.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
            backgroundLAB.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundLAB.setFont(font);
            

            XSSFRow row = sheet.createRow(1);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
            XSSFCell cellTitleIE = row.createCell(0);
            cellTitleIE.setCellStyle(backgroundIE);
            cellTitleIE.setCellValue("INSTITUCIÓN");
            CellUtil.setAlignment(cellTitleIE, wb, CellStyle.ALIGN_CENTER);
            
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 18));
            XSSFCell cellTitleTH = row.createCell(10);
            cellTitleTH.setCellStyle(backgroundTH);
            cellTitleTH.setCellValue("RESPONSABLES");
            CellUtil.setAlignment(cellTitleTH, wb, CellStyle.ALIGN_CENTER);
            
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 19, 34));
            XSSFCell cellTitleLAB = row.createCell(19);
            cellTitleLAB.setCellStyle(backgroundLAB);
            cellTitleLAB.setCellValue("LABORATORIOS DE INFORMÁTICA");
            CellUtil.setAlignment(cellTitleLAB, wb, CellStyle.ALIGN_CENTER);
            
            
            row = sheet.createRow(2);

            XSSFCell cell1 = row.createCell(0);
            cell1.setCellStyle(cellStyle);
            cell1.setCellValue("AMIE");

            XSSFCell cell2 = row.createCell(1);
            cell2.setCellStyle(cellStyle);
            cell2.setCellValue("FECHA DE REGISTRO DE FORMULARIO");

            XSSFCell cell3 = row.createCell(2);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue("NOMBRE DE INSTITUCIÓN EDUCATIVA");

            XSSFCell cell4 = row.createCell(3);
            cell4.setCellStyle(cellStyle);
            cell4.setCellValue("ZONA");

            XSSFCell cell5 = row.createCell((4));
            cell5.setCellStyle(cellStyle);
            cell5.setCellValue("DISTRITO");

            XSSFCell cell6 = row.createCell(5);
            cell6.setCellStyle(cellStyle);
            cell6.setCellValue("PROVINCIA");

            XSSFCell cell7 = row.createCell(6);
            cell7.setCellStyle(cellStyle);
            cell7.setCellValue("CANTÓN");

            XSSFCell cell8 = row.createCell(7);
            cell8.setCellStyle(cellStyle);
            cell8.setCellValue("PARROQUIA");

            XSSFCell cell9 = row.createCell(8);
            cell9.setCellStyle(cellStyle);
            cell9.setCellValue("URBANO / RURAL");

            XSSFCell cell10 = row.createCell(9);
            cell10.setCellStyle(cellStyle);
            cell10.setCellValue("ESTADO INSTITUCIÓN");
            
            XSSFCell cell11 = row.createCell(10);
            cell11.setCellStyle(cellStyle);
            cell11.setCellValue("NOMBRES Y APELLIDOS TÉCNICO MINEDUC");

            XSSFCell cell12 = row.createCell(11);
            cell12.setCellStyle(cellStyle);
            cell12.setCellValue("CORREO ELECTRÓNICO TÉCNICO MINEDUC");

            XSSFCell cell13 = row.createCell(12);
            cell13.setCellStyle(cellStyle);
            cell13.setCellValue("CONTACTOS TÉCNICO MINEDUC");

            XSSFCell cell14 = row.createCell(13);
            cell14.setCellStyle(cellStyle);
            cell14.setCellValue("NOMBRES Y APELLIDOS REPRESENTANTE LEGAL");

            XSSFCell cell15 = row.createCell(14);
            cell15.setCellStyle(cellStyle);
            cell15.setCellValue("CORREO ELECTRÓNICO REPRESENTANTE LEGAL");

            XSSFCell cell16 = row.createCell(15);
            cell16.setCellStyle(cellStyle);
            cell16.setCellValue("CONTACTOS REPRESENTANTE LEGAL");

            XSSFCell cell17 = row.createCell(16);
            cell17.setCellStyle(cellStyle);
            cell17.setCellValue("NOMBRES Y APELLIDOS DOCENTE DE INFORMÁTICA DE LA IE");

            XSSFCell cell18 = row.createCell(17);
            cell18.setCellStyle(cellStyle);
            cell18.setCellValue("CORREO ELECTRÓNICO DOCENTE DE INFORMÁTICA DE LA IE");

            XSSFCell cell19 = row.createCell(18);
            cell19.setCellStyle(cellStyle);
            cell19.setCellValue("CONTACTOS DOCENTE DE INFORMÁTICA DE LA IE");

            XSSFCell cell20 = row.createCell(19);
            cell20.setCellStyle(cellStyle);
            cell20.setCellValue("ESTADO FORMULARIO");

            XSSFCell cell21 = row.createCell(20);
            cell21.setCellStyle(cellStyle);
            cell21.setCellValue("NOMBRE LABORATORIO / SALA / BIBLIOTECA / ÁREA ADMINISTRATIVA");

            XSSFCell cell22 = row.createCell(21);
            cell22.setCellStyle(cellStyle);
            cell22.setCellValue("EN USO");

            XSSFCell cell23 = row.createCell(22);
            cell23.setCellStyle(cellStyle);
            cell23.setCellValue("PRESENTA INTERNET");

            XSSFCell cell24 = row.createCell(23);
            cell24.setCellStyle(cellStyle);
            cell24.setCellValue("VELOCIDAD NAVEGACIÓN (Mbps)");
            
            XSSFCell cell25 = row.createCell(24);
            cell25.setCellStyle(cellStyle);
            cell25.setCellValue("SERIAL");
                        
            XSSFCell cell26 = row.createCell(25);
            cell26.setCellStyle(cellStyle);
            cell26.setCellValue("MARCA - MODELO");

            XSSFCell cell27 = row.createCell(26);
            cell27.setCellStyle(cellStyle);
            cell27.setCellValue("TIPO ACTIVO");

            XSSFCell cell28 = row.createCell(27);
            cell28.setCellStyle(cellStyle);
            cell28.setCellValue("VELOCIDAD PROCESADOR (Ghz)");

            XSSFCell cell29 = row.createCell(28);
            cell29.setCellStyle(cellStyle);
            cell29.setCellValue("MEMORIA RAM (Gb)");

            XSSFCell cell30 = row.createCell(29);
            cell30.setCellStyle(cellStyle);
            cell30.setCellValue("CAPACIDAD DE DISCO (Gb)");
            
            XSSFCell cell31 = row.createCell(30);
            cell31.setCellStyle(cellStyle);
            cell31.setCellValue("TIENE DOBLE BOOTEO");
            
            XSSFCell cell32 = row.createCell(31);
            cell32.setCellStyle(cellStyle);
            cell32.setCellValue("SISTEMA OPERATIVO PRINCIPAL");
            
            XSSFCell cell33 = row.createCell(32);
            cell33.setCellStyle(cellStyle);
            cell33.setCellValue("SISTEMA OPERATIVO SECUNDARIO");
            
            XSSFCell cell34 = row.createCell(33);
            cell34.setCellStyle(cellStyle);
            cell34.setCellValue("PROCEDENCIA ACTIVO");
            
            XSSFCell cell35 = row.createCell(34);
            cell35.setCellStyle(cellStyle);
            cell35.setCellValue("ESTADO ACTIVO");
            

            int cont = 3;
            for (ReporteGeneralDTO objeto : reporte) {
            	
                row = sheet.createRow(cont);

                cell1 = row.createCell(0);
                cell1.setCellStyle(cellStyleData);
                cell1.setCellValue(objeto.getAmie());

                cell2 = row.createCell(1);
                cell2.setCellStyle(cellStyleData);
                cell2.setCellValue(Utils.dateToString(objeto.getFechaCarga(), "dd/MM/yyyy HH:mm:ss"));

                cell3 = row.createCell(2);
                cell3.setCellStyle(cellStyleData);
                cell3.setCellValue(objeto.getNombreInstitucion());

                cell4 = row.createCell(3);
                cell4.setCellStyle(cellStyleData);
                cell4.setCellValue(objeto.getZona());

                cell5 = row.createCell((4));
                cell5.setCellStyle(cellStyleData);
                cell5.setCellValue(objeto.getDistrito());

                cell6 = row.createCell(5);
                cell6.setCellStyle(cellStyleData);
                cell6.setCellValue(objeto.getProvincia());

                cell7 = row.createCell(6);
                cell7.setCellStyle(cellStyleData);
                cell7.setCellValue(objeto.getCanton());

                cell8 = row.createCell(7);
                cell8.setCellStyle(cellStyleData);
                cell8.setCellValue(objeto.getParroquia());

                cell9 = row.createCell(8);
                cell9.setCellStyle(cellStyleData);
                cell9.setCellValue(objeto.getUrbano());

                cell10 = row.createCell(9);
                cell10.setCellStyle(cellStyleData);
                cell10.setCellValue(objeto.getEstadoIE());
                
                cell11 = row.createCell(10);
                cell11.setCellStyle(cellStyleData);
                cell11.setCellValue(objeto.getNombresTecnicoMinEduc());

                cell12 = row.createCell(11);
                cell12.setCellStyle(cellStyleData);
                cell12.setCellValue(objeto.getMailTecnicoMinEduc());

                cell13 = row.createCell(12);
                cell13.setCellStyle(cellStyleData);
                cell13.setCellValue(objeto.getContactosTecnicoMinEduc());

                cell14 = row.createCell(13);
                cell14.setCellStyle(cellStyleData);
                cell14.setCellValue(objeto.getNombresResponsableIe());

                cell15 = row.createCell(14);
                cell15.setCellStyle(cellStyleData);
                cell15.setCellValue(objeto.getMailResponsableIe());

                cell16 = row.createCell(15);
                cell16.setCellStyle(cellStyleData);
                cell16.setCellValue(objeto.getContactosResponsableIe());

                cell17 = row.createCell(16);
                cell17.setCellStyle(cellStyleData);
                cell17.setCellValue(objeto.getNombresDocenteIe());

                cell18 = row.createCell(17);
                cell18.setCellStyle(cellStyleData);
                cell18.setCellValue(objeto.getMailDocenteIe());

                cell19 = row.createCell(18);
                cell19.setCellStyle(cellStyleData);
                cell19.setCellValue(objeto.getContactosDocenteIe());
                
                cell20 = row.createCell(19);
                cell20.setCellStyle(cellStyleData);
                cell20.setCellValue(objeto.getEstadoFormulario());

                cell21 = row.createCell(20);
                cell21.setCellStyle(cellStyleData);
                cell21.setCellValue(objeto.getNombreLaboratorio());

                cell22 = row.createCell(21);
                cell22.setCellStyle(cellStyleData);
                cell22.setCellValue(objeto.getEstadoLabTI());

                cell23 = row.createCell(22);
                cell23.setCellStyle(cellStyleData);
                cell23.setCellValue(objeto.getTieneInternetLabTI());

                cell24 = row.createCell(23);
                cell24.setCellStyle(cellStyleData);
                cell24.setCellValue(
                		((objeto.getVelocidadInternetLabTI() != null)?objeto.getVelocidadInternetLabTI().toString():"")
                		);
                
                cell25 = row.createCell(24);
                cell25.setCellStyle(cellStyleData);
                cell25.setCellValue(
                		((objeto.getSerial() != null)?objeto.getSerial():"")
                		);

                cell26 = row.createCell(25);
                cell26.setCellStyle(cellStyleData);
                cell26.setCellValue(
                		((objeto.getMarcaModelo() != null)?objeto.getMarcaModelo():"")
                		);

                cell27 = row.createCell(26);
                cell27.setCellStyle(cellStyleData);
                cell27.setCellValue(
                		((objeto.getNombreActivo() != null)?objeto.getNombreActivo():"")
                		);

                cell28 = row.createCell(27);
                cell28.setCellStyle(cellStyleData);
                cell28.setCellValue(
                		((objeto.getVelocidadProcesador() != null)?objeto.getVelocidadProcesador().toString():"")
                		);

                cell29 = row.createCell(28);
                cell29.setCellStyle(cellStyleData);
                cell29.setCellValue(
                		((objeto.getMemoria() != null)?objeto.getMemoria().toString():"")
                		);

                cell30 = row.createCell(29);
                cell30.setCellStyle(cellStyleData);
                cell30.setCellValue(
                		((objeto.getDiscoDuro() != null)?objeto.getDiscoDuro().toString():"")
                		);

                cell31 = row.createCell(30);
                cell31.setCellStyle(cellStyleData);
                cell31.setCellValue(objeto.getDobleBooteo());
                
                cell32 = row.createCell(31);
                cell32.setCellStyle(cellStyleData);
                cell32.setCellValue(objeto.getSoPrincipal());
                
                cell33 = row.createCell(32);
                cell33.setCellStyle(cellStyleData);
                cell33.setCellValue(objeto.getSoSecundario());
                
                cell34 = row.createCell(33);
                cell34.setCellStyle(cellStyleData);
                cell34.setCellValue(objeto.getProcedenciaActivo());
                
                cell35 = row.createCell(34);
                cell35.setCellStyle(cellStyleData);
                cell35.setCellValue(objeto.getEstadoActivo());
                

                cont++;

            }

            for (int i = 0; i < 36; i++) {
                sheet.setColumnWidth(i, 6000);//.autoSizeColumn((short) i);
            }
    		 
    		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    	    Date fecha = new Date();
    	    String nombreArchivoConsolidado = Constantes.NOMBRE_ARCHIVO_REPORTE + formato.format(fecha) + ".xlsx";
            downloadInBrowser(wb, nombreArchivoConsolidado);  
            generacionCorrecta = true;
        } catch (Exception e) {           
            e.printStackTrace();
        }
        
        return generacionCorrecta;
    }
    
    @SuppressWarnings({ "deprecation" })
	public boolean generarExcelTotales(List<ReporteGeneralDTO> reporte) {
        boolean generacionCorrecta = false;
        try {

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(Constantes.NOMBRE_HOJA_CALCULO_REPORTE);
            CreationHelper createHelper = wb.getCreationHelper();

            CellStyle estilo = wb.createCellStyle();
            XSSFFont letra = wb.createFont();
            letra.setFontHeightInPoints((short) 20);
            letra.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            letra.setColor(IndexedColors.BLACK.getIndex());
            estilo.setFont(letra);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(createHelper.createDataFormat()
                    .getFormat("dd/MM/yyy"));

            cellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
            cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
            

            XSSFFont font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setColor(IndexedColors.BLACK.getIndex());
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);

            CellStyle cellStyleData = wb.createCellStyle();
            cellStyleData.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyleData.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyleData.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderRight(CellStyle.BORDER_THIN);
            cellStyleData.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderTop(CellStyle.BORDER_THIN);
            cellStyleData.setTopBorderColor(HSSFColor.BLACK.index);
            
            CellStyle backgroundIE = wb.createCellStyle();
            backgroundIE.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            backgroundIE.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundIE.setFont(font);
            
            CellStyle backgroundTH = wb.createCellStyle();
            backgroundTH.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            backgroundTH.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundTH.setFont(font);
            
            
            CellStyle backgroundLAB = wb.createCellStyle();
            backgroundLAB.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
            backgroundLAB.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundLAB.setFont(font);
            

            XSSFRow row = sheet.createRow(1);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
            XSSFCell cellTitleIE = row.createCell(0);
            cellTitleIE.setCellStyle(backgroundIE);
            cellTitleIE.setCellValue("INSTITUCIÓN");
            CellUtil.setAlignment(cellTitleIE, wb, CellStyle.ALIGN_CENTER);
            
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 28));
            XSSFCell cellTitleLAB = row.createCell(10);
            cellTitleLAB.setCellStyle(backgroundLAB);
            cellTitleLAB.setCellValue("TOTALES DE ACTIVOS (COMPUTADORES E IMPRESORAS)");
            CellUtil.setAlignment(cellTitleLAB, wb, CellStyle.ALIGN_CENTER);
            
            
            row = sheet.createRow(2);

            XSSFCell cell1 = row.createCell(0);
            cell1.setCellStyle(cellStyle);
            cell1.setCellValue("AMIE");

            XSSFCell cell2 = row.createCell(1);
            cell2.setCellStyle(cellStyle);
            cell2.setCellValue("FECHA DE REGISTRO DE FORMULARIO");

            XSSFCell cell3 = row.createCell(2);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue("NOMBRE DE INSTITUCIÓN EDUCATIVA");

            XSSFCell cell4 = row.createCell(3);
            cell4.setCellStyle(cellStyle);
            cell4.setCellValue("ZONA");

            XSSFCell cell5 = row.createCell((4));
            cell5.setCellStyle(cellStyle);
            cell5.setCellValue("DISTRITO");

            XSSFCell cell6 = row.createCell(5);
            cell6.setCellStyle(cellStyle);
            cell6.setCellValue("PROVINCIA");

            XSSFCell cell7 = row.createCell(6);
            cell7.setCellStyle(cellStyle);
            cell7.setCellValue("CANTÓN");

            XSSFCell cell8 = row.createCell(7);
            cell8.setCellStyle(cellStyle);
            cell8.setCellValue("PARROQUIA");

            XSSFCell cell9 = row.createCell(8);
            cell9.setCellStyle(cellStyle);
            cell9.setCellValue("URBANO / RURAL");

            XSSFCell cell10 = row.createCell(9);
            cell10.setCellStyle(cellStyle);
            cell10.setCellValue("ESTADO INSTITUCIÓN");
            
            XSSFCell cell11 = row.createCell(10);
            cell11.setCellStyle(cellStyle);
            cell11.setCellValue("TOTALES LABORATORIOS TI");

            XSSFCell cell12 = row.createCell(11);
            cell12.setCellStyle(cellStyle);
            cell12.setCellValue("TOTAL COMPUTADORES TI");

            XSSFCell cell13 = row.createCell(12);
            cell13.setCellStyle(cellStyle);
            cell13.setCellValue("TOTAL COMPUTADORES TI (FUNCIONALES / POR REPARAR)");

            XSSFCell cell14 = row.createCell(13);
            cell14.setCellStyle(cellStyle);
            cell14.setCellValue("TOTAL COMPUTADORES TI OBSOLETOS");

            XSSFCell cell15 = row.createCell(14);
            cell15.setCellStyle(cellStyle);
            cell15.setCellValue("TOTAL IMPRESORAS TI");
            
            XSSFCell cell16 = row.createCell(15);
            cell16.setCellStyle(cellStyle);
            cell16.setCellValue("TOTAL IMPRESORAS TI (FUNCIONALES / POR REPARAR)");
                        
            XSSFCell cell17 = row.createCell(16);
            cell17.setCellStyle(cellStyle);
            cell17.setCellValue("TOTAL IMPRESORAS TI OBSOLETAS");

            XSSFCell cell18 = row.createCell(17);
            cell18.setCellStyle(cellStyle);
            cell18.setCellValue("TOTAL COMPUTADORES ADMINISTRATIVO");

            XSSFCell cell19 = row.createCell(18);
            cell19.setCellStyle(cellStyle);
            cell19.setCellValue("TOTAL COMPUTADORES (FUNCIONALES / POR REPARAR) ADMINISTRATIVO");

            XSSFCell cell20 = row.createCell(19);
            cell20.setCellStyle(cellStyle);
            cell20.setCellValue("TOTAL COMPUTADORES OBSOLETOS ADMINISTRATIVO");

            XSSFCell cell21 = row.createCell(20);
            cell21.setCellStyle(cellStyle);
            cell21.setCellValue("TOTAL IMPRESORAS ADMINISTRATIVO");
            
            XSSFCell cell22 = row.createCell(21);
            cell22.setCellStyle(cellStyle);
            cell22.setCellValue("TOTAL IMPRESORAS (FUNCIONALES / POR REPARAR) ADMINISTRATIVO");
            
            XSSFCell cell23 = row.createCell(22);
            cell23.setCellStyle(cellStyle);
            cell23.setCellValue("TOTAL IMPRESORAS OBSOLETAS ADMINISTRATIVO");
            
            XSSFCell cell24 = row.createCell(23);
            cell24.setCellStyle(cellStyle);
            cell24.setCellValue("TOTAL COMPUTADORES OTRAS ÁREAS");
            
            XSSFCell cell25 = row.createCell(24);
            cell25.setCellStyle(cellStyle);
            cell25.setCellValue("TOTAL COMPUTADORES (FUNCIONALES / POR REPARAR) OTRAS ÁREAS");
            
            XSSFCell cell26 = row.createCell(25);
            cell26.setCellStyle(cellStyle);
            cell26.setCellValue("TOTAL COMPUTADORES OBSOLETOS OTRAS ÁREAS");
            
            XSSFCell cell27 = row.createCell(26);
            cell27.setCellStyle(cellStyle);
            cell27.setCellValue("TOTAL IMPRESORAS OTRAS ÁREAS");
            
            XSSFCell cell28 = row.createCell(27);
            cell28.setCellStyle(cellStyle);
            cell28.setCellValue("TOTAL IMPRESORAS (FUNCIONALES / POR REPARAR) OTRAS ÁREAS");
            
            XSSFCell cell29 = row.createCell(28);
            cell29.setCellStyle(cellStyle);
            cell29.setCellValue("TOTAL IMPRESORAS OBSOLETAS OTRAS ÁREAS");

            int cont = 3;
            for (ReporteGeneralDTO objeto : reporte) {
            	
                row = sheet.createRow(cont);

                cell1 = row.createCell(0);
                cell1.setCellStyle(cellStyleData);
                cell1.setCellValue(objeto.getAmie());

                cell2 = row.createCell(1);
                cell2.setCellStyle(cellStyleData);
                cell2.setCellValue(Utils.dateToString(objeto.getFechaCarga(), "dd/MM/yyyy HH:mm:ss"));

                cell3 = row.createCell(2);
                cell3.setCellStyle(cellStyleData);
                cell3.setCellValue(objeto.getNombreInstitucion());

                cell4 = row.createCell(3);
                cell4.setCellStyle(cellStyleData);
                cell4.setCellValue(objeto.getZona());

                cell5 = row.createCell((4));
                cell5.setCellStyle(cellStyleData);
                cell5.setCellValue(objeto.getDistrito());

                cell6 = row.createCell(5);
                cell6.setCellStyle(cellStyleData);
                cell6.setCellValue(objeto.getProvincia());

                cell7 = row.createCell(6);
                cell7.setCellStyle(cellStyleData);
                cell7.setCellValue(objeto.getCanton());

                cell8 = row.createCell(7);
                cell8.setCellStyle(cellStyleData);
                cell8.setCellValue(objeto.getParroquia());

                cell9 = row.createCell(8);
                cell9.setCellStyle(cellStyleData);
                cell9.setCellValue(objeto.getUrbano());

                cell10 = row.createCell(9);
                cell10.setCellStyle(cellStyleData);
                cell10.setCellValue(objeto.getEstadoIE());
                
                cell11 = row.createCell(10);
                cell11.setCellStyle(cellStyleData);
                cell11.setCellValue(objeto.getTotalLaboratoriosTi());

                cell12 = row.createCell(11);
                cell12.setCellStyle(cellStyleData);
                cell12.setCellValue(objeto.getTotalComputadoresTi());

                cell13 = row.createCell(12);
                cell13.setCellStyle(cellStyleData);
                cell13.setCellValue(objeto.getTotalComputadoresEnUsoTi());

                cell14 = row.createCell(13);
                cell14.setCellStyle(cellStyleData);
                cell14.setCellValue(objeto.getTotalComputadoresObsoletasTi());

                cell15 = row.createCell(14);
                cell15.setCellStyle(cellStyleData);
                cell15.setCellValue(objeto.getTotalImpresorasTi());
                
                cell16 = row.createCell(15);
                cell16.setCellStyle(cellStyleData);
                cell16.setCellValue(objeto.getTotalImpresorasEnUsoTi());

                cell17 = row.createCell(16);
                cell17.setCellStyle(cellStyleData);
                cell17.setCellValue(objeto.getTotalImpresorasObsoletasTi());

                cell18 = row.createCell(17);
                cell18.setCellStyle(cellStyleData);
                cell18.setCellValue(objeto.getTotalComputadoresAdmin());

                cell19 = row.createCell(18);
                cell19.setCellStyle(cellStyleData);
                cell19.setCellValue(objeto.getTotalComputadoresEnUsoAdmin());

                cell20 = row.createCell(19);
                cell20.setCellStyle(cellStyleData);
                cell20.setCellValue(objeto.getTotalComputadoresObsoletasAdmin());

                cell21 = row.createCell(20);
                cell21.setCellStyle(cellStyleData);
                cell21.setCellValue(objeto.getTotalImpresorasAdmin());

                cell22 = row.createCell(21);
                cell22.setCellStyle(cellStyleData);
                cell22.setCellValue(objeto.getTotalImpresorasEnUsoAdmin());
                
                cell23 = row.createCell(22);
                cell23.setCellStyle(cellStyleData);
                cell23.setCellValue(objeto.getTotalImpresorasObsoletasAdmin());
                
                cell24 = row.createCell(23);
                cell24.setCellStyle(cellStyleData);
                cell24.setCellValue(objeto.getTotalComputadoresVarios());
                
                cell25 = row.createCell(24);
                cell25.setCellStyle(cellStyleData);
                cell25.setCellValue(objeto.getTotalComputadoresEnUsoVarios());
                
                cell26 = row.createCell(25);
                cell26.setCellStyle(cellStyleData);
                cell26.setCellValue(objeto.getTotalComputadoresObsoletasVarios());
                
                cell27 = row.createCell(26);
                cell27.setCellStyle(cellStyleData);
                cell27.setCellValue(objeto.getTotalImpresorasVarios());
                
                cell28 = row.createCell(27);
                cell28.setCellStyle(cellStyleData);
                cell28.setCellValue(objeto.getTotalImpresorasEnUsoVarios());
                
                cell29 = row.createCell(28);
                cell29.setCellStyle(cellStyleData);
                cell29.setCellValue(objeto.getTotalImpresorasObsoletasVarios());
                

                cont++;

            }

            for (int i = 0; i < 39; i++) {
                sheet.setColumnWidth(i, 6000);//.autoSizeColumn((short) i);
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = new Date();
            String nombreArchivoConsolidado = Constantes.NOMBRE_ARCHIVO_REPORTE + "Totales-" + formato.format(fecha) + ".xlsx";
            downloadInBrowser(wb, nombreArchivoConsolidado);
			generacionCorrecta = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return generacionCorrecta;
    }
    
    @SuppressWarnings("deprecation")
	public boolean generarExcelCargaInstituciones(List<ReporteGeneralDTO> reporte, String tipoConsulta) {
        boolean generacionCorrecta = false;
        try {

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(Constantes.NOMBRE_HOJA_CALCULO_REPORTE);
            CreationHelper createHelper = wb.getCreationHelper();

            CellStyle estilo = wb.createCellStyle();
            XSSFFont letra = wb.createFont();
            letra.setFontHeightInPoints((short) 20);
            letra.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            letra.setColor(IndexedColors.BLACK.getIndex());
            estilo.setFont(letra);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(createHelper.createDataFormat()
                    .getFormat("dd/MM/yyy"));

            cellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
            cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
            

            XSSFFont font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setColor(IndexedColors.BLACK.getIndex());
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);

            CellStyle cellStyleData = wb.createCellStyle();
            cellStyleData.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyleData.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyleData.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderRight(CellStyle.BORDER_THIN);
            cellStyleData.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBorderTop(CellStyle.BORDER_THIN);
            cellStyleData.setTopBorderColor(HSSFColor.BLACK.index);
            
            CellStyle backgroundIE = wb.createCellStyle();
            backgroundIE.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            backgroundIE.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundIE.setFont(font);
            
            CellStyle backgroundTH = wb.createCellStyle();
            backgroundTH.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            backgroundTH.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundTH.setFont(font);
            
            
            CellStyle backgroundLAB = wb.createCellStyle();
            backgroundLAB.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
            backgroundLAB.setFillPattern(CellStyle.SOLID_FOREGROUND);
            backgroundLAB.setFont(font);
            

            XSSFRow row = sheet.createRow(1);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
            XSSFCell cellTitleIE = row.createCell(0);
            cellTitleIE.setCellStyle(backgroundIE);
            cellTitleIE.setCellValue("INSTITUCIÓN");
            CellUtil.setAlignment(cellTitleIE, wb, CellStyle.ALIGN_CENTER);
            
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 18));
            XSSFCell cellTitleTH = row.createCell(10);
            cellTitleTH.setCellStyle(backgroundTH);
            cellTitleTH.setCellValue("RESPONSABLES");
            CellUtil.setAlignment(cellTitleTH, wb, CellStyle.ALIGN_CENTER);
            
            
            row = sheet.createRow(2);

            XSSFCell cell1 = row.createCell(0);
            cell1.setCellStyle(cellStyle);
            cell1.setCellValue("AMIE");

            XSSFCell cell2 = row.createCell(1);
            cell2.setCellStyle(cellStyle);
            cell2.setCellValue("ÚLTIMA FECHA DE CARGA");

            XSSFCell cell3 = row.createCell(2);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue("NOMBRE DE INSTITUCIÓN EDUCATIVA");

            XSSFCell cell4 = row.createCell(3);
            cell4.setCellStyle(cellStyle);
            cell4.setCellValue("ZONA");

            XSSFCell cell5 = row.createCell((4));
            cell5.setCellStyle(cellStyle);
            cell5.setCellValue("DISTRITO");

            XSSFCell cell6 = row.createCell(5);
            cell6.setCellStyle(cellStyle);
            cell6.setCellValue("PROVINCIA");

            XSSFCell cell7 = row.createCell(6);
            cell7.setCellStyle(cellStyle);
            cell7.setCellValue("CANTÓN");

            XSSFCell cell8 = row.createCell(7);
            cell8.setCellStyle(cellStyle);
            cell8.setCellValue("PARROQUIA");

            XSSFCell cell9 = row.createCell(8);
            cell9.setCellStyle(cellStyle);
            cell9.setCellValue("URBANO / RURAL");

            XSSFCell cell10 = row.createCell(9);
            cell10.setCellStyle(cellStyle);
            cell10.setCellValue("ESTADO INSTITUCIÓN");
            
            XSSFCell cell11 = row.createCell(10);
            cell11.setCellStyle(cellStyle);
            cell11.setCellValue("NOMBRES Y APELLIDOS TÉCNICO MINEDUC");

            XSSFCell cell12 = row.createCell(11);
            cell12.setCellStyle(cellStyle);
            cell12.setCellValue("CORREO ELECTRÓNICO TÉCNICO MINEDUC");

            XSSFCell cell13 = row.createCell(12);
            cell13.setCellStyle(cellStyle);
            cell13.setCellValue("CONTACTOS TÉCNICO MINEDUC");

            XSSFCell cell14 = row.createCell(13);
            cell14.setCellStyle(cellStyle);
            cell14.setCellValue("NOMBRES Y APELLIDOS REPRESENTANTE LEGAL");

            XSSFCell cell15 = row.createCell(14);
            cell15.setCellStyle(cellStyle);
            cell15.setCellValue("CORREO ELECTRÓNICO REPRESENTANTE LEGAL");

            XSSFCell cell16 = row.createCell(15);
            cell16.setCellStyle(cellStyle);
            cell16.setCellValue("CONTACTOS REPRESENTANTE LEGAL");

            XSSFCell cell17 = row.createCell(16);
            cell17.setCellStyle(cellStyle);
            cell17.setCellValue("NOMBRES Y APELLIDOS DOCENTE DE INFORMÁTICA DE LA IE");

            XSSFCell cell18 = row.createCell(17);
            cell18.setCellStyle(cellStyle);
            cell18.setCellValue("CORREO ELECTRÓNICO DOCENTE DE INFORMÁTICA DE LA IE");

            XSSFCell cell19 = row.createCell(18);
            cell19.setCellStyle(cellStyle);
            cell19.setCellValue("CONTACTOS DOCENTE DE INFORMÁTICA DE LA IE");

            int cont = 3;
            for (ReporteGeneralDTO objeto : reporte) {
            	
                row = sheet.createRow(cont);

                cell1 = row.createCell(0);
                cell1.setCellStyle(cellStyleData);
                cell1.setCellValue(objeto.getAmie());

                cell2 = row.createCell(1);
                cell2.setCellStyle(cellStyleData);
                cell2.setCellValue(Utils.dateToString(objeto.getFechaCarga(), "dd/MM/yyyy HH:mm:ss"));

                cell3 = row.createCell(2);
                cell3.setCellStyle(cellStyleData);
                cell3.setCellValue(objeto.getNombreInstitucion());

                cell4 = row.createCell(3);
                cell4.setCellStyle(cellStyleData);
                cell4.setCellValue(objeto.getZona());

                cell5 = row.createCell((4));
                cell5.setCellStyle(cellStyleData);
                cell5.setCellValue(objeto.getDistrito());

                cell6 = row.createCell(5);
                cell6.setCellStyle(cellStyleData);
                cell6.setCellValue(objeto.getProvincia());

                cell7 = row.createCell(6);
                cell7.setCellStyle(cellStyleData);
                cell7.setCellValue(objeto.getCanton());

                cell8 = row.createCell(7);
                cell8.setCellStyle(cellStyleData);
                cell8.setCellValue(objeto.getParroquia());

                cell9 = row.createCell(8);
                cell9.setCellStyle(cellStyleData);
                cell9.setCellValue(objeto.getUrbano());

                cell10 = row.createCell(9);
                cell10.setCellStyle(cellStyleData);
                cell10.setCellValue(objeto.getEstadoIE());
                
                cell11 = row.createCell(10);
                cell11.setCellStyle(cellStyleData);
                cell11.setCellValue(objeto.getNombresTecnicoMinEduc());

                cell12 = row.createCell(11);
                cell12.setCellStyle(cellStyleData);
                cell12.setCellValue(objeto.getMailTecnicoMinEduc());

                cell13 = row.createCell(12);
                cell13.setCellStyle(cellStyleData);
                cell13.setCellValue(objeto.getContactosTecnicoMinEduc());

                cell14 = row.createCell(13);
                cell14.setCellStyle(cellStyleData);
                cell14.setCellValue(objeto.getNombresResponsableIe());

                cell15 = row.createCell(14);
                cell15.setCellStyle(cellStyleData);
                cell15.setCellValue(objeto.getMailResponsableIe());

                cell16 = row.createCell(15);
                cell16.setCellStyle(cellStyleData);
                cell16.setCellValue(objeto.getContactosResponsableIe());

                cell17 = row.createCell(16);
                cell17.setCellStyle(cellStyleData);
                cell17.setCellValue(objeto.getNombresDocenteIe());

                cell18 = row.createCell(17);
                cell18.setCellStyle(cellStyleData);
                cell18.setCellValue(objeto.getMailDocenteIe());

                cell19 = row.createCell(18);
                cell19.setCellStyle(cellStyleData);
                cell19.setCellValue(objeto.getContactosDocenteIe());
                
                cont++;

            }

            for (int i = 0; i < 39; i++) {
                sheet.setColumnWidth(i, 6000);//.autoSizeColumn((short) i);
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = new Date();
            String nombreArchivoConsolidado = Constantes.NOMBRE_ARCHIVO_REPORTE + tipoConsulta +"-" + formato.format(fecha) + ".xlsx";
            downloadInBrowser(wb, nombreArchivoConsolidado);
			generacionCorrecta = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return generacionCorrecta;
    }
    
    private void downloadInBrowser(XSSFWorkbook wb, String nombreArchivo){
		
    	try {
    		FacesContext facesContext = FacesContext.getCurrentInstance();
    		HttpServletResponse response = (HttpServletResponse) facesContext
    				.getExternalContext().getResponse();
            
            OutputStream responseStream = response.getOutputStream();

    		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    		response.setHeader("Content-Disposition", "inline; filename="+nombreArchivo);
    		response.setHeader("Cache-Control", "no-cache");
    		response.setHeader("Pragma", "no-cache");
    		response.setDateHeader("Expires", 0);
    		wb.write(responseStream);
    		response.flushBuffer();
    		responseStream.close();
    		facesContext.responseComplete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
		
    }
}
