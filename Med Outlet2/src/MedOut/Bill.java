package MedOut;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Bill {
	public static void main(JTable table,int total)
	{
		try {
		Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Bill.pdf"));
		//Image img = Image.getInstance("src/MedOut/drug_shop-512.png");
		Image img = Image.getInstance(ClassLoader.getSystemResource("MedOut/drug_shop-512.png"));
		document.open();
		img.scaleAbsolute(80, 80);
		img.setAlignment(Image.MIDDLE);
		document.add(img);
		String name="Example Medical Outlet";
		String add1="6/3, Shree Apartment Krishna Road Cross Basavanagudi";
		String add2="Bangaluru, Karnataka 560004";
		Connection dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
		PreparedStatement prep=dbc.prepareStatement("SELECT name,line1,line2 FROM settings");
		ResultSet rs=prep.executeQuery();
		while(rs.next())
		{
			name=rs.getString("name");
			add1=rs.getString("line1");
			add2=rs.getString("line2");
		}
		dbc.close();
		Paragraph t=new Paragraph(name,FontFactory.getFont(FontFactory.TIMES_BOLD,18));
		t.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(t);
		t=new Paragraph(add1,FontFactory.getFont(FontFactory.TIMES,15));
		t.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(t);
		t=new Paragraph(add2,FontFactory.getFont(FontFactory.TIMES,15));
		t.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(t);
		LocalDate date=LocalDate.now();
		t=new Paragraph("Date:"+date+"    ");
		t.setSpacingBefore(20f);
		t.setAlignment(Paragraph.ALIGN_RIGHT);
		document.add(t);
		t=new Paragraph("Seller:"+MainMenu.name+"   ");
		t.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(t);	
		PdfPTable ptable=new PdfPTable(3);
		ptable.setWidths(new int[] {200,50,50});
		ptable.setSpacingBefore(15f);
		Font fontH1 = new Font(FontFactory.getFont(FontFactory.TIMES_BOLD));
		ptable.addCell(new PdfPCell(new Phrase("Product",fontH1)));
		ptable.addCell(new PdfPCell(new Phrase("Quantity",fontH1)));
		ptable.addCell(new PdfPCell(new Phrase("Price",fontH1)));
		for (int rows = 0; rows < table.getRowCount(); rows++) {
            for (int cols = 0; cols < table.getColumnCount(); cols++) {
                ptable.addCell(table.getModel().getValueAt(rows, cols).toString());

            }
        }
		for(int i=1;i<=9;i++)
		{
			ptable.addCell(" ");
		}
		ptable.addCell("");
		ptable.addCell(new PdfPCell(new Phrase("Total",fontH1)));
		ptable.addCell(String.valueOf(total));
		document.add(ptable);
		document.close();
		Desktop.getDesktop().open(new File("Bill.pdf"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}

} 
