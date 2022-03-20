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
        BlankHoney actual = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertEquals(1L, actual.getBlankHoneyId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
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
        BlankHoney actual = blankHoneyAdapter.getBlankHoney(blankHoneyDto);

        //Assert
        assertNotEquals(2L, actual.getBlankHoneyId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
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
        BlankHoneyDto actual = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertEquals(1L, actual.getBlankHoneyId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
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
        BlankHoneyDto actual = blankHoneyAdapter.getBlankHoneyDto(blankHoney);

        //Assert
        assertNotEquals(2L, actual.getBlankHoneyId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
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
        List<BlankHoneyDto> actualList = blankHoneyAdapter.getBlankHoneyDtoList(blanksHoney);

        //Assert
        actualList.forEach(actual -> {
            assertEquals(1L, actual.getBlankHoneyId());
            assertEquals("Testing start", actual.getName());
            assertEquals("Testing success", actual.getDescription());
            assertEquals(15, actual.getPrice());
            assertEquals("Same URL", actual.getPhotoUrl());
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
        List<BlankHoneyDto> actualList = blankHoneyAdapter.getBlankHoneyDtoList(blanksHoney);

        //Assert
        actualList.forEach(actual -> {
            assertNotEquals(2L, actual.getBlankHoneyId());
            assertNotEquals("Testing no start", actual.getName());
            assertNotEquals("Testing no success", actual.getDescription());
            assertNotEquals(16, actual.getPrice());
            assertNotEquals("Same no URL", actual.getPhotoUrl());
        });
    }
}