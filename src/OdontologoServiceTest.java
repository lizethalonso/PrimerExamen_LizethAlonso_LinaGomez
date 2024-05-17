import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import java.util.List;
public class OdontologoServiceTest{
    @Test
    public void listarTodosLosOdontologos() {
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologo1 = new Odontologo(1,"12345", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2,"67890", "Ana", "Lopez");
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assertions.assertEquals(2, odontologos.size());
    }
}

