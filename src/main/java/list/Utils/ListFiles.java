package list.Utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ListFiles {

    String source;
    ArrayList<String> lists;


    public ListFiles(String source) {
        this.source = source;
        this.lists = new ArrayList<String>();
    }

    /**
     * List all the files and folders from a directory
     *
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            System.out.println(file.getName());
        }
    }

    /**
     * List all the files under a directory
     *
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all the folder under a directory
     *
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all files from a directory and its subdirectories
     *
     * @param directoryName to be listed
     */
    public ArrayList<String> listFilesAndFilesSubDirectories(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                lists.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
        return lists;
    }

    public Map<String, Object[]> listFilesAndFilesSubDirectories() {
        //set lists with all files
        listFilesAndFilesSubDirectories(source);

        Map<String, Object[]> content = new TreeMap<String, Object[]>();

        int n = 1;
        for (String file : lists) {
            System.out.println(file);

            String ext = FilenameUtils.getExtension(file);
            String name = FilenameUtils.getBaseName(file);
            File f = new File(file);
            Long size = f.length();

            float fileSizeInKB = 0;
            if (size != null && size != 0) {
                fileSizeInKB = (float) size / 1024;
            }


            content.put(String.valueOf(n++), new Object[]{
                    name, file, ext, String.valueOf(fileSizeInKB)});
        }

        return content;
    }

}
