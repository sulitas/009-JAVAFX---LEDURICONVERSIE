
package leduriconversie;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sulitas
 */
public class LeduriConversie extends Application {
    
    public int n=0;//n intre 0 si 3
    double x0=20, y0=50 , Pspatiu, Dbec, Lsemafor=500, Hsemafor=200; 
    Color culoare[][] = {
                        {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
                        {Color.BLACK, Color.BLACK, Color.BLACK, Color.LIMEGREEN},
                        {Color.BLACK, Color.BLACK, Color.LIMEGREEN, Color.BLACK},
                        {Color.BLACK, Color.BLACK, Color.LIMEGREEN, Color.LIMEGREEN},   
                        
                        {Color.BLACK, Color.LIMEGREEN, Color.BLACK, Color.BLACK},
                        {Color.BLACK, Color.LIMEGREEN, Color.BLACK, Color.LIMEGREEN},
                        {Color.BLACK, Color.LIMEGREEN, Color.LIMEGREEN, Color.BLACK},
                        {Color.BLACK, Color.LIMEGREEN, Color.LIMEGREEN, Color.LIMEGREEN},
                        
                        {Color.LIMEGREEN, Color.BLACK, Color.BLACK, Color.BLACK},
                        {Color.LIMEGREEN, Color.BLACK, Color.BLACK, Color.LIMEGREEN},
                        {Color.LIMEGREEN, Color.BLACK, Color.LIMEGREEN, Color.BLACK},
                        {Color.LIMEGREEN, Color.BLACK, Color.LIMEGREEN, Color.LIMEGREEN},
                        
                        {Color.LIMEGREEN, Color.LIMEGREEN, Color.BLACK, Color.BLACK},
                        {Color.LIMEGREEN, Color.LIMEGREEN, Color.BLACK, Color.LIMEGREEN},
                        {Color.LIMEGREEN, Color.LIMEGREEN, Color.LIMEGREEN, Color.BLACK},
                        {Color.LIMEGREEN, Color.LIMEGREEN, Color.LIMEGREEN, Color.LIMEGREEN},                        
    };
    
    @Override
    public void start(Stage primaryStage) {
        
        Label eticheta1 = new Label("Valoarea numarului in cod binar (verde=1 si negru=0):");
        eticheta1.setLayoutX(115);
        eticheta1.setLayoutY(10);
        eticheta1.setPrefHeight(25);
        eticheta1.setPrefWidth(300);
        eticheta1.setAlignment(Pos.CENTER);
        eticheta1.setStyle("-fx-background-color: yellow;");
        
        Canvas canvas = new Canvas(530,230);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        GraphicsContext gc = canvas.getGraphicsContext2D();
         
        Pspatiu=Lsemafor/37;
        Dbec=8*Pspatiu;
        Hsemafor=10*Pspatiu; // in functie de inaltime semafor
        
        //deseneaza cadrul exterior al semaforului
        gc.setStroke(Color.DARKBLUE);  
        gc.setLineWidth(20);
        gc.strokeRect(x0,y0,Lsemafor,Hsemafor);
        gc.setFill(Color.CADETBLUE); 
        gc.fillRect(x0,y0,Lsemafor,Hsemafor);
        
        //deseneaza becurile semaforului
        for(int i=0;i<4;i++) {
            gc.setStroke(Color.DARKBLUE);
            gc.setLineWidth(5);
            gc.strokeOval(x0+Pspatiu+i*(Pspatiu+Dbec),y0+Pspatiu,Dbec,Dbec);
            gc.setFill(culoare[0][i]);
            gc.fillOval(x0+Pspatiu+i*(Pspatiu+Dbec),y0+Pspatiu,Dbec,Dbec);
        } 
        
        Label eticheta = new Label("Valoarea numarului in cod zecimal este 0");
        eticheta.setLayoutX(115);
        eticheta.setLayoutY(260);
        eticheta.setPrefHeight(25);
        eticheta.setPrefWidth(300);
        eticheta.setAlignment(Pos.CENTER);
        eticheta.setStyle("-fx-background-color: yellow;");
        
        
        Button pornestesemafor = new Button();
        pornestesemafor.setText("Afiseaza succesiv numerele de la 0 la 15 in cod zecimal si binar");
        pornestesemafor.setLayoutX(75);
        pornestesemafor.setLayoutY(300);
        pornestesemafor.setPrefHeight(25);
        pornestesemafor.setPrefWidth(400);
        pornestesemafor.setOnAction((ActionEvent event) -> {
            n=++n%16;
            eticheta.setText("Valoarea numarului in cod zecimal este "+n);
            for(int i=0;i<4;i++) {
                gc.setFill(culoare[n][i]);
                gc.fillOval(x0+Pspatiu+i*(Pspatiu+Dbec),y0+Pspatiu,Dbec,Dbec);
            } 
        }); 
           
        Pane root = new Pane(); // pentru a putea da coordonate absolute controalelor
        root.getChildren().add(canvas);
        root.getChildren().add(eticheta1);
        root.getChildren().add(eticheta);
        root.getChildren().add(pornestesemafor);
        
        Scene scene = new Scene(root, 530, 350);
        
        primaryStage.setTitle("Silviu Sulita - JavaFX - Leduri Conversie");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
