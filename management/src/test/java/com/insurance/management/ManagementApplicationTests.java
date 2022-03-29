package com.insurance.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.management.model.Approvals;
import com.insurance.management.model.Category;
import com.insurance.management.model.Disapproved;
import com.insurance.management.model.Policies;
import com.insurance.management.model.Queries;
import com.insurance.management.model.User;
import com.insurance.management.repository.ApprovalsRepository;
import com.insurance.management.repository.ApprovedRepository;
import com.insurance.management.repository.CategoryRepository;
import com.insurance.management.repository.DisapprovedRepository;
import com.insurance.management.repository.PoliciesRepository;
import com.insurance.management.repository.QueriesRepository;
import com.insurance.management.repository.UserRepository;

@SpringBootTest
class ManagementApplicationTests {
	@Autowired
	private ApprovalsRepository approvalsRepository;
	@Autowired
	private ApprovedRepository approvedRepository;
	@Autowired
	private DisapprovedRepository disapprovedRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PoliciesRepository policiesRepository;
	@Autowired
	private QueriesRepository queriesRepository;
	@Autowired
	private UserRepository userRepository;

	@Test
	public void addPolicy() {
		Policies policies = new Policies();
		policies.setPolicyId(1);
		policies.setPolicyName("Bheema");
		policies.setCategory("Bike");
		policies.setAmount(20.00);
		policies.setTenureInYears(5);
		policiesRepository.save(policies);
		assertNotNull(policiesRepository.findById(1).get());
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setUserid(2);
		user.setUserName("ankit");
		user.setMobile(7563425678L);
		user.setPassword("ankit123");
		user.setEmail("ankit@123");
		userRepository.save(user);
		assertNotNull(userRepository.findById("ankit").get());
	}

	@Test
	public void addQueries() {
		Queries queries = new Queries();
		queries.setUserName("ankit");
		queries.setQueryId(12);
		queries.setQuestion("anji");
		queries.setAnswer("ankit");
		queriesRepository.save(queries);
		assertNotNull(queriesRepository.findById("ankit").get());
	}

	@Test
	public void addCategory() {
		Category policycategory = new Category();
		policycategory.setCategory("Bike");
		categoryRepository.save(policycategory);
		assertNotNull(categoryRepository.findById("Bike").get());
	}

	@Test
	public void addApprovels() {
		Approvals approvals = new Approvals();
		approvals.setRequestId(8);
		approvals.setPolicyId(10);
		Date date = new Date();
		approvals.setDate(date);
		approvals.setStatus("pending");
		approvals.setUserName("ankit");
		approvalsRepository.save(approvals);
		assertNotNull(approvalsRepository.findById("ankit").get());
	}

	@Test
	public void addApproved() {
		com.insurance.management.model.Approved approved = new com.insurance.management.model.Approved();
		approved.setPolicyId(5);
		approved.setRequestId(2);
		Date date = new Date();
		approved.setDate(date);
		approved.setStatus("Success");
		approved.setUserName("ankit");
		approvedRepository.save(approved);
		assertNotNull(approvedRepository.findById("ankit").get());

	}

	@Test
	public void adddisApproved() {
		Disapproved disapproved = new Disapproved();
		disapproved.setPolicyId(10);
		disapproved.setRequestId(2);
		Date date = new Date();
		disapproved.setDate(date);
		disapproved.setStatus("Success");
		disapproved.setUserName("ankit");
		disapprovedRepository.save(disapproved);
		assertNotNull(disapprovedRepository.findById("ankit").get());

	}

	@Test
	public void policies() {
		List<Policies> list = policiesRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void user() {
		List<User> list = userRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void AllQueries() {
		List<Queries> list = queriesRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void categories() {
		List<Category> list = categoryRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void AllApprovals() {
		List<Approvals> list = approvalsRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void AllDisapproved() {
		List<Disapproved> list = disapprovedRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void AllApproved() {
		List<com.insurance.management.model.Approved> list = approvedRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void getPolicy() {
		Policies policies = policiesRepository.findById(1).get();
		assertEquals(5, policies.getTenureInYears());
	}

	@Test
	public void getUser() {
		User user = userRepository.findById("ankit").get();
		assertEquals("ankit", user.getUserName());
	}

	@Test
	public void Approval() {
		Approvals approvals = approvalsRepository.findById("ankit").get();
		assertEquals(8, approvals.getRequestId());
	}

	@Test
	public void getQuery() {
		Queries queries = queriesRepository.findById("ankit").get();
		assertEquals("what", queries.getQuestion());
	}

	@Test
	public void category() {
		Category category = categoryRepository.findById("Bike").get();
		assertEquals("Bike", category.getCategory());
	}

	@Test
	public void Approved() {
		com.insurance.management.model.Approved approved = approvedRepository.findById("ankit").get();
		assertEquals(5, approved.getPolicyId());
	}

	@Test
	public void Disapproved() {
		Disapproved disapproved = disapprovedRepository.findById("ankit").get();
		assertEquals(10, disapproved.getPolicyId());
	}

	@Test
	public void updatePolicy() {
		Policies policies = policiesRepository.findById(1).get();
		policies.setPolicyName("aayu");
		policies.setCategory("car");
		policies.setAmount(40.00);
		policies.setTenureInYears(10);
		policiesRepository.save(policies);
		assertNotEquals(20.00, policiesRepository.findById(1).get().getAmount());
		assertNotEquals("Bheema", policiesRepository.findById(1).get().getPolicyName());
		assertNotEquals("Bike", policiesRepository.findById(1).get().getCategory());
		assertNotEquals(5, policiesRepository.findById(1).get().getTenureInYears());
	}

	@Test
	public void updateUser() {
		User user = userRepository.findById("ankit").get();
		user.setUserName("ankit");
		user.setPassword("ankit1234");
		user.setMobile(8888888888L);
		user.setEmail("ankit123@123");
		userRepository.save(user);
		assertEquals("ankit", userRepository.findById("ankit").get().getUserName());
		assertNotEquals(7563425678L, userRepository.findById("ankit").get().getMobile());
		assertNotEquals("ankit123", userRepository.findById("ankit").get().getPassword());
		assertNotEquals("ankit@123", userRepository.findById("ankit").get().getPassword());
	}

	@Test
	public void updateQuery() {
		Queries queries = queriesRepository.findById("ankit").get();
		queries.setQuestion("what");
		queries.setAnswer("hi");
		queriesRepository.save(queries);
		assertNotEquals("san", queriesRepository.findById("ankit").get().getQuestion());
		assertNotEquals("ooo", queriesRepository.findById("ankit").get().getAnswer());
	}

	@Test
	public void deleteCategory() {
		categoryRepository.deleteById("Bike");
		assertThat(categoryRepository.existsById("Bike")).isFalse();
	}

}
