package Client;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class J_WebCamTest {
    public static void openTheCamAndSendVideoToPort(String host,int port) throws IOException, InterruptedException {
        Webcam webcam = Webcam.getDefault();

        webcam.setViewSize(new Dimension(176,144));

        webcam.open();

        while(true){
            BufferedImage image = webcam.getImage();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image,"PNG",outputStream);
            byte []sendInfo = outputStream.toByteArray();


            int lengthOfEachPicese = 50000;

            String divide_result[] = divideAndMergeByteArray.divideTheBytesToMainParts(sendInfo,lengthOfEachPicese);


            UDPClient.sentADataGramPacket((divide_result.length+","+lengthOfEachPicese+","+sendInfo.length).getBytes(),"localhost",8800);
//                                                  发送包的的个数,每个包的长度,总长度
            for (String picesString:divide_result) {
                byte picesByte[] = picesString.getBytes("ISO_8859_1");
                UDPClient.sentADataGramPacket(picesByte,host,port);
                Thread.currentThread().sleep(500);//毫秒
            }
        }

    }
}
