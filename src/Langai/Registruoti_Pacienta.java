package Langai;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paciento_info.Pacientas;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;

/** Klasė kurioj yra aprašomos paciento registravimo meniu punktas
 * Created by Dovile on 2016-05-23.
 */
public class Registruoti_Pacienta {

    public Registruoti_Pacienta(){}

    /** Sukuriamas "Užregistruoti" langas*/
    public GridPane createUzregistruoti(Stage primaryStage){
        /** Lango sukūrimas*/
        GridPane gridNaujas = new GridPane();
        gridNaujas.setHgap(20);
        gridNaujas.setVgap(15);
        gridNaujas.setPadding(new Insets(10,0,10,10));

        /** GUI visi veiksmai: Labels, TextBox ir t.t.*/
        /**Paciento registravimas (gridNaujas)*/

        Label fikt1 = new Label("aaaaaaaaaaa");
        gridNaujas.add(fikt1,6,1);
        fikt1.setVisible(false);

        Label vardas = new Label("Vardas");
        gridNaujas.add(vardas,1,1);
        TextField var = new TextField();
        gridNaujas.add(var,2,1);

        Label pavarde = new Label("Pavardė");
        gridNaujas.add(pavarde,4,1);
        TextField pav = new TextField();
        gridNaujas.add(pav,5,1);

        Label kodas = new Label("Asmens kodas");
        gridNaujas.add(kodas,1,2);
        TextField kod = new TextField();
        gridNaujas.add(kod,2,2);

        Label amzius = new Label("Amžius");
        gridNaujas.add(amzius,1,3);
        TextField amz = new TextField();
        gridNaujas.add(amz,2,3);

        Label adresas = new Label("Adresas");
        gridNaujas.add(adresas,4,2);
        TextField adr = new TextField();
        gridNaujas.add(adr,5,2);

        Label telefonas = new Label("Telefonas");
        gridNaujas.add(telefonas,4,3);
        TextField tel = new TextField();
        gridNaujas.add(tel,5,3);

        /**Gimimo datos nustatymas*/
        Label gimimoData = new Label("Gimimo data");
        gridNaujas.add(gimimoData,1,4);
        ChoiceBox<Integer> gimMetai = new ChoiceBox<>();
        ChoiceBox<String> gimMen = new ChoiceBox<>();
        ChoiceBox<Integer> gimDien = new ChoiceBox<>();
        data(gridNaujas, 4,1, gimMetai, gimMen, gimDien, false);

        /**Amziaus skaiciavimas is asmens kodo*/
        String[] code = new String[1];
        kod.textProperty().addListener((observable, oldValue, newValue) -> {
            code[0] = kod.getText();
            if (code[0].length() == 11) {
                String amziusString = koksAmzius(code,true);
                String gimDataString = koksAmzius(code,false);
                int amz_Int = Integer.parseInt(amziusString);
                amz.setText(Integer.toString(amz_Int));
                String[] gimData = new String[3];
                gimData = gimDataString.split(",");
                gimMetai.setValue(Integer.parseInt(gimData[0]));
                gimMen.setValue(menPavadinimas(Integer.parseInt(gimData[1])));
                gimDien.setValue(Integer.parseInt(gimData[2]));

                kod.setStyle("-fx-focus-color: green");
            }
            else {
                kod.setStyle("-fx-focus-color: red");
                amz.setText("");
            }
        });

        Label lytis = new Label("Lytis");
        gridNaujas.add(lytis,1,5);
        ChoiceBox<String> lyt = new ChoiceBox<>();
        lyt.getItems().addAll("Vyras", "Moteris");
        gridNaujas.add(lyt,2,5);


        Label profesija = new Label("Profesija");
        gridNaujas.add(profesija,4,4);
        TextField prof = new TextField();
        gridNaujas.add(prof,5,4);

        Label alkoholis = new Label("Alkoholis (kelis kartu per savaitę)");
        gridNaujas.add(alkoholis,1,7);
        ChoiceBox<String> alko = new ChoiceBox<>();
        alko.getItems().addAll("Taip", "Ne");
        gridNaujas.add(alko,2,7);

        Label rukymas = new Label("Rūkymas (kiekvieną dieną)");
        gridNaujas.add(rukymas,3,7);
        ChoiceBox<String> ruk = new ChoiceBox<>();
        ruk.getItems().addAll("Taip", "Ne");
        gridNaujas.add(ruk,4,7);

        Label data = new Label("Pirmas apsilankymas");
        gridNaujas.add(data,1,8);
        ChoiceBox<Integer> me = new ChoiceBox<>();
        ChoiceBox<String> men = new ChoiceBox<>();
        ChoiceBox<Integer> dien = new ChoiceBox<>();
        data(gridNaujas, 8, 1, me, men, dien, true);

        Button registruoti = new Button("Registruoti");
        gridNaujas.add(registruoti,5,20);
        registruoti.setStyle("-fx-font-size: 15px;");

        Button isvalyti = new Button("Išvalyti");
        gridNaujas.add(isvalyti,6,20);
        isvalyti.setTranslateX(-52);

        registruoti.setOnAction(event1 -> {
            if (kod.getText().trim().isEmpty()) {
                trukstaSkaiciu(primaryStage,false,0);
            }
            else if (!kod.getText().trim().isEmpty()) {
                if  (code[0].length() == 11) {
                    Pacientas p = new Pacientas();
                    p.setVardas(var.getText());
                    p.setPavarde(pav.getText());
                    p.setAsmens_kodas(kod.getText());
                    p.setAmzius(Integer.parseInt(amz.getText()));
                    p.setAdresas(adr.getText());
                    p.setTel_nr(tel.getText());
                    String s = datosIrasymas(gimMetai, gimMen, gimDien);
                    p.setGim_data(s);
                    p.setLytis(lyt.getValue());
                    p.setProfesija(prof.getText());
                    boolean a;
                    if(alko.getValue().equalsIgnoreCase("Taip")){
                        a = true;
                    }
                    else{
                        a = false;
                    }
                    p.setAlkoholis(a);
                    if(ruk.getValue().equalsIgnoreCase("Taip")){
                        a = true;
                    }
                    else{
                        a = false;
                    }
                    p.setRukymas(a);
                    s = datosIrasymas(me, men, dien);
                    p.setPirmas_kreipimasis(s);

                    var.setText("");
                    pav.setText("");
                    kod.setText("");
                    amz.setText("");
                    adr.setText("");
                    tel.setText("");
                    prof.setText("");
                    lyt.setValue(null);
                    alko.setValue(null);
                    dien.setValue(null);
                    men.setValue(null);
                    me.setValue(null);
                    ruk.setValue(null);

                    try {
                        p.setPacientas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    Alert regis = new Alert(Alert.AlertType.INFORMATION);
                    regis.setTitle("Registracija");
                    Button ok_registr = (Button) regis.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis.setHeaderText("Pacientas sėkmingai įregistruotas");
                    regis.initModality(Modality.APPLICATION_MODAL);
                    regis.initOwner(primaryStage);
                    regis.showAndWait();
                }
                else {
                    trukstaSkaiciu(primaryStage,true,code[0].length());
                }
            }
        });

        isvalyti.setOnAction(event1 -> {
            var.setText("");
            pav.setText("");
            kod.setText("");
            amz.setText("");
            adr.setText("");
            tel.setText("");
            prof.setText("");
            lyt.setValue(null);
            alko.setValue(null);
            dien.setValue(null);
            men.setValue(null);
            me.setValue(null);
            ruk.setValue(null);
        });
        primaryStage.setOnCloseRequest(event -> {
            if (!var.getText().isEmpty() || !pav.getText().isEmpty() || !kod.getText().isEmpty()
                    || !adr.getText().isEmpty() || !amz.getText().isEmpty() || !tel.getText().isEmpty()
                    || !prof.getText().isEmpty()) {
                Alert closeConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Neišsaugotas darbas bus prarastas");
                closeConfirmation.setTitle("Dėmesio");
                Button uzdaryti = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
                Button atsaukti = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.CANCEL);
                uzdaryti.setText("Uždaryti");
                atsaukti.setText("Atšaukti");
                closeConfirmation.setHeaderText("Ar tikrai norite uždaryti?");
                closeConfirmation.initModality(Modality.APPLICATION_MODAL);
                closeConfirmation.initOwner(primaryStage);

                Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
                if (!ButtonType.OK.equals(closeResponse.get())) {
                    event.consume();
                }
            }
        });

        return gridNaujas;
    }

