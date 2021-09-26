import java.io.*;
import java.util.Scanner;

import static java.lang.Thread.sleep;

class file{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        // creat root folder (test)
        String root="C:\\Users\\ASUS\\Desktop\\交通資工\\大四(下)\\softwaretesting\\final";
        File dir_file = new File(root+"/test");   /*路徑跟檔名*/
        root = root+"/test";
        File_sys file_sys = new File_sys();


        System.out.println("=== Welcome to file system test ===\n");
        System.out.println("Command list");
        // 功能與其相對應的數字的說明放在這裡
        System.out.println("---------------------------------------------");
        System.out.println("1 = New Folder");
        System.out.println("2 = Delete Folder");
        System.out.println("3 = Rename Folder");
        System.out.println("4 = New File");
        System.out.println("5 = Delete File");
        System.out.println("6 = Copy File");
        System.out.println("7 = Move File");
        System.out.println("8 = Rename File");
        System.out.println("---------------------------------------------\n");

        // 輸入要做的指令
        System.out.print("Input command : ");
        String next_input;
        next_input = scanner.next();
        while(!next_input.equals("end")) {

            String input_folder;
            String input_file;
            String confirm;
            // 1,新增資料夾
            if (next_input.equals("1")) {
                System.out.println("        === New folder === ");
                System.out.print("input folder name (with path) : ");
                input_folder = scanner.next();
                if (input_folder.matches("[a-zA-Z0-9]+")) {   //檢查要新增的資料夾是否檔名只有英文和數字
                    file_sys.newFolder(root, input_folder);
                } else {
                    System.out.println("Error folder name");
                }
            }
            if (next_input.equals("2")) {
                System.out.println("        === Delete folder === ");
                System.out.print("input folder name (with path) : ");
                input_folder = scanner.next();
                System.out.println("!!! Do you want to delete " + input_folder + " ? (Type Yes or No) ");
                System.out.print("Yes or No : ");
                confirm = scanner.next();
                if (confirm.equals("Yes")) {
                    File file2 = new File(root + "/" + input_folder);
                    if (file2.exists()) {
                        if (file2.delete()) {
                            System.out.println("    already delete");
                        } else {
                            System.out.println("The folder is not empty, do you really want to delete? (Type Yes or No) ");
                            System.out.print("Yes or No : ");
                            confirm = scanner.next();
                            if (confirm.equals("Yes")) {
                                file_sys.deleteFolder(file2);
                                System.out.println("    already delete");
                            }
                        }
                    } else {
                        System.out.println("    The path of folder is not exist");
                    }
                }

            }
            if (next_input.equals("3")) {
                System.out.println("        === Rename folder === ");
                String oldfolder;
                String newfolder;
                System.out.print("input oid folder name (with path) : ");
                oldfolder = scanner.next();
                System.out.print("input new folder name (with path) : ");
                newfolder = scanner.next();
                file_sys.renameFolder(root, oldfolder, newfolder);
            }

            if (next_input.equals("4")){
                System.out.println("        === New File === ");
                System.out.print("input File name (with path) : ");
                input_file = scanner.next();
                file_sys.createFile(root,input_file);
            }

            if(next_input.equals("5")){
                System.out.println("        === Delete File === ");
                System.out.print("input File name (with path) : ");
                input_file = scanner.next();
                file_sys.deleteFile(root,input_file);
            }

            if(next_input.equals("6")){
                System.out.println("        === Copy File === ");
                String oldfile;
                String newfile;
                System.out.print("input oid folder name (with path) : ");
                oldfile = scanner.next();
                System.out.print("input new folder name (with path) : ");
                newfile = scanner.next();
                file_sys.copyFile(root,oldfile,newfile);
            }

            if(next_input.equals("7")){
                System.out.println("        === Move File === ");
                String oldfile;
                String newfile;
                System.out.print("input oid folder name (with path) : ");
                oldfile = scanner.next();
                System.out.print("input new folder name (with path) : ");
                newfile = scanner.next();
                file_sys.moveFile(root,oldfile,newfile);
            }

            if(next_input.equals("8")){
                System.out.println("        === Rename File === ");
                String oldfile;
                String newfile;
                System.out.print("input oid folder name (with path) : ");
                oldfile = scanner.next();
                System.out.print("input new folder name (with path) : ");
                newfile = scanner.next();
                file_sys.renameFile(root,oldfile,newfile);
            }

            // next command input
            System.out.println("");
            try {
                sleep(1000); //暫停，每一秒輸出一次
            }catch (InterruptedException e) {
                return;
            }
            System.out.println("Command list");
            // 功能與其相對應的數字的說明放在這裡
            System.out.println("---------------------------------------------");
            System.out.println("1 = New Folder");
            System.out.println("2 = Delete Folder");
            System.out.println("3 = Rename Folder");
            System.out.println("4 = New File");
            System.out.println("5 = Delete File");
            System.out.println("6 = Copy File");
            System.out.println("7 = Move File");
            System.out.println("8 = Rename File");
            System.out.println("---------------------------------------------\n");

            // 輸入要做的指令
            System.out.print("Input command : ");
            next_input = scanner.next();
        }
    }
}