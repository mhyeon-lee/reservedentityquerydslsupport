package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.group.GroupRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservedEntityQueryDslSupportApplicationTests {
	@Autowired
	private GroupRepository groupRepository;

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void withClass() {
		groupRepository.queryWithClassQueryDsl();
	}

	@Test
	public void withMetadata() {
		groupRepository.queryWithMetadataQueryDsl();
	}
}
