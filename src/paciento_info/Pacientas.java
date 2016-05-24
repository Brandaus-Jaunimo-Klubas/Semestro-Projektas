package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** PACIENTA APIBUDINANTI KLASE;
 * Created by Dovile on 2016-04-27.
 */
public class Pacientas {

    DBConnect db = new DBConnect();


    // Paciento laukai:
    private String vardas;
    private String pavarde;
    private String asm_kodas; // Duomenu bazej ID;
    private String adresas;
    private String tel_nr;
    private int amzius;
    private String gim_data;
    private String lytis;
    private boolean alko;
    private boolean rukymas;
    private String profesija;
    private String pirmas_kreipimasis;
    private String paskutinis_kreipimasis;
    private int veziu_sk;
    private String alergija;
    private String mirties_data;
    private String mirties_priezastis;
    private int isgyvenimo_trukme;
    private String gydymo_pabaiga;
    private String gydymo_pradzia;
    private String paieska_kodas;

    public Pacientas(){
        this.vardas = null;
        this.pavarde = null;
        this.asm_kodas = null;
        this.adresas = null;
        this.tel_nr = null;
        this.amzius = 0;
        this.gim_data = null;
        this.lytis = null;
        this.alko = false;
        this.rukymas = false;
        this.profesija = null;
        this.pirmas_kreipimasis = null;
        this.paskutinis_kreipimasis = null;
        this.veziu_sk = 0;
        this.alergija = null;
        this.mirties_data = null;
        this.mirties_priezastis = null;
        this.isgyvenimo_trukme = 0;
        this.gydymo_pabaiga = null;
        this.gydymo_pradzia = null;
    }
    // Lauku metodai:

    public String getVardas() { return vardas; }
    public void setVardas(String vardas) {this.vardas = vardas;}
    public String getPavarde() {return pavarde;}
    public void setPavarde(String pavarde) { this.pavarde = pavarde;}
    public String getAsmens_kodas() {return asm_kodas;}
    public void setAsmens_kodas(String asmens_kodas) {this.asm_kodas = asmens_kodas;}
    public String getGim_data(){ return gim_data;}
    public void setGim_data(String data) {this.gim_data = data;}
    public int getAmzius(){return amzius;}
    public void setAmzius(int amzius) { this.amzius = amzius;}
    public String getAdresas() {return adresas;}
    public void setAdresas(String adresas) {this.adresas = adresas;}
    public String getTel_nr(){return tel_nr;}
    public void setTel_nr(String tel_nr){this.tel_nr = tel_nr;}
    public String getLytis() {return lytis;}
    public void setLytis(String lytis){this.lytis = lytis;}
    public boolean isAlkoholis(){return  alko;}
    public void setAlkoholis(boolean alkoholis){this.alko = alkoholis;}
    public boolean isRukymas() {return rukymas;}
    public void setRukymas(boolean rukymas){this.rukymas = rukymas;}
    public String getProfesija(){return profesija;}
    public void setProfesija(String profesija){this.profesija = profesija;}
    public String getPirmas_kreipimasis(){return pirmas_kreipimasis;}
    public void setPirmas_kreipimasis(String data) {this.pirmas_kreipimasis = data;}
    public String getPaskutinis_kreipimasis() {return paskutinis_kreipimasis;}
    public void setPaskutinis_kreipimasis(String data){this.paskutinis_kreipimasis = data;}
    public int getVeziu_sk(){return veziu_sk;}
    public void setVeziu_sk(int veziu_sk) {this.veziu_sk = veziu_sk;}
    public String getMirties_data(){return mirties_data;}
    public void setMirties_data(String data){this.mirties_data = data;}
    public String getMirties_priezastis(){return mirties_priezastis;}
    public void setMirties_priezastis(String mirties_priezastis){this.mirties_priezastis = mirties_priezastis;}
    public int getIsgyvenimo_trukme(){return isgyvenimo_trukme;}
    public void setIsgyvenimo_trukme(int isgyvenimo_trukme) {this.isgyvenimo_trukme = isgyvenimo_trukme;}
    public String getGydymo_pabaiga(){return gydymo_pabaiga;}
    public void setGydymo_pabaiga(String gydymo_pabaiga){this.gydymo_pabaiga = gydymo_pabaiga;}
    public String getAlergija(){return alergija;}
    public void setAlergija(String alergija) { this.alergija = alergija;}
    public String getGydymo_pradzia(){return gydymo_pradzia;}
    public void setGydymo_pradzia(String data) { this.gydymo_pradzia = data;}


    /** Iškelia duomenis iš duombazės, pagal asmens kodą*/
    public void getPacientas(String asm_kodas) throws SQLException {
        String query = "SELECT * FROM `pacientas` " +
                " WHERE `pacientas`.`asmens_kodas` = '"  + asm_kodas+"'" ;
        db.rs = db.st.executeQuery(query);
        while(db.rs.next()) {
            this.setVardas(db.rs.getString("vardas"));
            this.setPavarde(db.rs.getString("pavarde"));
            this.setAsmens_kodas(db.rs.getString("asmens_kodas"));
            this.setGim_data(db.rs.getString("gimimo_data"));
            this.setAmzius(db.rs.getInt("amzius"));
            this.setAdresas(db.rs.getString("adresas"));
            this.setTel_nr(db.rs.getString("telefono_nr"));
            this.setLytis(db.rs.getString("lytis"));
            this.setAlkoholis(db.rs.getBoolean("alkoholis"));
            this.setRukymas(db.rs.getBoolean("rukymas"));
            this.setProfesija(db.rs.getString("profesija"));
            this.setPirmas_kreipimasis(db.rs.getString("pirmasis_kreipimasis"));
            this.setPaskutinis_kreipimasis(db.rs.getString("paskutinis_apsilankymas"));
            this.setVeziu_sk(db.rs.getInt("veziu_sk"));
            this.setAlergija(db.rs.getString("alergija"));
            this.setMirties_data(db.rs.getString("mirties_data"));
            this.setMirties_priezastis(db.rs.getString("mirties_priezastis"));
            this.setIsgyvenimo_trukme(db.rs.getInt("isgyvenimo_trukme"));
            this.setGydymo_pabaiga(db.rs.getString("gydymo_pabaiga"));
            this.setGydymo_pradzia(db.rs.getString("gydymo_pradzia"));
        }
    }

