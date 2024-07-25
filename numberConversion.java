import java.util.Scanner;

public class numberConversion {
    public static void main(String[] args) {
        int choise;
        Scanner sc=new Scanner(System.in);
        {
            System.out.println("\tChoose the Convertion\n1.Convert Decimal to Binary\n2.Convert Decinal to Octal\n3.Convert Decinal to Hexadecimal\n4.Convert Binary to Decimal\n5.Convert Binary to Octal\n6.Convert Binary to Hexadecimal\n7.Convert Octal to Decimal\n8.Convert Octal to Binary\n9.Convert Octal to Hexadecimal\n10.Convert Hexaecimal to Binary\n11.Convert Hexaecimal to Decimal\n12.Convert Hexaecimal to Octal\n");
            choise =sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.print("Enter the Decimal Digit:");
                    System.out.print(DecimalToBinary(sc.nextInt()));
                    break;
                    case 2:
                    System.out.print("Enter the Decimal Digit:");
                    System.out.print(DecimalToOctal(sc.nextInt()));
                    break;
                    case 3:
                    System.out.print("Enter the Decimal Digit:");
                    System.out.print(DecimalToHexadecimal(sc.nextInt()));
                    break;
                    case 4:
                    System.out.print("Enter the Binary Digit:");
                    System.out.print(BinaryToDecimal(sc.nextInt()));
                    break;
                    case 5:
                    System.out.print("Enter the Binary Digit:");
                    System.out.print(BinaToOctal(sc.nextInt()));
                    break;
                    case 6:
                    System.out.print("Enter the Binary Digit:");
                    System.out.print(BinaryToHexadecimal(sc.nextInt()));
                    break;
                    case 7:
                    System.out.print("Enter Octal Digit:");
                    System.out.print(OctalToDecimal(sc.nextInt()));
                    break;
                    case 8:
                    System.out.print("Enter Octal Digit:");
                    System.out.print(OctalToBinary(sc.nextInt()));
                    break;
                    case 9:
                    System.out.print("Enter Octal Digit:");
                    System.out.print(OctalToHexadecimal(sc.nextInt()));
                    break;
                    case 10:
                    System.out.print("Enter Hexadecimal Digit:");
                    System.out.print(HexadecimalToBinary(sc.next()));
                    break;
                    case 11:
                    System.out.print("Enter Hexadecimal Digit:");
                    System.out.print(HexadecimaltoDecimal(sc.next()));
                    break;
                    case 12:
                    System.out.print("Enter Hexadecimal Digit:");
                    System.out.print(HexadecimalToOctal(sc.next()));
                    break;
                    default:
                    System.out.println(" \t$ -_- NOT VALID OPTION -_- $");
                    break;
            }
        }
    }
    public static String DecimalToBinary(int decimalinput){
    int rem;
    StringBuilder binary=new StringBuilder();
        while (decimalinput>0) 
        {
            rem=decimalinput%2;
            binary.insert(0,rem);
            decimalinput=decimalinput/2;
        }
        return binary.toString();
    }
    public static String DecimalToOctal(int decimalinput)
    {
        int rem;
        StringBuilder octal=new StringBuilder();
        while (decimalinput>0) 
        {
            rem=decimalinput%8;
            octal.insert(0, rem);
            decimalinput=decimalinput/8;
        }
        return octal.toString();
    }
    public static String DecimalToHexadecimal(int decimalinput){
        int rem;
        StringBuilder hexa=new StringBuilder();
        while (decimalinput>0) {
            rem=decimalinput%16;
            if(rem<10){
            hexa.insert(0,rem);
            }else{
                hexa.insert(0,(char)('A'+(rem-10)));
            }
            decimalinput=decimalinput/16;
        }
            return hexa.toString();
    }
    public static int BinaryToDecimal(int binary)
    {
        int pow=0;
        int decimal=0;
        while(binary>0){
        int bit=binary%10;
        if(bit==1)
        {
            decimal+= Power(2,pow);
        }
        binary/=10;
        pow++;
    }
    return decimal;
    }
    public static String BinaToOctal(int binary) {
        int decimal=BinaryToDecimal(binary);
        String octal=DecimalToOctal(decimal);
        return octal;
    }
    public static String BinaryToHexadecimal(int binary)
    {
        int decimal=BinaryToDecimal(binary);
        String hexa=DecimalToHexadecimal(decimal);
        return hexa;
    }
    public static int OctalToDecimal(int octal)
    {
        int decimal=0;
        int i=0;
        while(octal!=0)
        {
            decimal+=(octal%10)*Power(8, i);
            i++;
            octal/=10;
        }
        return decimal;
    }
    public static String OctalToBinary(int octal){
        int decimal=OctalToDecimal(octal);
        String binary=DecimalToBinary(decimal);
        return binary;
    }
    public static String OctalToHexadecimal(int octal){
        int decimal=OctalToDecimal(octal);
        String hexa=DecimalToHexadecimal(decimal);
        return hexa;
    }
    public static String HexadecimalToBinary(String hexa)
    {
        String hexaarr[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String binary="";
        for(int i=0;i<hexa.length();i++)
        {
            binary+=hexaarr[Character.digit(hexa.charAt(i), 16)];
        }
        return binary;
    }
    public static int HexadecimaltoDecimal(String hexa)
    {
        String binary=HexadecimalToBinary(hexa);
        int hexaStringCovertToInt=Integer.parseInt(binary);
        int decimal=BinaryToDecimal(hexaStringCovertToInt);
        return decimal;
    }
    public static String HexadecimalToOctal(String hexa)
    {
        String binary=HexadecimalToBinary(hexa);
        int hexaStringCovertToInt=Integer.parseInt(binary);
        String octal=BinaToOctal(hexaStringCovertToInt);
        return octal;
    }
    public static int Power(int base,int baseExpoValve)
    {
        int powervalue=1;
        for(int i=0;i<baseExpoValve;i++)
        {
            powervalue*=base;
        }
        return powervalue;
    }
}
