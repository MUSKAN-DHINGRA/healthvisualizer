package com.example.healthvisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartController {
    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    public void initialize() {
        populateChart();
    }

    private void populateChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Exercise");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int durationMinutes = resultSet.getInt("duration_minutes");

                series.getData().add(new XYChart.Data<>(name, durationMinutes));
            }

            lineChart.getData().add(series);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}