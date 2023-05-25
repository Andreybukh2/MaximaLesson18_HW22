package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    public void createCarsTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Cars(id int, марка varchar(15), " +
                    "модель varchar(15), госномер varchar(10) ,год varchar(4))"); //primary key auto_increment
            System.out.println("Table Cars created successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void dropCarsTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Cars");
            System.out.println("Table Cars deleted successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCar(int id, String марка, String модель, String госномер, String год) {
        final String INSERT_NEW_CAR = "INSERT INTO Cars(id, марка, модель, госномер, год)"
                + " VALUES(?,?,?,?,?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_CAR)) {
            statement.setInt(1, id);
            statement.setString(2, марка);
            statement.setString(3, модель);
            statement.setString(4, госномер);
            statement.setString(5, год);
            statement.execute();
            System.out.println("Fields created successful" + id + " ," + марка + " ," + модель + " ," + госномер + " ," + год);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCar(int id) {
        final String DELETE_CAR = "DELETE FROM Cars WHERE id = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CAR)) {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Fields deleted successful " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<CarDto> getAllCars() {
        List<CarDto> carDtoList = new ArrayList<>();
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String марка = resultSet.getString("марка");
                String модель = resultSet.getString("модель");
                String госномер = resultSet.getString("госномер");
                String год = resultSet.getString("год");
                CarDto carDto = new CarDto(id, марка, модель, госномер, год);
                carDtoList.add(carDto);
            }
            return carDtoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CarDto getCarsById (int id) {
        final String GET_CARS= "SELECT * FROM cars WHERE id = ?";
        CarDto carDto = null;
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CARS)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                String марка = resultSet.getString("марка");
                String модель = resultSet.getString("модель");
                String госномер = resultSet.getString("госномер");
                String год = resultSet.getString("год");
                carDto = new CarDto(id, марка, модель, госномер, год);
            }
            return carDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanCarTable() {
        final String DELETE_ALL_CARS = "DELETE FROM cars";
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_CARS)) {
            int count = preparedStatement.executeUpdate();
            if (count != 0) {
                System.out.println("Количество удаленных полей - " + count);
            } else {
                System.out.println("Таблица уже была пустая и удалять нечего");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}