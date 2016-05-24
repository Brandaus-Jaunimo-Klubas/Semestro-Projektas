import Langai.Paciento_Info_Langas;
import Langai.Registruoti_Pacienta;
import Langai.Statistikos_Langas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Aplikacijos kūrimo klasė
 * Created by Mantas Visockis on 03/19/16.
 */

public class Pagrindinis_Langas extends Application {

    private Registruoti_Pacienta regPac = new Registruoti_Pacienta();
    private Statistikos_Langas stati = new Statistikos_Langas();
    private Paciento_Info_Langas pacInfo = new Paciento_Info_Langas();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("GKPN Registravimo sistema");

        /** Meniu nustatymai */
        MenuBar menuBar = new MenuBar();

        Menu pacientas = new Menu("Užregistruoti pacientą.");
        Menu papild = new Menu("Papildyti pacientą.");
        Menu statist = new Menu("Statistika.");

        MenuItem sta = new MenuItem("Statistika");
        MenuItem uzreg = new MenuItem("Užregistruoti.");
        MenuItem paieska = new MenuItem("Paieška.");
        MenuItem dienyn = new MenuItem("Dienynas.");
        MenuItem gyd = new MenuItem("Gydymas.");
        // MenuItem mdk = new MenuItem("MDK.");
        MenuItem pac = new MenuItem("Paciento Duomenys.");

        statist.getItems().addAll(sta);
        pacientas.getItems().addAll(uzreg);
        papild.getItems().addAll(paieska, pac, dienyn, gyd);

        menuBar.getMenus().addAll(pacientas);
        menuBar.getMenus().addAll(papild);
        menuBar.getMenus().addAll(statist);

        /**Pagrindiniai Panes ir Scenes*/
        ScrollPane scroll = new ScrollPane();
        BorderPane border = new BorderPane();
        border.setTop(menuBar);
        Scene naujas = new Scene(scroll, 758, 600);
        Scene pagrindinis = new Scene(border, 758, 600);
        primaryStage.setScene(pagrindinis);


        /**Scrollbar padidinimas/visi Pane nustatymai*/
        scroll.setStyle("-fx-font-size: 16px;");
        border.setStyle(/*"-fx-padding: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;" +*/
                "-fx-font-size: 11px;");

        /** Paciento registracijos sukūrimas */
        GridPane registruotiPacienta = regPac.createUzregistruoti(primaryStage);
        pacientas.setOnAction((event) -> {
            border.setCenter(registruotiPacienta);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        /** Statiskitos sukūrimas */
        GridPane stat = stati.createStatistika(primaryStage);
        statist.setOnAction((event) -> {
            border.setCenter(stat);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        /** Paieškos sukūrimas */
        Stage pacientoPaieska = pacInfo.createPaieska(primaryStage);
        paieska.setOnAction((event) -> {
            pacientoPaieska.show();
        });

        /** Paciento info rodymo langas */
        GridPane gridPac = pacInfo.createPacInfo(primaryStage, border, naujas, scroll);
        primaryStage.setResizable(false);
        primaryStage.show();
        pac.setOnAction((event) -> {
            border.setCenter(gridPac);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        /** Gydymo rodymas */
        GridPane gridRodGyd = pacInfo.createRodGydymas();
        primaryStage.setResizable(false);
        primaryStage.show();
        gyd.setOnAction((event) -> {
            border.setCenter(gridRodGyd);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        /** Apžiūros rodymas (Dienynas) */
        GridPane gridRodApz = pacInfo.createRodApziura();
        primaryStage.setResizable(false);
        primaryStage.show();
        dienyn.setOnAction((event) -> {
            border.setCenter(gridRodApz);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });
    }
}