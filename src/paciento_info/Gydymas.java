package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** GYDYMA APIBUDINANTI KLASE;
 * Created by Dovile on 2016-04-28.
 */
public class Gydymas {
    DBConnect db = new DBConnect();

    /** Gydymo laikai:*/
    private String pav;
    private String operacinis_aprasymas;
    private boolean sarginis_l_m;
    private String l_m_gr_paz;
    private String l_m_gr_nepaz;
    private String l_m_gr_paz_teig;
    private String l_m_gr_nepaz_teig;
    private boolean limfo;
    private String limfo_gr_paz;
    private String limfo_gr_nepaz;
    private String limfo_gr_paz_teig;
    private String limfo_gr_nepaz_teig;
    private String tipas;
    private String aprasymas;
    private boolean ar_taikyta_limf;
    private int sumine_doze;
    private int frakcijos;
    private boolean cetuksimabas;
    private boolean cisplatina;
    private boolean docetakselis;
    private boolean paklitakselis;
    private boolean fu_5;
    private String kiti_vaistai;
    private int kursu_kiekis;
    private int kiekis;
    private String data_nuo;
    private String data_iki;
    private String asmens_kodas;
    private boolean gydymas_baigtas;

    public Gydymas() {
        this.pav = null;
        this.operacinis_aprasymas = null;
        this.sarginis_l_m = false;
        this.l_m_gr_paz = null;
        this.l_m_gr_nepaz = null;
        this.l_m_gr_paz_teig = null;
        this.l_m_gr_nepaz_teig = null;
        this.limfo = false;
        this.limfo_gr_paz = null;
        this.limfo_gr_nepaz = null;
        this.limfo_gr_paz_teig = null;
        this.limfo_gr_nepaz_teig = null;
        this.tipas = null;
        this.aprasymas = null;
        this.ar_taikyta_limf = false;
        this.sumine_doze = 0;
        this.frakcijos = 0;
        this.cetuksimabas = false;
        this.cisplatina = false;
        this.docetakselis = false;
        this.paklitakselis = false;
        this.fu_5 = false;
        this.kiti_vaistai = null;
        this.kursu_kiekis = 0;
        this.kiekis = 0;
        this.data_nuo = null;
        this.data_iki = null;
        this.asmens_kodas = null;
        this.gydymas_baigtas = false;
    }

