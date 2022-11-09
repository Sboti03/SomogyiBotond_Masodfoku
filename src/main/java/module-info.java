module hu.petrik.masodfoku.masodfoku {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens hu.petrik.masodfoku.masodfoku to javafx.fxml;
    exports hu.petrik.masodfoku.masodfoku;
}