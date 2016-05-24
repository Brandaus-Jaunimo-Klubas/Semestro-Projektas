package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** VEZI APIBUDINANTI KLASE;
 * Created by Dovile on 2016-04-27.
 */
public class Vezys {

    DBConnect db = new DBConnect();

    // Vezio laukai;
    private String numeris;
    private String sritis;
    private String dif;
    private String stadija;
    private String cTNM;
    private String pTNMRL;
    private String morfo;
    private String morfo_kita;
    private int m_kodas;
    private int laikas_be_ligos;
    private String asmens_kodas;
    private boolean progresavimas;
    private int laikas_be_progresavimo;
    private String skundo_pav;
    private int skundo_trukme;
    private boolean metastazes_yra;
    private String metastazes_tipas;
    private String metastazes_data;
    private boolean recidyvas_yra;
    private String recidyvas_tipas;
    private String recidyvas_data;

    public Vezys() {
        this.numeris = null;
        this.sritis = null;
        this.dif = null;
        this.stadija = null;
        this.cTNM = null;
        this.pTNMRL = null;
        this.morfo = null;
        this.morfo_kita = null;
        this.m_kodas = 0;
        this.laikas_be_ligos = 0;
        this.asmens_kodas = null;
        this.progresavimas = false;
        this.laikas_be_progresavimo = 0;
        this.skundo_pav = null;
        this.skundo_trukme = 0;
        this.metastazes_yra = false;
        this.metastazes_tipas = null;
        this.metastazes_data = null;
        this.recidyvas_yra = false;
        this.recidyvas_tipas = null;
        this.recidyvas_data = null;

    }
    // Lauku metodai:
    public String getNr() {return numeris;}
    public void setNr(String nr) {this.numeris = nr;}
    public String getSritis() {return sritis;}
    public void setSritis(String sritis) { this.sritis = sritis;}
    public String getDif() { return dif;}
    public void setDif(String dif) { this.dif = dif;}
    public String getStadija() { return stadija;}
    public void setStadija(String stadija) { this.stadija = stadija;}
    public String getcTNM() { return cTNM;}
    public void setcTNM(String cTNM) { this.cTNM = cTNM;}
    public String getpTNMRL() { return pTNMRL;}
    public void setpTNMRL(String pTNMRL) { this.pTNMRL = pTNMRL;}
    public String getMorfo(){return morfo;}
    public void setMorfo(String morfo) {this.morfo = morfo;};
    public String getMorfo_kita(){return morfo_kita;}
    public void setMorfo_kita(String morfo_kita) {this.morfo_kita = morfo_kita;};
    public int getM_kodas(){return m_kodas;}
    public void setM_kodas(int kodas) { this.m_kodas = kodas;}
    public int getLaikas_be_ligos() {return laikas_be_ligos;}
    public void setLaikas_be_ligos(int laikas_be_ligos){this.laikas_be_ligos = laikas_be_ligos;}
    public boolean getProgresavimas(){return progresavimas;}
    public void setProgresavimas(boolean progresavimas){this.progresavimas = progresavimas;}
    public int getLaikas_be_progresavimo(){return laikas_be_progresavimo;}
    public void setLaikas_be_progresavimo(int laikas) { this.laikas_be_progresavimo = laikas;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}
    public String getSkundo_pav(){return skundo_pav;}
    public void setSkundo_pav(String sunko_pav){this.skundo_pav = sunko_pav;}
    public int getSkundo_trukme(){return skundo_trukme;}
    public void setSkundo_trukme(int skundo_trukme){this.skundo_trukme = skundo_trukme;}
    public boolean isMetastazes_yra(){return metastazes_yra;}
    public void setMetastazes_yra(boolean metastazes_yra){this.metastazes_yra = metastazes_yra;}
    public String getMetastazes_tipas(){return metastazes_tipas;}
    public void setMetastazes_tipas(String metastazes_tipas){this.metastazes_tipas = metastazes_tipas;}
    public String getMetastazes_data(){return metastazes_data;}
    public void setMetastazes_data(String metastazes_data){this.metastazes_data = metastazes_data;}
    public boolean isRecidyvas_yra(){return recidyvas_yra;}
    public void setRecidyvas_yra(boolean recidyvas_yra){this.recidyvas_yra = recidyvas_yra;}
    public String getRecidyvas_tipas(){return recidyvas_tipas;}
    public void setRecidyvas_tipas(String recidyvas_tipas){this.recidyvas_tipas = recidyvas_tipas;}
    public String getRecidyvas_data(){return recidyvas_data;}
    public void setRecidyvas_data(String recidyvas_data){this.recidyvas_data = recidyvas_data;}