    // Metodai laukams:
    public String getPav(){return pav;}
    public void setPav(String pav){this.pav = pav;}
    public String getOperacinis_aprasymas() {return  operacinis_aprasymas;}
    public void setOperacinis_aprasymas(String operacinis_aprasymas){this.operacinis_aprasymas = operacinis_aprasymas;}
    public boolean isSarginis_l_m(){return sarginis_l_m;}
    public void setSarginis_l_m(boolean sarginis_l_m) {this.sarginis_l_m = sarginis_l_m;}
    public String getL_m_gr_paz(){return l_m_gr_paz;}
    public void setL_m_gr_paz(String l_m_gr_paz){this.l_m_gr_paz = l_m_gr_paz;}
    public String getL_m_gr_nepaz(){return l_m_gr_nepaz;}
    public void setL_m_gr_nepaz(String l_m_gr_nepaz) {this.l_m_gr_nepaz = l_m_gr_nepaz;}
    public String getL_m_gr_paz_teig(){return l_m_gr_paz_teig;}
    public void setL_m_gr_paz_teig(String l_m_gr_paz_teig){this.l_m_gr_paz_teig = l_m_gr_paz_teig;}
    public String getL_m_gr_nepaz_teig(){return l_m_gr_nepaz_teig;}
    public void setL_m_gr_nepaz_teig(String l_m_gr_nepaz_teig){this.l_m_gr_nepaz_teig = l_m_gr_nepaz_teig;}
    public boolean isLimfo(){return limfo;}
    public void setLimfo(boolean limfo){this.limfo = limfo;}
    public String getLimfo_gr_paz(){return limfo_gr_paz;}
    public void setLimfo_gr_paz(String limfo_gr_paz){this.limfo_gr_paz = limfo_gr_paz;}
    public String getLimfo_gr_nepaz(){return limfo_gr_nepaz;}
    public void setLimfo_gr_nepaz(String limfo_gr_nepaz){this.l_m_gr_nepaz = limfo_gr_nepaz;}
    public String getLimfo_gr_paz_teig(){return limfo_gr_paz_teig;}
    public void setLimfo_gr_paz_teig(String limfo_gr_paz_teig){this.limfo_gr_paz_teig = limfo_gr_paz_teig;}
    public String getLimfo_gr_nepaz_teig(){return limfo_gr_nepaz_teig;}
    public void setLimfo_gr_nepaz_teig(String limfo_gr_nepaz_teig){this.l_m_gr_nepaz_teig = limfo_gr_nepaz_teig;}
    public String getTipas(){return tipas;}
    public void setTipas(String tipas){this.tipas = tipas;}
    public String getAprasymas(){return aprasymas;}
    public void setAprasymas(String aprasymas){this.aprasymas = aprasymas;}
    public boolean isAr_taikyta_limf(){return ar_taikyta_limf;}
    public void setAr_taikyta_limf(boolean taikyta){this.ar_taikyta_limf = taikyta;}
    public int getSumine_doze(){return sumine_doze;}
    public void setSumine_doze(int sumine_doze){this.sumine_doze = sumine_doze;}
    public int getFrakcijos(){return frakcijos;}
    public void setFrakcijos(int frakcijos){this.frakcijos = frakcijos;}
    public boolean isCetuksimabas(){return cetuksimabas;}
    public void setCetuksimabas(boolean cetuksimabas){this.cetuksimabas = cetuksimabas;}
    public boolean isCisplatina(){return cisplatina;}
    public void setCisplatina(boolean cisplatina){this.cisplatina = cisplatina;}
    public boolean isDocetakselis() {return docetakselis;}
    public void setDocetakselis(boolean docetakselis) {this.docetakselis = docetakselis;}
    public boolean isPaklitakselis(){return paklitakselis;}
    public void setPaklitakselis(boolean paklitakselis) {this.paklitakselis = paklitakselis;}
    public boolean isFu_5(){return fu_5;}
    public void setFu_5(boolean fu_5) {this.fu_5 = fu_5;}
    public String getKiti_vaistai() {return kiti_vaistai;}
    public void setKiti_vaistai(String kiti_vaistai) {this.kiti_vaistai = kiti_vaistai;}
    public int getKursu_kiekis() {return kursu_kiekis;}
    public void setKursu_kiekis(int kursu_kiekis){this.kursu_kiekis = kursu_kiekis;}
    public int getKiekis(){return kiekis;}
    public void setKiekis(int kiekis){this.kiekis = kiekis;}
    public String getData_nuo(){return data_nuo;}
    public void setData_nuo(String data_nuo) {this.data_nuo = data_nuo;}
    public String getData_iki(){return data_iki;}
    public void setData_iki(String data_iki) {this.data_iki = data_iki;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}
    public boolean isGydymas_baigtas(){return gydymas_baigtas;}
    public void setGydymas_baigtas(boolean gydymas_baigtas){this.gydymas_baigtas = gydymas_baigtas;}
    /** Paemimas info is DB ir idejimas i DB:*/
    /** Duomenu isemimas is DB;*/
    public Gydymas[] getGydymas(String asm_kodas) throws SQLException {
        Gydymas gydymai[] = new Gydymas[getCount(asm_kodas)];
        String query = "SELECT * FROM `gydymas` " +
                " WHERE `gydymas`.`asmens_kodas` = '"+asm_kodas+"'" +
                " ORDER BY `gydymas`.`data_nuo` DESC";
        db.rs = db.st.executeQuery(query);
        int k = 0;
        while(db.rs.next()){
            Gydymas gyd = new Gydymas();
            gyd.setPav(db.rs.getString("pavadinimas"));
            gyd.setOperacinis_aprasymas(db.rs.getString("operacinis_aprasymas"));
            gyd.setSarginis_l_m(db.rs.getBoolean("sarginis_l_m"));
            gyd.setL_m_gr_paz(db.rs.getString("l_m_gr_paz"));
            gyd.setL_m_gr_nepaz(db.rs.getString("l_m_gr_nepaz"));
            gyd.setL_m_gr_paz_teig(db.rs.getString("l_m_paz_teig"));
            gyd.setL_m_gr_nepaz_teig(db.rs.getString(7));
            gyd.setLimfo(db.rs.getBoolean("limfanodektomija"));
            gyd.setLimfo_gr_paz(db.rs.getString("limfo_gr_paz"));
            gyd.setLimfo_gr_nepaz(db.rs.getString("limfo_gr_nepaz"));
            gyd.setLimfo_gr_paz_teig(db.rs.getString("limfo_gr_paz_teig"));
            gyd.setLimfo_gr_nepaz_teig(db.rs.getString("limfo_gr_nepaz_teig"));
            gyd.setTipas(db.rs.getString("tipas"));
            gyd.setAprasymas(db.rs.getString("aprasymas"));
            gyd.setAr_taikyta_limf(db.rs.getBoolean("ar_taikyta_limf"));
            gyd.setSumine_doze(db.rs.getInt("sumine_doze"));
            gyd.setFrakcijos(db.rs.getInt("frakcijos"));
            gyd.setCetuksimabas(db.rs.getBoolean("cetuksimabas"));
            gyd.setCisplatina(db.rs.getBoolean("cisplatina"));
            gyd.setDocetakselis(db.rs.getBoolean("docetakselis"));
            gyd.setPaklitakselis(db.rs.getBoolean("paklitakselis"));
            gyd.setFu_5(db.rs.getBoolean("5_fu"));
            gyd.setKiti_vaistai(db.rs.getString("kiti_vaistai"));
            gyd.setKursu_kiekis(db.rs.getInt("kursu_skaicius"));
            gyd.setKiekis(db.rs.getInt("kiekis"));
            gyd.setData_nuo(db.rs.getString("data_nuo"));
            gyd.setData_iki(db.rs.getString("data_iki"));
            gyd.setAsmens_kodas(db.rs.getString("asmens_kodas"));
            gyd.setGydymas_baigtas(db.rs.getBoolean("gydymas_baigtas"));
            gydymai[k] = gyd;
            k++;
        }

        return gydymai;
    }

