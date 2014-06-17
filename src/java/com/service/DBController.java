package com.service;

import com.beans.Immagine;
import com.beans.WebAdmin;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author Podgoreanu Alexandru
 */
@Service
@Scope(value = "singleton")
public final class DBController {

    //jdbc:mysql://localhost:3306/dbname
    private final Log log = LogFactory.getLog(DBController.class);
    ;
    private static final String dBurl = "jdbc:mysql://95.110.171.18:3306/dbinstance_835_1";
    private static final String dBuser = "649_835";
    private static final String dBpwd = "p.al5388";
    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;
    private static DBController instance;

    private DBController() {
        try {
            registerDB();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static synchronized DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public void registerDB() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void unregisterDB() throws SQLException {
        try {
            DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /* connect - Attempts to establish a connection to the given database URL.
     * The <code>DriverManager</code> attempts to select an appropriate driver from
     * the set of registered JDBC drivers.
     */

    private void connect() throws SQLException {
        try {
            //Richiedo la apertura di connessione al DB
            conn = DriverManager.getConnection(dBurl, dBuser, dBpwd);
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Conected to:" + dBurl);
    }

    private void disconnect() throws SQLException {
        st.close();
        conn.close();
        /*
         * A ResultSet rs is automaticaly closed when its statement is closed
         */
        //rs.close();
        System.out.println("Disconected from " + dBurl);
    }

    public void createTables() throws SQLException {
        connect();
        DatabaseMetaData md = conn.getMetaData();
        String createContatto = "CREATE TABLE CONTATTO"
                + "("
                + "ID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "NOME VARCHAR (128) NOT NULL,"
                + "TELEFONO VARCHAR (20),"
                + "EMAIL VARCHAR (128) NOT NULL,"
                + "MESSAGGIO VARCHAR (2048) NOT NULL"
                + ")";
        String createImmagine = "CREATE TABLE IMMAGINE"
                + "("
                + "ID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "NOME VARCHAR (512) NOT NULL,"
                + "DATA_CARICAMENTO TIMESTAMP NOT NULL,"
                + "SIZE VARCHAR(64) NOT NULL,"
                + "DESCRIZIONE VARCHAR (1024),"
                + "NUM_VIS INTEGER"
                + ")";
        String createNotiziaImmagine = "CREATE TABLE NOTIZIA_IMMAGINI"
                + "("
                + "ID_NOTIZIA INTEGER,"
                + "ID_IMMAGINE INTEGER,"
                + "PRIMARY KEY(ID_NOTIZIA, ID_IMMAGINE),"
                + "FOREIGN KEY(ID_NOTIZIA) REFERENCES NOTIZIA(ID),"
                + "FOREIGN KEY(ID_IMMAGINE) REFERENCES IMMAGINE(ID)"
                + ")";
        String createNotizia = "CREATE TABLE NOTIZIA"
                + "("
                + "ID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + "NOME VARCHAR (128) NOT NULL,"
                + "ARTICOLO VARCHAR (20000) NOT NULL,"
                + "TIPO VARCHAR (128) NOT NULL,"
                + "PRIORITA INTEGER NOT NULL,"
                + "DATA_CARICAMENTO TIMESTAMP NOT NULL,"
                + "NUM_VIS INTEGER"
                + ")";
        String createWebAdmin = "CREATE TABLE WEB_ADMIN"
                + "("
                + "LOGIN VARCHAR (32) PRIMARY KEY,"
                + "NOME VARCHAR (64) NOT NULL,"
                + "PASSWORD VARCHAR (32) NOT NULL,"
                + "LASTLOGIN TIMESTAMP NOT NULL"
                + ")";
        try {

            if (isTableExist("Contatto")) {
                st.execute("DROP TABLE Contatto");
                System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Tabella SessioneLavoro eliminata!");
            }
            if (isTableExist("NOTIZIA_IMMAGINI")) {
                st.execute("DROP TABLE NOTIZIA_IMMAGINI");
                System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Tabella SessioneLavoro eliminata!");
            }
            if (isTableExist("IMMAGINE")) {
                st.execute("DROP TABLE IMMAGINE");
                System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Tabella SessioneLavoro eliminata!");
            }
            if (isTableExist("NOTIZIA")) {
                st.execute("DROP TABLE NOTIZIA");
                System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Tabella SessioneLavoro eliminata!");
            }
            if (isTableExist("WEB_ADMIN")) {
                st.execute("DROP TABLE WEB_ADMIN");
                System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Tabella SessioneLavoro eliminata!");
            }

            st.executeUpdate(createContatto);
            System.out.println("Tabela Contatto creata");

            st.executeUpdate(createImmagine);
            System.out.println("Tabela IMMAGINE creata");

            st.executeUpdate(createNotizia);
            System.out.println("Tabela NOTIZIA creata");

            st.executeUpdate(createNotiziaImmagine);
            System.out.println("Tabela NOTIZIA_IMMAGINI creata");

            st.executeUpdate(createWebAdmin);
            System.out.println("Tabela WEB_ADMIN creata");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect();
        }

    }

    public boolean execute(Immagine img) throws SQLException {
        connect();
        String query = "";
        return false;
    }

    public boolean execute(String querry) throws SQLException {
        connect();
        System.out.println("Querry");
        int result = 0;
        try {
            result = st.executeUpdate(querry);
            System.out.println("Querry executed: " + querry);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect();
        }
        return result == 1;
    }

    public int executeUpdateAndReturnKey(String querry) throws SQLException {
        connect();
        int result = -1;
        try {
            st.executeUpdate(querry, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Query: " + querry + " - eseguita correttamente!");
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            log.fatal(this.getClass() + ":" + e.getMessage());
        } finally {
            disconnect();
        }
        return result;
    }

    public QueryResult executeQuery(String querry) throws SQLException {
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> riga = null;

        connect();
        try {
            rs = st.executeQuery(querry);
            ResultSetMetaData metaData = rs.getMetaData();
            Integer mt = metaData.getColumnCount();
            while (rs.next()) {
                riga = new HashMap<>();
                for (int i = 1; i <= mt; i++) {
                    riga.put(metaData.getColumnName(i).toLowerCase(), rs.getObject(i));
                }
                resultList.add(riga);
            }
        } catch (SQLException e) {
            log.fatal(this.getClass() + ":" + e.getMessage());
        } finally {
            disconnect();
        }
        System.out.println("INFO SERVICE:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Success");
        return new QueryResult(resultList);
    }

    public boolean verificaUtente(WebAdmin webAdmin) throws SQLException {
        connect();
        boolean result = false;
        String querry = "SELECT * FROM WEB_ADMIN";
        try {
            rs = st.executeQuery(querry);
            while (rs.next()) {
                if (rs.getString("login").equalsIgnoreCase(webAdmin.getLogin()) && rs.getString("password").equals(webAdmin.getPassword())) {
                    webAdmin.setNome(rs.getString("nome"));
                    result = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect();
        }
        return result;
    }

    private boolean isTableExist(String sTablename) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        rs = dbmd.getTables(null, null, sTablename.toUpperCase(), null);
        if (rs.next()) {
            System.out.println("INFO:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " Table " + rs.getString("TABLE_NAME") + "already exists !!");
            return true;
        } else {
            System.out.println("INFO:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " creating table: " + sTablename);
            return false;
        }
    }

}
