/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import domen.Porudzbenica;
import domen.StavkaPorudzbenice;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Pdf {
    
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    public void createPdfDocument(Porudzbenica p) throws FileNotFoundException, DocumentException{
        Document doc = new Document(); 
        PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("Porudzbenica"+p.getSifraPorudzbenice() + ".pdf"));

        doc.open();
        this.metadata(doc, p);
        this.sadrzaj(doc, p);
        doc.close();
        
    }
    
    
    public void metadata(Document document, Porudzbenica p){
        document.addTitle("Porudzbenica-" +p.getSifraPorudzbenice());
        document.addSubject("Porudzbenica-" +p.getSifraPorudzbenice());
        document.addAuthor(p.getMenadzer().toString());
        document.addCreator("admin@gmail.com");
    }
    
    public void sadrzaj(Document document, Porudzbenica p) throws DocumentException{
        Paragraph preface = new Paragraph();

        praznaLinija(preface, 1);

        preface.add(new Paragraph("Porudzbenica-" +p.getSifraPorudzbenice(), catFont));

        praznaLinija(preface, 1);
        
        preface.add(new Paragraph("Status", catFont));
        praznaLinija(preface, 1);
        
        preface.add(new Paragraph(p.getStatus(), smallBold));
        
        praznaLinija(preface, 1);
        
        preface.add(new Paragraph("Iznos porudzbenice: " + p.sracunajUkupno() ,smallBold));
        
        praznaLinija(preface, 1);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
        
        preface.add(new Paragraph("Vreme dogadjaja", smallBold));
        praznaLinija(preface, 1);
        preface.add(new Paragraph(sdf.format(p.getDatum()), redFont));
        
        document.add(preface);
        
        Paragraph paragraf = new Paragraph("Stavke porudzbenice", catFont);;
        
        praznaLinija(paragraf, 3);
        
        document.add(paragraf);        
        
        this.tabela(document, p);

    }
    
    public void tabela(Document document, Porudzbenica p) throws DocumentException{
        PdfPTable table = new PdfPTable(2);
        
        PdfPCell c1 = new PdfPCell(new Phrase("Proizvod"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        PdfPCell c2 = new PdfPCell(new Phrase("Kolicina"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c2);
        
        table.setHeaderRows(1);
        
        List<StavkaPorudzbenice> stavke = p.getStavke();
        
        
        for(StavkaPorudzbenice s : stavke){
            table.addCell(s.getProizvod().toString());
            table.addCell(s.getKolicina()+"");
        }
        
        document.add(table);
    }
    
    private static void praznaLinija(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}