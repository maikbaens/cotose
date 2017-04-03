/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.util.Map;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Xavier
 */
public class MySQL {

    /**
     * @author Pedro
     * @param args - 
     * @return  
     * @throws Exception
     */
    public static int install(String[] args) throws Exception{
        ProcessBuilder pb = null;
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            if (System.getenv("ProgramFiles(x86)") != null){
                pb = new ProcessBuilder("../scripts/mysql_win64.bat");
            } else {
                pb = new ProcessBuilder("../scripts/mysql_win32.bat");
            }
        } else if (os.toLowerCase().contains("unix")){
            if (System.getProperty("os.arch").indexOf("64") != -1){
                pb = new ProcessBuilder("../scripts/mysql_unix32.sh");
            } else {
                pb = new ProcessBuilder("../scripts/mysql_unix64.sh");
            }
        } else if (os.toLowerCase().contains("mac")){
            if (System.getProperty("os.arch").indexOf("64") != -1){
                pb = new ProcessBuilder("../scripts/mysql_mac32.sh");
            } else {
                pb = new ProcessBuilder("../scripts/mysql_mac64.sh");
            }
        } else throw new Exception("System not detected");
        
        //  formato pb: ProcessBuilder("myCommand", "myArg1", "myArg2");
        if (pb != null){
            Map<String, String> env = pb.environment(); // por si hay que guardar algun mensaje de error que de el script
            Process p;
            p = pb.start();
        }
        return 0;
    }
}
