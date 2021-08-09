package com.yaytech.MesProject.repo.mssql;

import com.yaytech.MesProject.model.mssql.ModuleInfoNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleInfoNUmRepo extends JpaRepository<ModuleInfoNum, Long> {
}
