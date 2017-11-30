package Controller;

import View.View_Pedido;
import View.View_Principal;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Controlador_Pedido {

    //Objeto de la interfaz Pedido
    View_Pedido Pedido = new View_Pedido();

    //Objeto de la clase Controlador_Producto
    Controlador_Producto ctr_Producto;

    //Objeto de la clase Controlador_Proveedor
    Controlador_Proveedor ctr_Proveedor;

    //Variables para guardar la posicion de la ventana
    private int x, y;

    //Variable para el Nombre de quien esta usando el aplicativo
    private static String Usuario;

    //Constructor
    Controlador_Pedido() {
    }

    //Metodo para iniciar la interfaz
    public void Iniciar() {
        Cargar();
    }

    //Metodo para cargar los componentes de la interfaz
    private void Cargar() {
        CargarInterfaz();
        CargarBotones();
    }

    //Metodo para Cargar la Interfaz
    private void CargarInterfaz() {
        Pedido.setTitle("Pedido");
        Pedido.setLocationRelativeTo(null);
        Pedido.setResizable(false);
        Pedido.setVisible(true);
    }

    //Metodo para cargar los botones de la interfaz
    private void CargarBotones() {
        BotonMover();
        BotonAtras();
        BotonMinimizar();
    }

    //Carga y modificacion del Boton Salir
    private void BotonAtras() {
        Pedido.lblAtras.setToolTipText("<html><h4>Cerrar</html>");
        Pedido.lblAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Pedido.hide();
                Controlador_Principal ctr_Principal = new Controlador_Principal(Usuario);
                ctr_Principal.Iniciar();
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Pedido.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mover la interfaz 
                Pedido.setLocation(Pedido.getLocation().x + evt.getX() - x, Pedido.getLocation().y + evt.getY() - y);
            }
        });
        Pedido.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }
    
    //Carga y modificacion del Boton Minimizar
    private void BotonMinimizar() {
        Pedido.lblMinizar.setToolTipText("<html><h4>Minimizar</html>");
        Pedido.lblMinizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Pedido.setExtendedState(ICONIFIED); //Minimiza la ventana
            }
        });
    }

    /**
     * Metodo para asignar un usuario a la ventana
     *
     * @param Usuario
     */
    public void setUsuario(String Usuario) {
        Controlador_Pedido.Usuario = Usuario;
    }
}
