package list.Utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

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

    public void write() {
        if (sheetName == null)
            sheetName = fileNameXlsx;

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Files Info");
        //Create row object
        XSSFRow row;
    }
}
