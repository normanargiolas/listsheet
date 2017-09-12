package list;

import list.Utils.ListFiles;
import list.Utils.PoiWorkbook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class List {
    public static void main(String args[]) throws Exception {
        System.out.println("----------start");

        final String sourceDirectory = "/home/norman/personal/java/list/src/";
        final String fileNameXlsx = "Writesheet.xlsx";
        String sheetName = "Files Info";


        //This data needs to be written (Object[])
        Map<String, Object[]> header = new TreeMap<String, Object[]>();
        header.put("1", new Object[]{
                "NOME FILE", "PERCORSO", "TIPOLOGIA", "DIMENSIONE"});


        ListFiles listFilesUtil = new ListFiles(sourceDirectory);
        Map<String, Object[]> content = listFilesUtil.listFilesAndFilesSubDirectories();


        ArrayList<String> list = listFilesUtil.listFilesAndFilesSubDirectories(sourceDirectory);

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
