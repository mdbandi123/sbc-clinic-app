package org.acumen.training.codes.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;





@Service
public class PdfService {

    public byte[] generatePdf() {
        // Output stream to hold the PDF
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Create PDF writer and document
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Add content to the PDF
        document.add(new Paragraph("Hello, World!"));
        document.add(new Paragraph("This is a PDF generated with iText and Spring Boot."));

        // Close document
        document.close();

        // Return the PDF as a byte array
        return outputStream.toByteArray();
    }
}
