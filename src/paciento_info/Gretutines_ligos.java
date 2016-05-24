package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** GRETUTINES LIGAS APIBUDINANTI KLASE;
 * Created by Dovile on 2016-04-28.
 */
public class Gretutines_ligos {
    DBConnect db = new DBConnect();
    public Gretutines_ligos(){}

    /**Klases laukai:*/
    private String pav;
    private String rodiklis;
    private String rodiklis_kita;
    private String asmens_kodas;

    /** Lauku metodai:*/
    public String getPav(){return pav;}
    public void setPav(String pav){this.pav = pav;}
    public String getRodiklis(){return rodiklis;}
    public void setRodiklis(String rodiklis){this.rodiklis = rodiklis;}
    public String getRodiklis_kita(){return rodiklis_kita;}
    public void setRodiklis_kita(String rodiklis_kita){this.rodiklis_kita = rodiklis_kita;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}

    /** Informacijos paemimas ir idejimas i DB:*/
    /** Paema gretutiniu ligu masyva is DB;*/
    public Gretutines_ligos[] getLigos(String asm_kodas) throws SQLException {
        String query = "SELECT * FROM `gretutines_ligos` WHERE `gretutines`.`asmens_kodas` = '" + asm_kodas + "'";
        db.rs = db.st.executeQuery(query);
        Gretutines_ligos ligos[] = new Gretutines_ligos[getCount(asm_kodas)];
        int k = 0;
        while(db.rs.next()) {
            Gretutines_ligos liga = new Gretutines_ligos();
            liga.setPav(db.rs.getString("pavadinimas"));
            liga.setRodiklis(db.rs.getString("rodiklis"));
            liga.setRodiklis_kita(db.rs.getString("rodiklis_kita"));
            liga.setAsmens_kodas(db.rs.getString("paciento_asmens_kodas"));
            ligos[k] = liga;
            k++;
        }
        return ligos;
    }

    /** Ideda gretutine liga i DB;*/
    public void setLiga(Gretutines_ligos liga) throws SQLException {
        String query = " INSERT INTO `gretutines_ligos`" +
                "VALUES(?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1,liga.getPav());
        smt.setString(2,liga.getRodiklis());
        smt.setString(3,liga.getRodiklis_kita());
        smt.setString(4,liga.getAsmens_kodas());
        smt.execute();
    }

    /** Suranda gretutiniu ligu vieno paciento kieki ir ji grazina;*/
    public int getCount(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`pavadinimas`) as `kiekis` " +
                "FROM `gretutines_ligos` " +
                "WHERE `gretutines_ligos`.`asmens_kodas` ="+ asmens_kodas;
        db.rs = db.st.executeQuery(query);
        int kiekis = db.rs.getInt("kiekis");

        return kiekis;
    }


}
