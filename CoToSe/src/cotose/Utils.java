/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotose;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hzone
 */
public class Utils {
    /*
        Cada linea del fichero como un string de la Lista devuelta
    */
    public static List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
              records.add(line);
            }
            reader.close();
            return records;
        }
        catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
    /*
        Funcion para escribir en fichero
        filename: nombre del fichero
        text: texto a escribir
        append: si true se anade, si false se sobreescribe
    */
    public static void writeFile(String filename, String text, Boolean append) throws IOException {
        File file = new File (filename);
        BufferedWriter out = new BufferedWriter(new FileWriter(file, append));
        out.write(text.concat("\n"));
        out.newLine();
        out.close();
    }
    /*
        Funcion para ejecutar linea por consola
        command: linea a ejecutar
        save: si se quiere guardar el log
        filename: nombre del fichero al que guardar el log, si save es false, puede ser null
        append: si se sobreescribe el fichero filename, si save es false, puede ser null
    */
    public static void executeCommand(String command,Boolean save,String filename,Boolean append) throws IOException {
        writeFile(filename,"",append);
        try {
            Runtime rt = Runtime.getRuntime();
            BufferedReader input = null;
            Process pr = null;

            pr = rt.exec("cmd.exe /c"+command);
            input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            
            if(save){
                String line = null;

                while ((line = input.readLine()) != null){
                    writeFile(filename,line,true);
                    //System.out.print(line);
                    //System.out.print("Jalo.\n");
                }
                int exitVal = pr.waitFor();
                //Printa el error code al finalizar la ejecucion, 0 = todo bien
                //writeFile(filename,"Exited with error code " + exitVal,true);
            }
        } catch (Exception e) {
            writeFile(filename,e.toString(),true);
            //e.printStackTrace();
        }
    }
    /*
        Funcion para ejecutar conjunto de lineas por consola desde fichero
        commandfile: nombre del fichero a leer (relativo)
        save: si se quiere guardar el log
        filename: nombre del fichero al que guardar el log, si save es false, puede ser null
        append: si se sobreescribe el fichero filename, si save es false, puede ser null
    */
    public static void executeCommands(String commandfile,Boolean save,String filename,Boolean append) throws IOException{
        List<String> filelines = readFile(commandfile);
        for(String comm : filelines){
            executeCommand(comm,save,filename,append);
        }
    }

}