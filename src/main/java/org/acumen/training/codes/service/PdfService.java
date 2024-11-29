package org.acumen.training.codes.service;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.time.LocalDate;

import org.acumen.training.codes.model.MedicalCertificate;
import org.acumen.training.codes.model.Patient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

@Service
public class PdfService {

	public byte[] generatePdf(MedicalCertificate medicalCertificate, Patient patient) throws MalformedURLException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PdfWriter writer = new PdfWriter(outputStream);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		ClassPathResource imgFile = new ClassPathResource("assets/img/SB Clinic.png");

		try {
			Image image = new Image(ImageDataFactory.create(imgFile.getURL()));
			image.scaleToFit(200, 75);
			image.setRelativePosition(160, 0, 0, 0);
			document.add(image);

			Paragraph title = new Paragraph("Medical Certificate").setFontSize(18)
					.setTextAlignment(TextAlignment.CENTER);
			document.add(title);

			document.add(new Paragraph("\n\n"));

			Paragraph body = new Paragraph(
					"This is to certify that the patient, %s will be unfit for duty/school for %s days from %s because of %s"
							.formatted(patient.getName(), medicalCertificate.getDay(), medicalCertificate.getStartDate(), medicalCertificate.getReason()))
					.setTextAlignment(TextAlignment.LEFT);
			document.add(body);

			document.add(new Paragraph("Date: %s".formatted(LocalDate.now())).setTextAlignment(TextAlignment.LEFT));
			document.add(new Paragraph("Signature: ______________________").setTextAlignment(TextAlignment.LEFT));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

		document.close();

		return outputStream.toByteArray();
	}
}
