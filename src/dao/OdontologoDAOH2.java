package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO VALUES (?,?,?,?)";
    private static final String SQL_BUSCARTODOS = "SELECT * FROM ODONTOLOGO";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try (Connection connection = BD.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT)) {
            psInsert.setInt(1, odontologo.getId());
            psInsert.setString(2, odontologo.getNumeroMatricula());
            psInsert.setString(3, odontologo.getNombre());
            psInsert.setString(4, odontologo.getApellido());
            psInsert.executeUpdate();
            logger.info("Odontólogo guardado con éxito: " + odontologo);
        } catch (Exception e) {
            logger.error("Error al guardar el odontólogo: " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Connection connection = BD.getConnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_BUSCARTODOS);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String numeroMat = rs.getString("NUMERO_MATRICULA");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                odontologos.add(new Odontologo(id, numeroMat, nombre, apellido));
            }

        } catch (Exception e) {
            logger.error("Error al listar los odontólogos: " + e.getMessage());
        }
        return odontologos;
    }
}


