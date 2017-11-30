package Class;

public class Cliente {

    //Atributos de la clase
    private String NOMBRE_CLIENTE;
    private String APELLIDO_CLIENTE;
    private String TELEFONO_CLIENTE;
    private String DOCUMENTO_CLIENTE;
    private String DIRECCION_CLIENTE;

    //Constructores
    public Cliente(String NOMBRE_CLIENTE, String APELLIDO_CLIENTE, String TELEFONO_CLIENTE, String DOCUMENTO_CLIENTE, String DIRECCION_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
        this.APELLIDO_CLIENTE = APELLIDO_CLIENTE;
        this.TELEFONO_CLIENTE = TELEFONO_CLIENTE;
        this.DOCUMENTO_CLIENTE = DOCUMENTO_CLIENTE;
        this.DIRECCION_CLIENTE = DIRECCION_CLIENTE;
    }

    public Cliente() {
    }

    //Metodos Set y Get requeridos
    
    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getAPELLIDO_CLIENTE() {
        return APELLIDO_CLIENTE;
    }

    public void setAPELLIDO_CLIENTE(String APELLIDO_CLIENTE) {
        this.APELLIDO_CLIENTE = APELLIDO_CLIENTE;
    }

    public String getTELEFONO_CLIENTE() {
        return TELEFONO_CLIENTE;
    }

    public void setTELEFONO_CLIENTE(String TELEFONO_CLIENTE) {
        this.TELEFONO_CLIENTE = TELEFONO_CLIENTE;
    }

    public String getDOCUMENTO_CLIENTE() {
        return DOCUMENTO_CLIENTE;
    }

    public void setDOCUMENTO_CLIENTE(String DOCUMENTO_CLIENTE) {
        this.DOCUMENTO_CLIENTE = DOCUMENTO_CLIENTE;
    }

    public String getDIRECCION_CLIENTE() {
        return DIRECCION_CLIENTE;
    }

    public void setDIRECCION_CLIENTE(String DIRECCION_CLIENTE) {
        this.DIRECCION_CLIENTE = DIRECCION_CLIENTE;
    }

}
