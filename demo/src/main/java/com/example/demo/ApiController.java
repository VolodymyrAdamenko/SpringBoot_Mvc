package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @Autowired
      RepositoryOrganization repoOrganization;

  @GetMapping(value = "get/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Map<String, Object>> getOrganizations() {
    return repoOrganization.getOrganizations();
  }

  @GetMapping(value = "get/organization/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Map<String, Object>> getOrganizationById(@PathVariable("id") int id) {
    return repoOrganization.getOrganizationById(id);
  }

  @PutMapping(value = "put/organization", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateOrganization(@RequestBody Organization org) {
    repoOrganization.updateOrganization(org);
  }

  @PostMapping(value = "post/organization", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void insertOrganization(@RequestBody Organization org) {
    repoOrganization.insertOrganization(org);
  }

  @DeleteMapping(value = "delete/organization/{id}")
  public void deleteOrganization(@PathVariable("id") int id) {
    repoOrganization.deleteOrganization(id);
  }

}
