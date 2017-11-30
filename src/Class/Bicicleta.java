package Class;

public class Bicicleta {

    //Atributos de la clase
    private int ID_BICICLETA;
    private String TIPO_BICICLETA;
    private String MATERIAL_BICICLETA;
    private String COLOR_BICICLETA;
    private String TAMAÑO_BICICLETA;

    //Constructores
    public Bicicleta(int ID_BICICLETA, String TIPO_BICICLETA, String MATERIAL_BICICLETA, String COLOR_BICICLETA, String TAMAÑO_BICICLETA) {
        this.ID_BICICLETA = ID_BICICLETA;
        this.TIPO_BICICLETA = TIPO_BICICLETA;
        this.MATERIAL_BICICLETA = MATERIAL_BICICLETA;
        this.COLOR_BICICLETA = COLOR_BICICLETA;
        this.TAMAÑO_BICICLETA = TAMAÑO_BICICLETA;
    }

    public Bicicleta() {
    }

    //Metodos Set y Get requeridos
    public int getID_BICICLETA() {
        return ID_BICICLETA;
    }

    public void setID_BICICLETA(int ID_BICICLETA) {
        this.ID_BICICLETA = ID_BICICLETA;
    }

    public String getTIPO_BICICLETA() {
        return TIPO_BICICLETA;
    }

    public void setTIPO_BICICLETA(String TIPO_BICICLETA) {
        this.TIPO_BICICLETA = TIPO_BICICLETA;
    }

    public String getMATERIAL_BICICLETA() {
        return MATERIAL_BICICLETA;
    }

    public void setMATERIAL_BICICLETA(String MATERIAL_BICICLETA) {
        this.MATERIAL_BICICLETA = MATERIAL_BICICLETA;
    }

    public String getCOLOR_BICICLETA() {
        return COLOR_BICICLETA;
    }

    public void setCOLOR_BICICLETA(String COLOR_BICICLETA) {
        this.COLOR_BICICLETA = COLOR_BICICLETA;
    }

    public String getTAMAÑO_BICICLETA() {
        return TAMAÑO_BICICLETA;
    }

    public void setTAMAÑO_BICICLETA(String TAMAÑO_BICICLETA) {
        this.TAMAÑO_BICICLETA = TAMAÑO_BICICLETA;
    }

}
