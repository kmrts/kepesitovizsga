package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JurassicPark {
    /*
    hozd létre a JurassicPark osztályt, ami konstruktor paraméterben kapja meg az adatbáziseléréshez
     szükséges DataSource példányt.
Az osztályban egyetlen publikus metódus van, checkOverpopulation néven, ami térjen vissza
azoknak a fajtáknak a nevével, amiknél a valós létszám magasabb,
mint az elvárt (a fenti példában a Maiasaurus, a Velociraptor és a Hypsilophodontida), ABC szerint növekvő sorrendben.

Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.
     */
    DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from dinosaur")
        ) {
            return getNames(rs);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot find", se);
        }
    }

    private List<String> getNames(ResultSet rs) throws SQLException {
        List<String> names = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("breed");
            int expected = rs.getInt("expected");
            int actual = rs.getInt("actual");

            if (actual > expected) {
                names.add(name);
            }
        }
        Collections.sort(names);
        return names;
    }
}
