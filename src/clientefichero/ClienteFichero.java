/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientefichero;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 *
 * @author ADVANCE
 */
public class ClienteFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     DataInputStream input;
     BufferedInputStream bis;
     BufferedOutputStream bos;
     int in;
     byte[] byteArray;
     final String filename = "E:\\test.txt";

    try{
        final File localFile = new File( filename );
        Socket client = new Socket("127.0.0.1", 4500);
        bis = new BufferedInputStream(new FileInputStream(localFile));
        bos = new BufferedOutputStream(client.getOutputStream());
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        dos.writeUTF(localFile.getName());
        byteArray = new byte[8192];
        while ((in = bis.read(byteArray)) != -1){
        bos.write(byteArray,0,in);
        }
            bis.close();
            bos.close();

       }catch ( Exception e ) {
        System.err.println(e);
        }
      }
    }
    

