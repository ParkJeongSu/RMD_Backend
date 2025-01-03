package com.jspark.rdmbackend.repository;

import com.jspark.rdmbackend.dto.StateDto;
import com.jspark.rdmbackend.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State,Long> {

    @Query(value = """
            SELECT\s
            'A1machine3' AS objectName,
            'MachineState' AS stateName,
            'Run' AS stateValue
            FROM\s
            dual
            UNION
            SELECT\s
            'A1machine6' AS objectName,
            'MachineState' AS stateName,
            'Run' AS stateValue
            FROM\s
            dual
            UNION
            SELECT\s
            'T1machine1' AS objectName,
            'MachineState' AS stateName,
            'Down' AS stateValue
            FROM\s
            dual
            """,nativeQuery = true)
    List<StateDto> findAllState();
}
