package com.araideeja.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.araideeja.jpa.policy.Policy;
import com.araideeja.jpa.policy.PolicyRepository;
import com.araideeja.jpa.policyPlan.PolicyPlan;
import com.araideeja.jpa.policyPlan.PolicyPlanRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(JpaApplication.class);
	
	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private PolicyPlanRepository policyPlanRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		addPolicy(2);
	
		policyRepository.findAll().forEach(c -> log.info(c.toString()));
		policyPlanRepository.findAll().forEach(c -> log.info(c.toString()));
	}

	private void addPolicy(int timeToAdd) {
		for(int i=1; i<= timeToAdd;i++) {
			Policy policy = new Policy("Pol" + i);
			policyRepository.save(policy);
			log.info(String.format("Add Policy %s", policy.toString()));
			addPolicyPlan(policy, 5 + i);
		}
	}

	private void addPolicyPlan(Policy policy, int timeToAdd) {
		for(int i=1;i<=timeToAdd;i++) {
			PolicyPlan policyPlan = new PolicyPlan("Plan" + i, policy.getId());
			policyPlanRepository.save(policyPlan);
			log.info(String.format("Add Policy Plan %s", policyPlan.toString()));
		}
	}

}
