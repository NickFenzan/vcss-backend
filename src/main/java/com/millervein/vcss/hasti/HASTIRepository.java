package com.millervein.vcss.hasti;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HASTIRepository extends JpaRepository<HASTI, Integer> {
//	@Query("SELECT CASE WHEN COUNT(v) > 0 THEN 'true' ELSE 'false' END FROM HASTI v WHERE v.pid = ?1 AND v.dos = ?2")
//    public Boolean existsByPidAndDos(Integer pid, LocalDate date);
	
	public HASTI findByPidAndDos(Integer pid, LocalDate dos);
}
