package list.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;

public class PoiWorkbook {

    String fileNameXlsx;
    String sheetName;
    Map<String, Object[]> header;
    Map<String, Object[]> content;


    public PoiWorkbook(String fileNameXlsx) {
        this.fileNameXlsx = fileNameXlsx;
    }

    public PoiWorkbook(String fileNameXlsx, String sheetName) {
        this.fileNameXlsx = fileNameXlsx;
        this.sheetName = sheetName;
    }


    public void create(Map<String, Object[]> header, Map<String, Object[]> content) {
        this.header = header;
        this.content = content;
    }

    public boolean write() throws Exception {
        if (sheetName == null)
            sheetName = fileNameXlsx;

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(sheetName);

        //Iterate over data and write to sheet
        writeHeader(header, spreadsheet);
        writeContent(content, spreadsheet);

        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File(fileNameXlsx));
        workbook.write(out);
        out.close();
        return true;
    }

    private void writeContent(Map<String, Object[]> content, XSSFSheet spreadsheet) {
        int rowIdContent = 1;
        iterateData(rowIdContent, spreadsheet, content);
    }

    private void writeHeader(Map<String, Object[]> header, XSSFSheet spreadsheet) {
        int rowIdHeader = 0;
        iterateData(rowIdHeader, spreadsheet, header);
    }

    private void iterateData(int rowIdHeader, XSSFSheet spreadsheet, Map<String, Object[]> header) {
        Set<String> keyIdHeader = header.keySet();
        XSSFRow row;
        for (String key : keyIdHeader) {
            row = spreadsheet.createRow(rowIdHeader++);
            Object[] objectArr = header.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }
    }

}
