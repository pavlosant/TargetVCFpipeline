import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;



public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNoFileSelected;
	private JTextField txtNoOutputFolder;
JFileChooser fc;
JList list;
DefaultListModel model;
public static File[] Filelist;


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

	public static void VCF_2_BED(File input_vcf){
	
	}
	
	
	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		JFileChooser fc=new JFileChooser();
		JFileChooser chooser2=new JFileChooser();
		JFileChooser chooser3=new JFileChooser();

		setTitle("Targeted Panel VCF Filtering Pipeline");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//final File folder;
		fc.setCurrentDirectory(new java.io.File(""));
		fc.setDialogTitle("Select VCF directory");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		JButton btnSelect = new JButton("Select");
		chooser2.setCurrentDirectory(new java.io.File(""));
		chooser2.setDialogTitle("Select known variant BED file");
		chooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser2.setAcceptAllFileFilterUsed(false);
		chooser3.setCurrentDirectory(new java.io.File(""));
		chooser3.setDialogTitle("Select output directory");
		chooser3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser3.setAcceptAllFileFilterUsed(false);
		
		
		
		
		//scrollPane.setToolTipText(fc.getCurrentDirectory().toString());
		
		btnSelect.setBounds(6, 37, 87, 29);
		contentPane.add(btnSelect);
		
		JLabel lblPleseSelectVcf = new JLabel("1.Please Select VCF folder");
		lblPleseSelectVcf.setBounds(6, 20, 169, 16);
		contentPane.add(lblPleseSelectVcf);
		
		JLabel lblPleaseSelectKnown = new JLabel("2. Please select known variants file");
		lblPleaseSelectKnown.setBounds(6, 164, 254, 16);
		contentPane.add(lblPleaseSelectKnown);
		
		txtNoFileSelected = new JTextField();
		txtNoFileSelected.setText("No File Selected");
		txtNoFileSelected.setBounds(204, 185, 567, 28);
		contentPane.add(txtNoFileSelected);
		txtNoFileSelected.setColumns(10);
		
		JButton btnSelect_1 = new JButton("Select");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSelect_1){
					int returnVal=chooser2.showOpenDialog(MenuFrame.this);
				File bedfile=new File(chooser2.getSelectedFile().getAbsolutePath());
				txtNoFileSelected.setText(bedfile.toString());
				}
			}
		});
		btnSelect_1.setBounds(0, 186, 98, 29);
		contentPane.add(btnSelect_1);
		
		JLabel lblPleaseSelect = new JLabel("3. Please select Output Folder");
		lblPleaseSelect.setBounds(10, 227, 210, 16);
		contentPane.add(lblPleaseSelect);
		
		JButton button = new JButton("Select");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					int returnVal=chooser3.showOpenDialog(MenuFrame.this);
				File outputfolder=new File(chooser3.getSelectedFile().getAbsolutePath());
				txtNoOutputFolder.setText(outputfolder.toString());
				}
				
			}
		});
		button.setBounds(0, 243, 98, 29);
		contentPane.add(button);
		
		txtNoOutputFolder = new JTextField();
		txtNoOutputFolder.setText("No Output Folder Selected");
		txtNoOutputFolder.setColumns(10);
		txtNoOutputFolder.setBounds(204, 242, 567, 28);
		contentPane.add(txtNoOutputFolder);
		model = new DefaultListModel();
		JList list_1 = new JList(model);
		list_1.setBounds(204, 20, 549, 121);
		contentPane.add(list_1);
		
		JScrollPane scrollPane = new JScrollPane(list_1);
		scrollPane.setBounds(204, 20, 503, 103);
		contentPane.add(scrollPane);
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSelect){
					int returnVal=fc.showOpenDialog(MenuFrame.this);
				File folder=new File(fc.getSelectedFile().getAbsolutePath());
					//vcf_files.addAll(folder.listFiles().);  
					//textArea.appendfolder.listFiles().);
			// File[] listoffiles=folder.listFiles();
			 File[] listoffiles = folder.listFiles(new FilenameFilter() {
				    public boolean accept(File folder, String name) {
				        return name.toLowerCase().endsWith(".vcf");
				    }
				});
			 for(int i=0;i < listoffiles.length;i++){
				 model.addElement(listoffiles[i]);

			 }
			 
			 for(int i=0;i < listoffiles.length;i++){
				 VCF_2_BED(listoffiles[i]);

			 }
			 
			 
			//	for (int i = 0; i < list.getModel().getSize(); i++) {
		      //      Object item = list.getModel().getElementAt(i);
		        //    System.out.println("Item = " + item);
		        //}
				//	 list_1=new JList(listoffiles);
					//scrollPane.add(list);
					

				}
				

			}
			
		});
	
		
		
		
	}
}