    /** Duomenu idejimas i DB;*/
    public void setGydymas() throws SQLException {
        String query = "INSERT INTO `gydymas`" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1, this.getPav());
        smt.setString(2, this.getOperacinis_aprasymas());
        smt.setBoolean(3, this.isSarginis_l_m());
        smt.setString(4, this.getL_m_gr_paz());
        smt.setString(5, this.getL_m_gr_nepaz());
        smt.setString(6, this.getL_m_gr_paz_teig());
        smt.setString(7, this.getL_m_gr_nepaz_teig());
        smt.setBoolean(8, this.isLimfo());
        smt.setString(9, this.getLimfo_gr_paz());
        smt.setString(10, this.getLimfo_gr_nepaz());
        smt.setString(11, this.getLimfo_gr_paz_teig());
        smt.setString(12, this.getLimfo_gr_nepaz_teig());
        smt.setString(13, this.getTipas());
        smt.setString(14, this.getAprasymas());
        smt.setBoolean(15, this.isAr_taikyta_limf());
        smt.setInt(16, this.getSumine_doze());
        smt.setInt(17, this.getFrakcijos());
        smt.setBoolean(18, this.isCetuksimabas());
        smt.setBoolean(19, this.isCisplatina());
        smt.setBoolean(20, this.isDocetakselis());
        smt.setBoolean(21, this.isPaklitakselis());
        smt.setBoolean(22, this.isFu_5());
        smt.setString(23, this.getKiti_vaistai());
        smt.setInt(24, this.getKursu_kiekis());
        smt.setInt(25, this.getKiekis());
        smt.setString(26, this.getData_nuo());
        smt.setString(27, this.getData_iki());
        smt.setString(28, this.getAsmens_kodas());
        smt.setBoolean(29, this.isGydymas_baigtas());

