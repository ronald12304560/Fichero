package ServidorFichero;

import java.net.*;
import java.io.*;

     class servidorfichero{
        public static void main (String[] args){

            ServerSocket server;
            Socket connection;

            DataOutputStream output;
            BufferedInputStream bis;
            BufferedOutputStream bos;

        byte[] receivedData;
         int in;
         String file;

    try{
        server = new ServerSocket( 4500 );
            while ( true ) {
                connection = server.accept();
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis=new DataInputStream(connection.getInputStream());
                file = dis.readUTF();
                file = file.substring(file.indexOf('\\')+1,file.length());
                bos = new BufferedOutputStream(new FileOutputStream(file));
            while ((in = bis.read(receivedData)) != -1){
                bos.write(receivedData,0,in);
            }
                bos.close();
                dis.close();
            }
     }catch (Exception e ) {
        System.err.println(e);
        }
     }
}