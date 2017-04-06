/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class Apache {

    /**
     * @param args the command line arguments
     */
    
    public static int apacheUnixLocal() throws Exception {
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        Utils.executeCommands("../scripts/apache_unix.sh", debug_bool, debug, true);
        return 0;
    }
     
    public static int apacheUnixRemoto(String uName, String pWord) throws Exception {
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        ProcessBuilder pb = null;
        pb = new ProcessBuilder("../scripts/apache_unix.sh", uName, pWord);
        Process p;
        p = pb.start();
        return 0;
    }
     
    public static int apacheWindows64Local() throws Exception {
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        Utils.executeCommands("../scripts/apache_win64.bat", debug_bool, debug, true);
        return 0;
    }  
     
    public static int apacheWindows32Local() throws Exception {
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        Utils.executeCommands("../scripts/apache_win32.bat", debug_bool, debug, true);
        return 0;
    }      
}