import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class fileSystemTest {
    @org.junit.jupiter.api.Test
    void newFolder(){
        String filePath="/new folder";
        File_sys.newFolder(File_sys.fileSystemPath,filePath);
        File file=new File(File_sys.fileSystemPath+filePath);
        assertTrue(file.exists());
    }
    @org.junit.jupiter.api.Test
    void deleteFolder(){
        String filePath="/new folder";
        File_sys.newFolder(File_sys.fileSystemPath,filePath);
        File_sys.deleteFile(File_sys.fileSystemPath,filePath);
        File file=new File(File_sys.fileSystemPath+filePath);
        assertFalse(file.exists());
    }
    @org.junit.jupiter.api.Test
    void renameFolder(){
        String oldFilePath="/new folder";
        String newFilePath="/old folder";
        File_sys.newFolder(File_sys.fileSystemPath,oldFilePath);
        File_sys.renameFolder(File_sys.fileSystemPath,oldFilePath,newFilePath);
        File file=new File(File_sys.fileSystemPath+newFilePath);
        assertTrue(file.exists());
    }
    @org.junit.jupiter.api.Test
    void createFile() {
        String filePath="\\abc.txt";
        File_sys.createFile(File_sys.fileSystemPath,filePath);
        File file=new File(File_sys.fileSystemPath+filePath);
        assertTrue(file.exists());
    }

    @org.junit.jupiter.api.Test
    void deleteFile() {
        String filePath="\\abc.txt";
        File_sys.createFile(File_sys.fileSystemPath,filePath);
        File_sys.deleteFile(File_sys.fileSystemPath,filePath);
        File file=new File(File_sys.fileSystemPath+filePath);
        assertFalse(file.exists());
    }

    @org.junit.jupiter.api.Test
    void copyFile() {
        String sourceFilePath="\\abc.txt";
        String destinationFilePath="\\def.txt";
        File_sys.createFile(File_sys.fileSystemPath,sourceFilePath);
        File_sys.deleteFile(File_sys.fileSystemPath,destinationFilePath);
        File_sys.copyFile(File_sys.fileSystemPath,sourceFilePath, destinationFilePath);
        File destinationFile=new File(File_sys.fileSystemPath+destinationFilePath);
        assertTrue(destinationFile.exists());
    }

    @org.junit.jupiter.api.Test
    void moveFile() {
        String sourceFilePath="\\abc.txt";
        String destinationFilePath="\\def.txt";
        File_sys.createFile(File_sys.fileSystemPath,sourceFilePath);
        File_sys.deleteFile(File_sys.fileSystemPath,destinationFilePath);
        File_sys.moveFile(File_sys.fileSystemPath,sourceFilePath, destinationFilePath);
        File destinationFile=new File(File_sys.fileSystemPath+destinationFilePath);
        assertTrue(destinationFile.exists());
    }

    @org.junit.jupiter.api.Test
    void renameFile() {
        String sourceFilePath="\\abc.txt";
        String destinationFilePath="\\def.txt";
        File_sys.createFile(File_sys.fileSystemPath,sourceFilePath);
        File_sys.deleteFile(File_sys.fileSystemPath,destinationFilePath);
        File_sys.renameFile(File_sys.fileSystemPath,sourceFilePath, destinationFilePath);
        File destinationFile=new File(File_sys.fileSystemPath+destinationFilePath);
        assertTrue(destinationFile.exists());
    }
}