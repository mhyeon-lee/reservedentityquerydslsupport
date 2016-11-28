package com.example.group;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mhyeon.lee on 2016. 11. 28..
 */
@Entity(name = "test_group")
public class Group {
	@Id
	private Long id;

	private String name;
}
