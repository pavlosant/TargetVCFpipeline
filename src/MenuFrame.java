import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNoFileSelected;
	private JTextField txtNoOutputFolder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setTitle("Targeted Panel VCF Filtering Pipeline");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 16, 134, 136);
		contentPane.add(scrollPane);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect.setBounds(6, 37, 87, 29);
		contentPane.add(btnSelect);
		
		JLabel lblPleseSelectVcf = new JLabel("1.Please Select VCF folder");
		lblPleseSelectVcf.setBounds(6, 20, 169, 16);
		contentPane.add(lblPleseSelectVcf);
		
		JLabel lblPleaseSelectKnown = new JLabel("2. Please select known variants file");
		lblPleaseSelectKnown.setBounds(6, 164, 214, 16);
		contentPane.add(lblPleaseSelectKnown);
		
		txtNoFileSelected = new JTextField();
		txtNoFileSelected.setText("No File Selected");
		txtNoFileSelected.setBounds(120, 185, 271, 28);
		contentPane.add(txtNoFileSelected);
		txtNoFileSelected.setColumns(10);
		
		JButton btnSelect_1 = new JButton("Select");
		btnSelect_1.setBounds(0, 186, 98, 29);
		contentPane.add(btnSelect_1);
		
		JLabel lblPleaseSelect = new JLabel("3. Please select Output Folder");
		lblPleaseSelect.setBounds(10, 227, 210, 16);
		contentPane.add(lblPleaseSelect);
		
		JButton button = new JButton("Select");
		button.setBounds(0, 243, 98, 29);
		contentPane.add(button);
		
		txtNoOutputFolder = new JTextField();
		txtNoOutputFolder.setText("No Output Folder Selected");
		txtNoOutputFolder.setColumns(10);
		txtNoOutputFolder.setBounds(120, 242, 271, 28);
		contentPane.add(txtNoOutputFolder);
	}
}
