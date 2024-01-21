package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Zoo.VisitanteAntiguo;
import Zoo.ZOO;

public class VentanaTaquillero extends JFrame {
    protected JFrame vActual, vAnterior;
    protected JButton btnVolver, btnCalcularIngresos, btnAplicarDescuento, btnNuevaCompra;
    protected JPanel pSur, pCentral, pDescuento;
    protected JTextField txtNumEntradas, txtIngresos, txtCodigoDescuento;
    protected JLabel lblNumEntradas, lblTipoEntrada, lblIngresos, lblDescuentoAplicado, lblLogo;
    protected JComboBox<String> cmbTipoEntrada;
    protected JLabel lblDineroRecibido, lblDevolver;
    protected JTextField txtDineroRecibido, txtDevolver;
    protected JButton btnCalcularCambio;

    private static final long serialVersionUID = 1L;
    private double totalIngresos; 

    public ZOO zoo;

    public VentanaTaquillero(JFrame va) {
        super();
        vActual = this;
        vAnterior = va;
        setTitle("Ventana Taquillero");
        setBounds(500, 300, 700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,250);
        setResizable(false);

        getContentPane().setBackground(new Color(70, 130, 180));

        btnVolver = new JButton("VOLVER");
        btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.addActionListener((e) -> {
            vAnterior.setVisible(true);
            vActual.dispose();
        });

        btnCalcularIngresos = new JButton("Agregar Entradas");
        btnCalcularIngresos.setForeground(new Color(70, 130, 180));
        btnCalcularIngresos.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnCalcularIngresos.addActionListener((e) -> {
            calcularIngresos();
        });

        btnAplicarDescuento = new JButton("Aplicar Descuento");
        btnAplicarDescuento.setForeground(new Color(70, 130, 180));
        btnAplicarDescuento.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnAplicarDescuento.addActionListener((e) -> {
            aplicarDescuento();
        });

        btnNuevaCompra = new JButton("Nueva Compra");
        btnNuevaCompra.setForeground(new Color(70, 130, 180));
        btnNuevaCompra.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNuevaCompra.addActionListener((e) -> {
            nuevaCompra();
        });
        
        btnCalcularCambio = new JButton("Calcular Cambio");
        btnCalcularCambio.setForeground(new Color(70, 130, 180));
        btnCalcularCambio.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnCalcularCambio.addActionListener((e) -> {
            calcularCambio();
        });
        
        pSur = new JPanel();
        pSur.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pSur.add(btnCalcularIngresos);
        pSur.add(btnAplicarDescuento);
        pSur.add(btnNuevaCompra);
        pSur.add(btnVolver);
        pSur.add(btnCalcularCambio);
        pSur.setBackground(new Color(70, 130, 180));

        pCentral = new JPanel();
        pCentral.setLayout(new FlowLayout());
        lblNumEntradas = new JLabel("Número de entradas vendidas:");
        lblNumEntradas.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNumEntradas.setForeground(new Color(70, 130, 180));
        txtNumEntradas = new JTextField(10);
        lblTipoEntrada = new JLabel("Tipo de entrada:");
        lblTipoEntrada.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblTipoEntrada.setForeground(new Color(70, 130, 180));
        cmbTipoEntrada = new JComboBox<>(new String[]{"Normal", "Familiar", "Joven", "Jubilado"});
        lblIngresos = new JLabel("Total a pagar:");
        lblIngresos.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblIngresos.setForeground(new Color(70, 130, 180));
        txtIngresos = new JTextField(10);
        txtIngresos.setEditable(false);
        lblDineroRecibido = new JLabel("Dinero Recibido:");
        lblDineroRecibido.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDineroRecibido.setForeground(new Color(70, 130, 180));
        txtDineroRecibido = new JTextField(10);
        lblDevolver = new JLabel("Devolver:");
        lblDevolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDevolver.setForeground(new Color(70, 130, 180));
        txtDevolver = new JTextField(10);
        txtDevolver.setEditable(false);

        
        pCentral.add(lblNumEntradas);
        pCentral.add(txtNumEntradas);
        pCentral.add(lblTipoEntrada);
        pCentral.add(cmbTipoEntrada);
        pCentral.add(lblIngresos);
        pCentral.add(txtIngresos);
        pCentral.add(lblDineroRecibido);
        pCentral.add(txtDineroRecibido);
        pCentral.add(lblDevolver);
        pCentral.add(txtDevolver);
        pCentral.setBackground(Color.white);
       

        pDescuento = new JPanel();
        pDescuento.setBackground(Color.white);
        pDescuento.setLayout(new FlowLayout());
        lblDescuentoAplicado = new JLabel("Descuento aplicado:");
        lblDescuentoAplicado.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDescuentoAplicado.setForeground(new Color(70, 130, 180));
        txtCodigoDescuento = new JTextField(10);
        pDescuento.add(lblDescuentoAplicado);
        pDescuento.add(txtCodigoDescuento);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pSur, BorderLayout.SOUTH);
        getContentPane().add(pCentral, BorderLayout.CENTER);
        getContentPane().add(pDescuento, BorderLayout.NORTH);
        