    /** Datos įrašymas, su mygtuku Šiandien
     * @param grid - kokiam GridPane pridedam datos pasirinkimą;
     * @param i - vieta GridPane, eilutes vieta;
     * @param j - vieta GridPane, stulpelio vieta;
     * @param me - metu choiceBox;
     * @param men - menesiu choiceBox;
     * @param dien - dienos choiceBox;
     * @param sian - nustabo ar reikia šiandien mygtuko, jei true reikia, kitais atvejais nereikia;*/
    public void data(GridPane grid, int i, int j, ChoiceBox<Integer> me, ChoiceBox<String> men, ChoiceBox<Integer> dien, boolean sian){
        /** Metų pasirinkimas*/
        Calendar data_metai = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String d1 = formatter.format(data_metai.getTime());
        int yea = Integer.parseInt(d1);

        /** Datos nustatymai*/
        me.getItems().addAll(yea + 1, yea, yea - 1, yea - 2 , yea - 3, yea - 4);
        grid.add(me,j+1,i);
        men.getItems().addAll("Sausis", "Vasaris", "Kovas", "Balandis", "Gegužė", "Birželis", "Liepa", "Rugpjūtis",
                "Rugsėjis", "Spalis", "Lapkritis", "Gruodis");
        grid.add(men,j+2,i);
        men.setTranslateX(-90);
        grid.add(dien,j+3,i);
        dien.setTranslateX(-155);

        men.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            dien.getItems().clear();
            grid.getChildren().remove(dien);
            if (Arrays.asList(0, 2, 4, 6, 7, 9, 11).contains(new_value.intValue())) {
                dien.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
                grid.add(dien, j+3, i);
                dien.setTranslateX(-155);
            } else if (new_value.intValue() == 1) {
                dien.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);
                grid.add(dien, j+3, i);
                dien.setTranslateX(-155);
            } else {
                dien.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
                grid.add(dien, j+3, i);
                dien.setTranslateX(-155);
            }
        });
        if (sian) {
            /**Sios dienos datos nustatymas*/
            Button siandien = new Button("Šiandien");
            grid.add(siandien,j+4,i);
            siandien.setTranslateX(-167);

            siandien.setOnAction((event) -> {
                Calendar date1 = Calendar.getInstance();
                SimpleDateFormat f1 = new SimpleDateFormat("yyyy");
                SimpleDateFormat f2 = new SimpleDateFormat("MM");
                SimpleDateFormat f3 = new SimpleDateFormat("dd");

                String da1 = f1.format(date1.getTime());
                String da2 = f2.format(date1.getTime());
                String da3 = f3.format(date1.getTime());

                me.setValue(Integer.parseInt(da1));
                men.setValue(menPavadinimas(Integer.parseInt(da2)));
                dien.setValue(Integer.parseInt(da3));
            });
        }
    }
    /**
     * Randa menesio pavadinima is duoto skaiciaus
     * @param men - paduodamas menesio skaicius
     * @return menesio pavadinima String formatu
     */
    public String menPavadinimas(int men) {

        String mene = "";
        switch (men) {
            case 1:
                mene = "Sausis";
                break;
            case 2:
                mene = "Vasaris";
                break;
            case 3:
                mene = "Kovas";
                break;
            case 4:
                mene = "Balandis";
                break;
            case 5:
                mene = "Gegužė";
                break;
            case 6:
                mene = "Birželis";
                break;
            case 7:
                mene = "Liepa";
                break;
            case 8:
                mene = "Rugpjūtis";
                break;
            case 9:
                mene = "Rugsėjis";
                break;
            case 10:
                mene = "Spalis";
                break;
            case 11:
                mene = "Lapkritis";
                break;
            case 12:
                mene = "Gruodis";
                break;
        }
        return mene;
    }
    /** Iš ChoiseBox grąžina datą String formatu.
     * @param me - metai;
     * @param men - menesiai;
     * @param day - diena;*/
    public String  datosIrasymas(ChoiceBox<Integer> me, ChoiceBox<String> men, ChoiceBox<Integer> day){
        String s = String.valueOf(me.getValue());
        switch(men.getValue()){
            case "Sausis":
                s += "-01-";
                break;
            case "Vasaris":
                s += "-02-";
                break;
            case "Kovas":
                s += "-03-";
                break;
            case "Balandis":
                s += "-04-";
                break;
            case "Gegužė":
                s += "-05-";
                break;
            case "Birželis":
                s += "-06-";
                break;
            case "Liepa":
                s += "-07-";
                break;
            case "Rugpjūtis":
                s += "-08-";
                break;
            case "Rugsėjis":
                s += "-09-";
                break;
            case "Spalis":
                s += "-10-";
                break;
            case "Lapkritis":
                s += "-11-";
                break;
            default:
                s += "-12-";
                break;
        }
        s += String.valueOf(day.getValue());
        return s;
    }
    /** Ismeta warninga jei asmens kodas trumpesinis ar ilgesnis nei 11 skaitmenu
     * @param st - naudojamo stage pavadinimas;
     * @param b - ar asmens kodas turi skaitmenu (ar kazkas buvo vesta i asmens kodo textfielda);
     * @param skaitm - asmens kodo ilgis;*/
    public void trukstaSkaiciu(Stage st, boolean b, int skaitm) {

        Alert mazai_skaiciu = new Alert(Alert.AlertType.WARNING, "Asmens kodas turi susidaryti iš 11 skaičių !!!");
        mazai_skaiciu.setTitle("Dėmesio !!!");
        Button kodo_mazai = (Button) mazai_skaiciu.getDialogPane().lookupButton(ButtonType.OK);
        kodo_mazai.setText("OK");
        if (b && skaitm > 11){
            mazai_skaiciu.setHeaderText("Per daug skaičių");
        }
        else {
            mazai_skaiciu.setHeaderText("Per mažai skaičių");
        }
        mazai_skaiciu.initModality(Modality.APPLICATION_MODAL);
        mazai_skaiciu.initOwner(st);
        mazai_skaiciu.showAndWait();
    }
    /** suskaiciuoja zmogaus amziu ir gimimo data is asmens kodo
     * @param a - asmens kodas String[] formatu;
     * @param b - nustatoma ar skaiciuosi amzius ar gimimo data;
     * @return amzius arba gimimo data string formatu (gimimo data skiriama kableliais pvz 1995,03,11); */
    public String koksAmzius(String[] a, boolean b) {

        Calendar data = Calendar.getInstance();
        String gimDien;

        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String d1 = formatter.format(data.getTime());

        String kodas = Arrays.toString(a);
        kodas = kodas.substring(2, kodas.length() - 5);

        int gimMetai = Integer.parseInt(kodas.substring(0, 2));
        int gimMenuo = Integer.parseInt(kodas.substring(2, 4));
        int gimDiena = Integer.parseInt(kodas.substring(4, 6));
        int metai = Integer.parseInt(d1.substring(0, 2));
        int menuo = Integer.parseInt(d1.substring(2, 4));
        int diena = Integer.parseInt(d1.substring(4, 6));

        if (b) {
            int amzius = metai - gimMetai;
            if (amzius < 0) {
                amzius = 100 + amzius;
            }
            if (gimMenuo > menuo) {
                amzius = amzius - 1;
            }
            if (gimMenuo == menuo && gimDiena > diena) {
                amzius = amzius - 1;

            }
            gimDien = Integer.toString(amzius);
        }
        else {
            if (gimMetai > metai) {
                gimDien = "19"+gimMetai+","+gimMenuo+","+gimDiena;
            }
            else {
                gimDien = "20"+gimMetai+","+gimMenuo+","+gimDiena;
            }
        }
        return gimDien;
    }
}
