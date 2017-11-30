package Controller;

import Class.Producto;
import Model.Model_Producto;
import View.View_Producto;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;

public class Controlador_Producto {

    //Objeto de la interfaz Producto
    View_Producto Producto;

    //Variables para guardar la posicion de la ventana
    private int x, y;

    //Variable temporal para el codigo del producto
    private String COD;

    //Constructor
    public Controlador_Producto(Frame frm) {
        Producto = new View_Producto(frm, true);

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

    //Cargar la interfaz Producto
    private void CargarInterfaz() {
        Producto.setLocationRelativeTo(null);
        Producto.setResizable(false);
        Producto.setTitle("Producto");
        Producto.setVisible(true);
    }

    //Metodo para cargar los botones y su funciones
    private void CargarBotones() {
        BotonSalir();
        BotonMover();
        BotonAgregarProducto();
        BotonModificarProducto();
        BotonBuscarProducto();
        BotonGuardarDatos();
        BotonLimpiarCajas();
        BotonEliminar();
    }

    //Carga y modificacion del Boton Salir
    private void BotonSalir() {
        Producto.lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        Producto.lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Producto.dispose();
            }
        });
    }

    //Carga y modificacion de la barra para mover la interfaz
    private void BotonMover() {
        Producto.lblMover.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //Mover la interfaz 
                Producto.setLocation(Producto.getLocation().x + evt.getX() - x, Producto.getLocation().y + evt.getY() - y);
            }
        });
        Producto.lblMover.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX(); //Obtiene la posicion X de la interfaz
                y = evt.getY(); //Obtiene la posicion Y de la interfaz
            }
        });
    }

    //Carga y modificacion del Boton AgregarProducto
    private void BotonAgregarProducto() {
        Producto.lblAgregar.setToolTipText("<html><h4>AGREGAR</html>");
        Producto.lblAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblAgregarProductoClicked(evt);
            }
        });
    }

    //Accion del Boton AgregarProducto
    private void lblAgregarProductoClicked(MouseEvent evt) {
        ValoresInicialesCajas();
        HabilitarCajas();
        Producto.txtCodigo.requestFocus();
    }

    //Carga y modificacion del Boton ModificarProducto
    private void BotonModificarProducto() {
        Producto.lblModificar.setToolTipText("<html><h4>MODIFICAR</html>");
        Producto.lblModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblModificarProductoClicked(evt);
            }
        });
    }

    //Accion del Boton ModificarProducto
    private void lblModificarProductoClicked(MouseEvent evt) {
        InhabilitarCajas();
        if (!Producto.txtCodigo.getText().equals("Codigo")) {
            Producto.txtCodigo.requestFocus();
            COD = Producto.txtCodigo.getText();
            HabilitarCajas();
        } else {
            JOptionPane.showMessageDialog(Producto, "No se ha seleccionado un Producto para modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Carga y modificacion del Boton BuscarProducto
    private void BotonBuscarProducto() {
        Producto.lblBuscar.setToolTipText("<html><h4>BUSCAR</html>");
        Producto.lblBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblBuscarProductoClicked(evt);
            }
        });
    }

    //Accion del Boton BuscarProducto
    private void lblBuscarProductoClicked(MouseEvent evt) {
        String COD1;
        COD1 = JOptionPane.showInputDialog(Producto, "Digite el COD del Producto");
        if (COD1 != null && COD1.length() > 0) {
            Model.Model_Producto Mod_Producto = new Model.Model_Producto();
            Producto Produ;
            Produ = Mod_Producto.BuscarProducto(COD1);
            if (Produ != null) {
                Caja_Datos_Producto(Produ);
            } else {
                JOptionPane.showMessageDialog(Producto, "El Producto no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(Producto, "No digito un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        InhabilitarCajas();
    }

    //Carga y modificacion del Boton GuardarDatos
    private void BotonGuardarDatos() {
        Producto.lblGuardar.setToolTipText("<html><h4>GUARDAR</html>");
        Producto.lblGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblGuardarDatosClicked(evt);
            }
        });
    }

    //Accion del Boton GuardarDatos
    private void lblGuardarDatosClicked(MouseEvent evt) {
        if (!Producto.txtCodigo.getText().equals("COD")) {
            if (COD != null) {
                Producto Produ = Object_Producto();
                Model_Producto Actu_Producto = new Model_Producto();
                if (Actu_Producto.ActualizarProducto(Produ, COD)) {
                    COD = null;
                    JOptionPane.showMessageDialog(Producto, "Se han actualizado los datos del Producto");
                } else {
                    JOptionPane.showMessageDialog(Producto, "No se actualizaron los datos el Producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Producto.txtCodigo.requestFocus();
                Producto Produ = Object_Producto();
                if (Produ.getCODIGO_PRODUCTO().length() > 0 && Produ.getDESCRIPCION_PRODUCTO().length() > 0
                        && Produ.getIVA_PRODUCTO() != 0) {
                    Model_Producto AddProducto = new Model_Producto();
                    if (AddProducto.AgregarProducto(Produ)) {
                        JOptionPane.showMessageDialog(Producto, "Se ha registrado el Producto");
                    } else {
                        JOptionPane.showMessageDialog(Producto, "No se registro el Producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Producto, "Digite todos los datos del Producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(Producto, "No hay datos para guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        ValoresInicialesCajas();
        InhabilitarCajas();

    }

    //Guarda los datos del Producto en un objeto
    private Producto Object_Producto() {
        Producto Produ = new Producto();
        Produ.setCODIGO_PRODUCTO(Producto.txtCodigo.getText());
        Produ.setDESCRIPCION_PRODUCTO(Producto.txtDescripcion.getText());
        Produ.setIVA_PRODUCTO(ClasificarIva());
        return Produ;
    }

    //Clasificar la seleccion de los botones
    private int ClasificarIva() {
        if (Producto.btnIVA19.isSelected()) {
            return 19;
        } else if (Producto.btnIVA5.isSelected()) {
            return 5;
        } else {
            return 0;
        }
    }

    //Cargar Cajas y sus funciones
    private void CargarCajas() {

        //Agregar Cajas de texto A la funcion Clicked
        Producto.txtDescripcion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Producto.txtDescripcion.isEnabled()) {
                    Producto.txtDescripcion.setText("");
                }
            }
        });

        Producto.txtCodigo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (Producto.txtCodigo.isEnabled()) {
                    Producto.txtCodigo.setText("");
                }
            }
        });

        //Configurar las acciones permitidas para cada caja
        Producto.txtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char x = evt.getKeyChar();
                if (x == '-' || Character.isDigit(x)) {
                } else {
                    evt.consume();
                }
            }
        });
    }

    //Carga y modificacion del Boton LimpiarCajas
    private void BotonLimpiarCajas() {
        Producto.lblLimpiar.setToolTipText("<html><h4>LIMPIAR</html>");
        Producto.lblLimpiar.addMouseListener(new MouseAdapter() {
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
        Producto.lblEliminar.setToolTipText("<html><h4>ELIMINAR</html>");
        Producto.lblEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                lblEliminarClicked(evt);
            }
        });
    }

    //Metodo para eliminar un Producto
    private void lblEliminarClicked(MouseEvent evt) {
        if (!Producto.txtCodigo.getText().equals("Codigo")) {
            Producto.txtCodigo.requestFocus();
        } else {
            JOptionPane.showMessageDialog(Producto, "No se ha seleccionado un Producto para eliminacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Ihnabilita las cajas hasta su proximo uso
    private void InhabilitarCajas() {
        Producto.txtDescripcion.setEnabled(false);
        Producto.txtCodigo.setEnabled(false);
        Producto.btnIVA19.setEnabled(false);
        Producto.btnIVA5.setEnabled(false);
    }

    //Hablitiar cajas para su uso
    private void HabilitarCajas() {
        Producto.txtCodigo.setEnabled(true);
        Producto.txtDescripcion.setEnabled(true);
        Producto.btnIVA19.setEnabled(true);
        Producto.btnIVA5.setEnabled(true);
    }

    //Regresa las cajas a su estado inicial
    private void ValoresInicialesCajas() {
        Producto.btnIVA.clearSelection();
        Producto.txtDescripcion.setText("Descripcion");
        Producto.txtCodigo.setText("Codigo");
        Producto.btnIVA19.setText("19%");
        Producto.btnIVA5.setText("5%");
    }

    /**
     * Envia los datos del Producto a sus respectivas cajas
     *
     * @param Produ Objeto de la clase Producto
     */
    private void Caja_Datos_Producto(Producto Produ) {
        Producto.txtCodigo.setText(Produ.getCODIGO_PRODUCTO());
        Producto.txtDescripcion.setText(Produ.getDESCRIPCION_PRODUCTO());
        switch (Produ.getIVA_PRODUCTO()) {
            case 5:
                Producto.btnIVA5.setSelected(true);
                break;
            case 19:
                Producto.btnIVA19.setSelected(true);
                break;
        }
    }

}
