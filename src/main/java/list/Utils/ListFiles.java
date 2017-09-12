package list.Utils;

import java.io.File;
import java.util.Map;

public class ListFiles {

    String source;

    public ListFiles(String source) {
        this.source = source;
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
    public void listFilesAndFilesSubDirectories(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

    public Map<String, Object[]> listFilesAndFilesSubDirectories() {

        return null;
    }
}
