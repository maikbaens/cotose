/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.awt.Point;
import java.io.IOException;

/**
 *
 * @author Xavier
 */
public class CoToSe {

    
    public static boolean local;
    public static boolean iApache;
    public static boolean iTomcat;
    public static boolean iPHP;
    public static boolean iPHPAdmin;
    public static boolean iSQL;
    
    public static Point point;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Init data
        iApache = iTomcat = iPHP = iPHPAdmin = iSQL = false;
        //Create first form for setup configuration
        Form config = new Form();
        config.setVisible(true);
    }

    static void installComponents() {
        Form2 install = new Form2();
        install.setVisible(true);
    }
}
