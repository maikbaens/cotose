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
        if (os.toLowerCase().contains("windows")){
            pb = new ProcessBuilder("../scripts/mysql_win.bat");
        } else if (os.toLowerCase().contains("unix")){
            pb = new ProcessBuilder("../scripts/mysql_unix.sh");
        } else if (os.toLowerCase().contains("mac")){
            pb = new ProcessBuilder("../scripts/mysql_mac.sh");
        } else return -1;
        
        //  formato pb: ProcessBuilder("myCommand", "myArg1", "myArg2");
        if (pb != null){
            Map<String, String> env = pb.environment(); // por si hay que guardar algun mensaje de error que de el script
            Process p;
            p = pb.start();
        }
        return 0;
    }
}
