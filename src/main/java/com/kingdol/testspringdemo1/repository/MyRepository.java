package com.kingdol.testspringdemo1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> executeNativeQuery(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();
//        List<Map<String, Object>> resultMapList = new ArrayList<>();
//        for (Object[] result : resultList) {
//            System.out.println(Arrays.toString(result));
//            Map<String, Object> resultMap = new HashMap<>();
//            for (int i = 0; i < result.length; i++) {
//                String columnName = ""+i;
//                resultMap.put(columnName, result[i]);
//            }
//            resultMapList.add(resultMap);
//        }
        //[1, 123456, aaaaaa]
        //[2, 123456, kingdol] 拿到的结果是只有值,name要自己封装
        return resultList;
    }

    public int executeNativeUpdate(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        return query.executeUpdate();
    }
}

