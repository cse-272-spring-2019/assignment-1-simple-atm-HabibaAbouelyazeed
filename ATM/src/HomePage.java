import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HomePage{
	Stage stage;
	Scene homePageScene;
	
	LoginForm loginForm;
	DepositeWindow depositeWindow;
	WithdrawWindow withdrawWindow;
	BankAccount myAccount;
	
	public HomePage(Stage stage,BankAccount myAccount) {
		this.stage = stage;
		this.myAccount = myAccount;
	}

	public void prepareScene(){
		
		Label mainMenu = new Label("          Main Menu        ");
		Label spaceLine = new Label();
		Label choice = new Label("Please select your choice:");
		Label onScreen = new Label();
		Button withdraw = new Button("          Withdraw           ");
		Button deposite = new Button("           Deposite           ");
		Button balanceInquiry = new Button("       Balance Inquiry     ");
		Button next = new Button("    Next    ");
		Button previous = new Button("  Previous  ");
		Label history = new Label("      Transaction History:");
		Button logout = new Button("logout");
		Label spaceLine2 = new Label();
		
		GridPane grid = new GridPane();
		grid.add(mainMenu, 1, 0);
		grid.add(spaceLine, 0, 1);
		grid.add(choice, 1, 2);
		grid.add(onScreen, 1, 3);
		grid.add(withdraw, 1, 4);
		grid.add(deposite, 1, 5);
		grid.add(balanceInquiry, 1, 6);
		grid.add(history, 1, 8);
		grid.add(previous, 0, 9);
		grid.add(next, 2, 9);
		grid.add(spaceLine2, 0, 10);
		grid.add(logout, 2, 11);
		
		
		withdraw.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(withdrawWindow.getScene());
			}
		});
		
		deposite.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(depositeWindow.getScene());
			}
		});
		
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				onScreen.setText("Current Balance: " + myAccount.balanceInquiry());
			}
		});
		
		previous.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(myAccount.history.size() == 0)
					onScreen.setText("No History exist");
				else
					onScreen.setText(myAccount.previousHistory());
			}
			
		});
		
		next.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(myAccount.history.size() == 0)
					onScreen.setText("No History exist");
				else
					onScreen.setText(myAccount.nextHistory());
			}
		});
		
		logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(loginForm.getScene());
			}
		});
		
		
		homePageScene = new Scene(grid,500,400);
	}
	
	public Scene getScene() {
		return this.homePageScene;
	}
	
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	
	public void setDepositeWindow(DepositeWindow depositeWindow) {
		this.depositeWindow = depositeWindow;
	}
	public void setWithdrawWindow(WithdrawWindow withdrawWindow) {
		this.withdrawWindow = withdrawWindow;
	}
}
