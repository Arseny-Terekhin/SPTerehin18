package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException {
        ProtectionCode file1 = new ProtectionCode("src\\com\\company\\", "src\\com\\company\\", "ThreadDownload.txt", "readyThread.txt" );
        file1.CleanComment();
        ArrayList<String> arrayClass;
        arrayClass = file1.renameClass();
        file1.renameVariable();
        ProtectionCode file = new ProtectionCode("src\\com\\company\\", "src\\com\\company\\", "Main.txt", "readyMain.txt", arrayClass);
        file.CleanComment();
        file.renameVariable();

    }
}
