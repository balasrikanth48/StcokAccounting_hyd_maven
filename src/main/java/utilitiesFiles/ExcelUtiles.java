package utilitiesFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtiles {
Workbook wb;
	
	
	public ExcelUtiles() throws Exception
	{
	FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\TestInput\\InputSheet.xlsx");
	wb=new XSSFWorkbook(fi);
	}
	public int getrowcount(String Sname)
	{
		 return wb.getSheet(Sname).getLastRowNum();
		
	}
	public  int getcolcount(String Sname)
	{
		 return wb.getSheet(Sname).getRow(0).getLastCellNum();
	}
	@SuppressWarnings("deprecation")
	public String  getData(String Sname,int row,int coloumn)
	{
		String data="";
		
		if (wb.getSheet(Sname).getRow(row).getCell(coloumn).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int) wb.getSheet(Sname).getRow(row).getCell(coloumn).getNumericCellValue();
			data=String.valueOf(celldata);
		}else
		{
			data=wb.getSheet(Sname).getRow(row).getCell(coloumn).getStringCellValue();
			
		}return data;
	
	}
	public void SetCellData(String Sname,int row,int coloumn,String Status) throws Exception
	{
		Cell cell  =wb.getSheet(Sname).getRow(row).getCell(coloumn);
		cell.setCellValue(Status);
		if (Status.equalsIgnoreCase("PASS"))
		{
			
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			
		}else if (Status.equalsIgnoreCase("fail"))
		{
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			
		}else if  (Status.equalsIgnoreCase("NotExcuted"))
        {
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
		}
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestOutput\\OutputSheet.xlsx");
		wb.write(fo);
		fo.close();
		
	}
	
	
	
}
