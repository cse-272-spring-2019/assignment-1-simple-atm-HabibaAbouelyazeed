import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DepositeWindow {
	Stage stage;
	Scene depositeWindowScene;
	BankAccount myAccount;
	HomePage homePage;
	
	public DepositeWindow(Stage stage,BankAccount myAccount) {
		this.stage = stage;
		this.myAccount = myAccount;
	}
	
	public void prepareScene(){
		Button back = new Button("Back");
		Button enter = new Button("Enter");
		Label onScreen = new Label("Deposite");
		Label inputAmount = new Label("Deposite amount: ");
		TextField amount = new TextField();
		Label result = new Label();
		Label spaceLine = new Label();
		
		
		GridPane grid = new GridPane();
		grid.add(onScreen, 1, 0);
		grid.add(spaceLine, 0, 1);
		grid.add(inputAmount, 0, 2);
		grid.add(amount, 1, 2);
		grid.add(enter, 1, 3);
		grid.add(back, 0, 4);
		grid.add(result, 1, 5);
		
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				myAccount.i = myAccount.history.size() - 1;
				stage.setScene(homePage.getScene());
			}
		});
		
		enter.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String myAmount = amount.getText();
				
				if (myAmount != null && !myAmount.isEmpty()) {
					double myAmountDouble = Double.parseDouble(myAmount);
					myAccount.deposit(myAmountDouble);
					result.setText("Amount successfully deposited");
				}
				else 
					result.setText("Enter amount to be deposited");
				
				amount.setText(null);
			}

		});
		
		
		
		depositeWindowScene = new Scene(grid,500,200);

	}
	
	public Scene getScene() {
		return this.depositeWindowScene;
	}
	
	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}

}
