package com.example.group;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;

/**
 * Created by mhyeon.lee on 2016. 11. 28..
 */
@Repository
@Transactional
public class GroupRepository extends QueryDslRepositorySupport {
	public GroupRepository() {
		super(Group.class);
	}

	public void queryWithClassQueryDsl() {
		JPQLQuery query = from(QGroup.group);
		Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "name");
		getQuerydsl().applySorting(sort, query).fetch();
	}

	public void queryWithMetadataQueryDsl() {
		JPQLQuery query = from(QGroup.group);
		Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "name");

		Querydsl querydsl = new Querydsl(getEntityManager(), new PathBuilder<Object>(Group.class, QGroup.group.getMetadata()));
		querydsl.applySorting(sort, query).fetch();
	}
}
