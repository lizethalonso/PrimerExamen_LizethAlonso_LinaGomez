package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger logger= Logger.getLogger(BD.class);

    private static final String SQL_DROP_CREATE_ODON="DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, NUMERO_MATRICULA VARCHAR (100) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";
    /*//private static final String SQL_PRUEBA2="INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES ('254698','Mario','Hernandez'), ('45887','Juan','López')," +
           // "('568986','Laura','Torres')";*/

public static void crearTablas(){
    Connection connection= null;
    try{
        connection= getConnection();
        Statement statement= connection.createStatement();

        statement.execute(SQL_DROP_CREATE_ODON);

        //statement.execute(SQL_PRUEBA2);
        logger.info("tabla creada con exito");

    }catch (Exception e){
        logger.warn(e.getMessage());
    }

}
public static Connection getConnection() throws Exception{
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:mem:~/clinicaOdontologica","sa","sa");
}
}
