package Class;

public class Proveedor {

    //Atributos de la clase
   private String NOMBRE_PROVEEDOR;
    private String NIT_PROVEEDOR;
    private String TELEFONO_PROVEEDOR;
    private String DIRECCION_PROVEEDOR;
    private String CORREO_ELECTRONICO_PROVEEDOR;

    //Constructores
    public Proveedor( String NOMBRE_PROVEEDOR, String NIT_PROVEEDOR, String TELEFONO_PROVEEDOR, String DIRECCION_PROVEEDOR, String CORREO_ELECTRONICO_PROVEEDOR) {
        this.NOMBRE_PROVEEDOR = NOMBRE_PROVEEDOR;
        this.NIT_PROVEEDOR = NIT_PROVEEDOR;
        this.TELEFONO_PROVEEDOR = TELEFONO_PROVEEDOR;
        this.DIRECCION_PROVEEDOR = DIRECCION_PROVEEDOR;
        this.CORREO_ELECTRONICO_PROVEEDOR = CORREO_ELECTRONICO_PROVEEDOR;
    }

    public Proveedor() {
    }

    //Metodos Set y Get requeridos
    
    public String getNOMBRE_PROVEEDOR() {
        return NOMBRE_PROVEEDOR;
    }

    public void setNOMBRE_PROVEEDOR(String NOMBRE_PROVEEDOR) {
        this.NOMBRE_PROVEEDOR = NOMBRE_PROVEEDOR;
    }

    public String getNIT_PROVEEDOR() {
        return NIT_PROVEEDOR;
    }

    public void setNIT_PROVEEDOR(String NIT_PROVEEDOR) {
        this.NIT_PROVEEDOR = NIT_PROVEEDOR;
    }

    public String getTELEFONO_PROVEEDOR() {
        return TELEFONO_PROVEEDOR;
    }

    public void setTELEFONO_PROVEEDOR(String TELEFONO_PROVEEDOR) {
        this.TELEFONO_PROVEEDOR = TELEFONO_PROVEEDOR;
    }

    public String getDIRECCION_PROVEEDOR() {
        return DIRECCION_PROVEEDOR;
    }

    public void setDIRECCION_PROVEEDOR(String DIRECCION_PROVEEDOR) {
        this.DIRECCION_PROVEEDOR = DIRECCION_PROVEEDOR;
    }

    public String getCORREO_ELECTRONICO_PROVEEDOR() {
        return CORREO_ELECTRONICO_PROVEEDOR;
    }

    public void setCORREO_ELECTRONICO_PROVEEDOR(String CORREO_ELECTRONICO_PROVEEDOR) {
        this.CORREO_ELECTRONICO_PROVEEDOR = CORREO_ELECTRONICO_PROVEEDOR;
    }

}
