package DB;

//Librerias necesarias
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

    //Variable Con para almacenar la ruta de conexion
    private Connection Con = null;

    //Metodo para obtener la conexion desde las clases hijas
    protected Connection Conectar() {
        return GetCon();
    }

    //Metodo privado para realizar y obtener una conexion
    private Connection GetCon() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost/bicitallernieto", "root", "S1201");
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex);
        }
        return Con;
    }

    /**
     * Metodo para cerrar las conexiones en una consulta
     *
     * @param ps PreparedStatement
     * @param rs ResultSet
     * @param Con Connection
     * @return
     */
    private void Cerrar(CallableStatement cs, ResultSet rs, Connection Con) {
        try {
            if (cs != null) {
                cs.close();
                System.out.println("PS cerrado");
            }
            if (rs != null) {
                rs.close();
                System.out.println("RS cerrado");
            }
            if (Con != null) {
                Con.close();
                System.out.println("CON cerrado");
            }
            System.out.println("Conexiones cerradas de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexiones: " + ex);
        }
    }

    //Metodo para cerrar las conexiones desde las clases hijas
    protected void CerrarConexiones(CallableStatement cs, ResultSet rs, Connection Con) {
        Cerrar(cs, rs, Con);
    }
}
