
package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class View_Principal extends javax.swing.JFrame {

    public View_Principal() {
        initComponents();
        
          //Agrega un fondo al frame
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/FondoPrincipal.png")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        
        //Agrega un icono al frame
        setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/Icono.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        lblMover = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        lblMinizar = new javax.swing.JLabel();
        lblAgregarProveedor = new javax.swing.JLabel();
        lblAgregarCliente = new javax.swing.JLabel();
        lblGenerarReporte = new javax.swing.JLabel();
        lblIniciarVenta = new javax.swing.JLabel();
        lblRegistrarPedido = new javax.swing.JLabel();
        lblAgregarProducto = new javax.swing.JLabel();
        lblIniciarReparacion = new javax.swing.JLabel();
        lblVerInventario = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblBienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);

        Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel.setMaximumSize(new java.awt.Dimension(1300, 812));
        Panel.setOpaque(false);

        lblMover.setText(" ");
        lblMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        lblSalir.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 0, 0));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("X");
        lblSalir.setToolTipText("<html><h4>Cerrar</html>");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblMinizar.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblMinizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinizar.setText("-");
        lblMinizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedor.png"))); // NOI18N
        lblAgregarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        lblAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GenerarReportes.png"))); // NOI18N
        lblGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblIniciarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CarroVentas.png"))); // NOI18N
        lblIniciarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblRegistrarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarPedido.png"))); // NOI18N
        lblRegistrarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarProducto.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lblAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarProducto.png"))); // NOI18N
        lblAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblIniciarReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IniciarReparacion.png"))); // NOI18N
        lblIniciarReparacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblVerInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario.png"))); // NOI18N
        lblVerInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("BICITALLER NIETO                     CONTROL DE INVENTARIO");

        lblBienvenido.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        lblBienvenido.setText("BIENVENIDO:  ");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(lblMover, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgregarCliente)
                            .addComponent(lblIniciarVenta))
                        .addGap(68, 68, 68)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAgregarProveedor)
                            .addComponent(lblIniciarReparacion))
                        .addGap(68, 68, 68)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegistrarPedido)
                            .addComponent(lblGenerarReporte))
                        .addGap(68, 68, 68)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVerInventario)
                            .addComponent(lblAgregarProducto)))
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgregarProveedor)
                    .addComponent(lblAgregarCliente)
                    .addComponent(lblAgregarProducto)
                    .addComponent(lblRegistrarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenerarReporte)
                    .addComponent(lblIniciarVenta)
                    .addComponent(lblVerInventario)
                    .addComponent(lblIniciarReparacion))
                .addGap(67, 67, 67)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    public javax.swing.JLabel lblAgregarCliente;
    public javax.swing.JLabel lblAgregarProducto;
    public javax.swing.JLabel lblAgregarProveedor;
    public javax.swing.JLabel lblBienvenido;
    public javax.swing.JLabel lblGenerarReporte;
    public javax.swing.JLabel lblIniciarReparacion;
    public javax.swing.JLabel lblIniciarVenta;
    public javax.swing.JLabel lblMinizar;
    public javax.swing.JLabel lblMover;
    public javax.swing.JLabel lblRegistrarPedido;
    public javax.swing.JLabel lblSalir;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblVerInventario;
    // End of variables declaration//GEN-END:variables
}
