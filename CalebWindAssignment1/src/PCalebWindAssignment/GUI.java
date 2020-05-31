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
import javax.swing.JOptionPane;

public class GUI extends JFrame {

	//create the JPanels my content is stored on
	private JPanel contentPane;
	private JPanel panelSearch = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel individualRecord = new JPanel();
	
	private ChartPanel myChartPanel;
	
	//create the tabbed pane
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	
	//create the table
	private JTable table;
	
	//this is the position the individual page works on. When the user clicks first, it sets it to 0 for example.
	private int indivPos = 0;
	
	//create the array list we will be using to store the values we have read in
	private static ArrayList<Location> locations;
	
	//create the table
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {,},
			new String[]
			{
				"Town", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Year Average"
			});

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(locations);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		}

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
	private JTextField txtSearchInput;
	private JTextField txtSearchJan;
	private JTextField txtSearchFeb;
	private JTextField txtSearchMar;
	private JTextField txtSearchTown;
	private JTextField txtSearchJun;
	private JTextField txtSearchMay;
	private JTextField txtSearchApr;
	private JTextField txtSearchJul;
	private JTextField txtSearchAug;
	private JTextField txtSearchSep;
	private JTextField txtSearchOct;
	private JTextField txtSearchNov;
	private JTextField txtSearchDec;
	private JTextField txtSearchAvg;
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
		

		tabbedPane.addTab("Individual Record", null, individualRecord, null);
		individualRecord.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(6, 5, 975, 15);
		individualRecord.add(table_1);
		
		tabbedPane.addTab("Search", null, panelSearch, null);
		panelSearch.setLayout(null);

		drawMainTable();
		createButtons();
		createLabels();
		createTextBoxes();
		createALineChartTab();
		fillOutText();
	}
	
	public void drawMainTable()
	{
		tm.setRowCount(0); //clear the table
		
		for (int i = 0; i < locations.size(); i++)
		{
			Object[] object = new Object[14];
			object[0] = locations.get(i).getLocationName();
			object[13] = locations.get(i).calcYearAverage();
		
			for (int j = 1; j < 13; j++)
			{
				object[j] = locations.get(i).getTemperatures().get(j - 1);
			}
		
			tm.addRow(object);
		}
	}
	
	public void fillOutSearch(int searchPos)
	{
		txtSearchTown.setText(locations.get(searchPos).getLocationName());
		txtSearchJan.setText(Double.toString((locations.get(searchPos).getTemperatures().get(0))));
		txtSearchFeb.setText(Double.toString((locations.get(searchPos).getTemperatures().get(1))));
		txtSearchMar.setText(Double.toString((locations.get(searchPos).getTemperatures().get(2))));
		txtSearchApr.setText(Double.toString((locations.get(searchPos).getTemperatures().get(3))));
		txtSearchMay.setText(Double.toString((locations.get(searchPos).getTemperatures().get(4))));
		txtSearchJun.setText(Double.toString((locations.get(searchPos).getTemperatures().get(5))));
		txtSearchJul.setText(Double.toString((locations.get(searchPos).getTemperatures().get(6))));
		txtSearchAug.setText(Double.toString((locations.get(searchPos).getTemperatures().get(7))));
		txtSearchSep.setText(Double.toString((locations.get(searchPos).getTemperatures().get(8))));
		txtSearchOct.setText(Double.toString((locations.get(searchPos).getTemperatures().get(9))));
		txtSearchNov.setText(Double.toString((locations.get(searchPos).getTemperatures().get(10))));
		txtSearchDec.setText(Double.toString((locations.get(searchPos).getTemperatures().get(11))));
	}
	
	public void fillOutText()
	{
		txtTown.setText(locations.get(indivPos).getLocationName());
		txtJan.setText(Double.toString((locations.get(indivPos).getTemperatures().get(0))));
		txtFeb.setText(Double.toString((locations.get(indivPos).getTemperatures().get(1))));
		txtMar.setText(Double.toString((locations.get(indivPos).getTemperatures().get(2))));
		txtApr.setText(Double.toString((locations.get(indivPos).getTemperatures().get(3))));
		txtMay.setText(Double.toString((locations.get(indivPos).getTemperatures().get(4))));
		txtJun.setText(Double.toString((locations.get(indivPos).getTemperatures().get(5))));
		txtJul.setText(Double.toString((locations.get(indivPos).getTemperatures().get(6))));
		txtAug.setText(Double.toString((locations.get(indivPos).getTemperatures().get(7))));
		txtSep.setText(Double.toString((locations.get(indivPos).getTemperatures().get(8))));
		txtOct.setText(Double.toString((locations.get(indivPos).getTemperatures().get(9))));
		txtNov.setText(Double.toString((locations.get(indivPos).getTemperatures().get(10))));
		txtDec.setText(Double.toString((locations.get(indivPos).getTemperatures().get(11))));
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
		
		myChartPanel = new ChartPanel(chart);
		tabbedPane.add("Line Chart", myChartPanel);
	}
	
	private void createButtons()
	{
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(75, 70, 85, 21);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//search
				if (txtSearchInput.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Error, no input detected");
				}
				else
				{
					Location temploc = new Location(txtSearchInput.getText(), new ArrayList<Double>());
					int sPos = 0;
					for (Location location : locations) {
						if (temploc.compareTo(location) == 0)
						{
							fillOutSearch(sPos);
						}
						else
						{
							sPos++;
						}
						
					}
					if (sPos == 30)
					{
						JOptionPane.showMessageDialog(null, "Error, town not found");
					}
					
				}
				
				
			}
		});
		panelSearch.add(btnSearch);

		JButton btnSortAlphabetical = new JButton("Sort Alphabetical");
		btnSortAlphabetical.setBounds(10, 430, 149, 26);
		btnSortAlphabetical.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(locations);				
				drawMainTable();				
			}
		});
		panel_1.add(btnSortAlphabetical);
		
		JButton btnNewButton = new JButton("Sort by Average Temp");
		btnNewButton.setBounds(190, 433, 162, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(locations);				
				drawMainTable();				
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(214, 315, 85, 21);
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indivPos == locations.size() - 1)
				{
					indivPos = 0;
				}
				else
				{
					indivPos++;
				}
				fillOutText();
			}
		});
		individualRecord.add(btnNext);
		
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(119, 315, 85, 21);
		btnPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indivPos == 0)
				{
					indivPos = locations.size() - 1;
				}
				else
				{
					indivPos--;
				}
				fillOutText();
			}
		});
		individualRecord.add(btnPrevious);
		
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(24, 315, 85, 21);
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				indivPos = 0;
				fillOutText();
				
			}
		});
		individualRecord.add(btnFirst);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(309, 315, 85, 21);
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				indivPos = locations.size() - 1;
				fillOutText();
				
			}});
		individualRecord.add(btnLast);
	}
	
	private void createLabels()
	{
		JLabel lblJuly = new JLabel("July");
		lblJuly.setBounds(130, 126, 45, 13);
		individualRecord.add(lblJuly);
		
		JLabel lblAugust = new JLabel("August");
		lblAugust.setBounds(236, 126, 45, 13);
		individualRecord.add(lblAugust);
		
		JLabel lblSeptember = new JLabel("September");
		lblSeptember.setBounds(342, 126, 72, 13);
		individualRecord.add(lblSeptember);
		
		JLabel lblOctober = new JLabel("October");
		lblOctober.setBounds(448, 126, 57, 13);
		individualRecord.add(lblOctober);
		
		JLabel lblNovember = new JLabel("November");
		lblNovember.setBounds(554, 126, 72, 13);
		individualRecord.add(lblNovember);
		
		JLabel lblDecember = new JLabel("December");
		lblDecember.setBounds(660, 126, 66, 13);
		individualRecord.add(lblDecember);
		
		JLabel lblJanuary = new JLabel("January");
		lblJanuary.setBounds(130, 70, 45, 13);
		individualRecord.add(lblJanuary);
		
		JLabel lblFebruary = new JLabel("February");
		lblFebruary.setBounds(236, 70, 63, 13);
		individualRecord.add(lblFebruary);
		
		JLabel lblMarch = new JLabel("March");
		lblMarch.setBounds(342, 70, 45, 13);
		individualRecord.add(lblMarch);
		
		JLabel lblApril = new JLabel("April");
		lblApril.setBounds(448, 70, 45, 13);
		individualRecord.add(lblApril);
		
		JLabel lblMay = new JLabel("May");
		lblMay.setBounds(554, 70, 45, 13);
		individualRecord.add(lblMay);
		
		JLabel lblJune = new JLabel("June");
		lblJune.setBounds(660, 70, 45, 13);
		individualRecord.add(lblJune);

		JLabel lblSearch = new JLabel("Enter the name of the town you wish to search for:");
		lblSearch.setBounds(75, 24, 292, 13);
		panelSearch.add(lblSearch);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setBounds(24, 70, 45, 13);
		individualRecord.add(lblTown);
		
		JLabel lblNewLabel = new JLabel("Town");
		lblNewLabel.setBounds(75, 117, 45, 13);
		panelSearch.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("January");
		lblNewLabel_1.setBounds(75, 188, 45, 13);
		panelSearch.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("February");
		lblNewLabel_2.setBounds(198, 188, 71, 13);
		panelSearch.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("April");
		lblNewLabel_2_1.setBounds(446, 188, 45, 13);
		panelSearch.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("March");
		lblNewLabel_3.setBounds(323, 188, 45, 13);
		panelSearch.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("June");
		lblNewLabel_2_2.setBounds(693, 188, 45, 13);
		panelSearch.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("May");
		lblNewLabel_1_2.setBounds(570, 188, 45, 13);
		panelSearch.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("December");
		lblNewLabel_2_2_1.setBounds(693, 252, 79, 13);
		panelSearch.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("November");
		lblNewLabel_1_2_1.setBounds(570, 252, 71, 13);
		panelSearch.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("October");
		lblNewLabel_2_1_1.setBounds(446, 252, 71, 13);
		panelSearch.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("September");
		lblNewLabel_1_1_1.setBounds(323, 252, 71, 13);
		panelSearch.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("August");
		lblNewLabel_2_3.setBounds(198, 252, 45, 13);
		panelSearch.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("July");
		lblNewLabel_1_3.setBounds(75, 252, 45, 13);
		panelSearch.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Year Average");
		lblNewLabel_1_3_1.setBounds(75, 308, 96, 13);
		panelSearch.add(lblNewLabel_1_3_1);
	}
	
	private void createTextBoxes()
	{
		txtTown = new JTextField();
		txtTown.setBounds(24, 86, 96, 19);
		individualRecord.add(txtTown);
		txtTown.setColumns(10);
		
		txtJan = new JTextField();
		txtJan.setBounds(130, 86, 96, 19);
		individualRecord.add(txtJan);
		txtJan.setColumns(10);
		
		txtFeb = new JTextField();
		txtFeb.setBounds(236, 86, 96, 19);
		individualRecord.add(txtFeb);
		txtFeb.setColumns(10);
		
		txtMar = new JTextField();
		txtMar.setBounds(342, 86, 96, 19);
		individualRecord.add(txtMar);
		txtMar.setColumns(10);
		
		txtApr = new JTextField();
		txtApr.setBounds(448, 86, 96, 19);
		individualRecord.add(txtApr);
		txtApr.setColumns(10);
		
		txtMay = new JTextField();
		txtMay.setBounds(554, 86, 96, 19);
		individualRecord.add(txtMay);
		txtMay.setColumns(10);
		
		txtJun = new JTextField();
		txtJun.setBounds(660, 86, 96, 19);
		individualRecord.add(txtJun);
		txtJun.setColumns(10);
		
		txtJul = new JTextField();
		txtJul.setBounds(130, 140, 96, 19);
		individualRecord.add(txtJul);
		txtJul.setColumns(10);
		
		txtAug = new JTextField();
		txtAug.setBounds(236, 140, 96, 19);
		individualRecord.add(txtAug);
		txtAug.setColumns(10);
		
		txtSep = new JTextField();
		txtSep.setBounds(342, 140, 96, 19);
		individualRecord.add(txtSep);
		txtSep.setColumns(10);
		
		txtOct = new JTextField();
		txtOct.setBounds(448, 140, 96, 19);
		individualRecord.add(txtOct);
		txtOct.setColumns(10);
		
		txtNov = new JTextField();
		txtNov.setBounds(554, 140, 96, 19);
		individualRecord.add(txtNov);
		txtNov.setColumns(10);
		
		txtDec = new JTextField();
		txtDec.setBounds(660, 140, 96, 19);
		individualRecord.add(txtDec);
		txtDec.setColumns(10);
		
		txtSearchInput = new JTextField();
		txtSearchInput.setBounds(75, 41, 230, 19);
		panelSearch.add(txtSearchInput);
		txtSearchInput.setColumns(10);
		
		txtSearchJan = new JTextField();
		txtSearchJan.setBounds(75, 203, 96, 19);
		panelSearch.add(txtSearchJan);
		txtSearchJan.setColumns(10);
		
		txtSearchFeb = new JTextField();
		txtSearchFeb.setBounds(198, 203, 96, 19);
		panelSearch.add(txtSearchFeb);
		txtSearchFeb.setColumns(10);
		
		txtSearchMar = new JTextField();
		txtSearchMar.setBounds(323, 203, 96, 19);
		panelSearch.add(txtSearchMar);
		txtSearchMar.setColumns(10);
		
		txtSearchTown = new JTextField();
		txtSearchTown.setBounds(75, 132, 96, 19);
		panelSearch.add(txtSearchTown);
		txtSearchTown.setColumns(10);
		
		txtSearchJun = new JTextField();
		txtSearchJun.setColumns(10);
		txtSearchJun.setBounds(695, 203, 96, 19);
		panelSearch.add(txtSearchJun);
		
		txtSearchMay = new JTextField();
		txtSearchMay.setColumns(10);
		txtSearchMay.setBounds(570, 203, 96, 19);
		panelSearch.add(txtSearchMay);
		
		txtSearchApr = new JTextField();
		txtSearchApr.setColumns(10);
		txtSearchApr.setBounds(447, 203, 96, 19);
		panelSearch.add(txtSearchApr);
		
		txtSearchJul = new JTextField();
		txtSearchJul.setColumns(10);
		txtSearchJul.setBounds(75, 269, 96, 19);
		panelSearch.add(txtSearchJul);
		
		txtSearchAug = new JTextField();
		txtSearchAug.setColumns(10);
		txtSearchAug.setBounds(198, 269, 96, 19);
		panelSearch.add(txtSearchAug);
		
		txtSearchSep = new JTextField();
		txtSearchSep.setColumns(10);
		txtSearchSep.setBounds(323, 269, 96, 19);
		panelSearch.add(txtSearchSep);
		
		txtSearchOct = new JTextField();
		txtSearchOct.setColumns(10);
		txtSearchOct.setBounds(447, 269, 96, 19);
		panelSearch.add(txtSearchOct);
		
		txtSearchNov = new JTextField();
		txtSearchNov.setColumns(10);
		txtSearchNov.setBounds(570, 269, 96, 19);
		panelSearch.add(txtSearchNov);
		
		txtSearchDec = new JTextField();
		txtSearchDec.setColumns(10);
		txtSearchDec.setBounds(695, 269, 96, 19);
		panelSearch.add(txtSearchDec);
		
		txtSearchAvg = new JTextField();
		txtSearchAvg.setColumns(10);
		txtSearchAvg.setBounds(75, 321, 96, 19);
		panelSearch.add(txtSearchAvg);
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
