package org.acme.Repository.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;

@ApplicationScoped
public class RepositoryLoginEmpresa {
    @Inject
    DataSource dataSource;
}
