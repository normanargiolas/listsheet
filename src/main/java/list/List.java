package list;

import list.Utils.ListFiles;
import list.Utils.PoiWorkbook;

import java.util.Map;
import java.util.TreeMap;

public class List {
    public static void main(String args[]) throws Exception {
        System.out.println("----------start");

        final String sourceDirectory = "/home/norman/personal/java/list/";
        final String fileNameXlsx = "Writesheet.xlsx";
        String sheetName = "Files Info";


        //This data needs to be written (Object[])
        Map<String, Object[]> header = new TreeMap<String, Object[]>();
        header.put("1", new Object[]{
                "NOME FILE", "DIMENSIONE", "TIPOLOGIA"});

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


        ListFiles listFilesUtil = new ListFiles(sourceDirectory);
        content = listFilesUtil.listFilesAndFilesSubDirectories();


        PoiWorkbook workbook = new PoiWorkbook(fileNameXlsx, sheetName);
        workbook.create(header, content);
        workbook.write();

        List app = new List();
        app.run();
    }

    void run() throws Exception {
        System.out.println("----------end");
    }
}
