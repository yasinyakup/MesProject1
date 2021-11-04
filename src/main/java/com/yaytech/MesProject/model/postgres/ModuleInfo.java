package com.yaytech.MesProject.model.postgres;


import com.yaytech.MesProject.model.mssql.ModuleInfoNum;
import com.yaytech.MesProject.model.mssql.ModuleInfoNum1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModuleInfo {
   @Id
   private long rn;
   private String ctm1;
   private String current_grade;
   private String el_name;
   private String cyj;
   private String m_line;
   private String m_result;
   private String emeso_main_search_table_id;
   private String module_barcode;
   private String emeso_manuorder_id;
   private String emeso_manuorder_code;
   private Date date_time;
   private String shift;
   private String line;
   private String cell_cutter;
   private String stringer;
   private String autobussing;
   private String first_el_test;
   private String lamination;
   private String layer;
   private String position;
   private String fvi_line;
   private String fvi_result;
   private String iv_power;
   private String iv_voc;
   private String iv_vmpp;
   private String iv_isc;
   private String iv_impp;
   private String iv_rs;
   private String iv_rsh;
   private String iv_temperature;
   private String iv_ff;
   private String ctm;
   private String current;
   private String cell_eff;
   private String cell_power;
   private String hi_pot;
   private String el_after;
   private String el_after_test;
   private String fqc_result;
   private String fqc_color;
   private String pack_towsign;
   private String ad_client_id;
   private String ad_org_id;
   private String isactive;
   private Date created;
   private String createdby;
   private Date updated;
   private String updatedby;
   private String module_type;
   private String auto;
   private String pm;
   private String towsign;
   private Date search_date;
   private String repairlocation;
   private String badcode;
   private String badposition;

   public ModuleInfoNum1 convertToNumeric1(){
      return ModuleInfoNum1.builder()
              .ad_client_id(this.ad_client_id)
              .ad_org_id(ad_org_id)
              .auto(this.auto)
              .autobussing(this.autobussing)
              .cell_cutter(this.cell_cutter)
              .cell_eff(this.cell_eff)
              .cell_power(this.cell_power)
              .created(this.created)
              .createdby(this.createdby)
              .ctm(this.ctm)
              .ctm1(this.ctm1)
              .curent(this.current)
              .cyj(this.cyj)
              .current_grade(this.current_grade)
              .date_time(this.date_time)
              .el_after(this.el_after)
              .el_after_test(this.el_after_test)
              .el_name(this.el_name)
              .emeso_main_search_table_id(this.emeso_main_search_table_id)
              .emeso_manuorder_code(this.emeso_manuorder_code)
              .first_el_test(this.first_el_test)
              .fqc_color(this.fqc_color)
              .fqc_result(this.fqc_result)
              .emeso_manuorder_id(this.emeso_manuorder_id)
              .fvi_line(this.fvi_line)
              .iv_power(this.iv_power)
              .fvi_result(this.fvi_result)
              .hi_pot(this.hi_pot)
              .isactive(this.isactive)
              .iv_voc(this.iv_voc)
              .iv_ff(this.iv_ff)
              .iv_impp(this.iv_impp)
              .iv_isc(this.iv_isc)
              .iv_rs(this.iv_rs)
              .iv_rsh(this.iv_rsh)
              .pm(this.pm)
              .iv_temperature(this.iv_temperature)
              .iv_vmpp(this.iv_vmpp)
              .lamination(this.lamination)
              .layer(this.layer)
              .line(this.line)
              .module_type(this.module_type)
              .module_barcode(this.module_barcode)
              .m_line(this.m_line)
              .m_result(this.m_result)
              .pack_towsign(this.pack_towsign)
              .position(this.position)
              .shift(this.shift)
              .stringer(this.stringer)
              .towsign(this.towsign)
              .updated(this.updated)
              .updatedby(this.updatedby)
              .search_date(this.search_date)
              .repairlocation(this.repairlocation)
              .badcode(this.badcode)
              .badposition(this.badposition)
              .build();
   }
   public ModuleInfoNum convertToNumeric(){
      return ModuleInfoNum.builder()
              .ad_client_id(this.ad_client_id)
              .ad_org_id(ad_org_id)
              .auto(this.auto)
              .autobussing(this.autobussing)
              .cell_cutter(this.cell_cutter)
              .cell_eff(this.cell_eff)
              .cell_power(this.cell_power.isEmpty()||this.cell_power.isBlank()||this.cell_power==null?0.0:Double.parseDouble(this.cell_power))
              .created(this.created)
              .createdby(this.createdby)
              .ctm(this.ctm)
              .ctm1(this.ctm1)
              .curent(this.current)
              .cyj(this.cyj)
              .current_grade(this.current_grade)
              .date_time(this.date_time)
              .el_after(this.el_after)
              .el_after_test(this.el_after_test)
              .el_name(this.el_name)
              .emeso_main_search_table_id(this.emeso_main_search_table_id)
              .emeso_manuorder_code(this.emeso_manuorder_code)
              .first_el_test(this.first_el_test)
              .fqc_color(this.fqc_color)
              .fqc_result(this.fqc_result)
              .emeso_manuorder_id(this.emeso_manuorder_id)
              .fvi_line(this.fvi_line)
              .iv_power(Double.parseDouble(Optional.ofNullable(this.iv_power).orElse("0")))
              .fvi_result(this.fvi_result)
              .hi_pot(this.hi_pot)
              .isactive(this.isactive)
              .iv_voc(Double.parseDouble(Optional.ofNullable(this.iv_voc).orElse("0")))
              .iv_ff(Double.parseDouble(Optional.ofNullable(this.iv_ff).orElse("0")))
              .iv_impp(Double.parseDouble(Optional.ofNullable(this.iv_impp).orElse("0")))
              .iv_isc(Double.parseDouble(Optional.ofNullable(this.iv_isc).orElse("0")))
              .iv_rs(Double.parseDouble(Optional.ofNullable(this.iv_rs).orElse("0")))
              .iv_rsh(Double.parseDouble(Optional.ofNullable(this.iv_rsh).orElse("0")))
              .pm(Double.parseDouble(Optional.ofNullable(this.pm).orElse("0")))
              .iv_temperature(Double.parseDouble(Optional.ofNullable(this.iv_temperature).orElse("0")))
              .iv_vmpp(Double.parseDouble(Optional.ofNullable(this.iv_vmpp).orElse("0")))
              .lamination(this.lamination)
              .layer(this.layer)
              .line(this.line)
              .module_type(this.module_type)
              .module_barcode(this.module_barcode)
              .m_line(this.m_line)
              .m_result(this.m_result)
              .pack_towsign(this.pack_towsign)
              .position(this.position)
              .shift(this.shift)
              .stringer(this.stringer)
              .towsign(this.towsign)
              .updated(this.updated)
              .updatedby(this.updatedby)
              .search_date(this.search_date)
              .repairlocation(this.repairlocation)
              .badcode(this.badcode)
              .badposition(this.badposition)
              .build();
   }
}
