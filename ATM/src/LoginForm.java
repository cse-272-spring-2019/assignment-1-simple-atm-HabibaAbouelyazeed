import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {
	Stage stage;
	Scene loginFormScene;
	BankAccount myAccount;
	HomePage homePage;
	
	public LoginForm(Stage stage,BankAccount myAccount) {
		this.stage = stage;
		this.myAccount = myAccount;
	}
	
	
	public void prepareScene() {
		Label welcome = new Label("Welcome to your bank ATM");
		Label spaceLine = new Label();
		Label userName = new Label("Username: ");
		Label cardNumber = new Label("Card Number: ");
		TextField userNameInput = new TextField();
		TextField cardNumberInput = new TextField();
		Button enter = new Button("Enter");
		Label validationResult = new Label();
		
		GridPane grid = new GridPane();
		grid.add(welcome, 2, 0);
		grid.add(spaceLine, 0, 1);
		grid.add(userName, 0, 2);
		grid.add(userNameInput, 2, 2);
		grid.add(cardNumber, 0, 3);
		grid.add(cardNumberInput, 2, 3);
		grid.add(enter, 2, 4);
		grid.add(validationResult, 2, 5);
		
		enter.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String myUsername = userNameInput.getText();
				String myCardNumber = cardNumberInput.getText();
				
				boolean valide = myAccount.validate (myUsername, myCardNumber);
				if (valide) {
					validationResult.setText(null);
					userNameInput.setText(null);
					cardNumberInput.setText(null);
					stage.setScene(homePage.getScene());
				}
				else
					validationResult.setText("Incorrect username or card number");
			} 
		});
		
		loginFormScene = new Scene(grid,400,400);
	}
	
	public Scene getScene() {
		return this.loginFormScene;
	}
	
	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}
	
}
