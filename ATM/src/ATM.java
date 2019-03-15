import javafx.application.Application;
import javafx.stage.Stage;


public class ATM  extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		BankAccount myAccount = new BankAccount("Habiba", 123, 1000);

		
		LoginForm loginForm = new LoginForm(primaryStage, myAccount);
		HomePage homePage = new HomePage(primaryStage, myAccount);
		DepositeWindow depositeWindow = new DepositeWindow(primaryStage, myAccount);
		WithdrawWindow withdrawWindow = new WithdrawWindow(primaryStage, myAccount);
		
		loginForm.prepareScene();
		homePage.prepareScene();
		depositeWindow.prepareScene();
		withdrawWindow.prepareScene();
		
		
		loginForm.setHomePage(homePage);
		homePage.setLoginForm(loginForm);
		homePage.setDepositeWindow(depositeWindow);
		homePage.setWithdrawWindow(withdrawWindow);
		depositeWindow.setHomePage(homePage);
		withdrawWindow.setHomePage(homePage);
		
		primaryStage.setScene(loginForm.getScene());
		
		primaryStage.show();
		
	}

}
