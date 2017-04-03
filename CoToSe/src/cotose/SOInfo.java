/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

/**
 *
 * @author Francisco
 * @version 1
 */
public class SOInfo {
    /**
     * @description Equivale al nombre del sistema operativo de la maquina.
     */
    public static String name;
    /**
     * @description Si es True la maquina es de 64 bits, si False es de 32.
     */
    public static Boolean is64bit;
    
    /**
     * @description Construtor de clase, asigna valores name y is64bit.
     */
    SOInfo(){
        name = System.getProperty("os.name");
        is64bit = false;
        if (System.getProperty("os.name").contains("Windows")) {
            is64bit = (System.getenv("ProgramFiles(x86)") != null);
        } else {
            is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
        }
    }
}
