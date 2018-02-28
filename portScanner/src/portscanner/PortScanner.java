/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portscanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the IP: ");
        String host = sc.nextLine();
        InetAddress inetAddress = InetAddress.getByName(host);

        String hostName = inetAddress.getHostName();
        for (int port = 0; port <= 65535; port++) 
        {
            try 
            {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                System.out.println(text);
                socket.close();
            } 
            catch (IOException e) 
            {
                String s = hostName + " is not listening on port " + port;
                System.out.println(s);
            }
        }
    }
}