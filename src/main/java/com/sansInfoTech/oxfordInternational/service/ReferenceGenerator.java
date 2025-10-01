package com.sansInfoTech.oxfordInternational.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

@Service
public class ReferenceGenerator {

	public byte[] generateRegistrationReceipt(StudentRegistration studentRegistration) throws FileNotFoundException, MalformedURLException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String studentName = studentRegistration.getStudent().getFirstName() + " " + studentRegistration.getStudent().getLastName();
		String fatherName = studentRegistration.getStudent().getParent().getFatherFirstName() + " " + studentRegistration.getStudent().getParent().getFatherLastName();
		String filePath = "src/main/resources/registrationReceipts" + studentRegistration.getRegistrationReference() + ".pdf";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' hh a");
        String testScheduledDate = studentRegistration.getTests().get(0).getTestScheduledOn().format(formatter);

		File file = new File(filePath);
		file.getParentFile().mkdirs();

		PdfWriter writer = new PdfWriter(outputStream);
		PdfDocument pdfDoc = new PdfDocument(writer);
		Document document = new Document(pdfDoc, PageSize.A4);
		document.setMargins(30, 30, 30, 30);

		// Border Box
//         document.add(new LineSeparator((ILineDrawer) new SolidBorder(1)));

		Image logo = new Image(ImageDataFactory.create("src/main/resources/assets/logo.png"));
		logo.setFixedPosition(0, 700);
		document.add(logo);

		// School Name
		Paragraph schoolName = new Paragraph("OXFORD INTERNATIONAL SCHOOL").setTextAlignment(TextAlignment.CENTER)
				.setBold().setFontSize(18);

		document.add(schoolName);

		Paragraph address = new Paragraph(
				"Sainik Road, Gorakh Chowk (Near S.S.B. Camp) Harpur, East Champaran\nBased on C.B.S.E. Syllabus   English Medium   Nur. to Vth\nCall : 8709292309")
				.setTextAlignment(TextAlignment.CENTER).setFontSize(10);
		address.setMarginLeft(10);
		document.add(address);

		// Table Layout for Photo Box and Fields
		float[] columnWidths = { 1, 1 };
		Table table = new Table(UnitValue.createPercentArray(columnWidths));
		table.setWidth(UnitValue.createPercentValue(100));

		// Left Column (Form Fields)
		Table left = new Table(1);
		left.setMarginTop(40);
		left.setWidth(UnitValue.createPercentValue(100));

//		left.addCell(getCell("SL. No.", 10, false));
		left.addCell(getCell(
				"Reg. No- " + studentRegistration.getRegistrationReference(),10, false));
		left.addCell(getCell(
				"Pupil's Name- " + studentName,
				10, false));
		left.addCell(getCell(
				"Father's Name- " + fatherName,
				10, false));
		left.addCell(getCell(
				"Entrance test scheduled to be held on- " + testScheduledDate, 10, false));

		table.addCell(new Cell().add(left).setBorder(Border.NO_BORDER));

		// Right Column (Photo Box)
		Cell photoCell = new Cell().setBorder(Border.NO_BORDER);
		photoCell.setHeight(110);
		photoCell.setWidth(UnitValue.createPercentValue(12));
		photoCell.setTextAlignment(TextAlignment.CENTER);
		photoCell.add(new Paragraph("Affix\nPassport\nsize Photo\nHere").setTextAlignment(TextAlignment.CENTER)
				.setFontSize(10).setItalic());
		photoCell.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
		table.addCell(photoCell);

		document.add(table);
		document.add(new Paragraph("\n"));

		// Signature Lines
		float[] sigCols = { 1, 1, 1 };
		Table sigTable = new Table(UnitValue.createPercentArray(sigCols));
		sigTable.setWidth(UnitValue.createPercentValue(100));

		sigTable.addCell(getSignatureCell("Examination Controller\nSignature"));
		sigTable.addCell(getSignatureCell("Office-Incharge\nSignature"));
		sigTable.addCell(getSignatureCell("Principal\nSignature and Stamp"));

		document.add(sigTable);

//         document.add(new LineSeparator((ILineDrawer) new SolidBorder(1)));

		document.close();
		System.out.println("PDF created: " + filePath);
		return outputStream.toByteArray();
	}

	private static Cell getCell(String text, float size, boolean bold) {
		Paragraph p = new Paragraph(text).setFontSize(size);
		if (bold)
			p.setBold();
		return new Cell().add(p).setBorder(Border.NO_BORDER);
	}

	private static Cell getSignatureCell(String text) {
		return new Cell().add(new Paragraph(text).setTextAlignment(TextAlignment.CENTER).setFontSize(10).setBold())
				.setBorder(Border.NO_BORDER).setPaddingTop(20);
	}
}