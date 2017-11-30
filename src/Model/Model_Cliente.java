package Model;

import Class.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;

public class Model_Cliente extends DB.DataBase {

    //Constructor
    public Model_Cliente() {
    }

    //Metodo para Buscar Cliente en la base de datos
    private Cliente SearchCliente(String Documento) {
        Connection Con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try {
            Con = Conectar();
            cs = Con.prepareCall("{call BuscarCliente(?,?)}");
            cs.setString(1, Documento);
            cs.registerOutParameter(2, Types.BOOLEAN);
            rs = cs.executeQuery();
            boolean OK = cs.getBoolean(2);
            if (OK) {
                Cliente Cliente=new Cliente();
                while (rs.next()) {
                    Cliente.setNOMBRE_CLIENTE(rs.getString("N_Cliente"));
                    Cliente.setDOCUMENTO_CLIENTE(rs.getString("D_Cliente"));
                    Cliente.setAPELLIDO_CLIENTE(rs.getString("A_Cliente"));
                    Cliente.setDIRECCION_CLIENTE(rs.getString("DIR_Cliente"));
                    Cliente.setTELEFONO_CLIENTE(rs.getString("T_Cliente"));
                }
                return Cliente;
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
    public Cliente BuscarCliente(String Documento) {
        return SearchCliente(Documento);
    }
    
    //Metodo para AgregarCliente
    private boolean NewCliente(Cliente cliente){
        Connection Con=null;
        CallableStatement cs=null;
        Savepoint sp=null;
        try{
            Con=Conectar();
            Con.setAutoCommit(false);
            sp=Con.setSavepoint();
            cs=Con.prepareCall("{call AgregarCliente(?,?,?,?,?)}");
            cs.setString(1, cliente.getNOMBRE_CLIENTE());
            cs.setString(2,cliente. getAPELLIDO_CLIENTE());
            cs.setString(3, cliente.getTELEFONO_CLIENTE());
            cs.setString(4, cliente.getDIRECCION_CLIENTE());
            cs.setString(5, cliente.getDOCUMENTO_CLIENTE());
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
    public boolean AgregarCliente(Cliente cliente){
    return NewCliente(cliente);
    }
    
    //Metodo para actualizar
    private boolean UpdateCliente(Cliente cliente, String Doc){
    Connection Con=null;
        CallableStatement cs=null;
        Savepoint sp=null;
        try{
            Con=Conectar();
            Con.setAutoCommit(false);
            sp=Con.setSavepoint();
            cs=Con.prepareCall("{call ActualizarCliente(?,?,?,?,?,?)}");
            cs.setString(1, cliente.getDOCUMENTO_CLIENTE());
            cs.setString(2, cliente.getNOMBRE_CLIENTE());
            cs.setString(3,cliente. getAPELLIDO_CLIENTE());
            cs.setString(4, cliente.getDIRECCION_CLIENTE());
            cs.setString(5, cliente.getTELEFONO_CLIENTE());
            cs.setString(6, Doc);
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
    public boolean ActualizarCliente(Cliente clie, String Doc){
    return UpdateCliente(clie, Doc);
    }
}
