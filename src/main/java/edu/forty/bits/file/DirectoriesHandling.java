package edu.forty.bits.file;

import java.io.File;
import java.util.Date;

public class DirectoriesHandling {

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today.toString());
        String currentDirectory = System.getProperty("user.dir");
        File screenshot_directory = new File(currentDirectory + "/logs/screenshots");
        if(!screenshot_directory.exists()){
            if(screenshot_directory.mkdirs()) System.out.println("Created the screenshots directory under logs.");
            else System.out.println("Couldn't create a directory.");
        }
        else{
            if(deleteDir(screenshot_directory)) System.out.println("Deleted the screenshots directory under logs.");
            else System.out.println("Couldn't delete the directory.");
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                return (deleteDir(new File(dir, aChildren)));
            }
        }
        return dir.delete();
    }
}
