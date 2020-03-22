package lk.pathum.utility.repository;

import lk.pathum.utility.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
