package Controller;

import Class.Inventario;
import Model.Model_Inventario;
import View.View_Inventario;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Controlador_Inventario {

    //Interfaz Inventario
    private final View_Inventario Inventario;

    //Variables para la posicion de la interfaz
    private int x, y;
    //Constructor

    public Controlador_Inventario(Frame frm) {
        Inventario = new View_Inventario(frm, true);
    }

    //Metodo para iniciar la interfaz
    /**
     * Inicia la interaz si y solo si se puede obtener una lista de productos
     */
    public void Iniciar() {
        if (CargarTabla()) {
            Cargar();
        } else {
            JOptionPane.showMessageDialog(Inventario,"El inventario se encuentra vacio","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Cargar componentes de la interfaz
    private void Cargar() {
        CargarBotones();
        CargarInterfaz();
    }

    //Cargar la interfaz Inventario
    private void CargarInterfaz() {
        Inventario.setLocationRelativeTo(null);
        Inventario.setResizable(false);
        Inventario.setTitle("Inventario");
        Inventario.setVisible(true);
    }

    //Metodo para cargar los botones y su funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMover();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Inventario.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Inventario.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Inventario.dispose();
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Inventario.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {

                //Mover la interfaz 
                Inventario.setLocation(Inventario.getLocation().x + evt.getX() - x, Inventario.getLocation().y + evt.getY() - y);
            }
        });
        Inventario.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Metodo para cargar y llenar la tabla
    private boolean CargarTabla() {
        Model_Inventario Mod_Inventario = new Model_Inventario();
        ArrayList<Inventario> Inven;
        Inven = Mod_Inventario.VerInventario();
        if (Inven != null && Inven.size()>0) {
            return ModeloTabla(Inven);

        } else {
            return false;
        }

    }

    //Metodo para llenar la tabla
    private boolean ModeloTabla(ArrayList<Inventario> Inven) {
        String Columnas[] = {"CODIGO", "DESCRIPCION", "CANTIDAD", "IVA", "VALOR VENTA"};
        DefaultTableModel Modelo = new DefaultTableModel(null, Columnas);
        Object[] filas = new Object[5];
        for (int i = 0; i < Inven.size(); i++) {
            filas[0] = Inven.get(i).getProducto().getCODIGO_PRODUCTO();
            filas[1] = Inven.get(i).getProducto().getDESCRIPCION_PRODUCTO();
            filas[2] = Inven.get(i).getProducto().getCANTIDAD_PRODUCTO();
            filas[3] = Inven.get(i).getProducto().getIVA_PRODUCTO();
            filas[4] = Inven.get(i).getValorVenta();
            Modelo.addRow(filas);
        }
        Inventario.tblInventario.setModel(Modelo);
        TamanoCeldas();
        CentrarCeldas();
        return true;
    }

    //Asignar un tamaño acorde a su contenido
    private void TamanoCeldas() {
        Inventario.tblInventario.getColumnModel().getColumn(0).setPreferredWidth(20);
        Inventario.tblInventario.getColumnModel().getColumn(1).setPreferredWidth(220);
        Inventario.tblInventario.getColumnModel().getColumn(2).setPreferredWidth(15);
        Inventario.tblInventario.getColumnModel().getColumn(3).setPreferredWidth(5);
        Inventario.tblInventario.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    //Centrar los datos de las celdas de la tabla
    private void CentrarCeldas() {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        Inventario.tblInventario.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        Inventario.tblInventario.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        Inventario.tblInventario.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        Inventario.tblInventario.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
    }
}
