package self.jjjyjj.mapping;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    @Test
    void shouldMapCarToDto() {
        // Arrange
        Car car = new Car("a", 3, CarType.NEW);

        // Act
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        // Assert
        assertThat(carDto).isNotNull();
        assertThat(carDto.getMake()).isEqualTo("a");
        assertThat(carDto.getSeatCount()).isEqualTo(3);
        assertThat(carDto.getType()).isEqualTo("NEW");

    }
}