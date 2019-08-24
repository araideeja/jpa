package com.araideeja.jpa.policy;

import org.springframework.data.repository.CrudRepository;

public interface PolicyRepository  extends CrudRepository<Policy, Long>{
	Policy findByPolicyCode(String policyCode);
}
