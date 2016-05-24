package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** KOMPLIKACIJAS APIBUDINANTI KLASE;
 * Created by Dovile on 2016-04-30.
 */
public class Komplikacijos {
    DBConnect db = new DBConnect();
    public Komplikacijos(){};

    /** Klases laukai:*/
    private String kokios;
    private String kokios_kita;
    private String data;
    private String asmens_kodas;
    /**Lauku metodai:*/
    public String getKokios(){return kokios;}
    public void setKokios(String kokios) {this.kokios = kokios;}
    public String getKokios_kita(){return kokios_kita;}
    public void setKokios_kita(String kokios_kita){this.kokios_kita = kokios_kita;}
    public String getData(){return data;}
    public void setData(String data){this.data = data;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}

    /** Informacijos paemimas ir idejimas i DB:*/
    /** Paema gretutiniu ligu masyva is DB;*/
    public Komplikacijos[] getKomplikacijos(String asm_kodas) throws SQLException {
        String query = "SELECT * `komplikacijos` " +
                "WHERE `komplikacijos`.`asmens_kodas` = " + asm_kodas+
                "ORDER BY `komplikacijos`.`data` ASC";
        db.rs = db.st.executeQuery(query);
        Komplikacijos komplikacijos[] = new Komplikacijos[getCount(asm_kodas)];
        int k = 0;
        while(db.rs.next()) {
            Komplikacijos kom = new Komplikacijos();
            kom.setKokios(db.rs.getString("kokios"));
            kom.setKokios_kita(db.rs.getString("kokios_kita"));
            kom.setData(db.rs.getString("rodiklis_kita"));
            kom.setAsmens_kodas(db.rs.getString("paciento_asmens_kodas"));
            komplikacijos[k] = kom;
            k++;
        }
        return komplikacijos;
    }

    /** Ideda gretutine liga i DB;*/
    public void setLiga(Komplikacijos kom) throws SQLException {
        String query = " INSERT INTO `komplikacijos`" +
                "VALUES(?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1,kom.getKokios());
        smt.setString(2,kom.getKokios_kita());
        smt.setString(3,kom.getData());
        smt.setString(4,kom.getAsmens_kodas());
        smt.execute();
    }
    /** Suranda gretutiniu ligu vieno paciento kieki ir ji grazina;*/
    public int getCount(String asmens_kodas) throws SQLException {
        String query = "SELECT COUNT(`kokios`) as `kiekis` " +
                "FROM `komplikacijos " +
                "WHERE `komplikacijos`.`asmens_kodas` = " +asmens_kodas;
        db.rs = db.st.executeQuery(query);
        int kiekis = db.rs.getInt("kiekis");

        return kiekis;
    }
}
