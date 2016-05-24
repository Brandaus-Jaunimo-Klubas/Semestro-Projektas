package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/* APZIURA APIBREZIANTI KLASE;
 * Created by Dovile on 2016-04-28.
 */
public class Apziura {
     DBConnect db = new DBConnect();

    /** Apziuros laukai:*/
    private String pav;
    private String pav_kita;
    private String rez;
    private String pazeidimo_puse;
    private String pazeidimo_lokolizacija;
    private String pazeidimas_apima;
    private boolean balso_klosciu_judrumas;
    private boolean ketaroze;
    private boolean randas;
    private boolean egzofitiniai_pozymiai_yra;
    private String egzofitiniai_pozymiai_kokie;
    private boolean stenoze_yra;
    private String stenoze_laipsnis;
    private String kita;
    private boolean duomenys_atitinka_kt;
    private String jei_duomenys_neatitinka_kt;
    private boolean kaklo_limf_kt;
    private String jei_limf_stebimi;
    private String data;
    private String asmens_kodas;

    public Apziura(){
        this.pav = null;
        this.pav_kita = null;
        this.rez = null;
        this.pazeidimo_puse = null;
        this.pazeidimo_lokolizacija = null;
        this.pazeidimas_apima = null;
        this.balso_klosciu_judrumas = false;
        this.ketaroze = false;
        this.randas = false;
        this.egzofitiniai_pozymiai_yra = false;
        this.egzofitiniai_pozymiai_kokie = null;
        this.stenoze_yra = false;
        this.stenoze_laipsnis = null;
        this.kita = null;
        this.duomenys_atitinka_kt = false;
        this.jei_duomenys_neatitinka_kt = null;
        this.kaklo_limf_kt = false;
        this.jei_limf_stebimi = null;
        this.data = null;
        this.asmens_kodas = null;
    }
    /** Metodai laukams:*/
    public String getPav(){return pav;}
    public void setPav(String pav){this.pav = pav;}
    public String getPav_kita(){return pav_kita;}
    public void setPav_kita(String pav_kita){this.pav_kita = pav_kita;}
    public String getRez(){return rez;}
    public void setRez(String rez){this.rez = rez;}
    public String getPazeidimo_puse() {return pazeidimo_puse;}
    public void setPazeidimo_puse(String pazeidimo_puse) { this.pazeidimo_puse = pazeidimo_puse;}
    public String getPazeidimo_lokolizacija(){return pazeidimo_lokolizacija;}
    public void setPazeidimo_lokolizacija(String pazeidimo_lokolizacija) {this.pazeidimo_lokolizacija = pazeidimo_lokolizacija;}
    public String getPazeidimas_apima(){return pazeidimas_apima;}
    public void setPazeidimas_apima(String pazeidimas_apima) {this.pazeidimas_apima = pazeidimas_apima;}
    public boolean isBalso_klosciu_judrumas() {return balso_klosciu_judrumas;}
    public void setBalso_klosciu_judrumas(boolean balso_klosciu_judrumas) {this.balso_klosciu_judrumas = balso_klosciu_judrumas;}
    public boolean isKetaroze() {return ketaroze;}
    public void setKetaroze(boolean ketaroze){this.ketaroze = ketaroze;}
    public boolean isRandas() {return randas;}
    public void setRandas(boolean randas) {this.randas = randas;}
    public boolean isEgzofitiniai_pozymiai_yra(){return egzofitiniai_pozymiai_yra;}
    public void setEgzofitiniai_pozymiai_yra(boolean egzofitiniai_pozymiai_yra){this.egzofitiniai_pozymiai_yra = egzofitiniai_pozymiai_yra;}
    public String getEgzofitiniai_pozymiai_kokie(){return egzofitiniai_pozymiai_kokie;}
    public void setEgzofitiniai_pozymiai_kokie(String egzofitiniai_pozymiai_kokie){this.egzofitiniai_pozymiai_kokie = egzofitiniai_pozymiai_kokie;}
    public boolean isStenoze_yra(){return stenoze_yra;}
    public void setStenoze_yra(boolean stenoze_yra) {this.stenoze_yra = stenoze_yra;}
    public String getStenoze_laipsnis(){return stenoze_laipsnis;}
    public void setStenoze_laipsnis(String stenoze_laipsnis){this.stenoze_laipsnis = stenoze_laipsnis;}
    public String getKita(){return kita;}
    public void setKita(String kita){this.kita = kita;}
    public boolean isDuomenys_atitinka_kt(){return duomenys_atitinka_kt;}
    public void setDuomenys_atitinka_kt(boolean duomenys_atitinka_kt) {this.duomenys_atitinka_kt = duomenys_atitinka_kt;}
    public String getJei_duomenys_neatitinka_kt(){return jei_duomenys_neatitinka_kt;}
    public void setJei_duomenys_neatitinka_kt(String jei_duomenys_neatitinka_kt){this.jei_duomenys_neatitinka_kt = jei_duomenys_neatitinka_kt;}
    public boolean isKaklo_limf_kt(){return kaklo_limf_kt;}
    public void setKaklo_limf_kt(boolean kaklo_limf_kt){this.kaklo_limf_kt = kaklo_limf_kt;}
    public String getJei_limf_stebimi(){return jei_limf_stebimi;}
    public void setJei_limf_stebimi(String jei_limf_stebimi){this.jei_limf_stebimi = jei_limf_stebimi;}
    public String getData(){return data;}
    public void setData(String data){this.data = data;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}

