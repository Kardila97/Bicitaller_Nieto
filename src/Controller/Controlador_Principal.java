package Controller;

import View.View_Principal;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 *
 * @author Kevin Duvan Ardila Lopera
 * @author Jenifer Tatiana Castro Galvis
 */
public class Controlador_Principal {

    //Variable para almacenar el usuario que inicia el aplicativo
    private static String Usuario;

    //Objeto de la interfaz Principal
    private final View_Principal Principal = new View_Principal();

    //Variables para guardar la posicion de la ventana
    private int x, y;

    /**
     * Constructor que recibe el parametro Usuario para guardar la persona que
     * inicia sesion
     *
     * @param Usuario
     */
    public Controlador_Principal(String Usuario) {
        Controlador_Principal.Usuario=Usuario;
    }
    
    public Controlador_Principal(){
    }

    //Metodo para generar la interfaz
    public void Iniciar() {
        Cargar();
    }

    //Metodo para cargar todos los componentes de la interfaz
    private void Cargar() {
        CargarInterfaz();
        CargarBotones();
    }

    //Cargar la interfaz Principal
    private void CargarInterfaz() {
        Principal.setTitle("Control de inventario");
        Principal.setLocationRelativeTo(null);
        Principal.setResizable(false);
        Principal.setVisible(true);
        Principal.lblBienvenido.setText(Principal.lblBienvenido.getText() + " " + Usuario);

    }

    //Metodo para cargar los botones y sus funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMinimizar();
        BotonMover();
        BotonCliente();
        BotonProveedor();
        BotonPedido();
        BotonProducto();
        BotonReporte();
        BotonInventario();
        BotonReparacion();
        BotonVenta();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Principal.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Principal.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                System.exit(0);
            }
        });
    }

    //Carga y modificacion del Boton Minimizar
    private void BotonMinimizar() {
        Principal.lblMinizar.setToolTipText("<html><h4>Minimizar</html>");
        Principal.lblMinizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Principal.setExtendedState(ICONIFIED); //Minimiza la ventana
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Principal.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mueve la interfaz en la pantalla
                Principal.setLocation(Principal.getLocation().x + evt.getX() - x, Principal.getLocation().y + evt.getY() - y);

            }
        });
        Principal.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {

                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Carga y modificacion del Boton Cliente
    private void BotonCliente() {
        Principal.lblAgregarCliente.setToolTipText("<html><h4>CLIENTE</html>");
        Principal.lblAgregarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Controlador_Cliente ctr_Cliente = new Controlador_Cliente(Principal);
                ctr_Cliente.Iniciar();
            }
        });
    }

    //Carga y modificacion del Boton Proveedor
    private void BotonProveedor() {
        Principal.lblAgregarProveedor.setToolTipText("<html><h4>PROVEEDOR</html>");
        Principal.lblAgregarProveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Controlador_Proveedor ctr_Proveedor = new Controlador_Proveedor(Principal);
                ctr_Proveedor.Iniciar();
            }
        });
    }

    //Carga y modificacion del Boton Pedido
    private void BotonPedido() {
        Principal.lblRegistrarPedido.setToolTipText("<html><h4>PEDIDOS</html>");
        Principal.lblRegistrarPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Controlador_Pedido ctr_Pedido=new Controlador_Pedido();
                Principal.hide();
                ctr_Pedido.setUsuario(Usuario);
                ctr_Pedido.Iniciar();
            }
        });
    }

    //Carga y modificacion del Boton Producto
    private void BotonProducto() {
        Principal.lblAgregarProducto.setToolTipText("<html><h4>PRODUCTOS</html>");
        Principal.lblAgregarProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Controlador_Producto ctr_Producto = new Controlador_Producto(Principal);
                ctr_Producto.Iniciar();
            }
        });
    }

    //Carga y modificacion del Boton Reporte
    private void BotonReporte() {
        Principal.lblGenerarReporte.setToolTipText("<html><h4>REPORTES</html>");
        Principal.lblGenerarReporte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //Conttrolador de la vista reporte
            }
        });
    }

    //Carga y modificacion del Boton Inventario
    private void BotonInventario() {
        Principal.lblVerInventario.setToolTipText("<html><h4>INVENTARIO</html>");
        Principal.lblVerInventario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Controlador_Inventario ctr_Inventario = new Controlador_Inventario(Principal);
                ctr_Inventario.Iniciar();
            }
        });
    }

    //Carga y modificacion del Boton Reparacion
    private void BotonReparacion() {
        Principal.lblIniciarReparacion.setToolTipText("<html><h4>REPARACION</html>");
        Principal.lblIniciarReparacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //Controlador de la vista reparacion
            }
        });
    }

    //Carga y modificacion del Boton Venta
    private void BotonVenta() {
        Principal.lblIniciarVenta.setToolTipText("<html><h4>VENTA</html>");
        Principal.lblIniciarVenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //Controlador de la vista venta
            }
        });
    }

    /**
     * Metodo para asignar un usuario a la ventana
     * @param Usuario 
     */
    public void setUsuario(String Usuario){
        Controlador_Principal.Usuario=Usuario;
    }
}
