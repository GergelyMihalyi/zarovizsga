package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogsByCountry = findDogsByCountry(country);
        return dogsByCountry;
    }

    public List<String> findDogsByCountry(String country) {
        String upperCaseCountry = country.toUpperCase();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select LOWER(name) from dog_types where country = ?");
        ) {
            ps.setString(1, upperCaseCountry);
            return selectDogsByPreparedStatement(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<String> selectDogsByPreparedStatement(PreparedStatement ps) {
        List<String> dogsByCountry = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("LOWER(name)");
                dogsByCountry.add(name);
            }
            return dogsByCountry;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

}
