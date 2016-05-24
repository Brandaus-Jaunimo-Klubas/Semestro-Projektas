package Langai;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Statistikos lango sukūrimas
 * Created by Dovile on 2016-05-23.
 */
public class Statistikos_Langas {
    private Registruoti_Pacienta regPac = new Registruoti_Pacienta();
    public Statistikos_Langas(){}
    /** GridPane sukūrimas*/
    public GridPane createStatistika(Stage primaryStage){

        /** GridPane sukūrimas*/
        GridPane stat = new GridPane();
        stat.setHgap(20);
        stat.setVgap(15);
        stat.setPadding(new Insets(10,0,10,10));

        TextField fikt2 = new TextField();
        stat.add(fikt2,2,19);
        fikt2.setVisible(false);

        Label amzius_stat = new Label("Amžius (Nuo - Iki)");
        stat.add(amzius_stat,1,1);
        TextField amz_stat1 = new TextField();
        amz_stat1.setMaxWidth(38);
        stat.add(amz_stat1,2,1);
        TextField amz_stat2 = new TextField();
        amz_stat2.setMaxWidth(38);
        stat.add(amz_stat2,2,1);
        amz_stat2.setTranslateX(55);
        Label amzius_dash = new Label("-");
        stat.add(amzius_dash,2,1);
        amzius_dash.setTranslateX(44);

        Label lytis_stat = new Label("Lytis");
        stat.add(lytis_stat,3,1);
        ChoiceBox<String> lytis_pas = new ChoiceBox<>();
        lytis_pas.getItems().addAll("Vyras","Moteris");
        stat.add(lytis_pas,4,1);

        Label alkoholis_stat = new Label("Alkoholis (kelis kartu per savaitę)");
        stat.add(alkoholis_stat,1,2);
        ChoiceBox<String> alko_stat = new ChoiceBox<>();
        alko_stat.getItems().addAll("Taip", "Ne");
        stat.add(alko_stat,2,2);

        Label rukymas_stat = new Label("Rūkymas (kiekvieną dieną)");
        stat.add(rukymas_stat,3,2);
        ChoiceBox<String> ruk_stat = new ChoiceBox<>();
        ruk_stat.getItems().addAll("Taip", "Ne");
        stat.add(ruk_stat,4,2);

        Label data_stat = new Label("Pirmas apsilankymas (Nuo - Iki)");
        stat.add(data_stat,1,3);
        ChoiceBox<Integer> me_stat = new ChoiceBox<>();
        ChoiceBox<String> men_stat = new ChoiceBox<>();
        ChoiceBox<Integer> dien_stat = new ChoiceBox<>();
        ChoiceBox<Integer> me_stat2 = new ChoiceBox<>();
        ChoiceBox<String> men_stat2 = new ChoiceBox<>();
        ChoiceBox<Integer> dien_stat2 = new ChoiceBox<>();
        regPac.data(stat,3,1,me_stat,men_stat,dien_stat,false);
        regPac.data(stat,3,3,me_stat2,men_stat2,dien_stat2,false);

        Label amzius_dash2 = new Label("-");
        stat.add(amzius_dash2,4,3);
        amzius_dash2.setTranslateX(-80);

        Label vezsk_stat = new Label("Piktybinių procesų skaičius");
        stat.add(vezsk_stat,1,4);
        TextField vezs_stat = new TextField();
        vezs_stat.setMaxWidth(30);
        stat.add(vezs_stat,2,4);

        Label sritis_stat = new Label("Sritis");
        stat.add(sritis_stat,1,5);
        ChoiceBox<String> sri_stat = new ChoiceBox<>();
        sri_stat.getItems().addAll("Lūpos C00", "Navikas be pirminio židinio C80", "Liežuvio šaknies C01", "Kitos liežuvio dalies C02",
                "Dantenos piktybinis navikas C03", "Burnos dugno C04", "Gomurio C05", "Kitų burnos dalių C06", "Paausinės eilių liaukos C07",
                "Kitų seilių liaukų C08", "Migdolo (ne ryklės ir ne liežuvio migdolų) C09", "Burnaryklės navikas C10", "Nosiaryklės C11",
                "Kriaušinės kišenės C12", "Gerklaryklės C13", "Kitų ir nepatikslintų lūpos, burnos ertmės ir ryklės dalių piktybinis navikas C14",
                "Nosies ertmės ir vidurinės ausies piktybinis navikas C30", "Prienosinių ančių piktybinis navikas C31", "Gerklų piktybinis navikas C32",
                "Tikrasis balso aparatas C32.0", "Gerklų viršutinė dalis C32.1", "Gerklų apatinė dalis  C32.2", "Kaukolės ir veido kaulai C41.0",
                "Odos piktybinė melanoma C43", "Kiti odos piktybiniai navikai C44", "Galvos, veido ir kaklo jungiamasis ir minkštieji audiniai C49.0",
                "Skydliaukės piktybinis navikas C73", "Kitų ir netiksliai apibrėžtų lokalizacijų piktybinis navikas C76",
                "Metastazinis ir nepatikslintas limfmazgių piktybinis navikas C77", "Kitų lokolizacijų piktybinis navikas 76.0");
        stat.add(sri_stat,7,5);
        sri_stat.setTranslateX(-584);

        Label diferenc_stat = new Label("Diferencijacija");
        stat.add(diferenc_stat,3,4);
        diferenc_stat.setTranslateX(-85);

        ChoiceBox<String> difer_stat = new ChoiceBox<>();
        difer_stat.getItems().addAll("GX", "G1", "G2", "G3", "G4");
        stat.add(difer_stat,4,4);
        difer_stat.setTranslateX(-145);

        Label tnm_stat = new Label("TNM");
        stat.add(tnm_stat,1,6);
        TextField tn_stat = new TextField();
        stat.add(tn_stat,2,6);

        Label stadi_stat = new Label("Stadija");
        stat.add(stadi_stat,3,4);
        stadi_stat.setTranslateX(100);
        ChoiceBox<String> stad_stat = new ChoiceBox<>();

        stad_stat.getItems().addAll("IA", "IB", "II", "III", "IVA", "IVB", "IVC");
        stat.add(stad_stat,4,4);
        stad_stat.setTranslateX(10);

        Label recidyv_stat = new Label("Recidyvas");
        stat.add(recidyv_stat,3,6);
        CheckBox rec_stat = new CheckBox();
        stat.add(rec_stat,4,6);
        rec_stat.setTranslateX(-80);

        ChoiceBox reci_stat = new ChoiceBox();
        reci_stat.getItems().addAll("Izoliuotas limfmazgių recidyvas", "Lokalus recidyvas");
        stat.add(reci_stat,7,6);
        reci_stat.setTranslateX(-280);
        reci_stat.setVisible(false);



        rec_stat.setOnAction((event) -> {
            if(rec_stat.isSelected()) {
                reci_stat.setVisible(true);
            }
            else {
                reci_stat.setVisible(false);
            }
        });

        Label metast_stat = new Label("Metastazė");
        stat.add(metast_stat,1,7);
        CheckBox meta_stat = new CheckBox();
        stat.add(meta_stat,2,7);
        rec_stat.setTranslateX(-80);

        ChoiceBox met_stat = new ChoiceBox();
        met_stat.getItems().addAll("Plaučiai", "Kepenys", "Galvos smegenys", "Kita");
        stat.add(met_stat,2,7);
        met_stat.setTranslateX(35);
        met_stat.setVisible(false);

        TextField metKit_stat = new TextField();
        stat.add(metKit_stat,3,7);
        met_stat.setTranslateX(35);
        metKit_stat.setVisible(false);


        meta_stat.setOnAction((event) -> {
            if(meta_stat.isSelected()) {
                met_stat.setVisible(true);
            }
            else {
                met_stat.setVisible(false);
                metKit_stat.setVisible(false);
            }
        });

        met_stat.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() == 3) {
                metKit_stat.setVisible(true);
            }
            else {
                metKit_stat.setVisible(false);
            }
        });

        Label pet_stat = new Label("PET/KT");
        stat.add(pet_stat,1,8);
        TextField pe_stat = new TextField();
        stat.add(pe_stat,2,8);

        Label hpv_stat = new Label("HPV");
        stat.add(hpv_stat,3,8);
        TextField hp_stat = new TextField();
        stat.add(hp_stat,2,8);
        hp_stat.setTranslateX(200);

        Label chirur_stat = new Label("Chirurginis gydymas");
        stat.add(chirur_stat,1,9);
        TextField chir_stat = new TextField();
        stat.add(chir_stat,2,9);

        Label spind_stat = new Label("Radioterapija");
        stat.add(spind_stat,3,9);
        TextField sp_stat = new TextField();
        stat.add(sp_stat,2,9);
        sp_stat.setTranslateX(285);

        CheckBox sarg_stat = new CheckBox("Sarginis L/M");
        stat.add(sarg_stat,1,10);

        CheckBox limfa_stat = new CheckBox("Limfanodektomija");
        stat.add(limfa_stat,2,10);

        Label chemo_stat = new Label("Chemoterapija");
        stat.add(chemo_stat,3,10);
        CheckBox chem_stat = new CheckBox();
        stat.add(chem_stat,3,10);
        chemo_stat.setTranslateX(20);

        ChoiceBox che_stat = new ChoiceBox();
        che_stat.getItems().addAll("Indukcinė", "Adjuvantinė");
        stat.add(che_stat,3,10);
        che_stat.setTranslateX(110);
        che_stat.setVisible(false);

        chem_stat.setOnAction((event) -> {
            if(chem_stat.isSelected()) {
                che_stat.setVisible(true);
            }
            else {
                che_stat.setVisible(false);
            }
        });

        CheckBox chemsp_stat = new CheckBox("Chemospindulinis gydymas");
        stat.add(chemsp_stat,1,11);

        ChoiceBox chems_stat = new ChoiceBox();
        chems_stat.getItems().addAll("Indukcinis", "Adjuvantinis");
        stat.add(chems_stat,2,11);

        chems_stat.setVisible(false);

        chemsp_stat.setOnAction((event) -> {
            if(chemsp_stat.isSelected()) {
                chems_stat.setVisible(true);
            }
            else {
                chems_stat.setVisible(false);
            }
        });

        CheckBox biolo_stat = new CheckBox("Biologinė terapija");
        stat.add(biolo_stat,3,11);

        ChoiceBox biol_stat = new ChoiceBox();
        biol_stat.getItems().addAll("Indukcinė", "Adjuvantinė");
        stat.add(biol_stat,3,11);
        biol_stat.setTranslateX(110);

        biol_stat.setVisible(false);

        biolo_stat.setOnAction((event) -> {
            if(chemsp_stat.isSelected()) {
                biol_stat.setVisible(true);
            }
            else {
                biol_stat.setVisible(false);
            }
        });

        CheckBox biosp_stat = new CheckBox("Biospindulinis gydymas");
        stat.add(biosp_stat,1,12);

        ChoiceBox bios_stat = new ChoiceBox();
        bios_stat.getItems().addAll("Indukcinis", "Adjuvantinis");
        stat.add(bios_stat,2,12);

        bios_stat.setVisible(false);

        biosp_stat.setOnAction((event) -> {
            if(biosp_stat.isSelected()) {
                bios_stat.setVisible(true);
            }
            else {
                bios_stat.setVisible(false);
            }
        });

        Label paliatyv_stat = new Label("Paliatyvus gydymas");
        stat.add(paliatyv_stat,3,12);
        TextField paliat_stat = new TextField();
        stat.add(paliat_stat,2,12);
        paliat_stat.setTranslateX(285);

        Label kitas_stat = new Label("Kitas gydymas");
        stat.add(kitas_stat,1,13);
        TextField kit_stat = new TextField();
        stat.add(kit_stat,2,13);

        Label komp_stat = new Label("Komplikacijos");
        stat.add(komp_stat,1,14);
        CheckBox kom_stat = new CheckBox();
        stat.add(kom_stat,2,14);
        rec_stat.setTranslateX(-80);

        ChoiceBox ko_stat = new ChoiceBox();
        ko_stat.getItems().addAll("Minkštųjų audinių nekrozė", "Kraujavimas", "Disfagija", "Osteonekrozė",
                "Kserostomija", "Masyvus kraujavimas", "Kita");
        stat.add(ko_stat,1,14);
        ko_stat.setTranslateX(230);
        ko_stat.setVisible(false);

        TextField komKit_stat = new TextField();
        stat.add(komKit_stat,1,14);
        komKit_stat.setTranslateX(400);
        komKit_stat.setVisible(false);

        kom_stat.setOnAction((event) -> {
            if(kom_stat.isSelected()) {
                ko_stat.setVisible(true);
            }
            else {
                ko_stat.setVisible(false);
                komKit_stat.setVisible(false);
            }
        });

        ko_stat.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() == 6) {
                komKit_stat.setVisible(true);
            }
            else {
                komKit_stat.setVisible(false);
            }
        });

        Label beLigos_stat = new Label("Laikas be ligos");
        stat.add(beLigos_stat,1,15);
        TextField beLig_stat = new TextField();
        stat.add(beLig_stat,2,15);

        Label beProgres_stat = new Label("Laikas be progreso");
        stat.add(beProgres_stat,3,15);
        TextField beProg_stat = new TextField();
        stat.add(beProg_stat,2,15);
        beProg_stat.setTranslateX(285);

        Label arMire_stat = new Label("Ar mirė?");
        stat.add(arMire_stat,1,16);

        ChoiceBox arMir_stat = new ChoiceBox();
        arMir_stat.getItems().addAll("Taip", "Ne");
        stat.add(arMir_stat,2,16);

        Button iesko_stat = new Button("Ieškoti");
        stat.add(iesko_stat,1,17);
        iesko_stat.setTranslateX(600);



        return stat;
    }

}
