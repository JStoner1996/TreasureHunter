import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestField {

    Field testField = new Field(4, 4);


    @Test
    public void testIsTreasure() {
        testField.getCell(1,1).setTreasure(false);
        Assertions.assertEquals(false, testField.getCell(1,1).isTreasure, "Cell is not treasure");

        testField.getCell(1,1).setTreasure(true);
        Assertions.assertEquals(true, testField.getCell(1,1).isTreasure, "Cell is now treasue");


    }

    @Test
    public void testIsVisible() {
        testField.getCell(1,1).setVisible(false);
        Assertions.assertEquals(false, testField.getCell(1,1).isVisible, "Cell is not visible");

        testField.getCell(1,1).setVisible(true);
        Assertions.assertEquals(true, testField.getCell(1,1).isVisible, "Cell is now visible");
    }


    }