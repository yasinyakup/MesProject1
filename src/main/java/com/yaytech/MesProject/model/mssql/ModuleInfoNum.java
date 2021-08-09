package com.yaytech.MesProject.model.mssql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MAIN_SEARCH_TABLE_2")
public class ModuleInfoNum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rn;
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
    private Double iv_power;
    private Double iv_voc;
    private Double iv_vmpp;
    private Double iv_isc;
    private Double iv_impp;
    private Double iv_rs;
    private Double iv_rsh;
    private Double iv_temperature;
    private Double iv_ff;
    private String ctm;
    private String curent;
    private String cell_eff;
    private Double cell_power;
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
    private double pm;
    private String towsign;
}
