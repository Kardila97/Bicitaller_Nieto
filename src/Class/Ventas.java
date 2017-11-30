package Class;

public class Ventas {

    //Atributos de la clase
    private int ID_VENTA;
    private int ID_CLIENTE;
    private int FECHA_VENTA;
    private String ESTADO_FACTURA;

    //Constructores
    public Ventas(int ID_VENTA, int ID_CLIENTE, int FECHA_VENTA, String ESTADO_FACTURA) {
        this.ID_VENTA = ID_VENTA;
        this.ID_CLIENTE = ID_CLIENTE;
        this.FECHA_VENTA = FECHA_VENTA;
        this.ESTADO_FACTURA = ESTADO_FACTURA;
    }

    public Ventas() {
    }

    //Metodos Set y Get requeridos
    public int getID_VENTA() {
        return ID_VENTA;
    }

    public void setID_VENTA(int ID_VENTA) {
        this.ID_VENTA = ID_VENTA;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getFECHA_VENTA() {
        return FECHA_VENTA;
    }

    public void setFECHA_VENTA(int FECHA_VENTA) {
        this.FECHA_VENTA = FECHA_VENTA;
    }

    public String getESTADO_FACTURA() {
        return ESTADO_FACTURA;
    }

    public void setESTADO_FACTURA(String ESTADO_FACTURA) {
        this.ESTADO_FACTURA = ESTADO_FACTURA;
    }

}