    /** Įkelia duomenis į duomenų bazę.*/
    public void setPacientas() throws SQLException {
        String query = " INSERT INTO `pacientas`" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1,this.getVardas());
        smt.setString(2,this.getPavarde());
        smt.setString(3,this.getAsmens_kodas());
        smt.setString(4,this.getGim_data());
        smt.setInt(5, this.getAmzius());
        smt.setString(6,this.getAdresas());
        smt.setString(7,this.getTel_nr());
        smt.setString(8,this.getLytis());
        smt.setBoolean(9,this.isAlkoholis());
        smt.setBoolean(10,this.isRukymas());
        smt.setString(11,this.getProfesija());
        smt.setString(12,this.getPirmas_kreipimasis());
        smt.setString(13,this.getPaskutinis_kreipimasis());
        smt.setInt(14,this.getVeziu_sk());
        smt.setString(15,this.getAlergija());
        smt.setString(16,this.getMirties_data());
        smt.setString(17,this.getMirties_priezastis());
        smt.setInt(18,this.getIsgyvenimo_trukme());
        smt.setString(19,this.getGydymo_pabaiga());
        smt.setString(20,this.getGydymo_pradzia());
        smt.execute();
    }

    /** Ar yra pacientas nurodytu asmens kodu?*/
    public int arPacientas_yra_DB(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`asmens_kodas`) as `kiekis`" +
                " FROM `pacientas`" +
                " WHERE `pacientas`.`asmens_kodas`='"+asmens_kodas+"'";
        db.rs = db.st.executeQuery(query);
        int kiekis = 0;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
        }
        return kiekis;
    }
    public String getPaieskaKodas() throws SQLException {
        String kod = new String();
        String query = "SELECT `name` FROM `paieska` " +
                " WHERE `paieska`.`id` = '1'" ;
        db.rs = db.st.executeQuery(query);
        while(db.rs.next()) {
            kod = db.rs.getString("name");
        }
        return kod;
    }
    public void setPaieskaKodas(String kodas) throws SQLException {
       String query = " UPDATE `paieska` SET `name`='"+kodas+"' WHERE `id`='1' ";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
    }
    public void updatePacientas(String asmens_kodas) throws SQLException {
        //String query = " UPDATE `pacientas`" + "SET VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) WHERE `pacientas`.`asmens_kodas` ='"+asmens_kodas+"'";
        String query = "UPDATE `pacientas` SET `vardas`='"+this.getVardas()+"',`pavarde`='"+getPavarde()+"',`gimimo_data`='"+this.getGim_data()+
                "',`amzius`='"+this.getAmzius()+"',`adresas`='"+this.getAdresas()+"',`telefono_nr`='"+this.getTel_nr()+"',`lytis`='"+this.getLytis()+
                "',`alkoholis`='"+this.isAlkoholis()+"',`rukymas`='"+this.isRukymas()+"',`profesija`='"+this.getProfesija()+
                "',`pirmasis_kreipimasis`='"+this.getPirmas_kreipimasis()+"',`paskutinis_apsilankymas`='"+this.getPaskutinis_kreipimasis()+
                "',`veziu_sk`='"+this.getVeziu_sk()+"',`alergija`='"+this.getAlergija()+"',`mirties_data`='"+this.getMirties_data()+
                "',`mirties_priezastis`='"+this.getMirties_priezastis()+"',`isgyvenimo_trukme`='"+this.getIsgyvenimo_trukme()+
                "',`gydymo_pabaiga`='"+this.getGydymo_pabaiga()+"',`gydymo_pradzia`='"+this.getGydymo_pradzia()+"' WHERE `asmens_kodas` ='"+asmens_kodas+"'";
        PreparedStatement smt = db.con.prepareStatement(query);

        smt.execute();
    }
    /** Naikinti pacientą*/
    public void deletePacientas(String asmens_kodas) throws SQLException {
        String query = "DELETE FROM `vezys` WHERE `vezys`.`paciento_asmens_kodas` = '"+ asmens_kodas+"'";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
        String query1 = "DELETE FROM `apziura` WHERE `apziura`.`asmens_kodas` = '"+ asmens_kodas+"'";
        PreparedStatement smt1 = db.con.prepareStatement(query1);
        smt1.execute();
        String query2 = "DELETE FROM `gydymas` WHERE `gydymas`.`asmens_kodas` = '"+ asmens_kodas+"'";
        PreparedStatement smt2 = db.con.prepareStatement(query2);
        smt2.execute();
        String query3 = "DELETE FROM `pacientas` WHERE `pacientas`.`asmens_kodas` = '"+ asmens_kodas+"'";
        PreparedStatement smt3 = db.con.prepareStatement(query3);
        smt3.execute();
    }
}
