/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


public class Pedido extends Thread {

  private final Socket mSocket;
  private DataInputStream input;
  private DataOutputStream output;


  public Pedido(Socket inSocket) {
    mSocket = inSocket;

    try {

       input = new DataInputStream(mSocket.getInputStream());
       output = new DataOutputStream(mSocket.getOutputStream());

     // output = new ObjectOutputStream(inSocket.getOutputStream());
     // input = new ObjectInputStream(inSocket.getInputStream());
      System.out.println("Ligacao cliente estabelecida" );
    }
    catch (IOException ex) {

    }
  }

  @Override
  public void run() {

    try
    { 
      while (true)
      {
        
        String mensagem = new String("");
        mensagem = input.readUTF(); 

        System.out.println("Mensagem " + mensagem + " recebida.");
        output.writeInt(mensagem.length());
        input.close();
        output.close();
        mSocket.close();

        System.out.println("Ligacao fechada" );
        System.out.println();
      }
    }
    catch(IOException e) 
    {
      System.out.println("Erro:" + e);
    }

  }

  
}
