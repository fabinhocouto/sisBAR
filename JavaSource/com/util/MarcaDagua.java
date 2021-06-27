package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class MarcaDagua {

	/*
	 * public static final String DEST =
	 * "D:/Contracheque - 06921069605 - mar_2020 - marca dagua.pdf"; public static
	 * final String DATA = "D:/aviso.pdf"; public static final Font FONT = new
	 * Font(); public static final Font BOLD = new Font(FontFamily.HELVETICA, 12,
	 * Font.BOLD);
	 * 
	 * public static void main(String[] args) throws IOException, DocumentException
	 * { File file = new File(DEST); file.getParentFile().mkdirs(); new
	 * MarcaDagua().createPdf(DEST); }
	 * 
	 * public class Watermark extends PdfPageEventHelper {
	 * 
	 * protected Phrase watermark = new Phrase("WATERMARK", new
	 * Font(FontFamily.HELVETICA, 60, Font.NORMAL, BaseColor.LIGHT_GRAY));
	 * 
	 * @Override public void onEndPage(PdfWriter writer, Document document) {
	 * PdfContentByte canvas = writer.getDirectContentUnder();
	 * ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421,
	 * 45); } }
	 * 
	 * public void createPdf(String dest) throws IOException, DocumentException {
	 * Document document = new Document(); PdfReader reader = new PdfReader(DATA);
	 * PdfCopy copy = new PdfCopy(document,new FileOutputStream(DEST));
	 * document.open(); copy.addPage( new Rectangle(50, 180, 70, 200), 0);
	 * copy.addAnnotation(PdfAnnotation.createFreeText(copy, new Rectangle(50, 180,
	 * 70, 200), dest, null)); //copy.addDocument(reader);
	 * 
	 * 
	 * 
	 * PdfImportedPage page = copy.getImportedPage(reader, 1); PdfCopy.PageStamp ps
	 * = copy.createPageStamp(page); ps.addAnnotation(PdfAnnotation.createText(copy,
	 * new Rectangle(50, 180, 70, 200), "Hello", "No Thanks", true, "Comment"));
	 * PdfContentByte under = ps.getUnderContent(); //under.addImage(img);
	 * PdfContentByte over = ps.getOverContent(); over.beginText();
	 * //over.setFontAndSize(bf, 18); over.setTextMatrix(30, 30);
	 * //over.showText("total page " + totalPage); over.endText();
	 * ps.alterContents(); copy.addPage(page);
	 * 
	 * 
	 * //copy.setPageEvent(new Watermark()); //writer.setPageEvent(new Watermark());
	 * 
	 * 
	 * 
	 * PdfPTable table = new PdfPTable(3); table.setWidthPercentage(100);
	 * table.setWidths(new int[] { 4, 1, 3 }); BufferedReader br = new
	 * BufferedReader(new FileReader(DATA)); String line = br.readLine();
	 * process(table, line, BOLD); table.setHeaderRows(1); while ((line =
	 * br.readLine()) != null) { process(table, line, FONT); } br.close();
	 * document.add(table);
	 * 
	 * document.close(); }
	 * 
	 * public void process(PdfPTable table, String line, Font font) {
	 * StringTokenizer tokenizer = new StringTokenizer(line, ";"); int c = 0; while
	 * (tokenizer.hasMoreTokens() && c++ < 3) { table.addCell(new
	 * Phrase(tokenizer.nextToken(), font)); } }
	 */
}
