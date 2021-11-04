package com.yaytech.MesProject.repo.postgres;

import com.yaytech.MesProject.model.postgres.ModuleInfo;
import com.yaytech.MesProject.repo.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ModuleInfoRepo extends ReadOnlyRepository<ModuleInfo, Long> {

    @Query(nativeQuery = true, value = "SELECT rn, ctm1, current_grade, el_name, cyj, m_line, m_result, emeso_main_search_table_id, module_barcode, emeso_manuorder_id, emeso_manuorder_code, date_time, shift, line, cell_cutter, stringer, autobussing, first_el_test, lamination, layer, \"position\", fvi_line, fvi_result, iv_power, iv_voc, iv_vmpp, iv_isc, iv_impp, iv_rs, iv_rsh, iv_temperature, iv_ff, ctm, \"current\", cell_eff, cell_power, hi_pot, el_after, el_after_test, fqc_result, fqc_color, pack_towsign, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, module_type, auto, pm, towsign, search_date, repairlocation,badcode, badposition FROM public.main_search_october")
    public List<ModuleInfo> getData();

    @Query(nativeQuery = true, value = "SELECT rn, ctm1, current_grade, el_name, cyj, m_line, m_result, emeso_main_search_table_id, module_barcode, emeso_manuorder_id, emeso_manuorder_code, date_time, shift, line, cell_cutter, stringer, autobussing, first_el_test, lamination, layer, \"position\", fvi_line, fvi_result, iv_power, iv_voc, iv_vmpp, iv_isc, iv_impp, iv_rs, iv_rsh, iv_temperature, iv_ff, ctm, \"current\", cell_eff, cell_power, hi_pot, el_after, el_after_test, fqc_result, fqc_color, pack_towsign, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, module_type, auto, pm, towsign FROM public.main_search_1")
    public List<ModuleInfo> getOneDayData();



    @Procedure(procedureName = "getmainsearchtable")
    List<ModuleInfo> getmainsearchtable(String startDate, String endDate);
}
