package paciento_info;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** MDK APIBREZIANTI KLASE;
 * Created by Dovile on 2016-04-28.
 */
public class MDK {

    DBConnect db = new DBConnect();

    public MDK() {}

    // MDK laikai:
    private String isvados;
    private String data;
    private String asmens_kodas;
    private String data_nuo;
    private String data_iki;

    // Metodai laukams:
    public String getIsvados(){return isvados;}
    public void setIsvados(String isvados){this.isvados = isvados;}
    public String getData(){return data;}
    public void setData(String data) {this.data = data;}
    public String getAsmens_kodas(){return asmens_kodas;}
    public void setAsmens_kodas(String asmens_kodas){this.asmens_kodas = asmens_kodas;}
    public String getData_nuo(){return data_nuo;}
    public void setData_nuo(String data) { data_nuo = data;}
    public String getData_iki(){return data_iki;}
    public void setData_iki(String data) {data_iki = data;}

    // Paemimas info is DB ir idejimas i DB:
    public MDK getMDK(String asm_kodas, String data) throws SQLException {
        String query = "SELECT * `mdk` WHERE `mdk`.`asmens_kodas` = '" + asm_kodas +"' AND `mdk`.`data` = '" + data + "'";
        db.rs = db.st.executeQuery(query);
        MDK mdk = new MDK();
        mdk.setIsvados(db.rs.getString("isvados"));
        mdk.setData(db.rs.getString("data"));
        mdk.setAsmens_kodas(db.rs.getString("asmens_kodas"));
        mdk.setData_nuo(db.rs.getString("data_nuo"));
        mdk.setData_iki(db.rs.getString("data_iki"));

        return mdk;
    }
    public void setMDK(MDK mdk) throws SQLException {
        String query = " INSERT INTO `mdk`"+"VALUES(?,?,?,?,?)";
        PreparedStatement smt = db.con.prepareStatement(query);
        smt.setString(1,mdk.getIsvados());
        smt.setString(2,mdk.getData());
        smt.setString(3,mdk.getAsmens_kodas());
        smt.setString(4,mdk.getData_nuo());
        smt.setString(5,mdk.getData_iki());

        smt.execute();
    }


}
