package Controller;

import View.View_Login;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;

public class Controlador_Login {

    //Objeto de la interfaz Login
    private final View_Login Login = new View_Login();

    //Variables para guardar la posicion de la ventana
    private int x, y;

    //Metodo para Generar la interfaz
    public void Iniciar() {
        Cargar();
    }

    //Metodo para cargar todos los componentes de la interfaz
    private void Cargar() {
        CargarInterfaz();
        CargarBotones();
        CargarCajas();
    }

    //Cargar la interfaz login
    private void CargarInterfaz() {
        Login.setLocationRelativeTo(null);
        Login.setResizable(false);
        Login.setTitle("Login");
        Login.setVisible(true);
    }

    //Metodo para cargar los botones y su funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMinimizar();
        BotonMover();
        BotonIngresar();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Login.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Login.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblSalirClicked(evt);
            }
        });
    }

    //Accion del Boton Salir
    private void lblSalirClicked(MouseEvent evt) {
        System.exit(0); //Finaliza el proyecto
    }

    //Carga y modificacion del Boton Minimizar
    private void BotonMinimizar() {
        Login.lblMinizar.setToolTipText("<html><h4>Minimizar</html>");
        Login.lblMinizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Login.setExtendedState(ICONIFIED); //Minimiza la ventana
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Login.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mover la interfaz 
                Login.setLocation(Login.getLocation().x + evt.getX() - x, Login.getLocation().y + evt.getY() - y);
            }
        });
        Login.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Carga y modificacion del Boton Ingresar
    private void BotonIngresar() {
        Login.lblIngresar.setToolTipText("<html><h4>Ingresar</html>");
        Login.lblIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblIngresarClicked(evt);
            }
        });
    }

    //Accion del Boton Ingresar
    private void lblIngresarClicked(MouseEvent evt) {
        Model.Model_Login ConeLogin = new Model.Model_Login();
        //Valida que las cajas esten llenas
        if (Login.txtUsuario.getText().length() > 0 && Login.psContrasena.getText().length() > 0) {
            if (Login.txtUsuario.getText().equals("USUARIO") && Login.psContrasena.getText().equals("CONTRASEÑA")) {
                JOptionPane.showMessageDialog(Login, "Digite su usuario y su contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ConeLogin.Iniciar_Sesion(Login.txtUsuario.getText(), Login.psContrasena.getText())) {
                    Controlador_Principal ctr_Principal = new Controlador_Principal(Login.txtUsuario.getText());
                    Login.setVisible(false);
                    ctr_Principal.Iniciar();
                } else {
                    JOptionPane.showMessageDialog(Login, "El usuario y/o la contraseña son incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(Login, "Digite su usuario y su contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo para cargar las cajas
    private void CargarCajas() {
        CajaUsuario();
        CajaContraseña();
    }

    //Carga y modificacion de la Caja Usuario 
    private void CajaUsuario() {
        Login.txtUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Login.txtUsuario.setText("");
            }
        });
        Login.txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (Character.isLowerCase(x)) {
                    String Mayus = ("" + x).toUpperCase();
                    x = Mayus.charAt(0);
                    evt.setKeyChar(x);
                }
            }
        });

    }

    //Carga y modificacion de la Caja contraseña
    private void CajaContraseña() {
        Login.psContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Login.psContrasena.setText("");
            }
        });
    }

}
