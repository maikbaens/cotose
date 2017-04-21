/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.util.Map;
import java.io.File;
import java.nio.file.Paths;


import java.lang.ProcessBuilder.Redirect;

/**
 *
 * @author Xavier
 */
public class MySQL {

    /**
     * @author Xavier
     * @return Returns 0 if the installation finished correctly. -1 If there was an error and debugging not enabled. Debugging info if debugging is enabled
     * @throws Exception - If the OS is not recognized
     * @param so - Defines the OS we are working with
     * @param bits - Defines the bits (32 or 64) of the OS
     */
    public static int install(int so, boolean bits) throws Exception{
        switch (so) {
            case 0:
                //Unix
                return installUnix();
            case 1:
                //Win
                return installWin();
            case 2:
                //Mac
                return installMac();
            default:
                throw new Exception();
        }
    }
    
    private static int installWin() throws Exception{
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        Utils.executeCommands("../scripts/mysql_win.bat " + Paths.get(".").toAbsolutePath().normalize().toString(), debug_bool, debug, true);
        
        if (debug_bool){
            if (Utils.readFile(debug) != null){
                throw new Exception();
            }
        }
        return 0;
    }
    
    private static int installUnix() throws Exception{
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        ProcessBuilder pb = new ProcessBuilder("../scripts/mysql_unix.sh");
        //Map<String, String> env = pb.environment(); // por si hay que guardar algun mensaje de error que de el script
        
        //Enable debugging. Redirect output to file debug.
        if (debug_bool){
            File log = new File(debug);
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
        }
        
        Process p;
        p = pb.start();

        //Check debugging
        if (debug_bool){
            if (Utils.readFile(debug) != null){
                throw new Exception();
            }
        }
        return 0;
    }
    
    private static int installMac() throws Exception{
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        ProcessBuilder pb = new ProcessBuilder("../scripts/mysql_mac.sh");
        //Map<String, String> env = pb.environment(); // por si hay que guardar algun mensaje de error que de el script
        
        //Enable debugging. Redirect output to file debug.
        if (debug_bool){
            File log = new File(debug);
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
        }
        Process p;
        p = pb.start();
        
        //Check debugging.
        if (debug_bool){
            if (Utils.readFile(debug) != null){
                throw new Exception();
            }
        }
        return 0;
    }
}
