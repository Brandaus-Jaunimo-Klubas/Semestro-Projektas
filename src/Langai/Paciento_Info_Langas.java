package Langai;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paciento_info.Apziura;
import paciento_info.Gydymas;
import paciento_info.Pacientas;
import paciento_info.Vezys;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/** Klase skirta sukurti Paciento Informacijos meniu punktą
 * Created by Dovile on 2016-05-23.
 */
public class Paciento_Info_Langas {
    private Registruoti_Pacienta regPac = new Registruoti_Pacienta();
    private String pacientoKodas = new String();
    private String gydymasPapil = new String();
    private String apziuraPapil = new String();


    public Paciento_Info_Langas(){}

    /** Paciento inforamcijos ir vežių rodymo langas */
    public GridPane createPacInfo(Stage primaryStage, BorderPane border, Scene naujas, ScrollPane scroll) throws SQLException {
        /** GridPane sukūrimas*/
        GridPane gridPac = new GridPane();
        gridPac.setHgap(20);
        gridPac.setVgap(15);
        gridPac.setPadding(new Insets(10,0,10,10));

        Pacientas p = new Pacientas();
        pacientoKodas = p.getPaieskaKodas();
        p.getPacientas(pacientoKodas);
        Label fiktpac1 = new Label("");
        gridPac.add(fiktpac1,6,1);

        Label vardasPac = new Label("Vardas:");
        gridPac.add(vardasPac,1,1);
        Label varPac = new Label(p.getVardas());
        gridPac.add(varPac, 2, 1);

        Label pavardePac = new Label("Pavardė:");
        gridPac.add(pavardePac,3,1);
        Label pavPac = new Label(p.getPavarde());
        gridPac.add(pavPac,4,1);

        Label kodasPac = new Label("Asmens kodas:");
        gridPac.add(kodasPac,1,2);
        Label kodPac = new Label(p.getAsmens_kodas());
        gridPac.add(kodPac,2,2);

        Label amziusPac = new Label("Amžius:");
        gridPac.add(amziusPac,1,3);
        Label amzPac = new Label(""+p.getAmzius());
        gridPac.add(amzPac,2,3);

        Label adresasPac = new Label("Adresas:");
        gridPac.add(adresasPac,3,2);
        Label adrPac = new Label(p.getAdresas());
        gridPac.add(adrPac,4,2);

        Label telefonasPac = new Label("Telefonas:");
        gridPac.add(telefonasPac,3,3);
        Label telPac = new Label(p.getTel_nr());
        gridPac.add(telPac,4,3);

        Label gimimoDataPac = new Label("Gimimo data:");
        gridPac.add(gimimoDataPac,1,4);
        Label gimDataPac = new Label(p.getGim_data());
        gridPac.add(gimDataPac,2,4);

        Label lytisPac = new Label("Lytis:");
        gridPac.add(lytisPac,1,5);
        Label lytPac = new  Label(p.getLytis());
        gridPac.add(lytPac,2,5);

        Label profesijaPac = new Label("Profesija:");
        gridPac.add(profesijaPac,3,4);
        Label profPac = new Label(p.getProfesija());
        gridPac.add(profPac,4,4);

        Label alkoholisPac = new Label("Alkoholis (kelis kartu per savaitę):");
        gridPac.add(alkoholisPac,1,7);
        String s;
        if(p.isAlkoholis()){
            s = "Taip";
        }
        else {
            s = "Ne";
        }
        Label alkoPac = new  Label(s);
        gridPac.add(alkoPac,2,7);

        Label rukymasPac = new Label("Rūkymas (kiekvieną dieną):");
        gridPac.add(rukymasPac,3,7);
        if(p.isRukymas()){
            s = "Taip";
        }
        else {
            s = "Ne";
        }
        Label rukPac = new  Label(s);
        gridPac.add(rukPac,4,7);
        Label dataPac = new Label("Pirmas apsilankymas:");
        gridPac.add(dataPac,1,8);
        Label dataPac1 = new Label(p.getPirmas_kreipimasis());
        gridPac.add(dataPac1,2,8);
        /*Button redaguoti = new Button("Redaguoti pacientą.");
        gridPac.add(redaguoti,1,10);*/
        Button trinti = new Button("Naikinti pacientą.");
        gridPac.add(trinti,1,10);
        Button regVezi = new Button("Registruoti piktybinį naviką.");
        gridPac.add(regVezi,1,11);
        Button naikVezi = new Button("Naikinti piktybinį naviką.");
        gridPac.add(naikVezi, 2, 11);
        /*Button redVezi = new Button("Redaguoti piktybinį naviką.");
        gridPac.add(redVezi, 3, 11);*/
        Button regApziura = new Button("Registruoti apžiūrą.");
        gridPac.add(regApziura,1,12);
        Button regGyd = new Button("Registruoti gydymą.");
        gridPac.add(regGyd,2,12);
       /* Button regLigos = new Button("Registruoti gretutines ligas.");
        gridPac.add(regLigos,3,12);*/
        /*Button regKom = new Button("Registruoti komplikacijas.");
        gridPac.add(regKom,4,12);*/
        Vezys vezi = new Vezys();
        int n = vezi.getCount(pacientoKodas);
        Vezys veziai[];
        veziai = vezi.getVezys(pacientoKodas);

        for(int i = 1; i <= n; i++){
            int j = 12;
            vezi = veziai[i-1];
            Label pav22 = new Label("Piktybinis navikas nr. " +vezi.getNr());
            gridPac.add(pav22, 1, j*i+1);
            Label skundai = new Label("Skundai");
            gridPac.add(skundai,1,j*i+2);
            Label skund = new Label(vezi.getSkundo_pav());
            gridPac.add(skund,2,j*i+2,3,1);
            Label skundTrukme = new Label("Skundų trukmė");
            gridPac.add(skundTrukme,1,j*i+3);
            Label truk = new Label(""+vezi.getSkundo_trukme());
            gridPac.add(truk,2,j*i+3);
            Label sritis = new Label("Sritis");
            gridPac.add(sritis,1,j*i+4);
            Label srit = new Label(vezi.getSritis());
            gridPac.add(srit,2,j*i+4, 3,1);
            Label morfo = new Label("Morfologija");
            gridPac.add(morfo,1,j*i+5);
            Label mm = new Label(vezi.getMorfo());
            gridPac.add(mm,2,j*i+5);
            Label mm1 = new Label(vezi.getMorfo_kita());
            gridPac.add(mm1, 3, j*i+5);
            Label mKodas = new Label("M kodas");
            gridPac.add(mKodas,1,j*i+6);
            Label mk = new Label(""+vezi.getM_kodas());
            gridPac.add(mk,2,j*i+6);
            Label dif = new Label("Diferencijacija");
            gridPac.add(dif,3,j*i+6);
            Label dd = new Label(vezi.getDif());
            gridPac.add(dd,4,j*i+6);
            Label tnm = new Label("TNM");
            gridPac.add(tnm,1,j*i+7);
            Label tnm1 = new Label(vezi.getcTNM());
            gridPac.add(tnm1, 2, j*i+7);
            Label tnmrl = new Label("TNMRL");
            gridPac.add(tnmrl,3,j*i+7);
            Label tnmrl1 = new Label(vezi.getpTNMRL());
            gridPac.add(tnmrl1, 4, j*i+7);
            Label stadija = new Label("Stadija");
            gridPac.add(stadija, 1, j*i+8);
            Label ss = new Label(vezi.getStadija());
            gridPac.add(ss,2,j*i+8);
            Label rec = new Label("Recidyvas");
            gridPac.add(rec,1,j*i+9);
            Label rr;
            if(vezi.isRecidyvas_yra()) {
                rr = new Label("Yra");
            }
            else{
                rr = new Label("Nėra");
            }
            gridPac.add(rr,2,j*i+9);
            if(vezi.isRecidyvas_yra()){
                Label recTipas = new Label("Recidyvo tipas");
                gridPac.add(recTipas,3,j*i+9);
                Label rt = new Label(vezi.getRecidyvas_tipas());
                gridPac.add(rt,4,j*i+9);
                Label recData = new Label("Recidyvo data");
                gridPac.add(recData,1,j*i+10);
                Label recMetai = new Label(vezi.getRecidyvas_data());
                gridPac.add(recMetai, 2, j*i+10);
            }
            Label metas = new Label("Metastazės");
            gridPac.add(metas,1,j*i+11);
            Label me3;
            if(vezi.isMetastazes_yra()){
                me3 = new Label("Yra");
            }
            else {
                me3 = new Label("Nėra");
            }
            gridPac.add(me3, 2, j * i + 11);
            if(vezi.isMetastazes_yra()) {
                Label metasTipas = new Label("Metastazių tipas");
                gridPac.add(metasTipas, 3, j * i + 11);
                Label mt = new Label(vezi.getMetastazes_tipas());
                gridPac.add(mt, 4, j * i + 11);
                Label metasData = new Label("Metastazių data");
                gridPac.add(metasData, 1, j * i + 12);
                Label metasM = new Label(vezi.getMetastazes_data());
                gridPac.add(metasM, 2, j * i + 12);
            }
        }

        /** Mygtuko redaguoti - "Redaguoti pacientą." realizacija*/
        // TO DO

        /** Mygtuko trinti - "Naikinti pacientą." realizacija*/
        // TO DO

        /** Mygtuko regVezi -"Registruoti piktybinį naviką." realizacija*/
        GridPane gridVezys = createRegVezys(primaryStage);
        primaryStage.setResizable(false);
        primaryStage.show();
        regVezi.setOnAction((event) -> {
            border.setCenter(gridVezys);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        /** Mygtuko naikVezi -"Naikinti piktybinį naviką." realizacija*/
        Stage naikintVezys = createDeleteVezys();
        naikVezi.setOnAction((event1)->{
            naikintVezys.show();
        });

        /** Mygtuko redVezi - "Redaguoti piktybinį naviką." realizacija*/
        // TO DO

        /** Mygtuko regApziura - "Registruoti apžiūrą." reaklizacija*/
        Stage regApziuraPav = chooseApziuraPav(primaryStage, border, naujas, scroll);
        regApziura.setOnAction((event1)->{
            regApziuraPav.show();
        });

        /** Mygtuko regGyd - "Registruoti gydymą." realizacija*/
        Stage regGydymas = chooseGydymoPav(primaryStage, border, naujas, scroll);
        regGyd.setOnAction((event1)->{
            regGydymas.show();
        });

        /** Mygtuko regLigos -"Registruoti gretutines ligas." realizacija*/
        // TO DO

        /** Mygtuko regKom - "Registruoti komplikacijas." realizacija*/
        // TO DO

        return gridPac;
    }

    /** Paciento paiesko langelis*/
    public Stage createPaieska(Stage primaryStage){

        /** GridPane sukūrimas*/
        GridPane gridPaieskaDialog = new GridPane();
        gridPaieskaDialog.setHgap(20);
        gridPaieskaDialog.setVgap(15);
        gridPaieskaDialog.setPadding(new Insets(10,0,10,10));

        /** Stage sukūrimas*/
        Stage pacientoPaieska = new Stage();
        pacientoPaieska.setTitle("Paciento paieška");
        Scene dialoguScena = new Scene(gridPaieskaDialog,300,200);
        pacientoPaieska.setScene(dialoguScena);
        pacientoPaieska.setResizable(false);

        /** GUI sukūrimas*/
        Label ieskKodo = new Label("Asmens kodas");
        TextField ieskKod = new TextField();
        Button ieskoti = new Button("     Ieškoti     ");
        gridPaieskaDialog.add(ieskKodo,1,2);
        gridPaieskaDialog.add(ieskKod,2,2);
        gridPaieskaDialog.add(ieskoti,2,5);
        ieskoti.setTranslateX(-17);

        String[] code1 = new String[1];
        ieskKod.textProperty().addListener((observable, oldValue, newValue) -> {
            code1[0] = ieskKod.getText();
            if (code1[0].length() == 11) {
                ieskKod.setStyle("-fx-focus-color: green");
            }
            else {
                ieskKod.setStyle("-fx-focus-color: red");
            }
        });

        /** Mygtuko ieskoti realizacija*/
        ieskoti.setOnAction((event) -> {
            if (ieskKod.getText().trim().isEmpty()) {
                regPac.trukstaSkaiciu(pacientoPaieska,false,0);
            }
            else if (!ieskKod.getText().trim().isEmpty()) {
                if  (code1[0].length() == 11) {

                    Pacientas p = new Pacientas();

                    ieskoti.setOnAction((event1) -> {
                        pacientoKodas = ieskKod.getText();
                        try {
                            if(p.arPacientas_yra_DB(pacientoKodas) != 1){
                                neraTokioAsmensKodo(pacientoPaieska,pacientoKodas);
                            }
                            else{
                                pacientoKodas = ieskKod.getText();
                                yraToksAsmensKodas(pacientoPaieska, pacientoKodas);
                                p.setPaieskaKodas(pacientoKodas);

                                pacientoPaieska.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }


                    });

                }
                else {
                    regPac.trukstaSkaiciu(primaryStage,true,code1[0].length());
                }
            }
        });

        return pacientoPaieska;
    }

    /** Vėžio naikinimo langelio sukūrimas*/
    public Stage createDeleteVezys(){
        /** Sukuria GridPane*/
        GridPane gridNaikintiVez = new GridPane();
        gridNaikintiVez.setHgap(20);
        gridNaikintiVez.setVgap(15);
        gridNaikintiVez.setPadding(new Insets(10,0,10,10));

        /** Sukuria Stage, kurį grąžina*/
        Stage naikintVezys = new Stage();
        naikintVezys.setTitle("Pinktybinio naviko naikintimas");
        Scene dialoguScena1 = new Scene(gridNaikintiVez,300,200);
        naikintVezys.setScene(dialoguScena1);
        naikintVezys.setResizable(false);

        /** Sukuria GUI*/
        Label vezNr = new Label("Numeris:");
        TextField vezNr1 = new TextField();
        Button naikinti = new Button("     Naikinti     ");
        gridNaikintiVez.add(vezNr,1,2);
        gridNaikintiVez.add(vezNr1,2,2);
        gridNaikintiVez.add(naikinti,2,5);
        naikinti.setTranslateX(-17);

        /** Mygtuko naikinti realizacija*/
        naikinti.setOnAction((event) -> {
            int nr = Integer.parseInt(vezNr1.getText());
            Vezys vez = new Vezys();
            try {
                if(vez.checkVezys(pacientoKodas, ""+nr) != 1){
                    neraSkaicius(naikintVezys,nr);
                }
                else{

                    trinti(naikintVezys);
                    vez.deleteVezys(pacientoKodas,""+ nr);
                    naikintVezys.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        return naikintVezys;
    }

    /** Sukuriamas vėžio registravimo langas*/
    public GridPane createRegVezys(Stage primaryStage){

        /** GridPane sukūrimas*/
        GridPane gridVezys = new GridPane();
        gridVezys.setHgap(20);
        gridVezys.setVgap(15);
        gridVezys.setPadding(new Insets(10,0,10,10));

        /** GUI sukūrimas*/
        Label skundai = new Label("Skundai");
        gridVezys.add(skundai,1,1);
        TextField skund = new TextField();
        gridVezys.add(skund,2,1);
        Label skundTrukme = new Label("Skundų trukmė");
        gridVezys.add(skundTrukme,1,2);
        TextField truk = new TextField();
        gridVezys.add(truk,2,2);
        Label sritis = new Label("Sritis");
        gridVezys.add(sritis,1,3);
        ChoiceBox<String> srit = new ChoiceBox<>();
        srit.getItems().addAll("Burnaryklės navikas C10", "Burnos dugno C04","Dantenos piktybinis navikas C03",
                "Galvos, veido ir kaklo jungiamasis ir minkštieji audiniai C49.0", "Gerklaryklės C13", "Gerklų apatinė dalis C32.2",
                "Gerklų piktybinis navikas C32", "Gerklų viršutinė dalis C32.1", "Gomurio C05",
                "Kaukolės ir veido kaulai C41.0", "Kiti odos piktybiniai navikai C44", "Kitos liežuvio dalies C02",
                "Kitų burnos dalių C06", "Kitų ir nepatikslintų lūpos, burnos ertmės ir ryklės dalių piktybinis navikas C14",
                "Kitų ir netiksliai apibrėžtų lokalizacijų piktybinis navikas C76", "Kitų lokolizacijų piktybinis navikas 76.0",
                "Kitų seilių liaukų C08", "Kriaušinės kišenės C12", "Liežuvio šaknies C01", "Lūpos C00",
                "Metastazinis ir nepatikslintas limfmazgių piktybinis navikas C77", "Migdolo (ne ryklės ir ne liežuvio migdolų) C09",
                "Navikas be pirminio židinio C80", "Nosiaryklės C11", "Nosies ertmės ir vidurinės ausies piktybinis navikas C30",
                "Odos piktybinė melanoma C43", "Paausinės eilių liaukos C07", "Prienosinių ančių piktybinis navikas C31",
                "Skydliaukės piktybinis navikas C73", "Tikrasis balso aparatas C32.0");
        gridVezys.add(srit,2,3);
        Label morfo = new Label("Morfologija");
        gridVezys.add(morfo,1,4);
        ChoiceBox<String> mm = new ChoiceBox<>();
        mm.getItems().addAll("Adenokarcinoma", "Limfoma", "Melanoma", "Plokščialąstė karcinoma", "Sarkoma", "Kita");
        gridVezys.add(mm,2,4);
        TextField kita = new TextField();
        gridVezys.add(kita, 3, 4);
        kita.setPromptText("Įrašykite.");
        kita.setTranslateX(-200);
        Label mKodas = new Label("M kodas");
        gridVezys.add(mKodas,1,5);
        TextField mk = new TextField();
        gridVezys.add(mk,2,5);
        Label dif = new Label("Diferencijacija");
        dif.setTranslateX(-170);
        gridVezys.add(dif,4,5);
        ChoiceBox<String> dd = new ChoiceBox<>();
        dd.getItems().addAll("GX", "G1", "G2", "G3", "G4");
        dd.setTranslateX(-250);
        gridVezys.add(dd,5,5);
        Label tnm = new Label("TNM");
        gridVezys.add(tnm,1,6);
        TextField tnm1 = new TextField();
        gridVezys.add(tnm1, 2, 6);
        Label tnmrl = new Label("TNMRL");
        gridVezys.add(tnmrl,3,6);
        TextField tnmrl1 = new TextField();
        tnmrl1.setTranslateX(-110);
        gridVezys.add(tnmrl1, 4, 6);
        Label stadija = new Label("Stadija");
        gridVezys.add(stadija, 1, 7);
        ChoiceBox<String> ss = new ChoiceBox<>();
        ss.getItems().addAll("IA", "IB", "II", "III", "IVA", "IVB", "IVC");
        gridVezys.add(ss,2,7);
        Label rec = new Label("Recidyvas");
        gridVezys.add(rec,1,8);
        ChoiceBox<String> rr = new ChoiceBox<>();
        rr.getItems().addAll("Taip", "Ne");
        gridVezys.add(rr,2,8);
        Label recTipas = new Label("Recidyvo tipas");
        gridVezys.add(recTipas,4,8);
        recTipas.setTranslateX(-500);
        ChoiceBox<String> rt = new ChoiceBox<>();
        rt.getItems().addAll("Izoliuotas limfmazgių", "Lokalus");
        rt.setTranslateX(-500);
        gridVezys.add(rt,5,8);
        Label recData = new Label("Recidyvo data");
        gridVezys.add(recData,1,9);
        ChoiceBox<Integer> recMetai = new ChoiceBox<>();
        ChoiceBox<String> recMen = new ChoiceBox<>();
        ChoiceBox<Integer> recDien = new ChoiceBox<>();
        regPac.data(gridVezys, 9, 1,recMetai, recMen, recDien, true);
        Label metas = new Label("Metastazės");
        gridVezys.add(metas,1,10);
        ChoiceBox<String> me3 = new ChoiceBox<>();
        me3.getItems().addAll("Taip", "Ne");
        gridVezys.add(me3,2,10);
        Label metasTipas = new Label("Metastazių tipas");
        metasTipas.setTranslateX(-500);
        gridVezys.add(metasTipas,4,10);
        ChoiceBox<String> mt = new ChoiceBox<>();
        mt.getItems().addAll("Galvos smegenys", "Kepenys", "Plaučiai", "Kita");
        mt.setTranslateX(-500);
        gridVezys.add(mt,5,10);
        Label metasData = new Label("Metastazių data");
        gridVezys.add(metasData,1,11);
        ChoiceBox<Integer> metasMetai = new ChoiceBox<>();
        ChoiceBox<String> metasMen = new ChoiceBox<>();
        ChoiceBox<Integer> metasDien = new ChoiceBox<>();
        regPac.data(gridVezys, 11, 1, metasMetai, metasMen, metasDien, true);

        Button registruoti = new Button("Registruoti");
        gridVezys.add(registruoti,3,15);
        registruoti.setStyle("-fx-font-size: 15px;");
        registruoti.setTranslateX(-50);
        Button isvalyti = new Button("Išvalyti");
        gridVezys.add(isvalyti,4,15);
        isvalyti.setTranslateX(-102);

        /** Mygtuko registruoti realizacija*/
        registruoti.setOnAction(event1 -> {
            Vezys vez = new Vezys();
            try {
                int nr = vez.getCount(pacientoKodas)+1;
                vez.setNr(""+nr);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            vez.setpTNMRL(tnmrl1.getText());
            vez.setcTNM(tnm.getText());
            vez.setSkundo_pav(skund.getText());
            if(truk.getText() != "") {
                vez.setSkundo_trukme(Integer.parseInt(truk.getText()));
            }
            vez.setSritis(srit.getValue());
            vez.setMorfo(mm.getValue());
            vez.setM_kodas(Integer.parseInt(mk.getText()));
            vez.setDif(dd.getValue());
            if(rr.getValue().equalsIgnoreCase("Taip")){
                vez.setRecidyvas_yra(true);
            }
            String s1 = "";
            if(recMetai.getValue() != null) {
                s1 = regPac.datosIrasymas(recMetai, recMen, recDien);
                vez.setRecidyvas_data(s1);
            }
            vez.setRecidyvas_tipas(rt.getValue());
            if(me3.getValue().equalsIgnoreCase("Taip")){
                vez.setMetastazes_yra(true);
            }
            vez.setMetastazes_tipas(mt.getValue());
            if(metasMetai.getValue() != null){
                s1 = regPac.datosIrasymas(metasMetai, metasMen, metasDien);
                vez.setMetastazes_data(s1);
            }
            vez.setAsmens_kodas(pacientoKodas);
            try {
                vez.setVezys();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            skund.setText("");
            truk.setText("");
            mk.setText("");
            srit.setValue(null);
            mm.setValue(null);
            tnm1.setText("");
            tnmrl1.setText("");
            dd.setValue(null);
            ss.setValue(null);
            rr.setValue(null);
            rt.setValue(null);
            recMetai.setValue(null);
            recMen.setValue(null);
            recDien.setValue(null);
            me3.setValue(null);
            mt.setValue(null);
            metasMetai.setValue(null);
            metasMen.setValue(null);
            metasDien.setValue(null);

            Alert regis = new Alert(Alert.AlertType.INFORMATION);
            regis.setTitle("Registracija");
            Button ok_registr = (Button) regis.getDialogPane().lookupButton(ButtonType.OK);
            ok_registr.setText("OK");
            regis.setHeaderText("Piktybinis navikas sėkmingai įregistruotas");
            regis.initModality(Modality.APPLICATION_MODAL);
            regis.initOwner(primaryStage);
            regis.showAndWait();
        });

        /** Mygtuko isvalyti realizacija*/
        isvalyti.setOnAction(event1 -> {
            skund.setText("");
            truk.setText("");
            mk.setText("");
            srit.setValue(null);
            mm.setValue(null);
            tnm1.setText("");
            tnmrl1.setText("");
            dd.setValue(null);
            ss.setValue(null);
            rr.setValue(null);
            rt.setValue(null);
            recMetai.setValue(null);
            recMen.setValue(null);
            recDien.setValue(null);
            me3.setValue(null);
            mt.setValue(null);
            metasMetai.setValue(null);
            metasMen.setValue(null);
            metasDien.setValue(null);

        });

        return gridVezys;
    }

    /** Gydymo rodymas*/
    public GridPane createRodGydymas() throws SQLException {
        /** GridPane sukūrimas*/
        GridPane gridRodGyd = new GridPane();
        gridRodGyd.setHgap(20);
        gridRodGyd.setVgap(15);
        gridRodGyd.setPadding(new Insets(10,0,10,10));

        /** GUI sukūrimas*/
        Gydymas gydi = new Gydymas();
        int nn = gydi.getCount(pacientoKodas);
        if(nn == 0){
            Label nera = new Label("Pacientas dar negydytas!");
            gridRodGyd.add(nera, 1,1);
        }
        else {
            Gydymas gydymai[];
            gydymai = gydi.getGydymas(pacientoKodas);
            Label pradz= new Label("Gydymo pradžia: " + gydymai[nn-1].getData_nuo());
            gridRodGyd.add(pradz, 1, 1);
            for(int i = 0; i < nn; i++){
                gydi = gydymai[i];
                String data;
                if(gydi.getData_iki() != null){
                    data = gydi.getData_nuo()+"--"+gydi.getData_iki();
                }
                else{
                    data = gydi.getData_nuo();
                }
                Label data1 = new Label(data);
                gridRodGyd.add(data1, 1, i+2);
                String pavadinimas = gydi.getPav();
                String gydymas;
                switch(pavadinimas){
                    case "Chirurginis":
                        gydymas = "Chirurginis gygymas.\n";
                        if(gydi.getOperacinis_aprasymas() != null) {
                            gydymas += "Operacija: " + gydi.getOperacinis_aprasymas() + "\n";
                        }
                        if(gydi.isSarginis_l_m()){
                            gydymas += "Sarginis L/M darytas.\n";
                            if(gydi.getL_m_gr_paz() != null){
                                gydymas += "Sarginio L/M grupė pažeidimo pusėj: " + gydi.getL_m_gr_paz()+"\n";
                            }
                            if(gydi.getL_m_gr_nepaz() != null){
                                gydymas += "Sarginio L/M grupė nepažeidimo pusėj: " + gydi.getL_m_gr_nepaz()+"\n";
                            }
                            if(gydi.getL_m_gr_paz_teig() != null){
                                gydymas += "Sarginio L/M grupė teigiami pažeidimo pusėj: " + gydi.getL_m_gr_paz_teig()+"\n";
                            }
                            if(gydi.getL_m_gr_nepaz_teig() != null){
                                gydymas += "Sarginio L/M grupė teigiami nepažeidimo pusėj: " + gydi.getL_m_gr_nepaz_teig()+"\n";
                            }
                        }
                        if(gydi.isLimfo()){
                            gydymas += "Limfanodektomija daryta.\n";
                            if(gydi.getLimfo_gr_paz() != null){
                                gydymas += "Limfanodektomijos grupė pažeidimo pusėj: " + gydi.getLimfo_gr_paz()+"\n";
                            }
                            if(gydi.getLimfo_gr_nepaz() != null){
                                gydymas += "Limfanodektomijos grupė nepažeidimo pusėj: " + gydi.getLimfo_gr_nepaz()+"\n";
                            }
                            if(gydi.getLimfo_gr_paz_teig() != null){
                                gydymas += "Limfanodektomijos grupė teigiami pažeidimo pusėj: " + gydi.getLimfo_gr_paz_teig();
                            }
                            if(gydi.getLimfo_gr_nepaz_teig() != null){
                                gydymas += "Limfanodektomijos grupė teigiami nepažeidimo pusėj: " + gydi.getL_m_gr_nepaz_teig()+"\n";
                            }
                        }
                        break;
                    case "Radioterapija":
                        gydymas = "Radioterapija gydymas.\n";
                        gydymas += "Tipas: " + gydi.getTipas() + ".\n";
                        gydymas += "Aprašymas: " + gydi.getAprasymas()+"\n";
                        if(gydi.isAr_taikyta_limf()){
                            gydymas += "Taikyta kaklo limfmazgiams.\n";
                        }
                        else{
                            gydymas += "Netaikyta kaklo limfmazgiams.\n";
                        }
                        gydymas += "Suminė dozė: " + gydi.getSumine_doze() + " .Frakcijos: " + gydi.getFrakcijos()+".\n";
                        break;
                    case "Chemoterapija":
                        gydymas = "Chemoterapija.\n";
                        if(gydi.isDocetakselis()) {
                            gydymas += "Naudotas docetakselis.\n";
                        }
                        if(gydi.isPaklitakselis()) {
                            gydymas += "Naudotas paklitakselis.\n";
                        }
                        if(gydi.isCisplatina()) {
                            gydymas += "Naudota cisplatina/karboplatina.\n";
                        }
                        if(gydi.isFu_5()) {
                            gydymas += "Naudota 5-Fu.\n";
                        }
                        if(gydi.getKiti_vaistai() != null) {
                            gydymas += "Naudota " + gydi.getKiti_vaistai()+".\n";
                        }
                        gydymas += "Kursų skaičius: " + gydi.getKursu_kiekis()+".\n";
                        break;
                    case "Chemospindulinis":
                        gydymas = "Chemospindulinis gydymas.\n";
                        gydymas += "Tipas: " + gydi.getTipas() + ".\n";
                        gydymas += "Aprašymas: " + gydi.getAprasymas()+"\n";
                        if(gydi.isAr_taikyta_limf()){
                            gydymas += "Taikyta kaklo limfmazgiams.\n";
                        }
                        else{
                            gydymas += "Netaikyta kaklo limfmazgiams.\n";
                        }
                        gydymas += "Suminė dozė: " + gydi.getSumine_doze() + " .Frakcijos: " + gydi.getFrakcijos()+".\n";
                        if(gydi.isCisplatina()) {
                            gydymas += "Naudota cisplatina/karboplatina.\n";
                        }
                        if(gydi.getKiti_vaistai() != null) {
                            gydymas += "Naudota " + gydi.getKiti_vaistai()+".\n";
                        }
                        gydymas += "Kursų skaičius: " + gydi.getKursu_kiekis() + ". Kiekis " + gydi.getKiekis() + ".\n";
                        break;
                    case "Biologinė terapija":
                        gydymas = "Biologinė terapija.\n";
                        gydymas += "Tipas: " + gydi.getTipas() + ".\n";
                        gydymas += "Vaistai: " + gydi.getKiti_vaistai()+"\n";
                        gydymas += "Kursų skaičius: " + gydi.getKursu_kiekis() + ".\n";
                        break;
                    case "BioSpindulinis":
                        gydymas = "BioSpindulinis gydymas.\n";
                        gydymas += "Tipas: " + gydi.getTipas() + ".\n";
                        gydymas += "Aprašymas: " + gydi.getAprasymas()+"\n";
                        if(gydi.isAr_taikyta_limf()){
                            gydymas += "Taikyta kaklo limfmazgiams.\n";
                        }
                        else{
                            gydymas += "Netaikyta kaklo limfmazgiams.\n";
                        }
                        gydymas += "Suminė dozė: " + gydi.getSumine_doze() + " .Frakcijos: " + gydi.getFrakcijos()+".\n";
                        if(gydi.isCetuksimabas()) {
                            gydymas += "Naudota cetuksimabas.\n";
                        }
                        if(gydi.getKiti_vaistai() != null) {
                            gydymas += "Naudota " + gydi.getKiti_vaistai()+".\n";
                        }
                        gydymas += "Kursų skaičius: " + gydi.getKursu_kiekis() + ".\n";
                        break;
                    case "Paliatyvus":
                        gydymas = "Paliatyvus gydymas.\n";
                        gydymas += "Aprašymas: " + gydi.getAprasymas()+"\n";
                        break;
                    default:
                        gydymas = "Kitas gydymas.\n";
                        gydymas += "Aprašymas: " + gydi.getAprasymas()+"\n";
                        break;
                }
                Label gydymas11 = new Label(gydymas);
                gridRodGyd.add(gydymas11, 2, i+2);
            }
        }

        Button red = new Button("Redaguoti gydymą.");
        gridRodGyd.add(red,1,nn+4);
        red.setStyle("-fx-font-size: 15px;");
        Button trinti = new Button("Naikinti gydymą.");
        gridRodGyd.add(trinti,2,nn+4);
        trinti.setTranslateX(-52);

        /** Mygtuko red realizacija*/
        //TO DO
        /** Mygtuko trinti realizacija*/
        Stage naikintGydymas = createDeleteGyd();
        trinti.setOnAction((event1)->{
            naikintGydymas.show();
        });

        return gridRodGyd;

    }

    /** Gydymo registravimas*/
    public GridPane createRegGydymas(Stage primaryStage) throws SQLException {
        /** Sukūrimas GridPane*/
        GridPane gridRRegGyd = new GridPane();
        gridRRegGyd.setHgap(20);
        gridRRegGyd.setVgap(15);
        gridRRegGyd.setPadding(new Insets(10,0,10,10));

        /** Sukūriamas GUI*/
        Gydymas g = new Gydymas();
        gydymasPapil = g.getGydymasPav();
        Label pav = new Label(gydymasPapil +" gydymas.");
        gridRRegGyd.add(pav,1,1);
        Label rez = new Label("Rezultatai");
        Label apras = new Label("Aprašymas");
        gridRRegGyd.add(apras,1,2);
        TextField apr = new TextField();
        gridRRegGyd.add(apr,2,2,4,1);
        ChoiceBox<Integer> nuoMetai = new ChoiceBox<>();
        ChoiceBox<String> nuoMen = new ChoiceBox<>();
        ChoiceBox<Integer> nuoDien = new ChoiceBox<>();
        ChoiceBox<Integer> ikiMetai = new ChoiceBox<>();
        ChoiceBox<String> ikiMen = new ChoiceBox<>();
        ChoiceBox<Integer> ikiDien = new ChoiceBox<>();
        if(gydymasPapil.equalsIgnoreCase("Chirurginis")){
            Label nuoData = new Label("Data");
            gridRRegGyd.add(nuoData,1,3);

        }
        else{
            Label nuoData = new Label("Data nuo");
            gridRRegGyd.add(nuoData,1,3);
            Label ikiData = new Label("Data iki");
            gridRRegGyd.add(ikiData,1,4);
            regPac.data(gridRRegGyd,4,1, ikiMetai, ikiMen, ikiDien, true);
        }
        regPac.data(gridRRegGyd,3,1, nuoMetai, nuoMen, nuoDien, true);

        switch(gydymasPapil) {
            case "Chirurginis":
                Label operacAprasymas = new Label("Operacijos pavadinimas");
                gridRRegGyd.add(operacAprasymas, 1, 4);
                ChoiceBox<String> apra = new ChoiceBox<>();
                apra.getItems().addAll("Nosies sparnelio rezekcija", "Nosies kriauklės rezekcija", "Liežuvio šaknies rezekcija",
                        "Hemiglosektomija ir burnos dugno rezekcija", "Hemiglosektomija ir burnos dugno rezekcija bei apatinio žandikaulio rezekcija",
                        "Burnos gleivinės naviko rezekcija", "Žiočių lanko rezekcija", "Žiočių lanko ir apatinio žandikaulio rezekcija",
                        "Viršutinio žandikaulio alveolinės ataugos rezekcija", "Apatinio žandikaulio alveolinės ataugos rezekcija",
                        "Apatinio žandikaulio rezekcija", "Minkštojo gomurio rezekcija", "Kietojo gomurio rezekcija",
                        "Tonzilektomija", "Viršutinės lūpos rezekcija", "Apatinės lūpos rezekcija", "Dalinė ausies kaušelio rezekcija",
                        "Ausies kaušelio amputacija", "Ryklės užpakalinės sienos rezekcija", "Ryklės rezekcija per priekinę faringotomiją",
                        "Ryklės rezekcija per šoninę faringotomiją", "Laringektomija su liežuvio šaknies rezekcija", "Laringektomija su ryklės rezekcija",
                        "Skydliaukės rezekcija", "Hemitiroidektomija", "Tiroidektomija");
                gridRRegGyd.add(apra, 2, 4);
                Label sarginisDarytas = new Label("Ar darytas sarginis L/M ?");
                gridRRegGyd.add(sarginisDarytas, 1, 5);
                ChoiceBox<String> sarg = new ChoiceBox<>();
                sarg.getItems().addAll("Taip", "Ne");
                gridRRegGyd.add(sarg, 2, 5);
                Label pazGr = new Label("Sarginio L/M grupė pažeidimo pusėje");
                gridRRegGyd.add(pazGr, 1, 6);
                TextField gr = new TextField();
                gridRRegGyd.add(gr, 2, 6);
                Label nepazGr = new Label("Sarginio L/M grupė nepažeidimo pusėje");
                gridRRegGyd.add(nepazGr, 1, 7);
                TextField gr1 = new TextField();
                gridRRegGyd.add(gr1, 2, 7);
                Label pazGrTeig = new Label("Sarginio L/M grupė teigiami pažeidimo pusėje");
                gridRRegGyd.add(pazGrTeig, 1, 8);
                TextField gr2 = new TextField();
                gridRRegGyd.add(gr2, 2, 8);
                Label nepazGrTeig = new Label("Sarginio L/M grupė teigiami nepažeidimo pusėje");
                gridRRegGyd.add(nepazGrTeig, 1, 9);
                TextField gr3 = new TextField();
                gridRRegGyd.add(gr3, 2, 9);
                Label limfoDarytas = new Label("Ar daryta limfanodektomija ?");
                gridRRegGyd.add(limfoDarytas, 1, 10);
                ChoiceBox<String> limf = new ChoiceBox<>();
                limf.getItems().addAll("Taip", "Ne");
                gridRRegGyd.add(limf, 2, 10);
                Label pazGr1 = new Label("Limfanodektomijos grupė pažeidimo pusėje");
                gridRRegGyd.add(pazGr1, 1, 11);
                TextField gr4 = new TextField();
                gridRRegGyd.add(gr4, 2, 11);
                Label nepazGr1 = new Label("Limfanodektomijos grupė nepažeidimo pusėje");
                gridRRegGyd.add(nepazGr1, 1, 12);
                TextField gr5 = new TextField();
                gridRRegGyd.add(gr5, 2, 12);
                Label pazGrTeig1 = new Label("Limfanodektomijos grupė teigiami pažeidimo pusėje");
                gridRRegGyd.add(pazGrTeig1, 1, 13);
                TextField gr6 = new TextField();
                gridRRegGyd.add(gr6, 2, 13);
                Label nepazGrTeig1 = new Label("Limfanodektomijos grupė teigiami nepažeidimo pusėje");
                gridRRegGyd.add(nepazGrTeig1, 1, 14);
                TextField gr7 = new TextField();
                gridRRegGyd.add(gr7, 2, 14);

                Button regis = new Button("Registruoti.");
                gridRRegGyd.add(regis, 1,16);
                Button isv = new Button("Išvalyti.");
                gridRRegGyd.add(isv, 2, 16);

                /** Mygtuko regis realizacija*/
                regis.setOnAction(event1 -> {
                    Gydymas gydChir = new Gydymas();
                    gydChir.setPav(gydymasPapil);
                    gydChir.setAsmens_kodas(pacientoKodas);
                    gydChir.setAprasymas(apr.getText());
                    gydChir.setOperacinis_aprasymas(apra.getValue());
                    if(sarg.getValue().equalsIgnoreCase("Taip")) {
                        gydChir.setSarginis_l_m(true);
                    }
                    gydChir.setL_m_gr_paz(gr.getText());
                    gydChir.setL_m_gr_nepaz(gr1.getText());
                    gydChir.setL_m_gr_paz_teig(gr2.getText());
                    gydChir.setL_m_gr_nepaz_teig(gr3.getText());
                    if(limf.getValue().equalsIgnoreCase("Taip")){
                        gydChir.setLimfo(true);
                    }
                    gydChir.setLimfo_gr_paz(gr4.getText());
                    gydChir.setLimfo_gr_nepaz(gr5.getText());
                    gydChir.setLimfo_gr_paz_teig(gr6.getText());
                    gydChir.setLimfo_gr_nepaz_teig(gr7.getText());
                    String sChir = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydChir.setData_nuo(sChir);
                    try {
                        gydChir.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    apra.setValue(null);
                    apr.setText("");
                    sarg.setValue(null);
                    gr.setText("");
                    gr1.setText("");
                    gr2.setText("");
                    gr3.setText("");
                    gr4.setText("");
                    gr5.setText("");
                    gr6.setText("");
                    gr7.setText("");
                    limf.setValue(null);
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    Alert regis2 = new Alert(Alert.AlertType.INFORMATION);
                    regis2.setTitle("Registracija");
                    Button ok_registr = (Button) regis2.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis2.setHeaderText("Chirurginis gydymas sėkmingai įregistruotas");
                    regis2.initModality(Modality.APPLICATION_MODAL);
                    regis2.initOwner(primaryStage);
                    regis2.showAndWait();
                });
                /** Mygtuko isvalyti realizacija*/
                isv.setOnAction(event1 -> {
                    apra.setValue(null);
                    apr.setText("");
                    sarg.setValue(null);
                    gr.setText("");
                    gr1.setText("");
                    gr2.setText("");
                    gr3.setText("");
                    gr4.setText("");
                    gr5.setText("");
                    gr6.setText("");
                    gr7.setText("");
                    limf.setValue(null);
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                });
                break;
            case "Radioterapija":
                Label tipas = new Label("Tipas");
                gridRRegGyd.add(tipas, 1, 5);
                ChoiceBox<String> t = new ChoiceBox<>();
                t.getItems().addAll("indukcinis", "adjuvantinis");
                gridRRegGyd.add(t, 2, 5);
                Label kaklolimf = new Label("Ar taikytas kaklo limfmazgiams?");
                gridRRegGyd.add(kaklolimf, 1, 6);
                ChoiceBox<String> limf1 = new ChoiceBox<>();
                limf1.getItems().addAll("Taip", "Ne");
                gridRRegGyd.add(limf1, 2, 6);
                Label doze = new Label("Suminė dozė");
                gridRRegGyd.add(doze, 1, 7);
                TextField doze1 = new TextField();
                gridRRegGyd.add(doze1, 2, 7);
                Label frakcijos = new Label("Frakcijos");
                gridRRegGyd.add(frakcijos, 4, 7);
                TextField sk = new TextField();
                gridRRegGyd.add(sk, 5, 7);

                Button regis2 = new Button("Registruoti.");
                gridRRegGyd.add(regis2, 1,9);
                Button isv2 = new Button("Išvalyti.");
                gridRRegGyd.add(isv2, 2, 9);

                /** Mygtuko regis2 realizacija*/
                regis2.setOnAction(event1 -> {
                    Gydymas gydRadio = new Gydymas();
                    gydRadio.setPav(gydymasPapil);
                    gydRadio.setAsmens_kodas(pacientoKodas);
                    gydRadio.setTipas(t.getValue());
                    gydRadio.setAprasymas(apr.getText());
                    if(limf1.getValue() == "Taip"){
                        gydRadio.setAr_taikyta_limf(true);
                    }
                    gydRadio.setSumine_doze(Integer.parseInt(doze1.getText()));
                    gydRadio.setFrakcijos(Integer.parseInt(sk.getText()));
                    String sRadio = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydRadio.setData_nuo(sRadio);
                    sRadio = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydRadio.setData_iki(sRadio);
                    try {
                        gydRadio.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    t.setValue(null);
                    apr.setText("");
                    limf1.setValue(null);
                    doze1.setText("");
                    sk.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis3 = new Alert(Alert.AlertType.INFORMATION);
                    regis3.setTitle("Registracija");
                    Button ok_registr = (Button) regis3.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis3.setHeaderText("Radioterapija sėkmingai įregistruotas");
                    regis3.initModality(Modality.APPLICATION_MODAL);
                    regis3.initOwner(primaryStage);
                    regis3.showAndWait();
                });

                /** Mygtuko isv2 realizacija*/
                isv2.setOnAction(event1 -> {
                    t.setValue(null);
                    apr.setText("");
                    limf1.setValue(null);
                    doze1.setText("");
                    sk.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
            case "Chemoterapija":
                Label tipas1 = new Label("Tipas");
                gridRRegGyd.add(tipas1, 1, 5);
                ChoiceBox<String> t1 = new ChoiceBox<>();
                t1.getItems().addAll("indukcinis", "adjuvantinis");
                gridRRegGyd.add(t1, 2, 5);
                Label vaistai = new Label("Vaistai");
                gridRRegGyd.add(vaistai, 1, 6);
                CheckBox doc = new CheckBox("Docetakselis");
                gridRRegGyd.add(doc, 1, 6);
                CheckBox pak = new CheckBox("Paklitakselis");
                gridRRegGyd.add(pak, 2, 6);
                CheckBox cis = new CheckBox("Cispaltina/Karboplatina");
                gridRRegGyd.add(cis, 3, 6);
                CheckBox fu = new CheckBox("5-Fu");
                gridRRegGyd.add(fu, 4, 6);
                Label kiti = new Label("Kiti vaistai");
                gridRRegGyd.add(kiti, 1, 7);
                TextField kit = new TextField();
                gridRRegGyd.add(kit, 2, 7);
                Label kursai = new Label("Kursų skaičius");
                gridRRegGyd.add(kursai, 3, 7);
                TextField kur = new TextField();
                gridRRegGyd.add(kur, 4, 7);

                Button regis3 = new Button("Registruoti.");
                gridRRegGyd.add(regis3, 1, 9);
                Button isv3 = new Button("Išvalyti.");
                gridRRegGyd.add(isv3, 2, 9);

                /** Mygtuko regis3 realizacija*/
                regis3.setOnAction(event1 -> {
                    Gydymas gydC = new Gydymas();
                    gydC.setPav(gydymasPapil);
                    gydC.setAsmens_kodas(pacientoKodas);
                    gydC.setTipas(t1.getValue());
                    gydC.setAprasymas(apr.getText());

                    if(doc.isSelected()){
                        gydC.setDocetakselis(true);
                    }
                    if(pak.isSelected()){
                        gydC.setPaklitakselis(true);
                    }
                    if(cis.isSelected()){
                        gydC.setCisplatina(true);
                    }
                    if(fu.isSelected()){
                        gydC.setFu_5(true);
                    }
                    gydC.setKiti_vaistai(kit.getText());
                    String sC = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydC.setData_nuo(sC);
                    sC = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydC.setData_iki(sC);
                    try {
                        gydC.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    t1.setValue(null);
                    apr.setText("");
                    doc.setSelected(false);
                    cis.setSelected(false);
                    pak.setSelected(false);
                    fu.setSelected(false);
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis4 = new Alert(Alert.AlertType.INFORMATION);
                    regis4.setTitle("Registracija");
                    Button ok_registr = (Button) regis4.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis4.setHeaderText("Chemoterapija sėkmingai įregistruotas");
                    regis4.initModality(Modality.APPLICATION_MODAL);
                    regis4.initOwner(primaryStage);
                    regis4.showAndWait();
                });

                /** Mygtuko isv3 realizacija*/
                isv3.setOnAction(event1 -> {
                    t1.setValue(null);
                    apr.setText("");
                    doc.setSelected(false);
                    cis.setSelected(false);
                    pak.setSelected(false);
                    fu.setSelected(false);
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
            case "Chemospindulinis":
                Label tipas2 = new Label("Tipas");
                gridRRegGyd.add(tipas2, 1, 5);
                ChoiceBox<String> t2 = new ChoiceBox<>();
                t2.getItems().addAll("indukcinis", "adjuvantinis");
                gridRRegGyd.add(t2, 2, 5);
                Label kaklolimf2 = new Label("Ar taikytas kaklo limfmazgiams?");
                gridRRegGyd.add(kaklolimf2, 1, 6);
                ChoiceBox<String> limf2 = new ChoiceBox<>();
                limf2.getItems().addAll("Taip", "Ne");
                gridRRegGyd.add(limf2, 2, 6);
                Label frakcijos1 = new Label("Frakcijos");
                gridRRegGyd.add(frakcijos1, 1, 7);
                TextField sk1 = new TextField();
                gridRRegGyd.add(sk1, 2, 7);
                Label vaistai1 = new Label("Vaistai");
                gridRRegGyd.add(vaistai1, 1, 8);
                CheckBox cis1 = new CheckBox("Cispaltina/Karboplatina");
                gridRRegGyd.add(cis1, 1, 9);
                Label kiti1 = new Label("Kiti vaistai");
                gridRRegGyd.add(kiti1, 2, 9);
                TextField kit1 = new TextField();
                gridRRegGyd.add(kit1, 3, 9);
                Label kursai1 = new Label("Kursų skaičius");
                gridRRegGyd.add(kursai1, 1, 10);
                TextField kur1 = new TextField();
                gridRRegGyd.add(kur1, 2, 10);

                Button regis4 = new Button("Registruoti.");
                gridRRegGyd.add(regis4, 1,12);
                Button isv4 = new Button("Išvalyti.");
                gridRRegGyd.add(isv4, 2, 12);

                /** Mygtuko regis4 realizacija*/
                regis4.setOnAction(event1 -> {
                    Gydymas gydCh = new Gydymas();
                    gydCh.setPav(gydymasPapil);
                    gydCh.setAsmens_kodas(pacientoKodas);
                    gydCh.setTipas(t2.getValue());
                    gydCh.setAprasymas(apr.getText());
                    if (limf2.getValue() == "Taip") {
                        gydCh.setAr_taikyta_limf(true);
                    }
                    gydCh.setFrakcijos(Integer.parseInt(sk1.getText()));
                    if (cis1.isSelected()) {
                        gydCh.setCisplatina(true);
                    }
                    gydCh.setKiti_vaistai(kit1.getText());
                    String sC = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydCh.setData_nuo(sC);
                    sC = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydCh.setData_iki(sC);
                    try {
                        gydCh.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    t2.setValue(null);
                    apr.setText("");
                    cis1.setSelected(false);
                    kit1.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis5 = new Alert(Alert.AlertType.INFORMATION);
                    regis5.setTitle("Registracija");
                    Button ok_registr = (Button) regis5.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis5.setHeaderText("Chemospindulinis gydymas sėkmingai įregistruotas");
                    regis5.initModality(Modality.APPLICATION_MODAL);
                    regis5.initOwner(primaryStage);
                    regis5.showAndWait();
                });

                /** Mygtuko isv4 realizacija*/
                isv4.setOnAction(event1 -> {
                    t2.setValue(null);
                    apr.setText("");
                    cis1.setSelected(false);
                    kit1.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
            case "Biologine terapija":
                Label tipas3 = new Label("Tipas");
                gridRRegGyd.add(tipas3, 1, 5);
                ChoiceBox<String> t3 = new ChoiceBox<>();
                t3.getItems().addAll("indukcinis", "adjuvantinis");
                gridRRegGyd.add(t3, 2, 5);
                Label vaistai2 = new Label("Vaistai");
                gridRRegGyd.add(vaistai2, 1, 6);
                TextField vai = new TextField();
                gridRRegGyd.add(vai, 2, 6, 3, 1);
                Label kursai2 = new Label("Kursų skaičius");
                gridRRegGyd.add(kursai2, 1, 7);
                TextField kur2 = new TextField();
                gridRRegGyd.add(kur2, 2, 7);

                Button regis5 = new Button("Registruoti.");
                gridRRegGyd.add(regis5, 1,9);
                Button isv5 = new Button("Išvalyti.");
                gridRRegGyd.add(isv5, 2, 9);

                /** Mygtuko regis5 realizacija*/
                regis5.setOnAction(event1 -> {
                    Gydymas gydBT = new Gydymas();
                    gydBT.setPav(gydymasPapil);
                    gydBT.setAsmens_kodas(pacientoKodas);
                    gydBT.setTipas(t3.getValue());
                    gydBT.setAprasymas(apr.getText());
                    gydBT.setKiti_vaistai(vai.getText());
                    gydBT.setKursu_kiekis(Integer.parseInt(kur2.getText()));
                    String sB = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydBT.setData_nuo(sB);
                    sB = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydBT.setData_iki(sB);
                    try {
                        gydBT.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    t3.setValue(null);
                    apr.setText("");
                    vai.setText("");
                    kur2.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis6 = new Alert(Alert.AlertType.INFORMATION);
                    regis6.setTitle("Registracija");
                    Button ok_registr = (Button) regis6.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis6.setHeaderText("Biologinė terapija sėkmingai įregistruotas");
                    regis6.initModality(Modality.APPLICATION_MODAL);
                    regis6.initOwner(primaryStage);
                    regis6.showAndWait();
                });

                /** Mygtuko isv5 realizacija*/
                isv5.setOnAction(event1 -> {
                    t3.setValue(null);
                    apr.setText("");
                    vai.setText("");
                    kur2.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
            case "Biospindulinis" :
                Label tipas4 = new Label("Tipas");
                gridRRegGyd.add(tipas4, 1, 5);
                ChoiceBox<String> t4 = new ChoiceBox<>();
                t4.getItems().addAll("indukcinis", "adjuvantinis");
                gridRRegGyd.add(t4, 2, 5);
                Label kaklolimf3 = new Label("Ar taikytas kaklo limfmazgiams?");
                gridRRegGyd.add(kaklolimf3, 1, 6);
                ChoiceBox<String> limf3 = new ChoiceBox<>();
                limf3.getItems().addAll("Taip", "Ne");
                gridRRegGyd.add(limf3, 2, 6);
                Label sumine_doze2 = new Label("Suminė dozė");
                gridRRegGyd.add(sumine_doze2, 1, 7);
                TextField sum = new TextField();
                gridRRegGyd.add(sum, 2, 7);
                Label frakcijos2 = new Label("Frakcijos");
                gridRRegGyd.add(frakcijos2, 3, 7);
                TextField sk2 = new TextField();
                gridRRegGyd.add(sk2, 4, 7);
                Label vaistai4 = new Label("Vaistai");
                gridRRegGyd.add(vaistai4, 1, 8);
                CheckBox ce2 = new CheckBox("Cetuksimabas");
                gridRRegGyd.add(ce2, 1, 9);
                Label kiti3 = new Label("Kiti vaistai");
                gridRRegGyd.add(kiti3, 2, 9);
                TextField kit3 = new TextField();
                gridRRegGyd.add(kit3, 3, 9);
                Label kursai4 = new Label("Kursų skaičius");
                gridRRegGyd.add(kursai4, 1, 10);
                TextField kur4 = new TextField();
                gridRRegGyd.add(kur4, 2, 10);

                Button regis6 = new Button("Registruoti.");
                gridRRegGyd.add(regis6, 1,12);
                Button isv6 = new Button("Išvalyti.");
                gridRRegGyd.add(isv6, 2, 12);

                /** Mygtuko regis6 realizacija*/
                regis6.setOnAction(event1 -> {
                    Gydymas gydBS = new Gydymas();
                    gydBS.setPav(gydymasPapil);
                    gydBS.setAsmens_kodas(pacientoKodas);
                    gydBS.setTipas(t4.getValue());
                    gydBS.setAprasymas(apr.getText());
                    if(limf3.getValue() == "Taip"){
                        gydBS.setAr_taikyta_limf(true);
                    }
                    gydBS.setSumine_doze(Integer.parseInt(sum.getText()));
                    gydBS.setFrakcijos(Integer.parseInt(sk2.getText()));
                    if(ce2.isSelected()){
                        gydBS.setCetuksimabas(true);
                    }
                    gydBS.setKiti_vaistai(kit3.getText());
                    gydBS.setKursu_kiekis(Integer.parseInt(kur4.getText()));
                    String sBS = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydBS.setData_nuo(sBS);
                    sBS = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydBS.setData_iki(sBS);
                    try {
                        gydBS.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    t4.setValue(null);
                    apr.setText("");
                    kit3.setText("");
                    sum.setText("");
                    sk2.setText("");
                    ce2.setSelected(false);
                    kur4.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis7 = new Alert(Alert.AlertType.INFORMATION);
                    regis7.setTitle("Registracija");
                    Button ok_registr = (Button) regis7.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis7.setHeaderText("Biospindulinis gydymas sėkmingai įregistruotas");
                    regis7.initModality(Modality.APPLICATION_MODAL);
                    regis7.initOwner(primaryStage);
                    regis7.showAndWait();
                });

                /** Mygtuko isv6 realizacija*/
                isv6.setOnAction(event1 -> {
                    t4.setValue(null);
                    apr.setText("");
                    kit3.setText("");
                    sum.setText("");
                    sk2.setText("");
                    ce2.setSelected(false);
                    kur4.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
            default:

                Button regis7 = new Button("Registruoti.");
                gridRRegGyd.add(regis7, 1,6);
                Button isv7 = new Button("Išvalyti.");
                gridRRegGyd.add(isv7, 2, 6);

                /** Mygtuko regis7 realizacija*/
                regis7.setOnAction(event1 -> {
                    Gydymas gydBS1 = new Gydymas();
                    gydBS1.setPav(gydymasPapil);
                    gydBS1.setAsmens_kodas(pacientoKodas);
                    gydBS1.setAprasymas(apr.getText());
                    String sBS = regPac.datosIrasymas(nuoMetai, nuoMen, nuoDien);
                    gydBS1.setData_nuo(sBS);
                    sBS = regPac.datosIrasymas(ikiMetai, ikiMen, ikiDien);
                    gydBS1.setData_iki(sBS);
                    try {
                        gydBS1.setGydymas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    apr.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                    Alert regis8 = new Alert(Alert.AlertType.INFORMATION);
                    regis8.setTitle("Registracija");
                    Button ok_registr = (Button) regis8.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis8.setHeaderText(gydymasPapil +" gydymas sėkmingai įregistruotas");
                    regis8.initModality(Modality.APPLICATION_MODAL);
                    regis8.initOwner(primaryStage);
                    regis8.showAndWait();
                });

                /** Mygtuko isv7 realizacija*/
                isv7.setOnAction(event1 -> {
                    apr.setText("");
                    nuoMetai.setValue(null);
                    nuoMen.setValue(null);
                    nuoDien.setValue(null);
                    ikiMetai.setValue(null);
                    ikiMen.setValue(null);
                    ikiDien.setValue(null);
                });
                break;
        }
        return gridRRegGyd;
    }

    /** Gydymo pavadinimo pasirinkimas*/
    public Stage chooseGydymoPav(Stage primaryStage, BorderPane border, Scene naujas, ScrollPane scroll) throws SQLException {
        /** GridPane sukūrimas*/
        GridPane gridRegGydymas = new GridPane();
        gridRegGydymas.setHgap(20);
        gridRegGydymas.setVgap(15);
        gridRegGydymas.setPadding(new Insets(10,0,10,10));

        /** Stage sukūrimas*/
        Stage regGydymas = new Stage();
        regGydymas.setTitle("Gydymo pasirinkimas");
        Scene dialoguScena4 = new Scene(gridRegGydymas,300,200);
        regGydymas.setScene(dialoguScena4);
        regGydymas.setResizable(false);

        /** GUI sukūrimas*/
        Label gydimas = new Label("Pavadinimas:");
        ChoiceBox<String> pas = new ChoiceBox<>();
        pas.getItems().addAll("Chirurginis","Radioterapija", "Biologine terapija", "Biospindulinis",
                "Chemospindulinis", "Chemoterapija","Paliatyvus", "Kitas");
        Button pildyti = new Button("     Pildyti     ");
        gridRegGydymas.add(gydimas,1,2);
        gridRegGydymas.add(pas,2,2);
        gridRegGydymas.add(pildyti,2,5);
        pas.setTranslateX(-17);

        GridPane gridRRegGyd = createRegGydymas(primaryStage);
        pildyti.setOnAction((event) -> {
            String pavv = pas.getValue();
            Gydymas gydii = new Gydymas();
            try {
                gydii.setGydymasPav(pavv);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            regGydymas.close();
            border.setCenter(gridRRegGyd);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        return regGydymas;

    }

    /** Apžiūros rodymas*/
    public GridPane createRodApziura() throws SQLException {
        /** GridPane sukūrimas*/
        GridPane gridRodApz = new GridPane();
        gridRodApz.setHgap(20);
        gridRodApz.setVgap(15);
        gridRodApz.setPadding(new Insets(10,0,10,10));

        /** GUI sukūrimas*/
        Apziura apzi = new Apziura();
        int nn = apzi.getCount(pacientoKodas);
        if(nn == 0){
            Label nera = new Label("Pacientas dar neatlikta apžiūra!");
            gridRodApz.add(nera, 1,1);
        }
        else {
            Apziura apziuros[];
            apziuros = apzi.getApziura(pacientoKodas);
            Label pradz = new Label("Apžiūrų pradžia: " + apziuros[nn-1].getData());
            gridRodApz.add(pradz, 1, 1);
            for(int i = 0; i < nn; i++){
                apzi = apziuros[i];
                String data12 = apzi.getData();
                Label data1 = new Label(data12);
                gridRodApz.add(data1, 1, i+2);
                String apziuraa = "";
                String pavadinimas1 = apzi.getPav();
                switch(pavadinimas1){
                    case "VLS":
                        apziuraa = "VLS.\n";
                        apziuraa += "Rezultatai: " + apzi.getRez() + ".\n";
                        apziuraa += "Pažeidimo pusė: " + apzi.getPazeidimo_puse() +".\n";
                        apziuraa += "Pažeidimo lokalizacija: " + apzi.getPazeidimo_lokolizacija() +".\n";
                        apziuraa += "Pažeidimas paima " + apzi.getPazeidimas_apima()+".\n";
                        if(apzi.isBalso_klosciu_judrumas()){
                            apziuraa += "Balso klosčių judrumas sutrikęs.\n";
                        }
                        if(apzi.isKetaroze()){
                            apziuraa += "Keratozė yra.\n";
                        }
                        if(apzi.isRandas()){
                            apziuraa += "Randas yra.\n";
                        }
                        if(apzi.isEgzofitiniai_pozymiai_yra()){
                            apziuraa += "Egzofitiniai požymiai yra, " + apzi.getEgzofitiniai_pozymiai_kokie() + ".\n";
                        }
                        if(apzi.isStenoze_yra()){
                            apziuraa += "Stenozė yra, laipsnis " + apzi.getStenoze_laipsnis() + ".\n";
                        }
                        if(apzi.getKita() != null){
                            apziuraa += apzi.getKita();
                        }
                        break;
                    case "Fibroskopija":
                        apziuraa += "Fibroskopija.\n";
                        apziuraa += "Rezultatai: " + apzi.getRez() + ".\n";
                        apziuraa += "Pažeidimo pusė: " + apzi.getPazeidimo_puse() +".\n";
                        apziuraa += "Pažeidimo lokalizacija: " + apzi.getPazeidimo_lokolizacija() +".\n";
                        apziuraa += "Pažeidimas paima " + apzi.getPazeidimas_apima()+".\n";
                        if(apzi.isRandas()){
                            apziuraa += "Randas yra.\n";
                        }
                        if(apzi.isEgzofitiniai_pozymiai_yra()){
                            apziuraa += "Egzofitiniai požymiai yra, " + apzi.getEgzofitiniai_pozymiai_kokie() + ".\n";
                        }
                        if(apzi.isStenoze_yra()){
                            apziuraa += "Stenozė yra.\n";
                        }
                        if(apzi.getKita() != null){
                            apziuraa += apzi.getKita();
                        }
                        break;
                    case "Galvos ir kaklo KT":
                        apziuraa = "Galvos ir kaklo KT.\n";
                        apziuraa += "Rezultatai: " + apzi.getRez() + ".\n";
                        if(apzi.isDuomenys_atitinka_kt()) {
                            apziuraa += "Duomenys atitinka klinikinį vaizdą.\n";
                        }
                        else{
                            apziuraa += "Duomenys neatitinka klinikinio vaizdo, " + apzi.getJei_duomenys_neatitinka_kt()+ ".\n";
                        }
                        if(apzi.isKaklo_limf_kt()){
                            apziuraa += "Kaklo limfmazgių patologija stebima, "+ apzi.getJei_limf_stebimi() +".\n";
                        }
                        break;
                    default:
                        apziuraa = apzi.getPav()+".\n";
                        apziuraa += "Rezultatai: " + apzi.getRez() + ".\n";
                        break;
                }
                Label apziura11 = new Label(apziuraa);
                gridRodApz.add(apziura11, 2, i+2);

            }
        }
        Button red = new Button("Redaguoti apžiūrą.");
        gridRodApz.add(red,1,nn+4);
        red.setStyle("-fx-font-size: 15px;");
        Button trinti = new Button("Naikinti apžiūrą.");
        gridRodApz.add(trinti,2,nn+4);

        /** Mygtuko red realizacija*/
        // TO DO
        /** Mygtuko trinti realizacija*/
        Stage naikintApziura = createDeleteApz();
        trinti.setOnAction((event1)->{
            naikintApziura.show();
        });

        return gridRodApz;
    }

    /** Apžiūros registravimas*/
    public GridPane createRegApziura(Stage primaryStage) throws SQLException {

        /** GridPane sukūrimas*/
        GridPane gridRRegApz = new GridPane();
        gridRRegApz.setHgap(20);
        gridRRegApz.setVgap(15);
        gridRRegApz.setPadding(new Insets(10,0,10,10));

        /** GUI sukūrimas*/
        Apziura a = new Apziura();
        apziuraPapil = a.getApziuraPav();
        Label pav = new Label(apziuraPapil+" apžiūra");
        gridRRegApz.add(pav, 1,1);
        Label rezultatai = new Label("Rezultatai");
        gridRRegApz.add(rezultatai, 1, 2);
        TextField re = new TextField();
        gridRRegApz.add(re, 2, 2, 3,1);
        Label Data = new Label("Data");
        gridRRegApz.add(Data,1,3);
        ChoiceBox<Integer> metai = new ChoiceBox<>();
        ChoiceBox<String> men = new ChoiceBox<>();
        ChoiceBox<Integer> dien = new ChoiceBox<>();
        regPac.data(gridRRegApz,3,1,metai, men, dien, true);

        switch(apziuraPapil){
            case "VLS":
                Label puse = new Label("Pažeidimo pusė");
                gridRRegApz.add(puse, 1,4);
                ChoiceBox<String> pus = new ChoiceBox<>();
                pus.getItems().addAll("kairė", "dešinė", "abi pusės");
                gridRRegApz.add(pus, 2, 4);
                Label lokal = new Label("Pažeidimo lokalizacija");
                gridRRegApz.add(lokal, 1, 5);
                ChoiceBox<String> lo = new ChoiceBox<>();
                lo.getItems().addAll("Antgerklio gerklinis paviršius/liežuvinis paviršius",
                        "Balso klostė/klostės","Kriaušinė kišenė","Valekula","Vedeginis gumburas",
                        "Vestibulinė klostė","Tarpvedeginė sritis","Stemplės įeiga");
                gridRRegApz.add(lo,2,5);
                Label paz = new Label("Pažeidimas apima");
                gridRRegApz.add(paz,1,6);
                ChoiceBox<String> paz1 = new ChoiceBox<>();
                paz1.getItems().addAll("1 subsritį","daugiau nei 1 subsritį");
                gridRRegApz.add(paz1,2,6);
                Label bklostes = new Label("Balso klosčių judrumas ");
                gridRRegApz.add(bklostes,1,7);
                ChoiceBox<String> b = new ChoiceBox<>();
                b.getItems().addAll("Sutrikęs", "Nesutrikęs");
                gridRRegApz.add(b,2,7);
                Label kera = new Label("Keratozė");
                kera.setTranslateX(-200);
                gridRRegApz.add(kera, 3,7);
                ChoiceBox<String> k = new ChoiceBox<>();
                k.getItems().addAll("Yra", "Nėra");
                k.setTranslateX(-250);
                gridRRegApz.add(k,4,7);
                Label ran = new Label("Randas");
                gridRRegApz.add(ran, 1,8);
                ChoiceBox<String> r = new ChoiceBox<>();
                r.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(r,2,8);
                Label egzo = new Label("Egzofitiniai požymiai");
                gridRRegApz.add(egzo, 1,9);
                ChoiceBox<String> e = new ChoiceBox<>();
                e.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(e,2,9);
                TextField kokie = new TextField();
                kokie.setTranslateX(-200);
                kokie.setPromptText("Kokie požymiai?");
                gridRRegApz.add(kokie, 3,9,3,1);
                Label sten = new Label("Stenozė");
                gridRRegApz.add(sten, 1,10);
                ChoiceBox<String> s1 = new ChoiceBox<>();
                s1.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(s1,2,10);
                TextField laipsnis = new TextField();
                laipsnis.setTranslateX(-200);
                laipsnis.setPromptText("Koks laipsnis?");
                gridRRegApz.add(laipsnis, 3,10);
                Label kita12 = new Label("Kita");
                gridRRegApz.add(kita12, 1, 11);
                TextField kit12 = new TextField();
                gridRRegApz.add(kit12, 2, 11, 3,1);

                Button regis12 = new Button("Registruoti.");
                gridRRegApz.add(regis12, 1,14);
                Button isv12 = new Button("Išvalyti.");
                gridRRegApz.add(isv12, 2, 14);

                /** Mygtuko regis12 realizacija*/
                regis12.setOnAction(event1 -> {
                    Apziura apzVls = new Apziura();
                    apzVls.setPav(apziuraPapil);
                    apzVls.setRez(re.getText());
                    apzVls.setAsmens_kodas(pacientoKodas);
                    apzVls.setPazeidimo_puse(pus.getValue());
                    apzVls.setPazeidimo_lokolizacija(lo.getValue());
                    apzVls.setPazeidimas_apima(paz1.getValue());
                    if(b.getValue() == "Sutrikęs"){
                        apzVls.setBalso_klosciu_judrumas(true);
                    }
                    if(k.getValue() == "Yra"){
                        apzVls.setKetaroze(true);
                    }
                    if(r.getValue() == "Yra"){
                        apzVls.setRandas(true);
                    }
                    if(e.getValue() == "Yra"){
                        apzVls.setEgzofitiniai_pozymiai_yra(true);
                        apzVls.setEgzofitiniai_pozymiai_kokie(kokie.getText());
                    }
                    if(s1.getValue() == "Yra"){
                        apzVls.setStenoze_yra(true);
                        apzVls.setStenoze_laipsnis(laipsnis.getText());
                    }
                    apzVls.setKita(kita12.getText());
                    String data12 = regPac.datosIrasymas(metai, men, dien);
                    apzVls.setData(data12);
                    try {
                        apzVls.setApziura();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    re.setText("");
                    pus.setValue(null);
                    lo.setValue(null);
                    paz1.setValue(null);
                    b.setValue(null);
                    k.setValue(null);
                    r.setValue(null);
                    e.setValue(null);
                    kokie.setText("");
                    s1.setValue(null);
                    laipsnis.setText("");
                    kita12.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                    Alert regis112 = new Alert(Alert.AlertType.INFORMATION);
                    regis112.setTitle("Registracija");
                    Button ok_registr = (Button) regis112.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis112.setHeaderText("VLS apžiūra sėkmingai įregistruotas");
                    regis112.initModality(Modality.APPLICATION_MODAL);
                    regis112.initOwner(primaryStage);
                    regis112.showAndWait();
                });
                isv12.setOnAction(event1 -> {
                    re.setText("");
                    pus.setValue(null);
                    lo.setValue(null);
                    paz1.setValue(null);
                    b.setValue(null);
                    k.setValue(null);
                    r.setValue(null);
                    e.setValue(null);
                    kokie.setText("");
                    s1.setValue(null);
                    laipsnis.setText("");
                    kita12.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                });

                break;
            case "Fibroskopija":
                Label puse14 = new Label("Pažeidimo pusė");
                gridRRegApz.add(puse14, 1,4);
                ChoiceBox<String> pus14 = new ChoiceBox<>();
                pus14.getItems().addAll("kairė", "dešinė", "abi pusės");
                gridRRegApz.add(pus14, 2, 4);
                Label lokal14 = new Label("Pažeidimo lokalizacija");
                gridRRegApz.add(lokal14, 1, 5);
                ChoiceBox<String> lo14 = new ChoiceBox<>();
                lo14.getItems().addAll("Nosies prieangis","Apatinė kriauklė","Vidurinė kriauklė",
                        "Viršutinė kriauklė","Pertvara","Choana","Nosiaryklė","Burnaryklė",
                        "Maksiliarinis sinusas","Frontalinis sinusas","Etmoidalinis sinusas",
                        "Sfenoidalinis sinusas");
                gridRRegApz.add(lo14,2,5);
                Label paz14 = new Label("Pažeidimas apima");
                gridRRegApz.add(paz14,1,6);
                ChoiceBox<String> paz114 = new ChoiceBox<>();
                paz114.getItems().addAll("1 subsritį","daugiau nei 1 subsritį");
                gridRRegApz.add(paz114,2,6);
                Label ran14 = new Label("Randas");
                gridRRegApz.add(ran14, 3,6);
                ChoiceBox<String> r14 = new ChoiceBox<>();
                r14.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(r14,4,6);
                Label egzo14 = new Label("Egzofitiniai požymiai");
                gridRRegApz.add(egzo14, 1,7);
                ChoiceBox<String> e14 = new ChoiceBox<>();
                e14.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(e14,2,7);
                TextField kokie14 = new TextField();
                kokie14.setPromptText("Kokie požymiai?");
                gridRRegApz.add(kokie14, 3,7,2,1);
                Label sten14 = new Label("Stenozė");
                gridRRegApz.add(sten14, 1,8);
                ChoiceBox<String> s114 = new ChoiceBox<>();
                s114.getItems().addAll("Yra", "Nėra");
                gridRRegApz.add(s114,2,8);
                Label kita14 = new Label("Kita");
                gridRRegApz.add(kita14, 1,9);
                TextField kit14 = new TextField();
                gridRRegApz.add(kit14, 2, 9, 3,1);

                Button regis14 = new Button("Registruoti.");
                gridRRegApz.add(regis14, 1,13);
                Button isv14 = new Button("Išvalyti.");
                gridRRegApz.add(isv14, 2, 13);

                /** Mygtuko regis14 realizacija*/
                regis14.setOnAction(event1 -> {
                    Apziura apzfibro = new Apziura();
                    apzfibro.setPav(apziuraPapil);
                    apzfibro.setRez(re.getText());
                    apzfibro.setAsmens_kodas(pacientoKodas);
                    apzfibro.setPazeidimo_puse(pus14.getValue());
                    apzfibro.setPazeidimo_lokolizacija(lo14.getValue());
                    apzfibro.setPazeidimas_apima(paz114.getValue());

                    if(r14.getValue() == "Yra"){
                        apzfibro.setRandas(true);
                    }
                    if(e14.getValue() == "Yra"){
                        apzfibro.setEgzofitiniai_pozymiai_yra(true);
                        apzfibro.setEgzofitiniai_pozymiai_kokie(kokie14.getText());
                    }
                    if(s114.getValue() == "Yra"){
                        apzfibro.setStenoze_yra(true);

                    }
                    apzfibro.setKita(kita14.getText());
                    String data14 = regPac.datosIrasymas(metai, men, dien);
                    apzfibro.setData(data14);
                    try {
                        apzfibro.setApziura();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    re.setText("");
                    pus14.setValue(null);
                    lo14.setValue(null);
                    paz114.setValue(null);
                    r14.setValue(null);
                    e14.setValue(null);
                    kokie14.setText("");
                    s114.setValue(null);
                    kita14.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                    Alert regis114 = new Alert(Alert.AlertType.INFORMATION);
                    regis114.setTitle("Registracija");
                    Button ok_registr = (Button) regis114.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis114.setHeaderText("Fibroskopijos apžiūra sėkmingai įregistruotas");
                    regis114.initModality(Modality.APPLICATION_MODAL);
                    regis114.initOwner(primaryStage);
                    regis114.showAndWait();
                });
                isv14.setOnAction(event1 -> {
                    re.setText("");
                    pus14.setValue(null);
                    lo14.setValue(null);
                    paz114.setValue(null);
                    r14.setValue(null);
                    e14.setValue(null);
                    kokie14.setText("");
                    s114.setValue(null);
                    kita14.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                });
                break;
            case "Galvos ir kaklo KT":
                Label klinik = new Label("Duomenys klininkinį vaizdą ");
                gridRRegApz.add(klinik, 1,5);
                ChoiceBox<String> kl = new ChoiceBox<>();
                kl.getItems().addAll("Atitinka", "Neatitinka");
                gridRRegApz.add(kl,2,5);
                TextField neatitinka = new TextField();
                neatitinka.setPromptText("Jei neatitinka, įvesti požymius.");
                gridRRegApz.add(neatitinka,3,5,2,1);
                Label patolog = new Label("Kaklo limfmazgių patologija");
                gridRRegApz.add(patolog, 1,6);
                ChoiceBox<String> st = new ChoiceBox<>();
                st.getItems().addAll("Stebima", "Nestebima");
                gridRRegApz.add(st,2,6);
                TextField stebima = new TextField();
                stebima.setPromptText("Jei stebima, įvesti.");
                gridRRegApz.add(stebima,3,6,2,1);


                Button regis3 = new Button("Registruoti.");
                gridRRegApz.add(regis3, 1,9);
                Button isv3 = new Button("Išvalyti.");
                gridRRegApz.add(isv3, 2, 9);

                regis3.setOnAction(event7 -> {
                    Apziura apzC = new Apziura();
                    apzC.setPav(apziuraPapil);
                    apzC.setAsmens_kodas(pacientoKodas);
                    apzC.setRez(re.getText());
                    if(kl.getValue() == "Neatitinka") {
                        apzC.setDuomenys_atitinka_kt(true);
                        apzC.setJei_duomenys_neatitinka_kt(neatitinka.getText());
                    }
                    if(st.getValue() == "Stebima"){
                        apzC.setKaklo_limf_kt(true);
                        apzC.setJei_limf_stebimi(stebima.getText());
                    }

                    String sC = regPac.datosIrasymas(metai, men, dien);
                    apzC.setData(sC);
                    try {
                        apzC.setApziura();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    re.setText("");
                    kl.setValue(null);
                    neatitinka.setText("");
                    st.setValue(null);
                    stebima.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                    Alert regis4 = new Alert(Alert.AlertType.INFORMATION);
                    regis4.setTitle("Registracija");
                    Button ok_registr = (Button) regis4.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis4.setHeaderText("Galvos ir kaklo KT apžiūra sėkmingai įregistruotas");
                    regis4.initModality(Modality.APPLICATION_MODAL);
                    regis4.initOwner(primaryStage);
                    regis4.showAndWait();

                });
                isv3.setOnAction(event7 -> {
                    re.setText("");
                    kl.setValue(null);
                    neatitinka.setText("");
                    st.setValue(null);
                    stebima.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                });
                break;
            default:
                Button regis13 = new Button("Registruoti.");
                gridRRegApz.add(regis13, 1,6);
                Button isv13 = new Button("Išvalyti.");
                gridRRegApz.add(isv13, 2, 6);

                /** Mygtuko regis13 realizacija*/
                regis13.setOnAction(event1 -> {
                    Apziura apzi13 = new Apziura();
                    apzi13.setPav(apziuraPapil);
                    apzi13.setAsmens_kodas(pacientoKodas);
                    apzi13.setRez(re.getText());
                    String sK = regPac.datosIrasymas(metai, men, dien);
                    apzi13.setData(sK);
                    try {
                        apzi13.setApziura();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    re.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                    Alert regis8 = new Alert(Alert.AlertType.INFORMATION);
                    regis8.setTitle("Registracija");
                    Button ok_registr = (Button) regis8.getDialogPane().lookupButton(ButtonType.OK);
                    ok_registr.setText("OK");
                    regis8.setHeaderText(apziuraPapil+" Apzymas sėkmingai įregistruotas");
                    regis8.initModality(Modality.APPLICATION_MODAL);
                    regis8.initOwner(primaryStage);
                    regis8.showAndWait();

                });

                /** Mygtuko isv13 realizacija*/
                isv13.setOnAction(event1 -> {
                    re.setText("");
                    metai.setValue(null);
                    men.setValue(null);
                    dien.setValue(null);
                });
                break;
        }
        return gridRRegApz;

    }
    /** Apiūros pavadinimo pasirinkimas*/
    public Stage chooseApziuraPav(Stage primaryStage, BorderPane border, Scene naujas, ScrollPane scroll){

        /** GridPane sukūrimas*/
        GridPane gridRegApziura = new GridPane();
        gridRegApziura.setHgap(20);
        gridRegApziura.setVgap(15);
        gridRegApziura.setPadding(new Insets(10,0,10,10));

        /** Stage sukūrimas*/
        Stage regApziura = new Stage();
        regApziura.setTitle("Apžiūros pasirinkimas");
        Scene dialoguScena = new Scene(gridRegApziura,350,200);
        regApziura.setScene(dialoguScena);
        regApziura.setResizable(false);

        /** GUI sukūrimas*/
        Label apziu = new Label("Pavadinimas:");
        ChoiceBox<String> pas1 = new ChoiceBox<>();
        pas1.getItems().addAll("VLS","Fibroskopija", "Rinoskopija", "Faringoskopija",
                "Kaklo echoskopija", "Galvos ir kaklo KT","Biopsija", "Plaučiu rentgenologinis tyrimas",
                "Pilvo organu echoskopija","Kaklo apziura, palpacija","Galvos ir kaklo MRT",
                "PET/KT","Gastroskopija","Bronchoskopija","Odontologo apziura","HPV testas",
                "Rijimo ivertinimas","Balso ivertinimas","Audiograma","Otoskopija","Kita");
        Button pildyti = new Button("     Pildyti     ");
        gridRegApziura.add(apziu,1,2);
        gridRegApziura.add(pas1,2,2);
        gridRegApziura.add(pildyti,2,5);

        /** Mygtuko pildyt realizacija*/
        pildyti.setOnAction((event) -> {
            String pavv = pas1.getValue();
            Apziura apzii = new Apziura();
            try {
                apzii.setApziuraPav(pavv);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            regApziura.close();
            GridPane gridRRegApz = null;
            try {
                gridRRegApz = createRegApziura(primaryStage);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            border.setCenter(gridRRegApz);
            scroll.setContent(border);
            primaryStage.setScene(naujas);
        });

        return regApziura;

    }

    /** Sukūriamas naikinti gydymą langelis*/
    public Stage createDeleteGyd(){
        /** Sukūiramas gridPane*/
        GridPane gridNaikintiGyd = new GridPane();
        gridNaikintiGyd.setHgap(20);
        gridNaikintiGyd.setVgap(15);
        gridNaikintiGyd.setPadding(new Insets(10,0,10,10));

        /** Sukūriamas Stage, kuris yra grąžinamas*/
        Stage naikintGydymas = new Stage();
        naikintGydymas.setTitle("Gydymo naikintimas");
        Scene dialoguScena3 = new Scene(gridNaikintiGyd,300,200);
        naikintGydymas.setScene(dialoguScena3);
        naikintGydymas.setResizable(false);

        /** Sukūriamas GUI*/
        Label gydPav = new Label("Pavadinmas:");
        TextField gydPav1 = new TextField();
        Label gydData = new Label("Data:");
        TextField gydData1 = new TextField();
        Button naikinti = new Button("     Naikinti     ");
        gridNaikintiGyd.add(gydPav,1,1);
        gridNaikintiGyd.add(gydPav1,2,1);
        gridNaikintiGyd.add(gydData,1,2);
        gridNaikintiGyd.add(gydData1,2,2);
        gridNaikintiGyd.add(naikinti,2,5);
        naikinti.setTranslateX(-17);

        /** Mygtuko naikinti realizacija*/
        naikinti.setOnAction((event) -> {
            String apav = gydPav1.getText();
            String adata = gydData1.getText();
            Gydymas gyd1 = new Gydymas();
            try {
                if(gyd1.checkGydymas(pacientoKodas, apav, adata) != 1){
                    neraGydymo(naikintGydymas,apav, adata);
                }
                else{
                    trinti(naikintGydymas);
                    gyd1.deleteGydymas(pacientoKodas,apav, adata);
                    naikintGydymas.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        return naikintGydymas;
    }

    /** Sukūrimas naikinti apžiūrą langelis*/
    public Stage createDeleteApz(){

        /** GridPane sukūrimas*/
        GridPane gridNaikintiApz = new GridPane();
        gridNaikintiApz.setHgap(20);
        gridNaikintiApz.setVgap(15);
        gridNaikintiApz.setPadding(new Insets(10,0,10,10));

        /** Stage sukūrimas*/
        Stage naikintApziura = new Stage();
        naikintApziura.setTitle("Apžiūros naikinimas");
        Scene dialoguScena2 = new Scene(gridNaikintiApz,300,200);
        naikintApziura.setScene(dialoguScena2);
        naikintApziura.setResizable(false);

        /** GUI sukūrimas*/
        Label apziPav = new Label("Pavadinmas:");
        TextField apziPav1 = new TextField();
        Label apziData = new Label("Data:");
        TextField apziData1 = new TextField();
        Button naikinti = new Button("     Naikinti     ");
        gridNaikintiApz.add(apziPav,1,1);
        gridNaikintiApz.add(apziPav1,2,1);
        gridNaikintiApz.add(apziData,1,2);
        gridNaikintiApz.add(apziData1,2,2);
        gridNaikintiApz.add(naikinti,2,5);
        naikinti.setTranslateX(-17);

        /** Mygtuko naikinti realizacija*/
        naikinti.setOnAction((event) -> {
            String apav = apziPav1.getText();
            String adata = apziData1.getText();
            Apziura apz = new Apziura();
            try {
                if(apz.checkApziura(pacientoKodas, apav, adata) != 1){
                    neraApziuros(naikintApziura,apav, adata);
                }
                else{

                    trinti(naikintApziura);
                    apz.deleteApziura(pacientoKodas,apav, adata);
                    naikintApziura.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        return naikintApziura;
    }

    /** WARNING apie tai jei į paiešką įveda neegzistuojantį asmens kodą DB*/
    public void neraTokioAsmensKodo(Stage st, String asmens_kodas){
        Alert neraAsmensKodo = new Alert(Alert.AlertType.WARNING, "Nėra paciento su "+asmens_kodas+" asmens kodu duomenų bazėje !!! \nBandykite dar kartą !!!\n");
        neraAsmensKodo.setTitle("Dėmesio !!!");
        Button nera = (Button) neraAsmensKodo.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        neraAsmensKodo.initModality(Modality.APPLICATION_MODAL);
        neraAsmensKodo.initOwner(st);
        neraAsmensKodo.showAndWait();
    }

    /** pasako kad rastas pacientas pagal asmens kodą*/
    public void yraToksAsmensKodas(Stage st, String asmens_kodas){
        Alert yraAsmensKodas = new Alert(Alert.AlertType.INFORMATION, "Rastas pacientas su " + asmens_kodas + " asmens kodu !!!");
        yraAsmensKodas.setTitle("Dėmesio !!!");
        Button nera = (Button) yraAsmensKodas.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        yraAsmensKodas.initModality(Modality.APPLICATION_MODAL);
        yraAsmensKodas.initOwner(st);
        yraAsmensKodas.showAndWait();
    }
    /** WARNING apie tai jei į naikinimą įveda  skaičių kurio nera*/
    public void neraSkaicius(Stage st, int nr){
        Alert neigiamas = new Alert(Alert.AlertType.WARNING, "Nėra piktybinio naviko " +nr +" numeriu !!! \nBandykite dar kartą !!!\n");
        neigiamas.setTitle("Dėmesio !!!");
        Button nera = (Button) neigiamas.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        neigiamas.initModality(Modality.APPLICATION_MODAL);
        neigiamas.initOwner(st);
        neigiamas.showAndWait();
    }
    /** WARNING apie tai jei į naikinimą įveda  apziura kurios nera*/
    public void neraApziuros(Stage st, String pav, String data){
        Alert neigiamas = new Alert(Alert.AlertType.WARNING, "Nėra apžiūros pavadinimu " +pav +" , kuri būtų daryta " +data+"!!! \nBandykite dar kartą !!!\n");
        neigiamas.setTitle("Dėmesio !!!");
        Button nera = (Button) neigiamas.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        neigiamas.initModality(Modality.APPLICATION_MODAL);
        neigiamas.initOwner(st);
        neigiamas.showAndWait();
    }
    /** WARNING apie tai jei į naikinimą įveda  gydyma kurio nera*/
    public void neraGydymo(Stage st, String pav, String data){
        Alert neigiamas = new Alert(Alert.AlertType.WARNING, "Nėra gydymo pavadinimu " +pav +" , kuri būtų daryta " +data+"!!! \nBandykite dar kartą !!!\n");
        neigiamas.setTitle("Dėmesio !!!");
        Button nera = (Button) neigiamas.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        neigiamas.initModality(Modality.APPLICATION_MODAL);
        neigiamas.initOwner(st);
        neigiamas.showAndWait();
    }

    /** pranesa apie ištrynimą*/
    public void trinti(Stage st){
        Alert trinta = new Alert(Alert.AlertType.INFORMATION, "Sėkmingai ištrinta\n");
        trinta.setTitle("Dėmesio !!!");
        Button nera = (Button) trinta.getDialogPane().lookupButton(ButtonType.OK);
        nera.setText("OK");
        trinta.initModality(Modality.APPLICATION_MODAL);
        trinta.initOwner(st);
        trinta.showAndWait();
    }

}