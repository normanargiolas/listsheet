package list;

import list.Utils.ListFiles;
import list.Utils.PoiWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class List {
    public static void main(String args[]) throws Exception {
        System.out.println("----------start");

        final String sourceDirectory = "/home/norman/personal/java/list/";
        final String fileNameXlsx = "createworkbook.xlsx";
        String sheetName = "Files Info";
        

        //This data needs to be written (Object[])
        Map<String, Object[]> header = new TreeMap<String, Object[]>();
        header.put("1", new Object[]{
                "EMP ID", "EMP NAME", "DESIGNATION"});

        Map<String, Object[]> content = new TreeMap<String, Object[]>();
        content.put("1", new Object[]{
                "tp01", "Gopal", "Technical Manager"});
        content.put("2", new Object[]{
                "tp02", "Manisha", "Proof Reader"});
        content.put("3", new Object[]{
                "tp03", "Masthan", "Technical Writer"});
        content.put("4", new Object[]{
                "tp04", "Satish", "Technical Writer"});
        content.put("5", new Object[]{
                "tp05", "Krishna", "Technical Writer"});


        PoiWorkbook workbook = new PoiWorkbook(fileNameXlsx, sheetName);
        workbook.create(header, content);
        workbook.write();


        //------------------------------------------------------------

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Files Info");
        //Create row object
        XSSFRow row;


        //This data needs to be written (Object[])
        Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
        empinfo.put("1", new Object[]{
                "EMP ID", "EMP NAME", "DESIGNATION"});
        empinfo.put("2", new Object[]{
                "tp01", "Gopal", "Technical Manager"});
        empinfo.put("3", new Object[]{
                "tp02", "Manisha", "Proof Reader"});
        empinfo.put("4", new Object[]{
                "tp03", "Masthan", "Technical Writer"});
        empinfo.put("5", new Object[]{
                "tp04", "Satish", "Technical Writer"});
        empinfo.put("6", new Object[]{
                "tp05", "Krishna", "Technical Writer"});


        //Iterate over data and write to sheet
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
        workbook.write(out);
        out.close();


        System.out.println("Writesheet.xlsx written successfully");

        //------------------------------------------------------------


        ListFiles listFilesUtil = new ListFiles();
        listFilesUtil.listFilesAndFilesSubDirectories(sourceDirectory);


        List app = new List();
        app.run();
    }

    void run() throws Exception {
        System.out.println("----------end");
    }
}