        smt.execute();
    }

    /** gydiuru kiekio radimas;*/
    public int getCount(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                " FROM `gydymas` " +
                " WHERE `gydymas`.`asmens_kodas` = '" + asmens_kodas + "'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    public int getCoutDatos(String asmens_kodas, String data_nuo, String data_iki) throws SQLException {
        String query = "SELECT COUNT(`gydymas`) as `kiekis` " +
                " FROM `gydymas` " +
                " WHERE `gydymas`.`asmens_kodas` = '" + asmens_kodas + "' AND " +
                " `gydymas`.`data_nuo` >= '" + data_nuo + "' AND" +
                " `gydymas`.`data_nuo` <= '" + data_iki + "'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    /** gydymo isemimas pagal datu intervala;*/
    public Gydymas[] getPagalDatosgydymas(String asm_kodas, String data_nuo, String data_iki ) throws SQLException {
        Gydymas gydymai[] = new Gydymas[getCoutDatos(asm_kodas, data_nuo, data_iki)];
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                " FROM `gydymas` " +
                " WHERE `gydymas`.`asmens_kodas` = '" + asmens_kodas + "' AND " +
                " `gydymas`.`data` >= '" + data_nuo + "' AND" +
                " `gydymas`.`data` <= '" + data_iki + "'"+
                " ORDER BY `gydymas`.`data_nuo` DESC";
        db.rs = db.st.executeQuery(query);
        int k = 0;
        while(db.rs.next()){
            Gydymas gyd = new Gydymas();
            gyd.setPav(db.rs.getString("pavadinimas"));
            gyd.setOperacinis_aprasymas(db.rs.getString("operacinis_aprasymas"));
            gyd.setSarginis_l_m(db.rs.getBoolean("sarginis_l_m"));
            gyd.setL_m_gr_paz(db.rs.getString("l_m_gr_paz"));
            gyd.setL_m_gr_nepaz(db.rs.getString("l_m_gr_nepaz"));
            gyd.setL_m_gr_paz_teig(db.rs.getString("l_m_paz_teig"));
            gyd.setL_m_gr_nepaz_teig(db.rs.getString(7));
            gyd.setLimfo(db.rs.getBoolean("limfanodektomija"));
            gyd.setLimfo_gr_paz(db.rs.getString("limfo_gr_paz"));
            gyd.setLimfo_gr_nepaz(db.rs.getString("limfo_gr_nepaz"));
            gyd.setLimfo_gr_paz_teig(db.rs.getString("limfo_gr_paz_teig"));
            gyd.setLimfo_gr_nepaz_teig(db.rs.getString("limfo_gr_nepaz_teig"));
            gyd.setTipas(db.rs.getString("tipas"));
            gyd.setAprasymas(db.rs.getString("aprasymas"));
            gyd.setAr_taikyta_limf(db.rs.getBoolean("ar_taikyta_limf"));
            gyd.setSumine_doze(db.rs.getInt("sumine_doze"));
            gyd.setFrakcijos(db.rs.getInt("frakcijos"));
            gyd.setCetuksimabas(db.rs.getBoolean("cetuksimabas"));
            gyd.setCisplatina(db.rs.getBoolean("cisplatina"));
            gyd.setDocetakselis(db.rs.getBoolean("docetakselis"));
            gyd.setPaklitakselis(db.rs.getBoolean("paklitakselis"));
            gyd.setFu_5(db.rs.getBoolean("5_fu"));
            gyd.setKiti_vaistai(db.rs.getString("kiti_vaistai"));
            gyd.setKursu_kiekis(db.rs.getInt("kursu_skaicius"));
            gyd.setKiekis(db.rs.getInt("kiekis"));
            gyd.setData_nuo(db.rs.getString("data_nuo"));
            gyd.setData_iki(db.rs.getString("data_iki"));
            gyd.setAsmens_kodas(db.rs.getString("asmens_kodas"));
            gyd.setGydymas_baigtas(db.rs.getBoolean("gydymas_baigtas"));
            gydymai[k] = gyd;
            k++;
        }
        return gydymai;
    }
    public void deleteGydymas(String asmens_kodas, String pav, String data) throws SQLException {
        String query = "DELETE FROM `gydymas` WHERE `gydymas`.`asmens_kodas` = '"+ asmens_kodas+"' AND `gydymas`.`pavadinimas` = '"+pav+"' AND `gydymas`.`data_nuo` = '" + data+"'";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
    }
    /** Patikrina ar yra tokiu numeriu vezys*/
    public int checkGydymas(String asmens_kodas, String pav, String data) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) AS `kiekis` FROM `gydymas`  WHERE `gydymas`.`asmens_kodas` = '"+ asmens_kodas+"' AND `gydymas`.`pavadinimas` = '"+pav+"' AND `gydymas`.`data_nuo` = '" + data+"'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    public String getGydymasPav() throws SQLException {
        String kod = new String();
        String query = "SELECT `gydymas` FROM `paieska` " +
                " WHERE `paieska`.`id` = '1'" ;
        db.rs = db.st.executeQuery(query);
        while(db.rs.next()) {
            kod = db.rs.getString("gydymas");
        }
        return kod;
    }
    public void setGydymasPav(String pav) throws SQLException {
        String query = " UPDATE `paieska` SET `gydymas`='"+pav+"' WHERE `id`='1' ";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();

    }
    
}
