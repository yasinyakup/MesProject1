package com.yaytech.MesProject.service.mssql.impl;

import com.yaytech.MesProject.model.postgres.ModuleInfo;
import com.yaytech.MesProject.repo.postgres.ModuleInfoRepo;
import com.yaytech.MesProject.service.mssql.ModuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleInfoServiceImpl implements ModuleInfoService {

    @Autowired
    ModuleInfoRepo moduleInfoRepo;

    @Override
    public List<ModuleInfo> getAll() {
       return moduleInfoRepo.getData();
    }

    @Override
    public List<ModuleInfo> getOneDayData() {
        return moduleInfoRepo.getOneDayData();
    }

    @Override
    public List<ModuleInfo> getFromFunc() {

        return moduleInfoRepo.getmainsearchtable("2021-05-01", "2021-05-02");
    }
}