    /** Duomenu paemimas ir idejimas i DB:*/

    /** Duomenu isemimas is DB;*/
    public Apziura[] getApziura(String asm_kodas) throws SQLException {
        Apziura apziuros[] = new Apziura[getCount(asm_kodas)];
        String query = "SELECT * FROM `apziura` " +
                       " WHERE `apziura`.`asmens_kodas` = '" + asm_kodas + "'" +
                       " ORDER BY `apziura`.`data` DESC";
        db.rs = db.st.executeQuery(query);
        int k = 0;
        while(db.rs.next()){
            Apziura apz = new Apziura();
            apz.setPav(db.rs.getString("pavadinimas"));
            apz.setPav_kita(db.rs.getString("pav_kita"));
            apz.setRez(db.rs.getString("rezultatai"));
            apz.setPazeidimo_puse(db.rs.getString("pazeidimo_puse"));
            apz.setPazeidimo_lokolizacija(db.rs.getString("pazeidimo_lokalizacija"));
            apz.setPazeidimas_apima(db.rs.getString("pazeidimas_apima"));
            apz.setBalso_klosciu_judrumas(db.rs.getBoolean("balso_klosciu_judrumas"));
            apz.setKetaroze(db.rs.getBoolean("keratoze"));
            apz.setRandas(db.rs.getBoolean("randas"));
            apz.setEgzofitiniai_pozymiai_yra(db.rs.getBoolean("egzofitiniai_pozymiai_yra"));
            apz.setEgzofitiniai_pozymiai_kokie(db.rs.getString("egzo_pozymiai_kokie"));
            apz.setStenoze_yra(db.rs.getBoolean("stenoze_yra"));
            apz.setStenoze_laipsnis(db.rs.getString("stenoze_laipsnis"));
            apz.setKita(db.rs.getString("kita"));
            apz.setDuomenys_atitinka_kt(db.rs.getBoolean("duomenys_atitinka_kt"));
            apz.setJei_duomenys_neatitinka_kt(db.rs.getString("jei_neatitinka_duom_kt"));
            apz.setKaklo_limf_kt(db.rs.getBoolean("kaklo_limf_kt"));
            apz.setJei_limf_stebimi(db.rs.getString("jei_limf_stebimi"));
            apz.setData(db.rs.getString("data"));
            apz.setAsmens_kodas(db.rs.getString("asmens_kodas"));
            apziuros[k] = apz;
            k++;
        }

        return apziuros;
    }

    /** Duomenu idejimas i DB;*/
    public void setApziura() throws SQLException {
        String query = "INSERT INTO `apziura`" +
                       " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1,this.getPav());
        smt.setString(2,this.getPav_kita());
        smt.setString(3,this.getRez());
        smt.setString(4,this.getPazeidimo_puse());
        smt.setString(5,this.getPazeidimo_lokolizacija());
        smt.setString(6,this.getPazeidimas_apima());
        smt.setBoolean(7,this.isBalso_klosciu_judrumas());
        smt.setBoolean(8,this.isKetaroze());
        smt.setBoolean(9,this.isRandas());
        smt.setBoolean(10,this.isEgzofitiniai_pozymiai_yra());
        smt.setString(11,this.getEgzofitiniai_pozymiai_kokie());
        smt.setBoolean(12,this.isStenoze_yra());
        smt.setString(13,this.getStenoze_laipsnis());
        smt.setString(14,this.getKita());
        smt.setBoolean(15,this.isDuomenys_atitinka_kt());
        smt.setString(16,this.getJei_duomenys_neatitinka_kt());
        smt.setBoolean(17,this.isKaklo_limf_kt());
        smt.setString(18,this.getJei_limf_stebimi());
        smt.setString(19,this.getData());
        smt.setString(20,this.getAsmens_kodas());
        smt.execute();
    }