        totalIngresos = 0; 

        setVisible(true);
    }

    // Método obtener precio de la entrada del visitante
    public double precioEntrada(String tipoEntrada) {
        double precio = 0.0;
        switch (tipoEntrada) {
            case "Normal":
                precio = 25.0;
                break;
            case "Familiar":
                precio = 50.0;
                break;
            case "Joven":
                precio = 15.0;
                break;
            case "Jubilado":
                precio = 10.0;
                break;
            default:
                break;
        }
		return precio;

    }

    // Método para calcular los ingresos totales
    public void calcularIngresos() {
        try {
            int numEntradas = Integer.parseInt(txtNumEntradas.getText());
            String tipoEntrada = (String) cmbTipoEntrada.getSelectedItem();
            double precioFinal = precioEntrada(tipoEntrada);
            double ingresos = numEntradas * precioFinal;
            totalIngresos += ingresos; // Accumulate the total income
            txtIngresos.setText(String.format("%.2f", totalIngresos));
        } catch (NumberFormatException e) {
            
            txtIngresos.setText("Error");
        }
    }

    // Método para aplicar descuento con código
    public void aplicarDescuento() {
        try {
            String codigoDescuento = txtCodigoDescuento.getText().trim().toLowerCase();

            switch (codigoDescuento) {
                case "familia":
                    aplicarDescuentoFamilia();
                    break;
                case "antiguo":
                    aplicarDescuentoAntiguo();
                    break;
                default:
                    txtIngresos.setText("Código inválido");
                    break;
            }
        } catch (NumberFormatException e) {
            txtIngresos.setText("Error");
        }
    }
    
 // Método para aplicar descuento a familias numerosas (20%)
    private void aplicarDescuentoFamilia() {
        try {
            int numEntradas = Integer.parseInt(txtNumEntradas.getText());
            String tipoEntrada = (String) cmbTipoEntrada.getSelectedItem();
            double precioFinal = precioEntrada(tipoEntrada);
            
            
            double descuento = 0.20; 
            double ingresosConDescuento = (numEntradas * precioFinal) * (1 - descuento);
            
            totalIngresos = ingresosConDescuento; 
            txtIngresos.setText(String.format("%.2f", totalIngresos));
        } catch (NumberFormatException e) {
            txtIngresos.setText("Error");
        }
    }

    // Método para aplicar descuento a visitantes antiguos (15%)
    private void aplicarDescuentoAntiguo() {
        try {
            int numEntradas = Integer.parseInt(txtNumEntradas.getText());
            String tipoEntrada = (String) cmbTipoEntrada.getSelectedItem();
            double precioFinal = precioEntrada(tipoEntrada);
            
            
            double descuento = 0.15; // 15%
            double ingresosConDescuento = (numEntradas * precioFinal) * (1 - descuento);
            
            totalIngresos = ingresosConDescuento; 
            txtIngresos.setText(String.format("%.2f", totalIngresos));
        } catch (NumberFormatException e) {
            txtIngresos.setText("Error");
        }
    }
    

    // Método para iniciar una nueva compra
    public void nuevaCompra() {
        totalIngresos = 0; 
        txtNumEntradas.setText(""); 
        txtIngresos.setText("0.0"); 
        txtDineroRecibido.setText("");
        txtDevolver.setText("0.0");
        
    }
    
    public void calcularCambio() {
        try {
            double dineroRecibido = Double.parseDouble(txtDineroRecibido.getText());
            double cambio = dineroRecibido - totalIngresos;

            txtDevolver.setText(String.format("%.2f", cambio));
        } catch (NumberFormatException e) {
            txtDevolver.setText("Error");
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaTaquillero(null);
            }
        });
    }
}

