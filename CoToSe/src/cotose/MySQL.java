/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.util.Map;
import java.io.File;
import java.io.IOException;

import cotose.Utils;

/**
 *
 * @author Xavier
 */
public class MySQL {

    /**
     * @author Xavier
     * @return Returns 0 if the installation finished correctly. -1 If there was an error and debugging not enabled. Debugging info if debugging is enabled
     * @throws Exception - If the OS is not recognized
     */
    public static int install() throws Exception{
        String os = System.getProperty("os.name");
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        
        ProcessBuilder pb;
        
        if (os.contains("Windows")) {
            if (System.getenv("ProgramFiles(x86)") != null){
                Utils.executeCommands("../scripts/mysql_win64.bat", debug_bool, debug, true);
            } else {
                Utils.executeCommands("../scripts/mysql_win32.bat", debug_bool, debug, true);
            }
        } else {
            if (os.toLowerCase().contains("unix")){
                pb = new ProcessBuilder("../scripts/mysql_unix.sh");
            } else if (os.toLowerCase().contains("mac")){
                pb = new ProcessBuilder("../scripts/mysql_mac.sh");
            } else {
                return -1; //Not found
            }
            
            if (pb != null){
                Map<String, String> env = pb.environment(); // por si hay que guardar algun mensaje de error que de el script
                Process p;
                p = pb.start();
            }
        }
        if (debug_bool && debug != null){
            throw new Exception(debug);
        }
        return 0;
    }
}
