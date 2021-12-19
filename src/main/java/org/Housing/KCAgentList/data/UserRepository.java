package org.Housing.KCAgentList.data;

import org.Housing.KCAgentList.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
