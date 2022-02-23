package honeyshop.adapter.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BlankHoneyAdapterTest {

    BlankHoneyAdapter blankHoneyAdapter;

    @BeforeEach
    void setUp() {
        blankHoneyAdapter = new BlankHoneyAdapterImpl();
    }

    @Test
    void itShouldGetBlankHoney() {
        //Arrange
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setName("Testing start");
        blankHoneyDto.setDescription("Testing success");
        blankHoneyDto.setPrice(15);
        blankHoneyDto.setPhotoUrl("Same URL");

        //Act
        BlankHoney expected = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetBlankHoney() {
        //Arrange
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setName("Testing start");
        blankHoneyDto.setDescription("Testing success");
        blankHoneyDto.setPrice(15);
        blankHoneyDto.setPhotoUrl("Same URL");

        //Act
        BlankHoney expected = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetBlankHoneyDto() {
        //Arrange
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setName("Testing start");
        blankHoney.setDescription("Testing success");
        blankHoney.setPrice(15);
        blankHoney.setPhotoUrl("Same URL");

        //Act
        BlankHoneyDto expected = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetBlankHoneyDto() {
        //Arrange
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setName("Testing start");
        blankHoney.setDescription("Testing success");
        blankHoney.setPrice(15);
        blankHoney.setPhotoUrl("Same URL");

        //Act
        BlankHoneyDto expected = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }
}