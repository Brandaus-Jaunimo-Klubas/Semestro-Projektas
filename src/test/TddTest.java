package test;

import org.junit.Test;
import paciento_info.Apziura;
import paciento_info.Gydymas;
import paciento_info.Pacientas;
import paciento_info.Vezys;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/** Automatinių testų klasė
 * Created by Dovile on 2016-05-22.
 */
public class TddTest {
    /** Paciento kalsės testai.*/

    @Test
    public void testInsertAndSelectPacientas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220552";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Pacientas pac1 = new Pacientas();
        pac1.getPacientas(asmens_kodas);
        assertEquals(vardas, pac1.getVardas());
    }

    @Test
    public void testUpdatePacientas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas1";
        String pavarde = "Pavarde1";
        String asmens_kodas = "49504220552";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.updatePacientas(asmens_kodas);
        Pacientas pac1 = new Pacientas();
        pac1.getPacientas(asmens_kodas);
        assertEquals(vardas, pac1.getVardas());
    }
    @Test
    public void testPaieskaPacientas() throws SQLException {
        Pacientas pac = new Pacientas();
        String asmens_kodas = "49504220552";
        pac.setPaieskaKodas(asmens_kodas);
        Pacientas pac1 = new Pacientas();
        assertEquals(asmens_kodas,pac1.getPaieskaKodas());
    }
    @Test
    public void testDeleteAndCountPacientas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220553";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        pac.deletePacientas(asmens_kodas);
        assertEquals(0, pac.arPacientas_yra_DB(asmens_kodas));
    }

    /** Vėžio klasės testai*/

    @Test
    public void testInsertAndSelectVezys() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220554";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Vezys vez = new Vezys();
        String numeris = "1";
        vez.setNr(numeris);
        vez.setAsmens_kodas(asmens_kodas);
        vez.setVezys();
        Vezys vez1 = new Vezys();
        Vezys vezi[] = vez1.getVezys(asmens_kodas);
        assertEquals(numeris, vezi[0].getNr());
    }


    @Test
    public void testCountVezys() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220555";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Vezys vez = new Vezys();
        String numeris = "1";
        vez.setNr(numeris);
        vez.setAsmens_kodas(asmens_kodas);
        vez.setVezys();
        assertEquals(1,vez.getCount(asmens_kodas));
    }

    @Test
    public void testDeleteAndCountVezys() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220556";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Vezys vez = new Vezys();
        String numeris = "1";
        vez.setNr(numeris);
        vez.setAsmens_kodas(asmens_kodas);
        vez.setVezys();
        vez.deleteVezys(asmens_kodas, numeris);
        assertEquals(0, vez.getCount(asmens_kodas));
    }
    @Test
    public void testCheckVezys() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220557";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Vezys vez = new Vezys();
        String numeris = "1";
        vez.setNr(numeris);
        vez.setAsmens_kodas(asmens_kodas);
        vez.setVezys();
        assertEquals(1, vez.checkVezys(asmens_kodas,numeris));
    }

    /** Gydymo klasės testai*/
    @Test
    public void testInsertAndSelectGydymas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220561";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Gydymas gyd = new Gydymas();
        String pav = "Chirurginis";
        gyd.setPav(pav);
        gyd.setAsmens_kodas(asmens_kodas);
        gyd.setGydymas();
        Gydymas gyd1 = new Gydymas();
        Gydymas gydi[] = gyd1.getGydymas(asmens_kodas);
        assertEquals(pav, gydi[0].getPav());
    }


    @Test
    public void testCountGydymas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220562";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Gydymas gyd = new Gydymas();
        String pav = "Chirurginis";
        gyd.setPav(pav);
        gyd.setAsmens_kodas(asmens_kodas);
        gyd.setGydymas();
        assertEquals(1,gyd.getCount(asmens_kodas));
    }

    @Test
    public void testDeleteAndCountGydymas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220563";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Gydymas gyd = new Gydymas();
        String pav = "Chirurginis";
        String data = "2016-05-22";
        gyd.setPav(pav);
        gyd.setData_nuo(data);
        gyd.setAsmens_kodas(asmens_kodas);
        gyd.setGydymas();
        gyd.deleteGydymas(asmens_kodas, pav, data);
        assertEquals(0, gyd.getCount(asmens_kodas));
    }
    @Test
    public void testCheckGydymas() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220564";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Gydymas gyd = new Gydymas();
        String pav = "Chirurginis";
        String data = "2016-05-22";
        gyd.setPav(pav);
        gyd.setData_nuo(data);
        gyd.setAsmens_kodas(asmens_kodas);
        gyd.setGydymas();
        assertEquals(1, gyd.checkGydymas(asmens_kodas,pav, data));
    }

    /** Apžiūros klasės testai*/
    @Test
    public void testInsertAndSelectApziura() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220571";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Apziura apz = new Apziura();
        String pav = "VLS";
        apz.setPav(pav);
        apz.setAsmens_kodas(asmens_kodas);
        apz.setApziura();
        Apziura apz1 = new Apziura();
        Apziura apzi[] = apz1.getApziura(asmens_kodas);
        assertEquals(pav, apzi[0].getPav());
    }


    @Test
    public void testCountAzpiura() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220572";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Apziura apz = new Apziura();
        String pav = "VLS";
        apz.setPav(pav);
        apz.setAsmens_kodas(asmens_kodas);
        apz.setApziura();
        Apziura apz1 = new Apziura();
        String pav1 = "VLS";
        apz1.setPav(pav);
        apz1.setAsmens_kodas(asmens_kodas);
        apz1.setApziura();
        assertEquals(2,apz1.getCount(asmens_kodas));
    }

    @Test
    public void testDeleteAndCountApziura() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220573";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Apziura apz = new Apziura();
        String pav = "VLS";
        String data = "2016-05-22";
        apz.setPav(pav);
        apz.setData(data);
        apz.setAsmens_kodas(asmens_kodas);
        apz.setApziura();
        apz.deleteApziura(asmens_kodas, pav, data);
        assertEquals(0, apz.getCount(asmens_kodas));
    }
    @Test
    public void testCheckApziura() throws SQLException {
        Pacientas pac = new Pacientas();
        String vardas = "Vardas";
        String pavarde = "Pavarde";
        String asmens_kodas = "49504220574";
        pac.setVardas(vardas);
        pac.setPavarde(pavarde);
        pac.setAsmens_kodas(asmens_kodas);
        pac.setPacientas();
        Apziura apz = new Apziura();
        String pav = "VLS";
        String data = "2016-05-22";
        apz.setPav(pav);
        apz.setData(data);
        apz.setAsmens_kodas(asmens_kodas);
        apz.setApziura();
        assertEquals(1, apz.checkApziura(asmens_kodas,pav, data));
    }




}
