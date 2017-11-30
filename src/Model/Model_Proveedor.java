
package Model;

import Class.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;


public class Model_Proveedor extends DB.DataBase {
    
    //Metodo para agregar un nuevo proveedor
    private boolean AgregarNuevoProveedor(Proveedor provee) {
        Connection Con = null;
        CallableStatement cs = null;
        Savepoint sp=null;
        try {
            Con = Conectar();
            sp=Con.setSavepoint();
            Con.setAutoCommit(false);
            cs=Con.prepareCall("{call AgregarProveedor(?,?,?,?,?)}");
            cs.setString(1, provee.getNIT_PROVEEDOR());
            cs.setString(2, provee.getNOMBRE_PROVEEDOR());
            cs.setString(3, provee.getDIRECCION_PROVEEDOR());
            cs.setString(4, provee.getTELEFONO_PROVEEDOR());
            cs.setString(5, provee.getCORREO_ELECTRONICO_PROVEEDOR());
            cs.execute();
            Con.commit();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                Con.rollback(sp);
            } catch (SQLException ex1) {
            }
            return false;
        } finally {
            CerrarConexiones(cs, null, Con);
        }
    }
    
    //Metodo publico para acceder al metodo privado y agregar un nuevo proveedor
    public boolean AgregarProveedor(Proveedor provee){
        return AgregarNuevoProveedor(provee);
    }
    
    //Metodo para Buscar proveedor en la base de datos
    private Proveedor SearchProveedor(String NIT) {
        Connection Con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try {
            Con = Conectar();
            cs = Con.prepareCall("{call BuscarProveedor(?,?)}");
            cs.setString(1, NIT);
            cs.registerOutParameter(2, Types.BOOLEAN);
            rs = cs.executeQuery();
            boolean OK = cs.getBoolean(2);
            if (OK) {
                Proveedor provee=new Proveedor();
                while (rs.next()) {
                    provee.setNOMBRE_PROVEEDOR(rs.getString("N_Proveedor"));
                    provee.setNIT_PROVEEDOR(rs.getString("NIT_Proveedor"));
                    provee.setDIRECCION_PROVEEDOR(rs.getString("DIR_Proveedor"));
                    provee.setCORREO_ELECTRONICO_PROVEEDOR(rs.getString("C_Proveedor"));
                    provee.setTELEFONO_PROVEEDOR(rs.getString("T_Proveedor"));
                }
                return provee;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        } finally {
            CerrarConexiones(cs, rs, Con);
        }
    }

    //Metodo publico para poder buscar un proveedor fuera de la clase
    public Proveedor BuscarProveedor(String NIT) {
        return SearchProveedor(NIT);
    }
    
    private boolean UpdateProveedor(Proveedor Provee, String Nit){
    Connection Con=null;
        CallableStatement cs=null;
        Savepoint sp=null;
        try{
            Con=Conectar();
            Con.setAutoCommit(false);
            sp=Con.setSavepoint();
            cs=Con.prepareCall("{call ActualizarProducto(?,?,?,?,?,?)}");
            cs.setString(1, Provee.getNIT_PROVEEDOR());
            cs.setString(2, Provee.getNOMBRE_PROVEEDOR());
            cs.setString(3,Provee.getDIRECCION_PROVEEDOR());
            cs.setString(3,Provee.getTELEFONO_PROVEEDOR());
            cs.setString(3,Provee.getCORREO_ELECTRONICO_PROVEEDOR());
            cs.setString(4, Nit);
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
    //Metodo Publico para poder Modificar un proveedor
    public boolean ActualizarProveedor(Proveedor Provee, String Nit){
    return UpdateProveedor(Provee,Nit);
    }
   
}
