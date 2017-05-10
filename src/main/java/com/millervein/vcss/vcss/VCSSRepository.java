package com.millervein.vcss.vcss;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VCSSRepository extends JpaRepository<VCSS, Integer> {
//	@Query("SELECT CASE WHEN COUNT(v) > 0 THEN 'true' ELSE 'false' END FROM VCSS v WHERE v.pid = ?1 AND v.dos = ?2")
//    public Boolean existsByPidAndDos(Integer pid, LocalDate date);
	
	public VCSS findByPidAndDos(Integer pid, LocalDate dos);
}
