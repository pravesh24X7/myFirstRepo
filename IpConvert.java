
/*
 * Java to get the corresponding binary value of given Ipv4 address
 *
 */

package coreJava;

import java.util.*;

public class IpConvert
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputIp = input.nextLine();

        System.out.println(func(inputIp));
        printUtils(inputIp);

        input.close();
    }


    private static String func(String ip) {
        String[] octets = new String[4];
        octets = ip.split("\\.");

        StringBuilder binaryIp = new StringBuilder("");
        for (String IpOctets : octets) {
            binaryIp.append(Integer.toBinaryString(Integer.parseInt(IpOctets)));
            binaryIp.append(".");
        }
        binaryIp.deleteCharAt(binaryIp.length()-1);

        return binaryIp.toString();
    }


    private static void printUtils(String ip) {
        String[] octets = new String[4];
        octets = ip.split("\\.");
        int initialValue = Integer.parseInt(octets[0]);

        if (initialValue < 127) {
            System.out.println("You've inputted a class A IP address");
            System.out.println("Your NetworkId :" + initialValue + ".0.0.0");
            System.out.println("Your SubnetMask :" + initialValue + "225.225.225");
            System.out.println("Total Ip available is :" + (int)(Math.pow(2, 24) - 2));
        } else if (initialValue == 127) {
            System.out.println("You've inputted a Loop back Address");
            System.out.println("Your NetworkId :" + initialValue + ".0.0.0");
            System.out.println("Your SubnetMask :" + initialValue + "225.225.225");
            System.out.println("Total Ip available is :" + 1);
        } else if (initialValue < 191) {
            System.out.println("You've inputted a class B IP address");
            System.out.println("Your NetworkId :" + initialValue + "." +octets[1] + ".0.0");
            System.out.println("Your SubnetMask :" + initialValue + ".225.225");
            System.out.println("Total Ip available is :" + (int)(Math.pow(2, 16) - 2));
        } else if (initialValue <= 192) {
            System.out.println("You've inputted a class C IP address");
            System.out.println("Your NetworkId :" + initialValue + "." + octets[1] + "." +octets[2] + ".0");
            System.out.println("Your SubnetMask :" + initialValue + "." +octets[1] + "." + octets[2] + ".225");
            System.out.println("Total Ip available is :" + (int)(Math.pow(2, 8) - 2));
        } else {
            System.out.println("You've an exceptional IP");
        }

    }

}
