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
     public static void main (String[] args)  throws Exception{  // main para poder pasarle parametros via args
        String os = System.getProperty("os.name");
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        
        ProcessBuilder pb = null;
        
        if (os.contains("Windows")) {
            if (System.getenv("ProgramFiles(x86)") != null){
                Utils.executeCommands("../scripts/apache_win64.bat", debug_bool, debug, true);
            } else {
                Utils.executeCommands("../scripts/apache_win32.bat", debug_bool, debug, true);
            }
        } else {
            if (os.toLowerCase().contains("unix")){
                if (args[0] != null) pb = new ProcessBuilder("../scripts/apache_unix.sh", args[0]); //1 parametro, username para instal. remota
                else pb = new ProcessBuilder("../scripts/apache_unix.sh"); 
            } else if (os.toLowerCase().contains("mac")){
                pb = new ProcessBuilder("../scripts/apache_mac.sh");
            } else {
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
    }
}