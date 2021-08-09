package com.yaytech.MesProject.repo.mssql;

import com.yaytech.MesProject.model.mssql.ModuleInfoNum1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleInfoNUmRepo1 extends JpaRepository<ModuleInfoNum1, Long> {
}
