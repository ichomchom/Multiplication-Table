package lab07;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Multiplication extends Application {
	GridPane grid = new GridPane();
	HBox hBox = new HBox();
	VBox vBox = new VBox();
	TextField txt = new TextField();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	

		
		BorderPane pane = new BorderPane();
		
		pane.setTop(getVBox());
		pane.setCenter(getHBox());
		pane.setBottom(getGrid());
		
	
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("lab07/style.css");

		
		
		primaryStage.setTitle("Lab 07");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private GridPane getGrid() {
	
		for(int i = 0;i<11;i++){
			Label lb = new Label(i+ " ");
			lb.getStyleClass().add("OUT");
			grid.addRow(i, lb);
		}
		
		for(int k = 1;k<11;k++){
			Label lb = new Label(k+ " ");
			lb.getStyleClass().add("OUT");
			grid.addColumn(k, lb);
		}
	
	
		for(int i = 1; i<11; i++){
			for (int k = 1; k<11;k++){
				Label lb = new Label (i +" * "+ k);
				grid.add(lb, i, k);
				lb.getStyleClass().add("GRID");
			}
		}

		return grid;
	}

	
	private VBox getVBox() {
		
		
		

		
		vBox.setPadding(new Insets(10,10,10,10));
		Text title = new Text("Reverse Multiplication Table");
		title.setFont(Font.font("Arial", FontWeight.BOLD,20));
		vBox.getChildren().add(title);
		
		vBox.getStyleClass().add("VBOX");
	
		return vBox;
	}

	private HBox getHBox(){
		
		
		
		
		
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.getChildren().add(new Label("Enter Answer: "));
	
		hBox.getChildren().add(txt);
		Button btn = new Button("Find Problems");
		hBox.getChildren().add(btn);
		
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				int answer = Integer.parseInt(txt.getText());
				Label lb = new Label();
				for (int i =1;i<11;i++){
					for (int k=1;k<11;k++){
						if (i*k == answer){
							lb = new Label(i +" * "+k);
							grid.add(lb,i,k);
							lb.getStyleClass().add("CHANGE");
							
							
						}
					}
				}
			}
			
		});
		
		hBox.getStyleClass().add("HBOX");

		return hBox;
	}
	


}

/*int[][] multi= new int[11][11];
		for(int i =1; i<11;i++){
			for(int j = 1; j<11;j++){
				hBox.getChildren().add(new Label( Integer.toString(i)+ "*" +Integer.toString(j)));
 */
