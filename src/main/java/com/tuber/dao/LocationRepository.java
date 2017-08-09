package com.tuber.dao;

import java.util.List;
import org.springframework.data.repository.Repository;
import com.tuber.domain.Location;

public interface LocationRepository extends Repository<Location, Long>{
	Location save(Location location);
	
	List<Location> findAll();
}
