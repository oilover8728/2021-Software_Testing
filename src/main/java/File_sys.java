import java.io.*;

public class File_sys {
    public static String fileSystemPath = "C:\\Users\\ASUS\\Desktop\\交通資工\\大四(下)\\softwaretesting\\final/test";
    public static void newFolder(String now_path,String new_folder_name){
        File dir_file = new File(now_path+"/"+new_folder_name);   /*路徑跟檔名*/
        dir_file.mkdir();
    }
    public static void deleteFolder(File file) {
        if(file.exists()) {//判斷路徑是否存在
            if(file.isFile()){//boolean isFile():測試此抽象路徑名錶示的檔案是否是一個標準檔案。
                file.delete();
            }else{//不是檔案，對於資料夾的操作
                //儲存 路徑D:/1/新建資料夾2  下的所有的檔案和資料夾到listFiles陣列中
                File[] listFiles = file.listFiles();//listFiles方法：返回file路徑下所有檔案和資料夾的絕對路徑
                for (File file2 : listFiles) {
                    /*
                     * 遞迴作用：由外到內先一層一層刪除裡面的檔案 再從最內層 反過來刪除資料夾
                     *    注意：此時的資料夾在上一步的操作之後，裡面的檔案內容已全部刪除
                     *         所以每一層的資料夾都是空的  ==》最後就可以直接刪除了
                     */
                    deleteFolder(file2);
                }
            }
            file.delete();
        }
    }

    public static void renameFolder(String root,String oldFilePath, String newFilePath){
        File oldFile=new File(root+"/"+oldFilePath);
        File newFile=new File(root+"/"+newFilePath);
        if(!oldFile.exists()){
            System.out.println("    "+oldFile.getName()+" not exists!");
        }else if(newFile.exists()){
            System.out.println("    "+newFile.getName()+" already exists!");
        }else{
            boolean rename=oldFile.renameTo(newFile);
            if(rename){
                System.out.println("    Successfully renamed.");
            }else{
                System.out.println("    Error!");
            }
        }
    }
    public static void createFile(String root,String filePath){
        try {
            File file=new File(root+"/"+filePath);
            if(!file.createNewFile()){
                System.out.println(file.getName()+" already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  void deleteFile(String root,String filePath){
        File file=new File(root+"/"+filePath);
        if(file.exists()){
            if(!file.delete()){
                System.out.println("Error!");
            }
        }else{
            System.out.println(file.getName()+" not exists!");
        }
    }
    public static boolean copyFile(String root,String sourceFilePath, String destinationFilePath) {
        try {
            File sourceFile=new File(root+"/"+sourceFilePath);
            File destinationFile = new File(root+"/"+destinationFilePath);
            if(!sourceFile.exists()){
                System.out.println(sourceFile.getName()+" not exists!");
                return false;
            }
            if (destinationFile.createNewFile()) {
                InputStream input = new FileInputStream(sourceFile);
                OutputStream output = new FileOutputStream(destinationFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                input.close();
                output.close();
                return true;
            } else {
                System.out.println(destinationFile.getName() + " already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void moveFile(String root,String sourceFilePath, String destinationFilePath) {
        if(copyFile(root,sourceFilePath, destinationFilePath)){
            deleteFile(root,sourceFilePath);
        }
    }
    public static void renameFile(String root,String oldFilePath, String newFilePath){
        File oldFile=new File(root+"/"+oldFilePath);
        File newFile=new File(root+"/"+newFilePath);
        if(!oldFile.exists()){
            System.out.println(oldFile.getName()+" not exists!");
        }else if(newFile.exists()){
            System.out.println(newFile.getName()+" already exists!");
        }else{
            if(!oldFile.renameTo(newFile)){
                System.out.println("Error!");
            }
        }
    }
}
