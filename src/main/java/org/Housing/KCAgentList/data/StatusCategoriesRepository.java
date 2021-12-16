package org.Housing.KCAgentList.data;

import org.Housing.KCAgentList.models.StatusCategories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCategoriesRepository extends CrudRepository<StatusCategories,Integer> {
}
