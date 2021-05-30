package Client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramSocket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;

public class J_Video {
    public static ImageIcon recEachPicAndReturn(DatagramSocket aSocket) throws IOException{
            String howManysInfo = (new String(UDPServer.recComingPackagesNumsAndEachLength(aSocket)));
            String []Infos = howManysInfo.split(",");
            int Nums = Integer.parseUnsignedInt(Infos[0]);
            int eachLength = Integer.parseUnsignedInt(Infos[1]);
            int totalLength = Integer.parseUnsignedInt(Infos[2]);
            String finalString = "";
            for(int i=0; i<Nums; i++){
                if(i!=Nums-1){
                    finalString+=new String(UDPServer.recADataGramPacket(aSocket, eachLength),"ISO_8859_1");
                }else{
                    finalString+=new String(UDPServer.recADataGramPacket(aSocket, totalLength-((Nums-1)*eachLength)),"ISO_8859_1");
                }
            }
            byte []MergeBytes = finalString.getBytes("ISO_8859_1");
            InputStream aInputStream = new ByteArrayInputStream(MergeBytes);
            BufferedImage aimage = ImageIO.read(aInputStream);
            return new ImageIcon(aimage);
        }
}
