package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class readExcel {
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	Cell cell;
	String name, email, index;

	@SuppressWarnings("deprecation")
	@Test
	void readData() throws IOException {

		File src = new File("D:\\Automation\\excel\\input.xls");
		FileInputStream finput = new FileInputStream(src);
		workbook = new HSSFWorkbook(finput);
		sheet = workbook.getSheetAt(0);

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			cell = sheet.getRow(i).getCell(0); // read name data
			// cell.setCellType(CellType.STRING);
			name = cell.getStringCellValue();

			cell = sheet.getRow(i).getCell(1); // read email data
			// cell.setCellType(CellType.STRING);
			email = cell.getStringCellValue();

			cell = sheet.getRow(i).getCell(2); // read numeric data
			cell.setCellType(CellType.STRING);
			index = cell.getStringCellValue();

			Reporter.log(name + ", " + email + ", " + index);
		}

	}

}
