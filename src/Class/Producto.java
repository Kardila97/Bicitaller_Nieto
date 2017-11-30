package Class;

public class Producto {

    //Atributos de la clase
    private String DESCRIPCION_PRODUCTO;
    private String CODIGO_PRODUCTO;
    private int IVA_PRODUCTO;
    private int CANTIDAD_PRODUCTO;

    //Constructores
    public Producto( String DESCRIPCION_PRODUCTO, String CODIGO_PRODUCTO, int IVA_PRODUCTO, int CANTIDAD_PRODUCTO) {
       this.DESCRIPCION_PRODUCTO = DESCRIPCION_PRODUCTO;
        this.CODIGO_PRODUCTO = CODIGO_PRODUCTO;
        this.IVA_PRODUCTO = IVA_PRODUCTO;
        this.CANTIDAD_PRODUCTO = CANTIDAD_PRODUCTO;
    }

    public Producto() {
    }

    //Metodos Set y Get requeridos
    
    public String getDESCRIPCION_PRODUCTO() {
        return DESCRIPCION_PRODUCTO;
    }

    public void setDESCRIPCION_PRODUCTO(String DESCRIPCION_PRODUCTO) {
        this.DESCRIPCION_PRODUCTO = DESCRIPCION_PRODUCTO;
    }

    public String getCODIGO_PRODUCTO() {
        return CODIGO_PRODUCTO;
    }

    public void setCODIGO_PRODUCTO(String CODIGO_PRODUCTO) {
        this.CODIGO_PRODUCTO = CODIGO_PRODUCTO;
    }

    public int getIVA_PRODUCTO() {
        return IVA_PRODUCTO;
    }

    public void setIVA_PRODUCTO(int IVA_PRODUCTO) {
        this.IVA_PRODUCTO = IVA_PRODUCTO;
    }

    public int getCANTIDAD_PRODUCTO() {
        return CANTIDAD_PRODUCTO;
    }

    public void setCANTIDAD_PRODUCTO(int CANTIDAD_PRODUCTO) {
        this.CANTIDAD_PRODUCTO = CANTIDAD_PRODUCTO;
    }

}
