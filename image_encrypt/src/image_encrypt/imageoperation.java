package image_encrypt;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class imageoperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
			f.setTitle("Image encryption");
			f.setSize(500,500);
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Font fo=new Font("Roboto",Font.BOLD,25);
			//-----------------------------------------
			JButton button=new JButton();
			button.setText("open image");
			button.setFont(fo);
			//----------------------------------------
			JTextField tex=new JTextField(10);
			tex.setFont(fo);
			
			//----------------------------------------
			f.setLayout(new FlowLayout());
			f.add(button);
			f.add(tex);
			f.setVisible(true);
			//-----------------------------------------
			button.addActionListener(e->{
					int x=Integer.parseInt(tex.getText());
					operate(x);
			
			});
			

	}

	private static void operate(int x) {
		// TODO Auto-generated method stub
		JFileChooser fl=new JFileChooser();
		fl.showOpenDialog(null);
		File file=fl.getSelectedFile();
		try {
			FileInputStream fis=new FileInputStream(file);
			byte data[]=new byte[fis.available()];
			fis.read(data);
			int i=0;
			for(byte b:data) {
				data[i++]=(byte)(b^x);
			}
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "done");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
