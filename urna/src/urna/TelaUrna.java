package urna;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.io.File;



public class TelaUrna extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUrna frame = new TelaUrna();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaUrna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = DefaultComponentFactory.getInstance().createTitle("Simulador Da Urna Eletrônica");
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(103, 24, 494, 31);
		contentPane.add(title);
		
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(192, 192, 192));
		panel1.setBounds(10, 88, 631, 484);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setEditable(false);
		textField.setBounds(146, 174, 118, 33);
		panel1.add(textField);
		textField.setColumns(10);
		
	
		JLabel nome = DefaultComponentFactory.getInstance().createLabel("Nome:");
		nome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		nome.setBounds(35, 246, 118, 34);
		panel1.add(nome);
		
		JLabel num = DefaultComponentFactory.getInstance().createLabel("Numero:");
		num.setFont(new Font("Tahoma", Font.PLAIN, 26));
		num.setBounds(35, 174, 101, 33);
		panel1.add(num);
		
		JLabel partido = DefaultComponentFactory.getInstance().createLabel("Partido:");
		partido.setFont(new Font("Tahoma", Font.PLAIN, 26));
		partido.setBounds(35, 309, 111, 33);
		panel1.add(partido);
		
		JLabel presiTitle = DefaultComponentFactory.getInstance().createLabel("Presidente(a):");
		presiTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		presiTitle.setBounds(35, 83, 196, 33);
		panel1.add(presiTitle);
		
		JLabel vicePresidente = DefaultComponentFactory.getInstance().createLabel("Vice-President(a):");
		vicePresidente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		vicePresidente.setBounds(35, 380, 215, 33);
		panel1.add(vicePresidente);
		
		JLabel nomeOut = DefaultComponentFactory.getInstance().createLabel("");
		nomeOut.setFont(new Font("Tahoma", Font.PLAIN, 26));
		nomeOut.setHorizontalAlignment(SwingConstants.LEFT);
		nomeOut.setBounds(143, 248, 294, 30);
		panel1.add(nomeOut);
		
		JLabel partidoOut = DefaultComponentFactory.getInstance().createLabel("");
		partidoOut.setHorizontalAlignment(SwingConstants.LEFT);
		partidoOut.setFont(new Font("Tahoma", Font.PLAIN, 26));
		partidoOut.setBounds(146, 311, 333, 29);
		panel1.add(partidoOut);
		
		JLabel viceOut = DefaultComponentFactory.getInstance().createLabel("");
		viceOut.setHorizontalAlignment(SwingConstants.LEFT);
		viceOut.setFont(new Font("Tahoma", Font.PLAIN, 26));
		viceOut.setBounds(254, 381, 270, 30);
		panel1.add(viceOut);
		
		JLabel statusVoto = DefaultComponentFactory.getInstance().createLabel("");
		statusVoto.setFont(new Font("Tahoma", Font.PLAIN, 26));
		statusVoto.setHorizontalAlignment(SwingConstants.LEFT);
		statusVoto.setBounds(216, 83, 405, 33);
		panel1.add(statusVoto);
		
		JLabel img = DefaultComponentFactory.getInstance().createLabel("");
		img.setFont(new Font("Tahoma", Font.PLAIN, 26));
		img.setIcon(new ImageIcon(""));
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setBounds(390, 174, 215, 180);
		panel1.add(img);
		
		
		
		Panel panel2 = new Panel();
		panel2.setBackground(new Color(0, 0, 0));
		panel2.setBounds(650, 134, 321, 438);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		Button branco = new Button("Branco");
		branco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusVoto.setText("Voce votou em branco!");
			}
		});
		branco.setBounds(10, 359, 99, 69);
		panel2.add(branco);
		branco.setFont(new Font("Dialog", Font.PLAIN, 20));
		branco.setBackground(new Color(255, 255, 255));
		branco.setForeground(new Color(0, 0, 0));
		
		Button confirmar = new Button("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String input = textField.getText();		
				
				
				if (input.equals("13")){
					
					statusVoto.setText("Voce votou com Sucesso!");


			            try {
			                // Carregando o arquivo de áudio
			                File arquivoDeAudio = new File("C:\\Users\\caio_giaretton\\POO\\Uber\\urna\\src\\urna\\confirma.wav");
			                Clip clip = AudioSystem.getClip();
			                clip.open(AudioSystem.getAudioInputStream(arquivoDeAudio));

			                // Reproduzindo o som
			                clip.start();

			                // Aguarda a reprodução terminar
			                Thread.sleep(clip.getMicrosecondLength() / 1000);

			                // Parando a reprodução
			                clip.stop();
			                clip.close();
			            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e1) {
			                e1.printStackTrace();
			            }

					
					
				}else {
					statusVoto.setText("Voce votou Nulo!");
				};
				
				if (input.isEmpty()) {
					statusVoto.setText("Opcao Invalida!");
				}

			}
		});
		confirmar.setBounds(219, 359, 92, 69);
		panel2.add(confirmar);
		confirmar.setFont(new Font("Dialog", Font.PLAIN, 20));
		confirmar.setBackground(new Color(0, 255, 0));
		
		Button corrigir = new Button("Corrigir");
		corrigir.setBounds(115, 359, 98, 69);
		panel2.add(corrigir);
		corrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				nomeOut.setText("");
				partidoOut.setText("");
				viceOut.setText("");
				statusVoto.setText("");
				img.setIcon(new ImageIcon(""));
				
				
				
			}
		});
		corrigir.setFont(new Font("Dialog", Font.PLAIN, 20));
		corrigir.setBackground(new Color(255, 255, 0));
		
		Button button1 = new Button("1");
		button1.setBounds(42, 23, 64, 69);
		panel2.add(button1);
		button1.setBackground(new Color(0, 0, 0));
		button1.setForeground(new Color(255, 255, 255));
		button1.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = textField.getText();
				String aux;
				aux = textField.getText();
				textField.setText(aux+"1");
				
					if (textField.getText().equals("13")) {
					
					nomeOut.setText("Lulamolusco");
					partidoOut.setText("Abacaxi");
					viceOut.setText("Patrick");
					img.setFont(new Font("Tahoma", Font.PLAIN, 26));
					img.setIcon(new ImageIcon("C:\\Users\\caio_giaretton\\POO\\Uber\\urna\\src\\urna\\lula.jpg"));
					img.setHorizontalAlignment(SwingConstants.CENTER);
					img.setBounds(390, 174, 215, 180);
					panel1.add(img);
					
				}
		            try {
		                // Carregando o arquivo de áudio
		                File arquivoDeAudio = new File("C:\\Users\\caio_giaretton\\POO\\Uber\\urna\\src\\urna\\bot.wav");
		                Clip clip = AudioSystem.getClip();
		                clip.open(AudioSystem.getAudioInputStream(arquivoDeAudio));

		                // Reproduzindo o som
		                clip.start();

		                // Aguarda a reprodução terminar
		                Thread.sleep(clip.getMicrosecondLength() / 1000);

		                // Parando a reprodução
		                clip.stop();
		                clip.close();
		            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e1) {
		                e1.printStackTrace();
		            }
				
			}
		});
		
		
		Button button2 = new Button("2");
		button2.setBounds(128, 23, 64, 69);
		panel2.add(button2);
		button2.setForeground(new Color(255, 255, 255));
		button2.setFont(new Font("Dialog", Font.PLAIN, 30));
		button2.setBackground(new Color(0, 0, 0));
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"2");

				
			}
		});
		
		Button button3 = new Button("3");
		button3.setBounds(211, 23, 64, 69);
		panel2.add(button3);
		button3.setBackground(new Color(0, 0, 0));
		button3.setFont(new Font("Dialog", Font.PLAIN, 30));
		button3.setForeground(new Color(255, 255, 255));
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String input = textField.getText();
				String aux;
				aux = textField.getText();
				textField.setText(aux+"3");
				
					if (textField.getText().equals("13")) {
					
					nomeOut.setText("Lulamolusco");
					partidoOut.setText("Abacaxi");
					viceOut.setText("Patrick");
					img.setFont(new Font("Tahoma", Font.PLAIN, 26));
					img.setIcon(new ImageIcon("C:\\Users\\caio_giaretton\\POO\\Uber\\urna\\src\\urna\\lula.jpg"));
					img.setHorizontalAlignment(SwingConstants.CENTER);
					img.setBounds(390, 174, 215, 180);
					panel1.add(img);


					
				}
				
			}
		});
		
		Button button4 = new Button("4");
		button4.setBounds(42, 106, 64, 69);
		panel2.add(button4);
		button4.setFont(new Font("Dialog", Font.PLAIN, 30));
		button4.setForeground(new Color(255, 255, 255));
		button4.setBackground(new Color(0, 0, 0));
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"4");

				
			}
		});
	
		
		Button button5 = new Button("5");
		button5.setBounds(128, 106, 64, 69);
		panel2.add(button5);
		button5.setBackground(new Color(0, 0, 0));
		button5.setForeground(new Color(255, 255, 255));
		button5.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"5");
				
			}
		});
		
		Button button6 = new Button("6");
		button6.setBounds(211, 106, 64, 69);
		panel2.add(button6);
		button6.setForeground(new Color(255, 255, 255));
		button6.setFont(new Font("Dialog", Font.PLAIN, 30));
		button6.setBackground(new Color(0, 0, 0));
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"6");
				
			}
		});
		
		
		Button button7 = new Button("7");
		button7.setBounds(42, 192, 64, 69);
		panel2.add(button7);
		button7.setBackground(new Color(0, 0, 0));
		button7.setFont(new Font("Dialog", Font.PLAIN, 30));
		button7.setForeground(new Color(255, 255, 255));
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"7");
				
			}
		});
		
		
		Button button8 = new Button("8");
		button8.setBounds(128, 192, 64, 69);
		panel2.add(button8);
		button8.setBackground(new Color(0, 0, 0));
		button8.setFont(new Font("Dialog", Font.PLAIN, 30));
		button8.setForeground(new Color(255, 255, 255));
		
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"8");
				
			}
		});
		
		Button button9 = new Button("9");
		button9.setBounds(211, 192, 64, 69);
		panel2.add(button9);
		button9.setBackground(new Color(0, 0, 0));
		button9.setFont(new Font("Dialog", Font.PLAIN, 30));
		button9.setForeground(new Color(255, 255, 255));
		
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"9");
				
			}
		});
		
		Button button0 = new Button("0");
		button0.setBounds(128, 272, 64, 69);
		panel2.add(button0);
		button0.setBackground(new Color(0, 0, 0));
		button0.setFont(new Font("Dialog", Font.PLAIN, 30));
		button0.setForeground(new Color(255, 255, 255));
		
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux;
				aux = textField.getText();
				textField.setText(aux+"0");
				
			}
		});
		
		
		JLabel justica = DefaultComponentFactory.getInstance().createTitle("Justiça");
		justica.setHorizontalAlignment(SwingConstants.CENTER);
		justica.setFont(new Font("Tahoma", Font.PLAIN, 30));
		justica.setBounds(808, 24, 163, 31);
		contentPane.add(justica);
		
		JLabel eleitoral = DefaultComponentFactory.getInstance().createTitle("Eleitoral");
		eleitoral.setHorizontalAlignment(SwingConstants.CENTER);
		eleitoral.setFont(new Font("Tahoma", Font.PLAIN, 30));
		eleitoral.setBounds(818, 66, 140, 31);
		contentPane.add(eleitoral);
		
		JLabel imgJE = DefaultComponentFactory.getInstance().createLabel("");
		imgJE.setIcon(new ImageIcon("C:\\Users\\caio_giaretton\\POO\\Uber\\urna\\src\\urna\\img.png"));
		imgJE.setHorizontalAlignment(SwingConstants.CENTER);
		imgJE.setBounds(650, 11, 158, 117);
		contentPane.add(imgJE);
	}
}
