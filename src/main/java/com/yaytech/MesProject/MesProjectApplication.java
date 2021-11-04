package com.yaytech.MesProject;

import com.yaytech.MesProject.model.mssql.ModuleInfoNum;
import com.yaytech.MesProject.model.mssql.ModuleInfoNum1;
import com.yaytech.MesProject.model.postgres.ModuleInfo;
import com.yaytech.MesProject.repo.mssql.ModuleInfoNUmRepo;
import com.yaytech.MesProject.service.mssql.ModuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class MesProjectApplication implements CommandLineRunner {

	@Autowired
	ModuleInfoService moduleInfoService;


	@Autowired
	ModuleInfoNUmRepo moduleInfoNUmRepo;


	public static void main(String[] args) {
		SpringApplication.run(MesProjectApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		List<ModuleInfo> m1 = moduleInfoService.getAll();
		List<ModuleInfoNum> m2 = m1.stream().map(ModuleInfo::convertToNumeric).collect(Collectors.toList());
		//m2.forEach(System.out::println);
		moduleInfoNUmRepo.saveAll(m2);
		System.out.println("Mission Completed");
	}
}
