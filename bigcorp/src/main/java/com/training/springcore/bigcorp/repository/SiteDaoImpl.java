package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Site;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SiteDaoImpl implements SiteDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    public SiteDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static String SELECT_WITH_JOIN =
            "SELECT c.id, c.name, c.site_id, s.name as site_name " +
                    "FROM Captor c inner join Site s on c.site_id = s.id ";

    @Override
    public void create(Site element) {
        jdbcTemplate.update("insert into SITE (id, name) values (:id, :name)",
                new MapSqlParameterSource()
                        .addValue("id", element.getId())
                        .addValue("name", element.getName()));
    }



    @Override
    public Site findById(String s) {
        try{
            return jdbcTemplate.queryForObject("select id, name from SITE where id = :id ",
                    new MapSqlParameterSource("id", s),
                    this::siteMapper);
        }catch (EmptyResultDataAccessException e) {return null;}
    }



    @Override
    public List<Site> findAll() {
        {
            return jdbcTemplate.query("select id, name from SITE", this::siteMapper);
        }
    }

    @Override
    public void update(Site element) {
        jdbcTemplate.update("update SITE set name = :name where id =:id",
                new MapSqlParameterSource()
                        .addValue("id", element.getId())
                        .addValue("name", element.getName()));

    }

    @Override
    public void deleteById(String s) {
        jdbcTemplate.update("delete from SITE where id = :id" ,
                new MapSqlParameterSource("id" , s)) ;

    }

    private Site siteMapper(ResultSet rs, int rowNum) throws SQLException, SQLException {
        Site site = new Site(rs.getString("name"));
        site.setId(rs.getString("id"));
        return site;
    }

}