    // Metodai ideti i DB ir paimti is DB:
    public Vezys[] getVezys(String asm_kodas) throws SQLException {
        Vezys veziai[] = new Vezys[getCount(asm_kodas)];
        String query = "SELECT * FROM `vezys` " +
                " WHERE `vezys`.`paciento_asmens_kodas` = '" + asm_kodas + "'" +
                " ORDER BY `vezys`.`numeris` ASC";
        db.rs = db.st.executeQuery(query);
        int k = 0;
        while(db.rs.next()){
            Vezys vez = new Vezys();
            vez.setNr(db.rs.getString("numeris"));
            vez.setSritis(db.rs.getString("sritis"));
            vez.setDif(db.rs.getString("diferencijacija"));
            vez.setStadija(db.rs.getString("stadija"));
            vez.setMorfo(db.rs.getString("morfologija"));
            vez.setMorfo_kita(db.rs.getString("morfo_kita"));
            vez.setM_kodas(db.rs.getInt("M_kodas"));
            vez.setcTNM(db.rs.getString("cTNM"));
            vez.setpTNMRL(db.rs.getString("pTNMRL"));
            vez.setLaikas_be_ligos(db.rs.getInt("laikas_be_ligos"));
            vez.setProgresavimas(db.rs.getBoolean("progresavimas"));
            vez.setLaikas_be_progresavimo(db.rs.getInt("laikas_be_progresavimo"));
            vez.setAsmens_kodas(db.rs.getString("paciento_asmens_kodas"));
            vez.setSkundo_pav(db.rs.getString("skundo_pav"));
            vez.setSkundo_trukme(db.rs.getInt("skundo_trukme"));
            vez.setMetastazes_yra(db.rs.getBoolean("metastazes_yra"));
            vez.setMetastazes_tipas(db.rs.getString("metastazes_tipas"));
            vez.setMetastazes_data(db.rs.getString("metastazes_data"));
            vez.setRecidyvas_yra(db.rs.getBoolean("recidyvas_yra"));
            vez.setRecidyvas_tipas(db.rs.getString("recidyvo_tipas"));
            vez.setRecidyvas_data(db.rs.getString("recidyvo_data"));
            veziai[k] = vez;
            k++;
        }

        return veziai;
    }

    /** Duomenu idejimas i DB;*/
    public void setVezys() throws SQLException {
        String query = "INSERT INTO `vezys`" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1, this.getNr());
        smt.setString(2, this.getSritis());
        smt.setString(3, this.getDif());
        smt.setString(4, this.getStadija());
        smt.setString(5, this.getMorfo());
        smt.setString(6, this.getMorfo_kita());
        smt.setInt(7, this.getM_kodas());
        smt.setString(8, this.getcTNM());
        smt.setString(9, this.getpTNMRL());
        smt.setInt(10, this.getLaikas_be_ligos());
        smt.setBoolean(11, this.getProgresavimas());
        smt.setInt(12, this.getLaikas_be_progresavimo());
        smt.setString(13, this.getAsmens_kodas());
        smt.setString(14, this.getSkundo_pav());
        smt.setInt(15, this.getSkundo_trukme());
        smt.setBoolean(16, this.isMetastazes_yra());
        smt.setString(17, this.getMetastazes_tipas());
        smt.setString(18, this.getMetastazes_data());
        smt.setBoolean(19, this.isRecidyvas_yra());
        smt.setString(20, this.getRecidyvas_tipas());
        smt.setString(21, this.getMetastazes_data());

        smt.execute();
    }

    /** veziu kiekio radimas;*/
    public int getCount(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`numeris`) as `kiekis` " +
                "FROM `vezys` " +
                "WHERE `vezys`.`paciento_asmens_kodas` = '" + asmens_kodas + "'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    /** Naikinti vėžį*/
    public void deleteVezys(String asmens_kodas, String numeris) throws SQLException {
        String query = "DELETE FROM `vezys` WHERE `vezys`.`paciento_asmens_kodas` = '"+ asmens_kodas+"' AND `numeris` = '"+numeris+"'";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
    }
    /** Patikrina ar yra tokiu numeriu vezys*/
    public int checkVezys(String asmens_kodas, String numeris) throws SQLException {
        String query = "SELECT COUNT(`numeris`) AS `kiekis` FROM `vezys` WHERE `vezys`.`paciento_asmens_kodas` = '"+ asmens_kodas+"' AND `numeris` = '"+numeris+"'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }


}
