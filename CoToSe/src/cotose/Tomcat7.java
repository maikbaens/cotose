/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;

/**
 *
 * @author gamemaik
 */
public class Tomcat7 {
    
    
    public static int tomcat7_installation(int so, int bits) throws Exception{
        
        switch (so) {
            case 0: 
                return installUnix();
            case 1: 
                return installWin();
            case 2: 
                return installMac();
            default:
                throw new Exception();                
        }
    }
    
    
    public static int installUnix() throws Exception{
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        ProcessBuilder pb = new ProcessBuilder("../scripts/tomcat7_unix.sh");
        
        if (debug_bool) {
            File log = new File(debug);
            pb.redirectErrorStream(true);
            pb.redirectError(Redirect.appendTo(log));
        }
        
        Process p = pb.start();
        
        if (debug_bool && (Utils.readFile(debug) != null)) {
            throw new Exception();
        }
        
        return 0;
    }
    
    
    private static int installWin() throws Exception{
        Boolean debug_bool = false;
        String debug = "debuginfo.txt";
        Utils.executeCommands("../scripts/tomcat7_win.bat", debug_bool, debug, true);
        
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
        ProcessBuilder pb = new ProcessBuilder("../scripts/tomcat7_mac.sh");
        
        if (debug_bool){
            File log = new File(debug);
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
        }
        Process p;
        p = pb.start();
        
        if (debug_bool){
            if (Utils.readFile(debug) != null){
                throw new Exception();
            }
        }
        return 0;
    }
    
}
