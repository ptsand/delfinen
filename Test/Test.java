import controller.Controller;
import model.Medlem;
import model.MedlemStatus;
import org.junit.jupiter.api.Test;
import util.KonsolInputOutput;
import view.OpretMedlem;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class ControllerTest {

    @Test
    void tilføjMedlemTest(){
        //Arrange
        KonsolInputOutput io = new KonsolInputOutput();
        Controller controller = new Controller(io);

        //Act
        Medlem m1 = new Medlem("Anders", "22210803", "asd@gmail.com", LocalDate.parse("2019-06-09"),MedlemStatus.AKTIV);

        //Assert
        assertTrue(controller.getMedlem().isEmpty());
        controller.tilføjMedlem(m1);
        assertFalse(controller.getMedlem().isEmpty());


    }


}
