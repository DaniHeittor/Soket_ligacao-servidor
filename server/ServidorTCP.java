/**
 * @(#)ServidorTCP.java
 * @version 1.0
 */

import java.lang.*;
import java.io.*;
import java.net.*;

public class ServidorTCP {

  private static final int port=6789;

  public static void main(String[] args)
  {
    ServerSocket serversocket = null;
    try 
    {
      serversocket = new ServerSocket(port);     
    }
    catch(Exception e)
    {
      System.out.println( "Erro: Nao foi possivel criar o socket" + 
                                                        "servidor" + e );
      System.exit(1); 
    }
  
          System.out.println("A espera de ligacoes do cliente ");
     try {
          (new Pedido(serversocket.accept())).start();
      System.out.println("Conexao aceite!");
        }
        catch (IOException ex) {
          System.out.println("Falha ao estabelecer conexão com cliente!");
        }


    try
    { 
      serversocket.close();
    }
    catch(IOException e) 
    {
      System.out.println("Erro ao fechar a ligacao:" + e);
    }

    

  }
}
