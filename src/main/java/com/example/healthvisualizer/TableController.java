package com.example.healthvisualizer;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableController {
    @FXML
    private TableView<Exercise> tableView;

    @FXML
    private TableColumn<Exercise, String> nameColumn;

    @FXML
    private TableColumn<Exercise, Integer> durationColumn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asObject());

        populateTable();
    }

    private void populateTable() {
        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Exercise");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int duration = resultSet.getInt("duration_minutes");

                tableView.getItems().add(new Exercise(name, duration));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}