package Class;

public class Reparacion {

    //Atributos de la clase
    private int ID_REPARACION;
    private int ID_BICICLETA;
    private int TOTAL_REPARACION;
    private int ABONO_REPARACION;
    private String FECHA_INICIO_REPARACION;
    private String FECHA_FIN_REPARACION;

    //Constructores
    public Reparacion(int ID_REPARACION, int ID_BICICLETA, int TOTAL_REPARACION, int ABONO_REPARACION, String FECHA_INICIO_REPARACION, String FECHA_FIN_REPARACION) {
        this.ID_REPARACION = ID_REPARACION;
        this.ID_BICICLETA = ID_BICICLETA;
        this.TOTAL_REPARACION = TOTAL_REPARACION;
        this.ABONO_REPARACION = ABONO_REPARACION;
        this.FECHA_INICIO_REPARACION = FECHA_INICIO_REPARACION;
        this.FECHA_FIN_REPARACION = FECHA_FIN_REPARACION;
    }

    public Reparacion() {
    }

    //Metodos Set y Get requeridos
    public int getID_REPARACION() {
        return ID_REPARACION;
    }

    public void setID_REPARACION(int ID_REPARACION) {
        this.ID_REPARACION = ID_REPARACION;
    }

    public int getID_BICICLETA() {
        return ID_BICICLETA;
    }

    public void setID_BICICLETA(int ID_BICICLETA) {
        this.ID_BICICLETA = ID_BICICLETA;
    }

    public int getTOTAL_REPARACION() {
        return TOTAL_REPARACION;
    }

    public void setTOTAL_REPARACION(int TOTAL_REPARACION) {
        this.TOTAL_REPARACION = TOTAL_REPARACION;
    }

    public int getABONO_REPARACION() {
        return ABONO_REPARACION;
    }

    public void setABONO_REPARACION(int ABONO_REPARACION) {
        this.ABONO_REPARACION = ABONO_REPARACION;
    }

    public String getFECHA_INICIO_REPARACION() {
        return FECHA_INICIO_REPARACION;
    }

    public void setFECHA_INICIO_REPARACION(String FECHA_INICIO_REPARACION) {
        this.FECHA_INICIO_REPARACION = FECHA_INICIO_REPARACION;
    }

    public String getFECHA_FIN_REPARACION() {
        return FECHA_FIN_REPARACION;
    }

    public void setFECHA_FIN_REPARACION(String FECHA_FIN_REPARACION) {
        this.FECHA_FIN_REPARACION = FECHA_FIN_REPARACION;
    }

}