    /** Apziuru kiekio radimas;*/
    public int getCount(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                "FROM `apziura` " +
                "WHERE `apziura`.`asmens_kodas` = '" + asmens_kodas + "'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    public int getCoutDatos(String asmens_kodas, String data_nuo, String data_iki) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                " FROM `apziura` " +
                " WHERE `apziura`.`asmens_kodas` = '" + asmens_kodas + "' AND " +
                " `apziura`.`data` >= '" + data_nuo + "' AND" +
                " `apziura`.`data` <= '" + data_iki + "'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    /** Apziuru isemimas pagal datu intervala;*/
    public Apziura[] getPagalDatosApziura(String asm_kodas, String data_nuo, String data_iki ) throws SQLException {
        Apziura apziuros[] = new Apziura[getCoutDatos(asm_kodas, data_nuo, data_iki)];
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                "FROM `apziura` " +
                " WHERE `apziura`.`asmens_kodas` = '" + asmens_kodas + "' AND " +
                " `apziura`.`data` >= '" + data_nuo + "' AND" +
                " `apziura`.`data` <= '" + data_iki + "'";
        db.rs = db.st.executeQuery(query);
        int k = 0;
        while(db.rs.next()){
            Apziura apz = new Apziura();
            apz.setPav(db.rs.getString("pavadinimas"));
            apz.setPav_kita(db.rs.getString("pav_kita"));
            apz.setRez(db.rs.getString("rezultatai"));
            apz.setPazeidimo_puse(db.rs.getString("pazeidimo_puse"));
            apz.setPazeidimo_lokolizacija(db.rs.getString("pazeidimo_lokalizacija"));
            apz.setPazeidimas_apima(db.rs.getString("pazeidimas_apima"));
            apz.setBalso_klosciu_judrumas(db.rs.getBoolean("balso_klosciu_judrumas"));
            apz.setKetaroze(db.rs.getBoolean("ketaroze"));
            apz.setRandas(db.rs.getBoolean("randas"));
            apz.setEgzofitiniai_pozymiai_yra(db.rs.getBoolean("egzofitiniai_pozymiai_yra"));
            apz.setEgzofitiniai_pozymiai_kokie(db.rs.getString("egzofitiniai_pozymiai_kokie"));
            apz.setStenoze_yra(db.rs.getBoolean("stenoze_yra"));
            apz.setStenoze_laipsnis(db.rs.getString("stenoze_laipsnis"));
            apz.setKita(db.rs.getString("kita"));
            apz.setDuomenys_atitinka_kt(db.rs.getBoolean("duomenys_atitinka_kt"));
            apz.setJei_duomenys_neatitinka_kt(db.rs.getString("jei_neatitinka_duom_kt"));
            apz.setKaklo_limf_kt(db.rs.getBoolean("kaklo_limf_kt"));
            apz.setJei_limf_stebimi(db.rs.getString("jei_limf_stebimi"));
            apz.setData(db.rs.getString("data"));
            apz.setAsmens_kodas(db.rs.getString("asmens_kodas"));
            apziuros[k] = apz;
            k++;
        }
        return apziuros;
    }
    public void deleteApziura(String asmens_kodas, String pav, String data) throws SQLException {
        String query = "DELETE FROM `apziura` WHERE `apziura`.`asmens_kodas` = '"+ asmens_kodas+"' AND `apziura`.`pavadinimas` = '"+pav+"' AND `apziura`.`data` = '" + data+"'";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
    }
    /** Patikrina ar yra apziura*/
    public int checkApziura(String asmens_kodas, String pav, String data) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) AS `kiekis` FROM `apziura`  WHERE `apziura`.`asmens_kodas` = '"+ asmens_kodas+"' AND `apziura`.`pavadinimas` = '"+pav+"' AND `apziura`.`data` = '" + data+"'";
        db.rs = db.st.executeQuery(query);
        int kiekis;
        while(db.rs.next()) {
            kiekis = db.rs.getInt("kiekis");
            return kiekis;
        }
        return -1;
    }
    public String getApziuraPav() throws SQLException {
        String kod = new String();
        String query = "SELECT `apziura` FROM `paieska` " +
                " WHERE `paieska`.`id` = '1'" ;
        db.rs = db.st.executeQuery(query);
        while(db.rs.next()) {
            kod = db.rs.getString("apziura");
        }
        return kod;
    }
    public void setApziuraPav(String pav) throws SQLException {
        String query = " UPDATE `paieska` SET `apziura`='"+pav+"' WHERE `id`='1' ";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.execute();
    }

}
