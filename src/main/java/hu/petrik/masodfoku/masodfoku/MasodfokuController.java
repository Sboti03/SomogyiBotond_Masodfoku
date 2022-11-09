package hu.petrik.masodfoku.masodfoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MasodfokuController {

    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private TextField inputC;
    @FXML
    private Button calBtn;
    @FXML
    private Label x1Label;
    @FXML
    private Label x2Label;

    Alert alert = new Alert(Alert.AlertType.ERROR);


    private void alertManager(String msg, String title) {
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.setHeaderText("");
        alert.show();
    }

    public void calculateAction(ActionEvent actionEvent) {
        if (inputA.getText().equals("") || inputB.getText().equals("") || inputC.getText().equals("")) {
            alertManager("Minden mező kitöltése kötelező!", "Hiba");
        } else {
            try {
                double a = Double.parseDouble(inputA.getText());
                double b = Double.parseDouble(inputB.getText());
                double c = Double.parseDouble(inputC.getText());
                double d = getD(a, b, c);
                if (a == 0 ||d < 0) {
                    alertManager("Nem oldható meg a valós számok halmazán", "Hiba");
                } else {
                    double[] resutls = calculateResult(a, b, d);
                    if (resutls[0] == resutls[1]) {
                        x1Label.setText("x1 = x2 = " + resutls[0]);
                        x2Label.setText("");
                    } else {
                        x1Label.setText("x1 = " + resutls[0]);
                        x2Label.setText("x2 = " + resutls[1]);
                    }
                }
            } catch (Exception e) {
                alertManager("Csak számot adhat meg", "Hiba");
            }
        }
    }

    private double[] calculateResult(double a, double b, double d) {
        double sqrtD = Math.sqrt(d);
        double x1 = (-b + sqrtD) / (2 * a);
        double x2 = (-b - sqrtD) / (2 * a);

        return new double[]{x1, x2};
    }

    private double getD(double a, double b, double c) {
        return (b * b - 4 * a * c);
    }
}