package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryOrganization {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  NamedParameterJdbcTemplate template;

  public List<Map<String, Object>> getOrganizations() {
    String selectSql = "SELECT * FROM organizations";
    List<Map<String, Object>> organizations = jdbcTemplate.queryForList(selectSql);
    return organizations;
  }

  public List<Map<String, Object>> getOrganizationById(int id) {
    String selectSql = "SELECT * FROM organizations WHERE id ="+id;
    List<Map<String, Object>> organizations = jdbcTemplate.queryForList(selectSql);
    return organizations;
  }

  public void insertOrganization(Organization org) {
    String sql = "insert into organizations(id, name, description) values(:id , :name , :description)";
    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", org.getId())
        .addValue("name", org.getName())
        .addValue("description", org.getDescription());
    template.update(sql,param, holder);
  }

  public void updateOrganization (Organization org) {
    final String sql = "update organizations set name=:name, description=:description where id=:id";
    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", org.getId())
        .addValue("name", org.getName())
        .addValue("description", org.getDescription());
    template.update(sql,param, holder);
  }

  public void deleteOrganization (int id) {
    String sql = "delete from organizations where id = "+id;
    jdbcTemplate.execute(sql);
}
}