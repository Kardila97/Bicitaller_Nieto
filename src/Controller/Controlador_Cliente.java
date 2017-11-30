package Controller;

import Class.Cliente;
import View.View_Cliente;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import Model.Model_Cliente;

public class Controlador_Cliente {

    //Objeto de la interfaz Cliente
    private final View_Cliente Cliente;

    //Variables para guardar la posicion de la ventana
    private int x, y;

    //Documento Temporal
    private String Doc = null;

    //Constructor
    public Controlador_Cliente(Frame frm) {
        Cliente = new View_Cliente(frm, true);
    }

    //Metodo para iniciar la interfaz
    public void Iniciar() {
        Cargar();
    }

    //Cargar componentes de la interfaz
    private void Cargar() {
        CargarBotones();
        ValoresInicialesCajas();
        InhabilitarCajas();
        CargarCajas();
        CargarInterfaz();
    }

    //Cargar la interfaz Cliente
    private void CargarInterfaz() {
        Cliente.setLocationRelativeTo(null);
        Cliente.setResizable(false);
        Cliente.setTitle("Cliente");
        Cliente.setVisible(true);
    }

    //Metodo para cargar los botones y su funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMover();
        BotonAgregarCliente();
        BotonModificarCliente();
        BotonBuscarCliente();
        BotonGuardarDatos();
        BotonLimpiarCajas();
        BotonEliminar();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Cliente.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Cliente.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Cliente.dispose();
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Cliente.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mover la interfaz
                Cliente.setLocation(Cliente.getLocation().x + evt.getX() - x, Cliente.getLocation().y + evt.getY() - y);
            }
        });
        Cliente.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Carga y modificacion del Boton AgregarCliente
    private void BotonAgregarCliente() {
        Cliente.lblAgregarPersona.setToolTipText("<html><h4>AGREGAR</html>");
        Cliente.lblAgregarPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblAgregarClienteClicked(evt);
            }
        });
    }

    //Accion del Boton AgregarCliente
    private void lblAgregarClienteClicked(MouseEvent evt) {
        ValoresInicialesCajas();
        HabilitarCajas();
        Cliente.txtDocumento.requestFocus();
    }

    //Carga y modificacion del Boton ModificarCliente
    private void BotonModificarCliente() {
        Cliente.lblModificar.setToolTipText("<html><h4>MODIFICAR</html>");
        Cliente.lblModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblModificarClienteClicked(evt);
            }
        });
    }

    //Accion del Boton ModificarCliente
    private void lblModificarClienteClicked(MouseEvent evt) {
        InhabilitarCajas();
        if (!Cliente.txtDocumento.getText().equals("Documento")) {
            Cliente.txtDocumento.requestFocus();
            Doc = Cliente.txtDocumento.getText();
            HabilitarCajas();
        } else {
            JOptionPane.showMessageDialog(Cliente, "No se ha seleccionado un cliente para modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Carga y modificacion del Boton BuscarCliente
    private void BotonBuscarCliente() {
        Cliente.lblBuscar.setToolTipText("<html><h4>BUSCAR</html>");
        Cliente.lblBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblBuscarClienteClicked(evt);
            }
        });
    }

    //Accion del Boton BuscarCliente
    private void lblBuscarClienteClicked(MouseEvent evt) {
        String Docu;
        Docu = JOptionPane.showInputDialog(Cliente, "Digite el documento del cliente");
        if (Docu != null && Docu.length() > 0) {
            Model.Model_Cliente Mod_Cliente = new Model.Model_Cliente();
            Cliente clie;
            clie = Mod_Cliente.BuscarCliente(Docu);
            if (clie != null) {
                Caja_Datos_Cliente(clie);
            } else {
                JOptionPane.showMessageDialog(Cliente, "El cliente no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(Cliente, "No digito un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        InhabilitarCajas();
    }

    //Carga y modificacion del Boton GuardarDatos
    private void BotonGuardarDatos() {
        Cliente.lblGuardar.setToolTipText("<html><h4>GUARDAR</html>");
        Cliente.lblGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblGuardarDatosClicked(evt);
            }
        });
    }

    //Accion del Boton GuardarDatos
    private void lblGuardarDatosClicked(MouseEvent evt) {
        if (!Cliente.txtDocumento.getText().equals("Documento")) {
            if (Doc != null) {
                Cliente clie = Object_Cliente();
                Model_Cliente Actu_Cliente = new Model_Cliente();
                if (Actu_Cliente.ActualizarCliente(clie, Doc)) {
                    Doc = null;
                    JOptionPane.showMessageDialog(Cliente, "Se han actualizado los datos del cliente");
                } else {
                    JOptionPane.showMessageDialog(Cliente, "No se actualizaron los datos el cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Cliente.txtDocumento.requestFocus();
                Cliente clie = Object_Cliente();
                if (clie.getNOMBRE_CLIENTE().length() > 0 && clie.getAPELLIDO_CLIENTE().length() > 0
                        && clie.getDIRECCION_CLIENTE().length() > 0 && clie.getDOCUMENTO_CLIENTE().length() > 0
                        && clie.getTELEFONO_CLIENTE().length() > 0) {
                    Model_Cliente AddCliente = new Model_Cliente();
                    if (AddCliente.AgregarCliente(clie)) {
                        JOptionPane.showMessageDialog(Cliente, "Se ha registrado el cliente");
                    } else {
                        JOptionPane.showMessageDialog(Cliente, "No se registro el cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Cliente, "Digite todos los datos del cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(Cliente, "No hay datos para guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        ValoresInicialesCajas();
        InhabilitarCajas();

    }

    //Guarda los datos del cliente en un objeto
    private Cliente Object_Cliente() {
        Cliente clie = new Cliente();
        clie.setNOMBRE_CLIENTE(Cliente.txtNombre.getText());
        clie.setAPELLIDO_CLIENTE(Cliente.txtApellido.getText());
        clie.setDIRECCION_CLIENTE(Cliente.txtDireccion.getText());
        clie.setDOCUMENTO_CLIENTE(Cliente.txtDocumento.getText());
        clie.setTELEFONO_CLIENTE(Cliente.txtTelefono.getText());
        return clie;
    }

    //Cargar Cajas y sus funciones
    private void CargarCajas() {

        //Agregar Cajas de texto A la funcion Clicked
        Cliente.txtNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Cliente.txtNombre.isEnabled()) {
                    Cliente.txtNombre.setText("");
                }
            }
        });

        Cliente.txtDocumento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Cliente.txtDocumento.isEnabled()) {
                    Cliente.txtDocumento.setText("");
                }
            }
        });

        Cliente.txtDireccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Cliente.txtDireccion.isEnabled()) {
                    Cliente.txtDireccion.setText("");
                }
            }
        });

        Cliente.txtApellido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Cliente.txtApellido.isEnabled()) {
                    Cliente.txtApellido.setText("");
                }
            }
        });

        Cliente.txtTelefono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Cliente.txtTelefono.isEnabled()) {
                    Cliente.txtTelefono.setText("");
                }
            }
        });

        //Configurar las acciones permitidas para cada caja
        Cliente.txtDocumento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (!Character.isDigit(x)) {
                    evt.consume();
                }
            }
        });

        Cliente.txtApellido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                txtCajas(evt);
            }
        });

        Cliente.txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                txtCajas(evt);
            }
        });

        Cliente.txtTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (!Character.isDigit(x)) {
                    evt.consume();
                }
            }
        });

        Cliente.txtDireccion.addKeyListener(new KeyAdapter() {
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

    //Accion para las cajas de texto
    private void txtCajas(KeyEvent evt) {
        char z = evt.getKeyChar();
        if (z == ' ' || Character.isAlphabetic(z)) {
        } else {
            evt.consume();
        }
        if (Character.isLowerCase(z)) {
            String Mayus = ("" + z).toUpperCase();
            z = Mayus.charAt(0);
            evt.setKeyChar(z);
        }
    }

    //Carga y modificacion del Boton LimpiarCajas
    private void BotonLimpiarCajas() {
        Cliente.lblLimpiar.setToolTipText("<html><h4>LIMPIAR</html>");
        Cliente.lblLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblLimpiarCajasClicked(evt);
            }
        });
    }

    //Accion del Boton LimpiarCajas
    private void lblLimpiarCajasClicked(MouseEvent evt) {
        ValoresInicialesCajas();
        InhabilitarCajas();
    }

    //Carga y modificacion del boton eliminar
    private void BotonEliminar() {
        Cliente.lblEliminar.setToolTipText("<html><h4>ELIMINAR</html>");
        Cliente.lblEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblEliminarClicked(evt);
            }
        });
    }

    //Metodo para eliminar un cliente
    private void lblEliminarClicked(MouseEvent evt) {
        if (!Cliente.txtDocumento.getText().equals("Documento")) {
            Cliente.txtDocumento.requestFocus();
        } else {
            JOptionPane.showMessageDialog(Cliente, "No se ha seleccionado un cliente para eliminacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Ihnabilita las cajas hasta su proximo uso
    private void InhabilitarCajas() {
        Cliente.txtNombre.setEnabled(false);
        Cliente.txtDireccion.setEnabled(false);
        Cliente.txtApellido.setEnabled(false);
        Cliente.txtDocumento.setEnabled(false);
        Cliente.txtTelefono.setEnabled(false);
    }

    //Hablitiar cajas para su uso
    private void HabilitarCajas() {
        Cliente.txtNombre.setEnabled(true);
        Cliente.txtDireccion.setEnabled(true);
        Cliente.txtApellido.setEnabled(true);
        Cliente.txtDocumento.setEnabled(true);
        Cliente.txtTelefono.setEnabled(true);
    }

    //Regresa las cajas a su estado inicial
    private void ValoresInicialesCajas() {
        Cliente.txtApellido.setText("Apellido");
        Cliente.txtDireccion.setText("Direccion");
        Cliente.txtDocumento.setText("Documento");
        Cliente.txtNombre.setText("Nombre");
        Cliente.txtTelefono.setText("Telefono");
    }

    /**
     * Envia los datos del cliente a sus respectivas cajas
     *
     * @param clie //Objeto de la clase Cliente
     */
    private void Caja_Datos_Cliente(Cliente clie) {
        Cliente.txtNombre.setText(clie.getNOMBRE_CLIENTE());
        Cliente.txtApellido.setText(clie.getAPELLIDO_CLIENTE());
        Cliente.txtDocumento.setText(clie.getDOCUMENTO_CLIENTE());
        Cliente.txtTelefono.setText(clie.getTELEFONO_CLIENTE());
        Cliente.txtDireccion.setText(clie.getDIRECCION_CLIENTE());
    }
}
