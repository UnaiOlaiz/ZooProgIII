package Ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BaseDeDatos.VisualizarBD;
import Zoo.Animal;

public class VentanaAdministrador extends JFrame{
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	// Lista de trabajadores
    private JList<String> listaTrabajadores;

    // Área para mostrar datos del trabajador
    private JTextArea datosTrabajador;
    private JTabbedPane tabbedPane;
    private JTable tablaAnimales;
    private JLabel labelRecursos;
    private JTextArea areaBalances;
	private JProgressBar progressAgua;
	private JProgressBar progresscomida;
	public VentanaAdministrador(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Administrador");
        setBounds(500, 300, 700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        tabbedPane = new JTabbedPane();
        
        // Panel tabla animales
        JPanel panel1 = new JPanel();
        ArrayList<Animal> animales = VisualizarBD.visualizarAnimales();
//        animales.forEach(animal -> {
//        	System.out.println(animal);
//        });
        
        DefaultTableModel modelo = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        	
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Hábitat");
        
        animales.forEach(animal -> {
        	modelo.addRow(new Object[] {animal.getId_animal(), animal.getNombre(), animal.getEspecie(), animal.getFecha_nacimiento(), animal.getHabitat()});
        });
        
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (row % 2 == 0) {
					comp.setBackground(new Color(240, 240, 240));
				} else {
					comp.setBackground(Color.WHITE);
				}
				return comp;
			}
        	
        };
        
        DefaultTableCellRenderer colRenderer = new DefaultTableCellRenderer() {
        	
        	@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				Object id = table.getValueAt(row, 0);
				setHorizontalAlignment(JLabel.CENTER);
				setVerticalAlignment(JLabel.CENTER);
				if (id != null && id.equals(value)) {
					comp.setFont(comp.getFont().deriveFont(Font.BOLD));
				} else {
					comp.setFont(comp.getFont().deriveFont(Font.PLAIN));
				}
				return comp;
			}
        };
        
        tablaAnimales = new JTable(modelo);
        tablaAnimales.getTableHeader().setReorderingAllowed(false);
        
        for (int i = 0; i< tablaAnimales.getColumnCount(); i++) {
        	tablaAnimales.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        tablaAnimales.getColumnModel().getColumn(0).setCellRenderer(colRenderer);
        tablaAnimales.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaAnimales.getColumnModel().getColumn(1).setPreferredWidth(100);
        
        DefaultTableCellRenderer heaCellRenderer = new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				setBackground(new Color(70, 130, 180));
				setForeground(Color.WHITE);
				setFont(new Font("Arial", Font.BOLD, 12));
				return comp;
			}
        	
        };
        tablaAnimales.getTableHeader().setDefaultRenderer(heaCellRenderer);
        
        panel1.add(new JScrollPane(tablaAnimales), BorderLayout.CENTER);
        
        tabbedPane.addTab("Gestión Animales", panel1);
        
        // Pestaña 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        progressAgua = new JProgressBar(0, 100);
        progressAgua.setStringPainted(true);
        actualizarAgua();
       
        progresscomida = new JProgressBar(0, 100);
        progresscomida.setStringPainted(true);
        actualizarComida();
        
        panel2.add(progressAgua);
        panel2.add(progresscomida);
        
		tabbedPane.addTab("Gestión Recursos", panel2);
		
		
        JPanel panel3 = new JPanel();
        DefaultTableModel modelo2 = new DefaultTableModel() { 

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        	
        };
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Ingresos");
        modelo2.addColumn("Gastos");
        modelo2.addColumn("Resultado");
        
        Random random = new Random();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JANUARY, 1);
        Date fechaInicial = calendar.getTime();
        
        for (int i = 0; i < 30; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date fecha = calendar.getTime();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(fecha);

            int ingresos = random.nextInt(1000);
            int gastos = random.nextInt(1000);
            int resultado = ingresos - gastos;
 
            modelo2.addRow(new Object[]{fechaFormateada, ingresos, gastos, resultado});
        }
        
        
        DefaultTableCellRenderer rendererColor = new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				int resultado = Integer.parseInt(table.getValueAt(row, 3).toString());
				setHorizontalAlignment(JLabel.CENTER);
				setVerticalAlignment(JLabel.CENTER);
                if (resultado < 0) {
                    comp.setBackground(Color.RED);
                } else {
                    comp.setBackground(Color.GREEN);
                }

                return comp;
			}
        	
        };
        
        DefaultTableCellRenderer headerRendererCabecera = new DefaultTableCellRenderer() {
        	
        	@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				setBackground(new Color(70, 130, 180));
				setForeground(Color.WHITE);
				setFont(new Font("Arial", Font.BOLD, 12));
				return comp;
			}
        };
        
        JTable tabla2 = new JTable(modelo2);
        tabla2.getTableHeader().setReorderingAllowed(false);
        tabla2.getTableHeader().setDefaultRenderer(headerRendererCabecera);
        panel3.add(new JScrollPane(tabla2), BorderLayout.CENTER);
        
        DefaultTableCellRenderer cellRenderer2 = new DefaultTableCellRenderer();
        cellRenderer2.setHorizontalAlignment(JLabel.CENTER);
        
        for (int i = 0; i<tabla2.getColumnCount(); i++) {
        	tabla2.getColumnModel().getColumn(i).setCellRenderer(cellRenderer2);
        }
        
        tabla2.getColumnModel().getColumn(3).setCellRenderer(rendererColor);
        
		tabbedPane.addTab("Gestión balances", panel3);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        btnVolver = new JButton("VOLVER");
        btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);
        
        
        setVisible(true);
	}
	
	
	private void actualizarComida() {
	    int porcentajeComida = new Random().nextInt(101);
	    progresscomida.setValue(porcentajeComida);
	    progresscomida.setString("Nivel de alimentos: " + porcentajeComida + "%");

	    if (tabbedPane.getTabCount() > 1) {
	    	Component componenteRecursos = tabbedPane.getComponentAt(1);

		    if (componenteRecursos instanceof JPanel) {
		        JPanel panelRecursos = (JPanel) componenteRecursos;

		        for (Component comp : panelRecursos.getComponents()) {
		            if (comp instanceof JPanel) {
		                JPanel panelComida = (JPanel) comp;
		                
		                for (Component subComp : panelComida.getComponents()) {
		                    if (subComp instanceof JLabel) {
		                        JLabel labelComida = (JLabel) subComp;
		                        labelComida.setText("Nivel de alimentos: " + porcentajeComida + "%");
		                    }
		                }
		            }
		        }
		    }
	    }
	}

	private void actualizarAgua() {
	    int porcentajeAgua = new Random().nextInt(101);
	    progressAgua.setValue(porcentajeAgua);
	    progressAgua.setString("Nivel de agua: " + porcentajeAgua + "%");

	    if (tabbedPane.getTabCount() > 1) {
	    	Component componenteRecursos = tabbedPane.getComponentAt(1);

		    if (componenteRecursos instanceof JPanel) {
		        JPanel panelRecursos = (JPanel) componenteRecursos;

		        for (Component comp : panelRecursos.getComponents()) {
		            if (comp instanceof JPanel) {
		                JPanel panelAgua = (JPanel) comp;

		                for (Component subComp : panelAgua.getComponents()) {
		                    if (subComp instanceof JLabel) {
		                        JLabel labelAgua = (JLabel) subComp;
		                        labelAgua.setText("Nivel de agua: " + porcentajeAgua + "%");
		                    }
		                }
		            }
		        }
		    }
	    }
	}


}
