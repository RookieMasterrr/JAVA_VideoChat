package Client;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;



public class chatGUI{
	static JFrame aFrame;
	static JTextArea EditArea;
	static JTextArea RecArea;
	static JButton aButton;
	static JLabel who;
	static JButton videoChatBUtton;
	public chatGUI() {
		aFrame = new JFrame("J_GUI");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		aFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		EditArea = new JTextArea();
		EditArea.setBounds(10, 205, 255, 113);
		contentPane.add(EditArea);

		RecArea = new JTextArea();
		RecArea.setBounds(10, 51, 255, 113);
		contentPane.add(RecArea);

		aButton = new JButton("发送");
		aButton.setBounds(280, 246, 154, 36);
		aButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					System.out.println("You Clicked the aButton");
					CCommunicator.sendChatText(EditArea.getText());
				}catch(IOException aException){
				}
			}
		});
		contentPane.add(aButton);

		videoChatBUtton = new JButton("视频通话");
		videoChatBUtton.setBounds(280,290,154,36);
		videoChatBUtton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					// Send the UDPInfomations
					System.out.println("You Want Video chat");
					CCommunicator.sendChatText("VideoRequest:@|"+"localhost:9900"+"@|Ending");

				}catch(IOException aException){
				}
			}
		});
		contentPane.add(videoChatBUtton);


		who = new JLabel("someone");
		who.setBounds(280, 87, 92, 36);
		contentPane.add(who);

		JLabel lblNewLabel_1 = new JLabel("接收区");
		lblNewLabel_1.setBounds(10, 26, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("发送区");
		lblNewLabel_2.setBounds(10, 180, 54, 15);
		contentPane.add(lblNewLabel_2);



		aFrame.setSize(500,500);
		aFrame.setAlwaysOnTop(true);
		aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new chatGUI();
	}
}
