package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

public class Recipe {
    private JTextField idData;
    private JTextField nameData;
    private JTextField ingriData;
    private JTable table1;
    private JButton ADDRECORDButton;
    private JButton UPDATERECORDButton;
    private JTextArea recipeData;
    private JComboBox<String> typeData;
    private JPanel recipePanel;
    JFrame recipeFrame = new JFrame();

    public Recipe() {
        recipeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recipeFrame.setContentPane(recipePanel);
        recipeFrame.pack();
        recipeFrame.setLocationRelativeTo(null);
        recipeFrame.setSize(600, 500);
        recipeFrame.setVisible(true);

        tableData(); // Load existing data into the table

        ADDRECORDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idData.getText().equals("") || nameData.getText().equals("") || recipeData.getText().equals("")
                        || ingriData.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields to add a record.");
                } else {
                    try {
                        String sql = "INSERT INTO recipe (ID, NAME, TYPE, INGREDIENTS, RECIPE) VALUES (?, ?, ?, ?, ?)";
                        Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, Integer.parseInt(idData.getText()));
                        statement.setString(2, nameData.getText());
                        statement.setString(3, (String) typeData.getSelectedItem());
                        statement.setString(4, ingriData.getText());
                        statement.setString(5, recipeData.getText());
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Item added successfully!");
                        clearFields(); // Clear text fields after adding
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    tableData(); // Refresh table data
                }
            }
        });

        UPDATERECORDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "UPDATE recipe SET NAME = ?, TYPE = ?, INGREDIENTS = ?, RECIPE = ? WHERE ID = ?";
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, nameData.getText());
                    statement.setString(2, (String) typeData.getSelectedItem());
                    statement.setString(3, ingriData.getText());
                    statement.setString(4, recipeData.getText());
                    statement.setInt(5, Integer.parseInt(idData.getText()));
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Updated successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                tableData(); // Refresh table data
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                int selectedRow = table1.getSelectedRow();
                idData.setText(model.getValueAt(selectedRow, 0).toString());
                nameData.setText(model.getValueAt(selectedRow, 1).toString());
                ingriData.setText(model.getValueAt(selectedRow, 3).toString());
                recipeData.setText(model.getValueAt(selectedRow, 4).toString());
            }
        });
    }

    public void tableData() {
        try {
            String query = "SELECT * FROM recipe";
            Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            table1.setModel(buildTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    private void clearFields() {
        idData.setText("");
        nameData.setText("");
        ingriData.setText("");
        recipeData.setText("");
    }
}
