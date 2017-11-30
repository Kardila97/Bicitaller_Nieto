package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Model_Login extends DB.DataBase {

    //Constructor vacio
    public Model_Login() {
    }

    //Buscar un usuario en la base de datos
    private boolean Sesionar_Usuario(String Usuario, String Contrasena) {
        Connection Con = null;
        CallableStatement cs = null;
        try {
            Con = Conectar();
            Con.setAutoCommit(false);
            cs = Con.prepareCall("{call IniciarSesion(?,?,?)}");
            cs.setString(1, Usuario);
            cs.setString(2, Contrasena);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.execute();
            boolean OK = cs.getBoolean(3);
            return OK;
        } catch (SQLException ex) {
            return false;
        } finally {
            CerrarConexiones(cs, null, Con);
        }
    }

    //Metodo publico para acceder al metodo privado y buscar el usuario
    public boolean Iniciar_Sesion(String Usuario, String Contrasena) {
        return Sesionar_Usuario(Usuario, Contrasena);
    }

}
