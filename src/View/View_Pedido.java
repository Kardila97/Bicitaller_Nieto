package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class View_Pedido extends javax.swing.JFrame {

    public View_Pedido() {
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
        lblAtras = new javax.swing.JLabel();
        lblMinizar = new javax.swing.JLabel();
        lblAgregarProveedor = new javax.swing.JLabel();
        lblAgregarCliente = new javax.swing.JLabel();
        lblAgregarProducto = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel.setMaximumSize(new java.awt.Dimension(1300, 812));
        Panel.setOpaque(false);

        lblMover.setText(" ");
        lblMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        lblAtras.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        lblAtras.setForeground(new java.awt.Color(255, 0, 0));
        lblAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtras.setText("X");
        lblAtras.setToolTipText("<html><h4>Cerrar</html>");
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblMinizar.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblMinizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinizar.setText("-");
        lblMinizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedor.png"))); // NOI18N
        lblAgregarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        lblAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregarProducto.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lblAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarProducto.png"))); // NOI18N
        lblAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("PEDIDOS");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(lblMover, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgregarProducto)
                            .addComponent(lblAgregarProveedor)
                            .addComponent(lblAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblAgregarCliente)
                .addGap(18, 18, 18)
                .addComponent(lblAgregarProveedor)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblAgregarProducto)
                .addContainerGap())
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
    public javax.swing.JLabel lblAtras;
    public javax.swing.JLabel lblMinizar;
    public javax.swing.JLabel lblMover;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
