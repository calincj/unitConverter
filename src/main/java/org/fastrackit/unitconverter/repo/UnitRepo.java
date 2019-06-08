package org.fastrackit.unitconverter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.fastrackit.unitconverter.model.Unit;

@Repository
public interface UnitRepo extends JpaRepository<Unit, Long> {

    @Query(value = "select * from tbl_unit where type=:type and from_unit=:fromUnit and to_unit=:toUnit", nativeQuery = true)
    public List<Unit> findUnitByTypeAndName(@Param("type") String type, @Param("fromUnit") String fromUnit,
                                            @Param("toUnit") String toUnit);

    @Query(value = "select * from tbl_unit where type=:type", nativeQuery = true)
    public List<Unit> findUnitByType(@Param("type") String type);

}