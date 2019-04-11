package com.popovanton.testcase.services;

import com.popovanton.testcase.model.Formid;
import com.popovanton.testcase.model.NotFinishedUsers;
import com.popovanton.testcase.model.OneHourActivityUser;
import com.popovanton.testcase.repositories.TestCaseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    EntityManager entityManager;
    private TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository, EntityManager entityManager) {
        this.testCaseRepository = testCaseRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<OneHourActivityUser> findUsersAndLastHourActivity() {
        List<OneHourActivityUser> list = new ArrayList<>();

        Query query = entityManager.createNativeQuery("select id, ssoid, formid," +
                " ts from test_case " +
                "where cast(ts as int) >=(select max(cast(ts as int)) from test_case)-(60*60)" +
                "order by ssoid asc, ts desc", OneHourActivityUser.class);

        query.getResultStream().forEach(i -> list.add((OneHourActivityUser)i));

        return list;
    }

    @Override
    public List<NotFinishedUsers> findNotFinishedUsers() {
        List <NotFinishedUsers> list = new ArrayList<>();

        Query query = entityManager.createNativeQuery("select distinct on (t.ssoid) t.ssoid," +
                "t.formid,t.subtype,t.type,t.ts," +
                "t.grp,t.orgid, t.id from test_case t " +
                "INNER JOIN (" +
                "select ssoid, max(ts) as mts from " +
                "test_case where subtype<>'send' group by ssoid) l " +
                "on t.ts=l.mts and t.ssoid = l.ssoid " +
                "group by t.ssoid,t.formid, t.grp, t.orgid,t.subtype, t.ts, t.type, t.id", NotFinishedUsers.class);

        query.getResultStream().forEach(i -> list.add((NotFinishedUsers)i));

        return list;
    }

    @Override
    public List<Formid> findTopFiveForms() {
        List<Formid> list = new ArrayList<>();

        Query query = entityManager.createNativeQuery("select formid, count(*) as count from " +
                "(select formid from test_case) as t " +
                "group by formid order by count desc limit 5", Formid.class);

        query.getResultStream().forEach(i -> list.add((Formid)i));
        return list;
    }
}
