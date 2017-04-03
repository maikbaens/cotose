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
        String debug = new String();
        
        if (os.contains("Windows")) {
            if (System.getenv("ProgramFiles(x86)") != null){
                Utils.executeCommands("../scripts/mysql_win64.bat", debug_bool, debug, false);
            } else {
                Utils.executeCommands("../scripts/mysql_win32.bat", debug_bool, debug, false);
            }
        } else if (os.toLowerCase().contains("unix")){
            if (System.getProperty("os.arch").indexOf("64") != -1){
                Utils.executeCommands("../scripts/mysql_unix32.sh", debug_bool, debug, false);
            } else {
                Utils.executeCommands("../scripts/mysql_unix64.sh", debug_bool, debug, false);
            }
        } else if (os.toLowerCase().contains("mac")){
            if (System.getProperty("os.arch").indexOf("64") != -1){
                Utils.executeCommands("../scripts/mysql_mac32.sh", debug_bool, debug, false);
            } else {
                Utils.executeCommands("../scripts/mysql_mac64.sh", debug_bool, debug, false);
            }
        } else {
            if (debug_bool){
                throw new Exception(debug);
            }
            return -1;
        }
        
        return 0;
    }
}
