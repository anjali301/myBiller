package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static com.example.myapplication.R.layout.final_last_pdf;


public class PdfDatabase extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(final_last_pdf);
        try {
            createPdf();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPdf() throws FileNotFoundException {
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "myPDF.pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer); //writer
        Document document = new Document(pdfDocument);  // pdfDocumenty

        float[] columnWidth = {112, 112, 120, 104, 112};
        Table table = new Table(columnWidth);


        // Row 01
        table.addCell(new Cell(1,2).add(new Paragraph("Sarvoday").setFontSize(20f).setBold().setFontColor(new DeviceRgb(66, 133, 244))).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        // Row 02
        table.addCell(new Cell().add(new Paragraph("123 street\nIndia\n421312\n")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("123\nsarv@email.com\nsarvwebsite.com\n")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        // Row 03
        table.addCell(new Cell().add(new Paragraph("\n")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        Text textBilledTo = new Text("BILLED TO \n");
        textBilledTo.setBold();
        textBilledTo.setFontColor(new DeviceRgb(18,192,33));

        Paragraph paragraphBilledTo = new Paragraph();
        paragraphBilledTo.add(textBilledTo);
        paragraphBilledTo.add("Rahul\n" +
                "Street address\n" +
                "Thane, India\n" +
                "ZIP Code\n");
        // Row 04
        table.addCell(new Cell().add(paragraphBilledTo).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        // Row 05
        table.addCell(new Cell(2,1).add(new Paragraph("INVOICE").setBold().setFontSize(24).setFontColor(new DeviceRgb(18,192,33))).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("\n")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        // Row 06

        table.addCell(new Cell().add(new Paragraph("Item Name").setFontColor(ColorConstants.WHITE)).setBackgroundColor(new DeviceRgb(66,133,244)));
        table.addCell(new Cell().add(new Paragraph("Price per Item").setFontColor(ColorConstants.WHITE)).setBackgroundColor(new DeviceRgb(66,133,244)));
        table.addCell(new Cell().add(new Paragraph("QTY").setFontColor(ColorConstants.WHITE)).setBackgroundColor(new DeviceRgb(66,133,244)));
        table.addCell(new Cell().add(new Paragraph("Total AMOUNT").setFontColor(ColorConstants.WHITE)).setBackgroundColor(new DeviceRgb(66,133,244)));

        // Row 07
        Text textInvoiceNumber = new Text("INVOICE NUMBER\n");
        textInvoiceNumber.setBold().setFontColor(new DeviceRgb(18,192,33));
        Paragraph paragraphInvoiceNumber = new Paragraph();
        paragraphInvoiceNumber.add(textInvoiceNumber);
        paragraphInvoiceNumber.add("00001");

        table.addCell(new Cell(2,1).add(paragraphInvoiceNumber).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("item1")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        // Row 08

        table.addCell(new Cell().add(new Paragraph("item2")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));

        // Row 09
        Text textDateOfIssue = new Text("DATE OF ISSUE\n");
        textDateOfIssue.setBold().setFontColor(new DeviceRgb(18,192,33));
        Paragraph paragraphDateOfIssue = new Paragraph();
        paragraphDateOfIssue.add(textDateOfIssue);
        paragraphDateOfIssue.add("07/03/2021");

        table.addCell(new Cell(2,1).add(paragraphDateOfIssue).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("item3")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));

        // Row 10

        table.addCell(new Cell().add(new Paragraph("item4")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(new DeviceRgb(220, 220, 220)));
        table.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(new DeviceRgb(220, 220, 220)));

        // Row 11
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));

        // Row 12
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("SUBTOTAL").setFontColor(new DeviceRgb(18,192,33))));
        table.addCell(new Cell().add(new Paragraph("400")));

        // Row 13
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("DISCOUNT").setFontColor(new DeviceRgb(18,192,33))));
        table.addCell(new Cell().add(new Paragraph("0")));

        // Row 14
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("(TAX RATE)").setFontColor(new DeviceRgb(18,192,33))));
        table.addCell(new Cell().add(new Paragraph("10%")));

        // Row 15
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("TAX").setFontColor(new DeviceRgb(18,192,33))));
        table.addCell(new Cell().add(new Paragraph("40")));

        // Row 16
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell(1,2).add(new Paragraph("==================").setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));

        // Row 17
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        Text textInvoiceTotal = new Text("INVOICE TOTAL\n");
        textInvoiceTotal.setFontColor(new DeviceRgb(66,133,244)).setFontSize(16);
        Paragraph paragraphInvoiceTotal = new Paragraph();
        paragraphInvoiceTotal.add(textInvoiceTotal);
        paragraphInvoiceTotal.add("440");


        table.addCell(new Cell(1,2).add(paragraphInvoiceTotal).setTextAlignment(TextAlignment.CENTER));


        // Row 18
        table.addCell(new Cell(1,2).add(new Paragraph("TERMS\n" +
                "E.g. Please pay invoice by 10/03/2021\n")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));



        document.add(table);

        document.add(new Paragraph("\n\n\n\n\n(Authorised Signatory)"));

        document.close();

    }
    public void genPDF(View view) {
        Toast.makeText(this, "Pdf Created", Toast.LENGTH_LONG).show();
    }
    private PdfWriter getWriter(PdfWriter writer) {
        return writer;
    }

}












