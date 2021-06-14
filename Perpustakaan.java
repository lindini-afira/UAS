package GUI_JDBC;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.Blob;


public class Perpustakaan {

	
	protected static final String Perpustakaan = null;
	JFrame frmPerpustakaan;
	private JTextField nama;
	private JTextField nim;
	private JTextField kobu;
	private static JTable tableMahasiswa;
	private static JTable tableCoverBuku;
	private JTextArea tglpk;
	
	ArrayList<Hasil> perpus = new ArrayList<Hasil>();
	private JLabel txtnama;
	private JLabel txtnim;
	private JLabel txtkobu;
	private JLabel txttglp;
	private JLabel txttglk;
	
	

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static Connection con() {
		try {
			String url = "jdbc:mysql://localhost:3306/peminjaman";
			String user = "root";
		    String password = "";
		    
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    } catch(ClassNotFoundException e){
		    	e.printStackTrace();
		    }
		    
		    return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Gagal Koneksi ke Database "+e, "Alert!!!", 0);
		}
		return con();
	}
	
	private void kosongkanForm() {
		txtnama.setText(null);
		txtnim.setText(null);
		txtkobu.setText(null);
		txttglp.setText(null);
		txttglk.setText(null);
	}
	
	public static void showDataPeminjamFromDB() {
		try {
			String query = "select * from data_mahasiswa by no_mahasiswa";
			Connection con = con();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			DefaultTableModel table = (DefaultTableModel)tableMahasiswa.getModel();
	        table.setRowCount(0);
	        
	        String [] data = new String [5];
	        while(rs.next()) {
	        	data[0] = rs.getString("Nama");
	        	data[1] = rs.getString("No_Mahasiswa");
	        	data[2] = rs.getString("Kd_Buku");
	        	
	        	table.addRow(data);
	        }	
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Gagal Insert Data\n"+e);
		}
	}
	
	
	public static void showDataBukuFromDB() {
		try {
			String query = "select * from data_buku by Kd_Buku";
			Connection con = con();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			DefaultTableModel table = (DefaultTableModel)tableCoverBuku.getModel();
	        table.setRowCount(0);
	        
	        String [] data = new String [5];
	        while(rs.next()) {
	        	data[0] = rs.getString("Kd_Buku");
	        	data[1] = rs.getString("Cover");        	
	        	
	        	table.addRow(data);
	        }	
		}catch (Exception e) {
			System.out.println("Gagal Insert Data\n"+e);
		}
	}

	/**
	 * Create the application.
	 */
	
	
	// Menampilakn data_mahasiswa dari database ke tabel
	public class dataMahasiswa{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		public ResultSet temukan(String i) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/peminjam", "root", "");
				ps = con.prepareStatement("select * from data_mahasiswa where No_Mahasiswa= ?");
				ps = setString(i);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}return rs;
		}

		private PreparedStatement setString(String i) {
			// TODO Auto-generated method stub
			return null;
		}

		

		
	}
	
	//Menampilakn data_buku dari database ke tabel cover buku
	public class dataBuku{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		public ResultSet temukan(String s) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/peminjam", "root", "");
				ps = con.prepareStatement("select * from data_buku where Kd_Buku= ?");
				ps = setString(s);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				System.out.println("Proses jika koneksi sukses");
			}return rs;
		}

		private PreparedStatement setString(String s) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
		public Perpustakaan() {
			initialize();
			showDataBukuFromDB();
			
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmPerpustakaan = new JFrame();
		frmPerpustakaan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frmPerpustakaan.setBackground(new Color(0, 139, 139));
		frmPerpustakaan.setTitle("PERPUSTAKAAN");
		frmPerpustakaan.getContentPane().setBackground(new Color(0, 206, 209));
		frmPerpustakaan.setBounds(100, 100, 909, 521);
		frmPerpustakaan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNewLabel = new JLabel("Data Peminjaman Buku");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(69, 11, 195, 21);
		frmPerpustakaan.getContentPane().add(lblNewLabel);
		
		JLabel Nama = new JLabel("Nama");
		Nama.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Nama.setBounds(10, 55, 46, 21);
		frmPerpustakaan.getContentPane().add(Nama);
		
		JLabel NIM = new JLabel("NIM");
		NIM.setFont(new Font("Times New Roman", Font.BOLD, 15));
		NIM.setBounds(10, 105, 46, 21);
		frmPerpustakaan.getContentPane().add(NIM);
		
		JLabel KOBU = new JLabel("Kode Buku");
		KOBU.setFont(new Font("Times New Roman", Font.BOLD, 15));
		KOBU.setBounds(10, 205, 88, 21);
		frmPerpustakaan.getContentPane().add(KOBU);
		
		JLabel TGLP = new JLabel("Tanggal Pinjam");
		TGLP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TGLP.setBounds(10, 265, 113, 21);
		frmPerpustakaan.getContentPane().add(TGLP);
		
		JLabel TGLK = new JLabel("Tanggal Kembali");
		TGLK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TGLK.setBounds(10, 325, 113, 21);
		frmPerpustakaan.getContentPane().add(TGLK);
		
		nama = new JTextField();
		nama.setBounds(141, 53, 205, 26);
		frmPerpustakaan.getContentPane().add(nama);
		nama.setColumns(10);
		
		nim = new JTextField();
		nim.setBounds(141, 103, 136, 26);
		frmPerpustakaan.getContentPane().add(nim);
		nim.setColumns(10);
		
		kobu = new JTextField();
		kobu.setColumns(10);
		kobu.setBounds(141, 203, 88, 26);
		frmPerpustakaan.getContentPane().add(kobu);
		
		JFormattedTextField tglp = new JFormattedTextField();
		DateFormat tglFormat = new SimpleDateFormat("dd/MM/yyy");
		DateFormatter df = new DateFormatter(tglFormat);
		JFormattedTextField formatTglp = new JFormattedTextField(df);
		formatTglp.setValue(new Date(0));
		tglp.setBounds(141, 263, 136, 26);
		frmPerpustakaan.getContentPane().add(tglp);
		
		JFormattedTextField tglk = new JFormattedTextField();
		DateFormat tglFormat1 = new SimpleDateFormat("dd/MM/yyy");
		DateFormatter df1 = new DateFormatter(tglFormat1);
		JFormattedTextField formatTglp1 = new JFormattedTextField(df);
		formatTglp.setValue(new Date(0));
		tglk.setBounds(141, 326, 136, 26);
		frmPerpustakaan.getContentPane().add(tglk);
		
		JScrollPane mahasiswa = new JScrollPane();
		mahasiswa.setBounds(397, 52, 465, 125);
		frmPerpustakaan.getContentPane().add(mahasiswa);
		
		tableMahasiswa = new JTable();
		tableMahasiswa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nama", "NIM", "Foto"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		mahasiswa.setViewportView(tableMahasiswa);
		
		JScrollPane buku = new JScrollPane();
		buku.setBounds(397, 202, 264, 150);
		frmPerpustakaan.getContentPane().add(buku);
		tableCoverBuku = new JTable();
		tableCoverBuku.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kode_Buku", "Foto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		buku.setViewportView(tableCoverBuku);
		
		JButton save = new JButton("SAVE");
		save.setFont(new Font("Times New Roman", Font.BOLD, 18));
		save.setBounds(10, 382, 89, 36);
		frmPerpustakaan.getContentPane().add(save);
		
		JButton delete = new JButton("DELETE");
		delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		delete.setBounds(141, 382, 123, 36);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableMahasiswa.setRowHeight(0);
				tableMahasiswa.setToolTipText(null);
				tableCoverBuku.setRowHeight(0);
				tableCoverBuku.setToolTipText(null);
			}
		});
			
		frmPerpustakaan.getContentPane().add(delete);
		
		JTextArea tglpk = new JTextArea();
		tglpk.setBounds(681, 204, 181, 82);
		frmPerpustakaan.getContentPane().add(tglpk);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Perpustakaan().frmPerpustakaan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

