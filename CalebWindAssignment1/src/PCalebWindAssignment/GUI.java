package PCalebWindAssignment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int position = 0;
	
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {,
			},
			new String[] {
				"Town", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
			}
		);
	private DefaultTableModel tm2 = new DefaultTableModel(
			new Object[][] {,
			},
			new String[] {
				"Town", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
			}
		);
	
	private static ArrayList<Location> locations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(locations);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable table_1;
	private JTextField txtTown;
	private JTextField txtJan;
	private JTextField txtFeb;
	private JTextField txtMar;
	private JTextField txtApr;
	private JTextField txtMay;
	private JTextField txtJun;
	private JTextField txtJul;
	private JTextField txtAug;
	private JTextField txtSep;
	private JTextField txtOct;
	private JTextField txtNov;
	private JTextField txtDec;
	/**
	 * Create the frame.
	 */
	public GUI(ArrayList<Location> locations)
	{
		this.locations = locations;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1117, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBounds(5, 20, 992, 600);
		contentPane.add(tabbedPane);
		
		//grab the data
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Table", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 973, 395);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		JButton btnSort = new JButton("Sort Array");
		btnSort.setBounds(10, 430, 85, 21);
		btnSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(locations);				
				drawMainTable();				
			}
		});
		panel_1.add(btnSort);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Individual Record", null, panel, null);
		panel.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(6, 5, 975, 15);
		table_1.setModel(tm2);
		panel.add(table_1);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(214, 315, 85, 21);
		btnNext.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (position == locations.size() - 1)
				{
					position = 0;
				}
				else
				{
					position++;
				}
				fillOutText();
			}
		});
		panel.add(btnNext);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(119, 315, 85, 21);
		btnPrevious.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (position == 0)
				{
					position = locations.size() - 1;
				}
				else
				{
					position--;
				}
				fillOutText();
			}
		});
		panel.add(btnPrevious);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(24, 315, 85, 21);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position = 0;
				fillOutText();
				
			}
		});
		panel.add(btnFirst);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(309, 315, 85, 21);
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position = locations.size() - 1;
				fillOutText();
				
			}
		});
		panel.add(btnLast);
		
		txtTown = new JTextField();
		txtTown.setBounds(24, 86, 96, 19);
		panel.add(txtTown);
		txtTown.setColumns(10);
		
		txtJan = new JTextField();
		txtJan.setBounds(130, 86, 96, 19);
		panel.add(txtJan);
		txtJan.setColumns(10);
		
		txtFeb = new JTextField();
		txtFeb.setBounds(236, 86, 96, 19);
		panel.add(txtFeb);
		txtFeb.setColumns(10);
		
		txtMar = new JTextField();
		txtMar.setBounds(342, 86, 96, 19);
		panel.add(txtMar);
		txtMar.setColumns(10);
		
		txtApr = new JTextField();
		txtApr.setBounds(448, 86, 96, 19);
		panel.add(txtApr);
		txtApr.setColumns(10);
		
		txtMay = new JTextField();
		txtMay.setBounds(554, 86, 96, 19);
		panel.add(txtMay);
		txtMay.setColumns(10);
		
		txtJun = new JTextField();
		txtJun.setBounds(660, 86, 96, 19);
		panel.add(txtJun);
		txtJun.setColumns(10);
		
		txtJul = new JTextField();
		txtJul.setBounds(130, 140, 96, 19);
		panel.add(txtJul);
		txtJul.setColumns(10);
		
		txtAug = new JTextField();
		txtAug.setBounds(236, 140, 96, 19);
		panel.add(txtAug);
		txtAug.setColumns(10);
		
		txtSep = new JTextField();
		txtSep.setBounds(342, 140, 96, 19);
		panel.add(txtSep);
		txtSep.setColumns(10);
		
		txtOct = new JTextField();
		txtOct.setBounds(448, 140, 96, 19);
		panel.add(txtOct);
		txtOct.setColumns(10);
		
		txtNov = new JTextField();
		txtNov.setBounds(554, 140, 96, 19);
		panel.add(txtNov);
		txtNov.setColumns(10);
		
		txtDec = new JTextField();
		txtDec.setBounds(660, 140, 96, 19);
		panel.add(txtDec);
		txtDec.setColumns(10);
		
		JLabel lblJuly = new JLabel("July");
		lblJuly.setBounds(130, 126, 45, 13);
		panel.add(lblJuly);
		
		JLabel lblAugust = new JLabel("August");
		lblAugust.setBounds(236, 126, 45, 13);
		panel.add(lblAugust);
		
		JLabel lblSeptember = new JLabel("September");
		lblSeptember.setBounds(342, 126, 72, 13);
		panel.add(lblSeptember);
		
		JLabel lblOctober = new JLabel("October");
		lblOctober.setBounds(448, 126, 57, 13);
		panel.add(lblOctober);
		
		JLabel lblNovember = new JLabel("November");
		lblNovember.setBounds(554, 126, 72, 13);
		panel.add(lblNovember);
		
		JLabel lblDecember = new JLabel("December");
		lblDecember.setBounds(660, 126, 66, 13);
		panel.add(lblDecember);
		
		JLabel lblJanuary = new JLabel("January");
		lblJanuary.setBounds(130, 70, 45, 13);
		panel.add(lblJanuary);
		
		JLabel lblFebruary = new JLabel("February");
		lblFebruary.setBounds(236, 70, 63, 13);
		panel.add(lblFebruary);
		
		JLabel lblMarch = new JLabel("March");
		lblMarch.setBounds(342, 70, 45, 13);
		panel.add(lblMarch);
		
		JLabel lblApril = new JLabel("April");
		lblApril.setBounds(448, 70, 45, 13);
		panel.add(lblApril);
		
		JLabel lblMay = new JLabel("May");
		lblMay.setBounds(554, 70, 45, 13);
		panel.add(lblMay);
		
		JLabel lblJune = new JLabel("June");
		lblJune.setBounds(660, 70, 45, 13);
		panel.add(lblJune);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setBounds(24, 70, 45, 13);
		panel.add(lblTown);
		

		drawMainTable();
		createALineChartTab();
		fillOutText();
		
		
	}
	
	public void drawMainTable()
	{
		tm.setRowCount(0); //clear the table
		
		for (int i = 0; i < locations.size(); i++)
		{
			Object[] object = new Object[13];
			object[0] = locations.get(i).getLocationName();
		
			for (int j = 1; j < 13; j++)
			{
				object[j] = locations.get(i).getTemperatures().get(j - 1);
			}
		
			tm.addRow(object);
		}
		
	}
	
	public void fillOutText()
	{
		txtTown.setText(locations.get(position).getLocationName());
		txtJan.setText(Double.toString((locations.get(position).getTemperatures().get(0))));
		txtFeb.setText(Double.toString((locations.get(position).getTemperatures().get(1))));
		txtMar.setText(Double.toString((locations.get(position).getTemperatures().get(2))));
		txtApr.setText(Double.toString((locations.get(position).getTemperatures().get(3))));
		txtMay.setText(Double.toString((locations.get(position).getTemperatures().get(4))));
		txtJun.setText(Double.toString((locations.get(position).getTemperatures().get(5))));
		txtJul.setText(Double.toString((locations.get(position).getTemperatures().get(6))));
		txtAug.setText(Double.toString((locations.get(position).getTemperatures().get(7))));
		txtSep.setText(Double.toString((locations.get(position).getTemperatures().get(8))));
		txtOct.setText(Double.toString((locations.get(position).getTemperatures().get(9))));
		txtNov.setText(Double.toString((locations.get(position).getTemperatures().get(10))));
		txtDec.setText(Double.toString((locations.get(position).getTemperatures().get(11))));
		tm2.setRowCount(0); //clear the table
		
	}
		
	
    

	private void createALineChartTab()
	{
		XYDataset dataset = createDataset();
		
	
		
		JFreeChart chart = ChartFactory.createXYLineChart("Average Temperature From the Last 30 Years for each Month", "Month", "Temperature in oC", dataset);
		
		XYPlot plot = chart.getXYPlot();
		
		//x axis aka temperature
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		range.setRange(0, 22);
		range.setTickUnit(new NumberTickUnit(0.5));
		
		//y axis aka months
		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		domain.setRange(0, 11);
		domain.setTickUnit(new NumberTickUnit(1));
		domain.setVerticalTickLabels(true);
		
		ChartPanel myChartPanel = new ChartPanel(chart);
		tabbedPane.add("Line Chart", myChartPanel);
		
		
		
	}
	
	private XYDataset createDataset() 
	{
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		ArrayList<XYSeries> series = new ArrayList<XYSeries>();
		for (int i = 0; i < locations.size(); i++)
		{
			XYSeries temp = new XYSeries(locations.get(i).locationName);
			for (int j = 1; j < 13; j++) 
			{
				temp.add(j - 1, locations.get(i).getTemperatures().get(j - 1));
			}
			series.add(temp);
		}
		for (int i = 0; i < series.size(); i++) {
			dataset.addSeries(series.get(i));
		}
		
		return dataset;
	}
	

	
}
