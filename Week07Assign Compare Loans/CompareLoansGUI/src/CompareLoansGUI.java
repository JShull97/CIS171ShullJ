/**
* Program: Compare Loans
* Developer: Justin Shull
* Date: 3/5/19
* Purpose: Use GUI Applications to display loan payments
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CompareLoansGUI extends Application{
    TextField numOfYears = new TextField();
    TextField loanAmt = new TextField();
    VBox table = new VBox(5);
    
    @Override 
    public void start(Stage primaryStage) {
        // set textfields
        table.setPadding(new Insets(10, 25, 25, 25));
        table.setAlignment(Pos.CENTER);
        loanAmt.setPrefColumnCount(8);       
        numOfYears.setPrefColumnCount(5);
        Button showTable = new Button("Show Table");
        
        // set HBox
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Loan Amount: "), loanAmt, new Label("Number of Years: "), numOfYears, showTable);
        
        // set event listener
        showTable.setOnAction(e -> displayTable());
        
        // set VBox
        VBox vBox = new VBox(hBox, table);
        
        //set stage
        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Compare Loans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public VBox displayTable() {
        int years = Integer.parseInt(numOfYears.getText());
        double loan = Double.parseDouble(loanAmt.getText());
        double interestRate = 5.0;
        HBox header = new HBox(5);
        
        header.getChildren().addAll(new Label("Interest Rate\t"), new Label("Monthly Payment\t"), new Label("Total Payment"));
        table.getChildren().add(header);
        
        double monthlyPayment;
        double totalPayment;
        for (int i = 1; i <= years * 12; i++) {
            // set vars
            monthlyPayment = loan * interestRate / 12 / 100;
            totalPayment = (monthlyPayment * 12 * years * 100);
            String strMonthlyPayment = String.format("%.2f", monthlyPayment);
            String strTotalPayment = String.format("%.2f", totalPayment);
            String text = Double.toString(Math.abs(interestRate));
            int integerPlaces = text.indexOf('.');
            int decimalPlaces = text.length() - integerPlaces - 1;
            HBox temp = new HBox(5);
            
            // add payment to the table
            if (decimalPlaces < 3) temp.getChildren().addAll(new Label(String.valueOf(interestRate) + "\t\t\t"), new Label(strMonthlyPayment + "\t\t\t"), new Label(strTotalPayment));
            else temp.getChildren().addAll(new Label(String.valueOf(interestRate) + "\t\t"), new Label(strMonthlyPayment + "\t\t\t"), new Label(strTotalPayment));
            table.getChildren().add(temp);
            
            if (interestRate < 8.0) interestRate+= 0.125;
        }        
        table.setStyle("-fx-border-color: blue;");
        return table;
    }
  
    public static void main(String[] args) {
        launch(args);
    }    
}
