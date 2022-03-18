package honeyshop.adapter.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BlankHoneyAdapterTest {

    BlankHoneyAdapter blankHoneyAdapter;

    @BeforeEach
    void setUp() {
        blankHoneyAdapter = new BlankHoneyAdapter();
    }

    @Test
    void itShouldGetBlankHoney() {
        //Arrange
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setBlankHoneyId(1L);
        blankHoneyDto.setName("Testing start");
        blankHoneyDto.setDescription("Testing success");
        blankHoneyDto.setPrice(15);
        blankHoneyDto.setPhotoUrl("Same URL");

        //Act
        BlankHoney expected = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertEquals(expected.getBlankHoneyId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetBlankHoney() {
        //Arrange
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setBlankHoneyId(1L);
        blankHoneyDto.setName("Testing start");
        blankHoneyDto.setDescription("Testing success");
        blankHoneyDto.setPrice(15);
        blankHoneyDto.setPhotoUrl("Same URL");

        //Act
        BlankHoney expected = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertNotEquals(expected.getBlankHoneyId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetBlankHoneyDto() {
        //Arrange
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setBlankHoneyId(1L);
        blankHoney.setName("Testing start");
        blankHoney.setDescription("Testing success");
        blankHoney.setPrice(15);
        blankHoney.setPhotoUrl("Same URL");

        //Act
        BlankHoneyDto expected = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertEquals(expected.getBlankHoneyId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetBlankHoneyDto() {
        //Arrange
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setBlankHoneyId(1L);
        blankHoney.setName("Testing start");
        blankHoney.setDescription("Testing success");
        blankHoney.setPrice(15);
        blankHoney.setPhotoUrl("Same URL");

        //Act
        BlankHoneyDto expected = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertNotEquals(expected.getBlankHoneyId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetBlankHoneyDtoList() {
        //Arrange
        List<BlankHoney> blanksHoney = List.of(
                new BlankHoney(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new BlankHoney(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<BlankHoneyDto> expectedList = blankHoneyAdapter.getBlankHoneyDtoList(blanksHoney);

        //Assert
        expectedList.forEach(expected->{
            assertEquals(expected.getBlankHoneyId(), 1L);
            assertEquals(expected.getName(), "Testing start");
            assertEquals(expected.getDescription(), "Testing success");
            assertEquals(expected.getPrice(), 15);
            assertEquals(expected.getPhotoUrl(), "Same URL");
        });
    }

    @Test
    void itShouldNotGetBlankHoneyDtoList() {
        //Arrange
        List<BlankHoney> blanksHoney = List.of(
                new BlankHoney(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new BlankHoney(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<BlankHoneyDto> expectedList = blankHoneyAdapter.getBlankHoneyDtoList(blanksHoney);

        //Assert
        expectedList.forEach(expected->{
            assertNotEquals(expected.getBlankHoneyId(), 2L);
            assertNotEquals(expected.getName(), "Testing no start");
            assertNotEquals(expected.getDescription(), "Testing no success");
            assertNotEquals(expected.getPrice(), 16);
            assertNotEquals(expected.getPhotoUrl(), "Same no URL");
        });
    }
}