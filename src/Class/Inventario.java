package Class;

public class Inventario {

    //Atributos
    private String ValorVenta;
    Producto Producto;

    //Constructores
    public Inventario(String ValorVenta, Producto producto, int CANTIDAD_PRODUCTO) {
        this.Producto=producto;
        this.ValorVenta = ValorVenta;
    }

    public Inventario() {
    }
    
    //Metodos set y get requeridos
    public String getValorVenta() {
        return ValorVenta;
    }

    public void setValorVenta(String ValorVenta) {
        this.ValorVenta = ValorVenta;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

   
    


}
