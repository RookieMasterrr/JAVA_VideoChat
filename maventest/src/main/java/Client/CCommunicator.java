// GUI and Socket Communicator
package Client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
public class CCommunicator {
    static Client aClient;//?????????????socket
    static Socket chatSocket;//????socket
    public static void LoginSentUsernameAndPasswordFromGUItoSocket (String username, String password)throws IOException{
        String tempString = username+password;
        LoginGUI.aFrame.dispose();
        
		// ClientMenuGUI
        Thread t1 = new Thread(new test(aClient.getLocalAddress().toString()));
        t1.start();
        
		// 
		Thread t2 = new Thread(new test2());
        t2.start();
        
    }


    public static void ClientListening() throws IOException {
    	while(true) {
    		System.out.println("TextFromServer");
    		String Info = aClient.Read();
			System.out.println(Info);
    		System.out.println(Info);
    		if(Info.indexOf("Userlist")!=-1) {
    			addButton(Info);
    		}else {
    			
    		}
    	}
    }
    
	
    public static void addButton(String ButtonInfo) {
        String aString = ButtonInfo;

		System.out.println("aString.length="+aString.length());

		// ???????
		String temp2 = aString.replace("Userlist", "");
        String temp3 = (temp2.replace("[", ""));
        String temp4 = temp3.replace("]", "");
        String temp5 = temp4.replace(" ", "");
        String []iplist = temp5.split(",");

        for(String i:iplist){
        	
			JButton otherClientButton = new JButton(i);
        	otherClientButton.addActionListener(new ActionListener() {
				
				// ???°????????
				@Override
				public void actionPerformed(ActionEvent e) {
					String []IpAndPort = i.split(":");
					
					String MyIp = IpAndPort[0];
					String strport = IpAndPort[1];
					
					//????????????
					strport=strport.substring(0,4);
					
					int MyPort = Integer.parseInt(strport);

					// ???????????
					try {

						chatSocket = new Socket(MyIp, MyPort);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

					

					// chatGUI???
					Thread chatGUIthread = new Thread(new chatGUIThread());
					chatGUIthread.start();

					Thread aThread = new Thread(new ListeningChatInfoThread(chatSocket));
					aThread.start();


					
				}
			});
        	ClientMenuGUI.aJPanel.add(otherClientButton);
			// refresh GUI
        	ClientMenuGUI.aJPanel.revalidate();
        }    
        }

	public static void sendChatText(String text) throws IOException{
		Server.Write(chatSocket, text);
	}

	public static void removeChatInfoToGUI(String textString){
		chatGUI.RecArea.setText(textString);
	}


}




class test implements Runnable{
	static String whoami;
	public test(String aString){
		whoami = aString;
	}
	@Override
	public void run() {
		new ClientMenuGUI(whoami);
	}
}

class test2 implements Runnable{
	@Override
	public void run(){
    	try {
			CCommunicator.ClientListening();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class chatGUIThread implements Runnable{
	@Override
	public void run(){
		new chatGUI();
	}
}