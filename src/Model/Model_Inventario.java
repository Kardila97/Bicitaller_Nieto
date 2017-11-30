package Model;

import Class.Inventario;
import Class.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model_Inventario extends DB.DataBase {

    //Metodo para mostrar el Inventario
    private ArrayList<Inventario> ShowInventario() {
        Connection Con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            Con = Conectar();
            cs = Con.prepareCall("{call MostrarInventario()}");
            rs = cs.executeQuery();

            ArrayList<Inventario> Listado = new ArrayList();
            Inventario Inven;
            Producto Produ;
            while (rs.next()) {
                Inven = new Inventario();
                Produ = new Producto();
                Produ.setCODIGO_PRODUCTO(rs.getString("COD_PRODU"));
                Produ.setCANTIDAD_PRODUCTO(rs.getInt("C_PRODU"));
                Produ.setDESCRIPCION_PRODUCTO(rs.getString("D_PRODU"));
                Produ.setIVA_PRODUCTO(rs.getInt("IV_PRODU"));
                Inven.setValorVenta(rs.getString("V_V"));
                Inven.setProducto(Produ);
                Listado.add(Inven);
            }
            return Listado;
        } catch (SQLException ex) {
            return null;
        } finally {
            CerrarConexiones(cs, rs, Con);
        }
    }

    //Metodo publico para mostrar el Inventario
    public ArrayList<Inventario> VerInventario() {
        return ShowInventario();
    }

}
