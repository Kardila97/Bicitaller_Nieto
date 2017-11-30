package Model;
import Class.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
public class Model_Producto extends DB.DataBase {



    //Metodo para Buscar un Producto en la base de datos
    private Producto SearchProducto(String Codigo) {
        Connection Con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try {
            Con = Conectar();
            cs = Con.prepareCall("{call MostrarProducto(?,?)}");
            cs.setString(1, Codigo);
            cs.registerOutParameter(2, Types.BOOLEAN);
            rs = cs.executeQuery();
            boolean OK = cs.getBoolean(2);
            if (OK) {
                Producto Producto=new Producto();
                while (rs.next()) {
                    Producto.setCODIGO_PRODUCTO(rs.getString("C_PRODU"));
                    Producto.setDESCRIPCION_PRODUCTO(rs.getString("D_PRODU"));
                    Producto.setIVA_PRODUCTO(rs.getInt("I_PRODU"));
                }
                return Producto;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        } finally {
            CerrarConexiones(cs, rs, Con);
        }
    }

    //Metodo publico para poder buscar un cliente fuera de la clase
    public Producto BuscarProducto(String Codigo) {
        return SearchProducto(Codigo);
    }
    
    //Metodo para AgregarProducto
    private boolean NewProducto(Producto producto){
        Connection Con=null;
        CallableStatement cs=null;
        Savepoint sp=null;
        try{
            Con=Conectar();
            Con.setAutoCommit(false);
            sp=Con.setSavepoint();
            cs=Con.prepareCall("{call AgregarProducto(?,?,?)}");
            cs.setString(1, producto.getCODIGO_PRODUCTO());
            cs.setString(2,producto.getDESCRIPCION_PRODUCTO());
            cs.setInt(3, producto.getIVA_PRODUCTO());
            cs.executeUpdate();
            Con.commit();
            return true;
        }catch(SQLException ex){
            try {
                Con.rollback(sp);
            } catch (SQLException ex1) {
            }
            return false;
        }
        finally{
            CerrarConexiones(cs, null, Con);
        }
    }

    //Metodo publico para agregar un cliente fuera de la clase
    public boolean AgregarProducto(Producto produ){
    return NewProducto(produ);
    }
    
    //Metodo para actualizar un producto
    private boolean UpdateProducto(Producto produ, String Cod){
    Connection Con=null;
        CallableStatement cs=null;
        Savepoint sp=null;
        try{
            Con=Conectar();
            Con.setAutoCommit(false);
            sp=Con.setSavepoint();
            cs=Con.prepareCall("{call ActualizarProducto(?,?,?,?)}");
            cs.setString(1, produ.getCODIGO_PRODUCTO());
            cs.setInt(2, produ.getIVA_PRODUCTO());
            cs.setString(3,produ.getDESCRIPCION_PRODUCTO());
            cs.setString(4, Cod);
            cs.executeUpdate();
            Con.commit();
            return true;
        }catch(SQLException ex){
            try {
                Con.rollback(sp);
            } catch (SQLException ex1) {
            }
            return false;
        }
        finally{
            CerrarConexiones(cs, null, Con);
        }
    }
    
    //Metodo publico para poder actualizar un cliente fuera de la casa
    public boolean ActualizarProducto(Producto produ, String Cod){
    return UpdateProducto(produ, Cod);
    }


}
