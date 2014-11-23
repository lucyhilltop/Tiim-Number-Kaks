package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Base interface for data items, so one JTable can be used to display different entities.
 */
public interface DisplayableItem {
	/**
	 * Id of entity.
	 */
	public Long getId();
	public String getName();
}
