package Client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class divideAndMergeByteArray {

   public static void main(String[] args) throws IOException{
        byte []byte1 = "阿瑟cx东大时代".getBytes();
        byte []byte2 = "顶顶顶顶22132".getBytes();
        byte []byte3 = (MergeTwoBytes(byte1, byte2));
        for (byte a : byte1) {
            System.out.println(a);
        }
        System.out.println();
        for (byte b : byte2) {
            System.out.println(b);
        }
        System.out.println();
        for (byte c : byte3) {
            System.out.println(c);
        }
        System.out.println();
    }

   public static byte[] MergeTwoBytes(byte bytes1[],byte bytes2[])throws IOException{
    String s1 = new String(bytes1,"ISO_8859_1");
    String s2 = new String(bytes2,"ISO_8859_1");

    String s3 = s1 + s2;

    byte bytes3[] = s3.getBytes("ISO_8859_1");
    return bytes3;
}
    public static String[] divideTheBytesToMainParts(byte bytes[],int eachLength) throws UnsupportedEncodingException {
        int total_Length = bytes.length;
        String allString = new String(bytes,"ISO_8859_1");

        int howmany=0;
        if(total_Length%eachLength==0){
            howmany=total_Length/eachLength;
        }else{
            howmany=(total_Length/eachLength)+1;
        }

        String []PartsList = new String[howmany];
        for(int i=0; i<howmany; i++){
            if(i!=howmany-1){
                String eachPart = allString.substring(i*eachLength,(i+1)*(eachLength));
                PartsList[i] = eachPart;
            }else{
                String eachPart = allString.substring(i*eachLength,allString.length());
                PartsList[i] = eachPart;
            }
        }
        return PartsList;
    }



    public void displayThreeBytes(byte bytes1[],byte bytes2[],byte bytes3[]){
        for (byte a : bytes1) {
            System.out.println(a);
        }
        System.out.println();
        for (byte b : bytes2) {
            System.out.println(b);
        }
        System.out.println();
        for (byte c : bytes3) {
            System.out.println(c);
        }
        System.out.println();
    }
}