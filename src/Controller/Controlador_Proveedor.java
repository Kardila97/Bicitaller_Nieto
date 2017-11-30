package Controller;

import Class.Proveedor;
import Model.Model_Proveedor;
import View.View_Proveedor;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;

public class Controlador_Proveedor {

    //Objeto de la interfaz Proveedor
    private final View_Proveedor Proveedor;

    //Variables para guardar la posicion de la ventana
    private int x, y;

    //NIT Temporal
    private String NIT = null;

    //Constructor
    public Controlador_Proveedor(Frame frm) {
        Proveedor = new View_Proveedor(frm, true);
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

    //Cargar la interfaz Proveedor
    private void CargarInterfaz() {
        Proveedor.setLocationRelativeTo(null);
        Proveedor.setResizable(false);
        Proveedor.setTitle("Proveedor");
        Proveedor.setVisible(true);
    }

    //Metodo para cargar los botones y su funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMover();
        BotonAgregarProveedor();
        BotonModificarProveedor();
        BotonBuscarProveedor();
        BotonGuardarDatos();
        BotonLimpiarCajas();
        BotonEliminar();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Proveedor.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Proveedor.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Proveedor.dispose();
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Proveedor.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mover la interfaz 
                Proveedor.setLocation(Proveedor.getLocation().x + evt.getX() - x, Proveedor.getLocation().y + evt.getY() - y);
            }
        });
        Proveedor.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Carga y modificacion del Boton AgregarProveedor
    private void BotonAgregarProveedor() {
        Proveedor.lblAgregarPersona.setToolTipText("<html><h4>AGREGAR</html>");
        Proveedor.lblAgregarPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblAgregarProveedorClicked(evt);
            }
        });
    }

    //Accion del Boton AgregarProveedor
    private void lblAgregarProveedorClicked(MouseEvent evt) {
        ValoresInicialesCajas();
        HabilitarCajas();
        Proveedor.txtNIT.requestFocus();
    }

    //Carga y modificacion del Boton ModificarProveedor
    private void BotonModificarProveedor() {
        Proveedor.lblModificar.setToolTipText("<html><h4>MODIFICAR</html>");
        Proveedor.lblModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblModificarProveedorClicked(evt);
            }
        });
    }

    //Accion del Boton ModificarProveedor
    private void lblModificarProveedorClicked(MouseEvent evt) {
        InhabilitarCajas();
        if (!Proveedor.txtNIT.getText().equals("NIT")) {
            Proveedor.txtNIT.requestFocus();
            NIT = Proveedor.txtNIT.getText();
            HabilitarCajas();
        } else {
            JOptionPane.showMessageDialog(Proveedor, "No se ha seleccionado un Proveedor para modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Carga y modificacion del Boton BuscarProveedor
    private void BotonBuscarProveedor() {
        Proveedor.lblBuscar.setToolTipText("<html><h4>BUSCAR</html>");
        Proveedor.lblBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblBuscarProveedorClicked(evt);
            }
        });
    }

    //Accion del Boton BuscarProveedor
    private void lblBuscarProveedorClicked(MouseEvent evt) {
        String NIT1;
        NIT1 = JOptionPane.showInputDialog(Proveedor, "Digite el NIT del Proveedor");
        if (NIT1 != null && NIT1.length() > 0) {
            Model.Model_Proveedor Mod_Proveedor = new Model.Model_Proveedor();
            Proveedor provee;
            provee = Mod_Proveedor.BuscarProveedor(NIT1);
            if (provee != null) {
                Caja_Datos_Proveedor(provee);
            } else {
                JOptionPane.showMessageDialog(Proveedor, "El Proveedor no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(Proveedor, "No digito un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        InhabilitarCajas();
    }

    //Carga y modificacion del Boton GuardarDatos
    private void BotonGuardarDatos() {
        Proveedor.lblGuardar.setToolTipText("<html><h4>GUARDAR</html>");
        Proveedor.lblGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblGuardarDatosClicked(evt);
            }
        });
    }

    //Accion del Boton GuardarDatos
    private void lblGuardarDatosClicked(MouseEvent evt) {
        if (!Proveedor.txtNIT.getText().equals("NIT")) {
            if (NIT != null) {
                Proveedor provee = Object_Proveedor();
                Model_Proveedor Actu_Proveedor = new Model_Proveedor();
                if (Actu_Proveedor.ActualizarProveedor(provee, NIT)) {
                    NIT = null;
                    JOptionPane.showMessageDialog(Proveedor, "Se han actualizado los datos del proveedor");
                } else {
                    JOptionPane.showMessageDialog(Proveedor, "No se actualizaron los datos el proveedor", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Proveedor.txtNIT.requestFocus();
                Proveedor provee = Object_Proveedor();
                if (provee.getNOMBRE_PROVEEDOR().length() > 0 && provee.getCORREO_ELECTRONICO_PROVEEDOR().length() > 0
                        && provee.getDIRECCION_PROVEEDOR().length() > 0 && provee.getTELEFONO_PROVEEDOR().length() > 0
                        && provee.getNIT_PROVEEDOR().length() > 0) {
                    Model_Proveedor AddProveedor = new Model_Proveedor();
                    if (AddProveedor.AgregarProveedor(provee)) {
                        JOptionPane.showMessageDialog(Proveedor, "Se ha registrado el proveedor");
                    } else {
                        JOptionPane.showMessageDialog(Proveedor, "No se registro el proveedor", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Proveedor, "Digite todos los datos del proveedor", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(Proveedor, "No hay datos para guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        ValoresInicialesCajas();
        InhabilitarCajas();

    }

    //Guarda los datos del proveedor en un objeto
    private Proveedor Object_Proveedor() {
        Proveedor provee = new Proveedor();
        provee.setNOMBRE_PROVEEDOR(Proveedor.txtNombre.getText());
        provee.setCORREO_ELECTRONICO_PROVEEDOR(Proveedor.txtCorreoElectronico.getText());
        provee.setDIRECCION_PROVEEDOR(Proveedor.txtDireccion.getText());
        provee.setNIT_PROVEEDOR(Proveedor.txtNIT.getText());
        provee.setTELEFONO_PROVEEDOR(Proveedor.txtTelefono.getText());
        return provee;
    }

    //Cargar Cajas y sus funciones
    private void CargarCajas() {

        //Agregar Cajas de texto A la funcion Clicked
        Proveedor.txtNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Proveedor.txtNombre.isEnabled()) {
                    Proveedor.txtNombre.setText("");
                }
            }
        });

        Proveedor.txtNIT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Proveedor.txtNIT.isEnabled()) {
                    Proveedor.txtNIT.setText("");
                }
            }
        });

        Proveedor.txtDireccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Proveedor.txtDireccion.isEnabled()) {
                    Proveedor.txtDireccion.setText("");
                }
            }
        });

        Proveedor.txtCorreoElectronico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Proveedor.txtCorreoElectronico.isEnabled()) {
                    Proveedor.txtCorreoElectronico.setText("");
                }
            }
        });

        Proveedor.txtTelefono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Proveedor.txtTelefono.isEnabled()) {
                    Proveedor.txtTelefono.setText("");
                }
            }
        });

        //Configurar las acciones permitidas para cada caja
        Proveedor.txtNIT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (x == '-' || Character.isDigit(x)) {
                } else {
                    evt.consume();
                }
            }
        });

        Proveedor.txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                txtCajas(evt);
            }
        });

        Proveedor.txtTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (!Character.isDigit(x)) {
                    evt.consume();
                }
            }
        });

        Proveedor.txtDireccion.addKeyListener(new KeyAdapter() {
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
        Proveedor.lblLimpiar.setToolTipText("<html><h4>LIMPIAR</html>");
        Proveedor.lblLimpiar.addMouseListener(new MouseAdapter() {
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
        Proveedor.lblEliminar.setToolTipText("<html><h4>ELIMINAR</html>");
        Proveedor.lblEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblEliminarClicked(evt);
            }
        });
    }

    //Metodo para eliminar un proveedor
    private void lblEliminarClicked(MouseEvent evt) {
        if (!Proveedor.txtNIT.getText().equals("NIT")) {
            Proveedor.txtNIT.requestFocus();
        } else {
            JOptionPane.showMessageDialog(Proveedor, "No se ha seleccionado un proveedor para eliminacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Ihnabilita las cajas hasta su proximo uso
    private void InhabilitarCajas() {
        Proveedor.txtNombre.setEnabled(false);
        Proveedor.txtDireccion.setEnabled(false);
        Proveedor.txtCorreoElectronico.setEnabled(false);
        Proveedor.txtNIT.setEnabled(false);
        Proveedor.txtTelefono.setEnabled(false);
    }

    //Hablitiar cajas para su uso
    private void HabilitarCajas() {
        Proveedor.txtNombre.setEnabled(true);
        Proveedor.txtDireccion.setEnabled(true);
        Proveedor.txtCorreoElectronico.setEnabled(true);
        Proveedor.txtNIT.setEnabled(true);
        Proveedor.txtTelefono.setEnabled(true);
    }

    //Regresa las cajas a su estado inicial
    private void ValoresInicialesCajas() {
        Proveedor.txtCorreoElectronico.setText("Correo Electronico");
        Proveedor.txtDireccion.setText("Direccion");
        Proveedor.txtNIT.setText("NIT");
        Proveedor.txtNombre.setText("Nombre");
        Proveedor.txtTelefono.setText("Telefono");
    }

    /**
     * Envia los datos del proveedor a sus respectivas cajas
     *
     * @param provee Objeto de la clase Proveedor
     */
    private void Caja_Datos_Proveedor(Proveedor provee) {
        Proveedor.txtNombre.setText(provee.getNOMBRE_PROVEEDOR());
        Proveedor.txtCorreoElectronico.setText(provee.getCORREO_ELECTRONICO_PROVEEDOR());
        Proveedor.txtNIT.setText(provee.getNIT_PROVEEDOR());
        Proveedor.txtTelefono.setText(provee.getTELEFONO_PROVEEDOR());
        Proveedor.txtDireccion.setText(provee.getDIRECCION_PROVEEDOR());
    }
}
