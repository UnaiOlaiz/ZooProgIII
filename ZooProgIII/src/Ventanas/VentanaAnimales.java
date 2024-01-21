package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BaseDeDatos.VisualizarBD;
import Zoo.Animal;

public class VentanaAnimales extends JFrame{
	private JFrame vActual, vAnterior;
	private JButton btnVolver;
	private JPanel pSur;
	
	public VentanaAnimales (JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle( "Información sobre los animales del ZOO" );
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Vamos a crear un JTable para insertar todos los animales sacados de
		 * la BD, y luego un JComboBox con las características del animal dentro,
		 * al seleccionar la característica los animales se ordenarán en la lista 
		 * por esa categoría ( por habitat, por ejemplo ).
		 * Los animales serán aleatoriamente introducidos al principio.	
		 */
		
		JPanel panelTabla = new JPanel();
		DefaultTableModel modeloTabla = new DefaultTableModel();
		// Añadimos las columnas a la tabla
		modeloTabla.addColumn( "ID" );
		modeloTabla.addColumn( "Nombre" );
		modeloTabla.addColumn( "Especie" );
		modeloTabla.addColumn( "Habitat" );
		modeloTabla.addColumn( "Fecha Nacimiento" );
		JTable tabla = new JTable(modeloTabla);
		
		// Importante para más adelante, para que se ordenen los animales al ser seleccionado el criterio
		tabla.setAutoCreateRowSorter(true);
		
		// Aquí ya cargamos los animales
		ArrayList<Animal> animales = (ArrayList<Animal>) VisualizarBD.visualizarAnimales();
		// System.out.println(animales);
		
		// Preferiblemente vamos a optar por añadir a los animales aleatoriamente
		// Así al ordenarlos el efecto será mas agradable visualmente
		Random random = new Random();
		ArrayList<Animal> animalesCopia = new ArrayList<>(animales); // Creamos un segundo array para evitar errores
		for( int i = 0; i<animalesCopia.size(); i++ ) {
			if (!animalesCopia.isEmpty()) {
				int indiceAleatorioAnimales = random.nextInt( animalesCopia.size() );
				Animal animalAleatorio = animalesCopia.get(indiceAleatorioAnimales);
				modeloTabla.addRow(new Object[] {
						animalAleatorio.getId_animal(),
						animalAleatorio.getNombre(),
						animalAleatorio.getEspecie(),
						animalAleatorio.getHabitat(),
						animalAleatorio.getFecha_nacimiento()

				});
				animalesCopia.remove(indiceAleatorioAnimales); // Quitamos al animal anteriormente seleccionado para que no salga más de una vez

			}
		}
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane, BorderLayout.CENTER);
		
		pSur = new JPanel();
		
		JLabel labelOrdenar = new JLabel( "Ordenar animales por: " );
		pSur.add(labelOrdenar);
		
		// comboAleatorio
		JComboBox<String> comboOpcionesAleatorias = new JComboBox<>();
		comboOpcionesAleatorias.addItem( "ID animal" );
		comboOpcionesAleatorias.addItem( "Nombre" );
		comboOpcionesAleatorias.addItem( "Especie" );
		comboOpcionesAleatorias.addItem( "Fecha Nacimiento" );
		comboOpcionesAleatorias.addItem( "Habitat" );
		pSur.add(comboOpcionesAleatorias);
		
		// Ahora a configurar el comboBox:
		comboOpcionesAleatorias.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JComboBox<String> combo = (JComboBox<String>) e.getSource();
		        String criterio = (String) combo.getSelectedItem();
		        TableRowSorter<TableModel> sorter = new TableRowSorter<>(modeloTabla);
		        tabla.setRowSorter(sorter);

		        // para comparar según el criterio:
		        switch (criterio) {
		            case "ID animal":
		                sorter.setComparator(0, Comparator.naturalOrder());
		                break;
		            case "Nombre":
		                sorter.setComparator(1, Comparator.naturalOrder());
		                break;
		            case "Especie":
		                sorter.setComparator(2, Comparator.naturalOrder());
		                break;
		            case "Habitat":
		                sorter.setComparator(3, Comparator.naturalOrder());
		                break;
		            case "Fecha Nacimiento":
		                sorter.setComparator(4, new Comparator<String>() {
		                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		                    @Override
		                    public int compare(String fecha1, String fecha2) {
		                        LocalDate date1 = LocalDate.parse(fecha1, formatter);
		                        LocalDate date2 = LocalDate.parse(fecha2, formatter);
		                        return date1.compareTo(date2);
		                    }
		                });
		                break;
		        }

		        sorter.sort();
		    }
		});

		
		btnVolver = new JButton("VOLVER");
		getContentPane().add(pSur, BorderLayout.SOUTH);
		pSur.add(btnVolver);
		
		btnVolver.addActionListener((e)->{
			vAnterior.setVisible(true);
			vActual.dispose();
		});
		
		setVisible(true);
	}
	
	//Informacion de todos los animales del zoo

}
