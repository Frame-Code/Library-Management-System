package com.company.system.dao.interfaces;

import java.util.List;

import com.company.system.model.Devolution;
import com.company.system.model.User;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public interface DevolutionDao extends Dao<Devolution>{

    List<Devolution> findByStudent(User student);
}
