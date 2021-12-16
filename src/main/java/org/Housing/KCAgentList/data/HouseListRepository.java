package org.Housing.KCAgentList.data;

import org.Housing.KCAgentList.models.HouseList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseListRepository extends CrudRepository<HouseList,Integer> {
}
