package com.araideeja.jpa.policy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_ID_SEQ")
    @SequenceGenerator(sequenceName = "POLICY_ID_SEQ", allocationSize = 1, name = "POLICY_ID_SEQ")
	private Long id;

	private String policyCode;
	public Policy() {
		super();
	}
	public Policy(String policyCode) {
		super();
		this.policyCode = policyCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyCode=" + policyCode + "]";
	}

}
