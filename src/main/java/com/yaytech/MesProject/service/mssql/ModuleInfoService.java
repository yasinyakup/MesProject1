package com.yaytech.MesProject.service.mssql;

import com.yaytech.MesProject.model.postgres.ModuleInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface ModuleInfoService {
    public List<ModuleInfo> getAll();

    public List<ModuleInfo> getOneDayData();

    public List<ModuleInfo> getFromFunc();
}
