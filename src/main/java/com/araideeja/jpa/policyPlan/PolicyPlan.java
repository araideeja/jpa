package com.araideeja.jpa.policyPlan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.araideeja.jpa.policy.Policy;

@Entity
public class PolicyPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_PLAN_ID_SEQ")
    @SequenceGenerator(sequenceName = "POLICY_PLAN_ID_SEQ", allocationSize = 1, name = "POLICY_PLAN_ID_SEQ")
	private Long id;
	
	private String name;

	@ManyToOne
	private Policy policy;
	
	public PolicyPlan() {
		super();
	}

	public PolicyPlan(String name, Long policyId) {
		super();
		this.name = name;
		this.policy = new Policy();
		this.policy.setId(policyId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "PolicyPlan [id=" + id + ", name=" + name + ", policy=" + policy + "]";
	}



	
}
