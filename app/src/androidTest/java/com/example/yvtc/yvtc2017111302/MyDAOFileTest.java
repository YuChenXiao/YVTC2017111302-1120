package com.example.yvtc.yvtc2017111302;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.yvtc.yvtc2017111302.data.Student;
import com.example.yvtc.yvtc2017111302.data.StudentDAOFileImpl;
import com.example.yvtc.yvtc2017111302.data.StudentDAOMemoryImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by yvtc on 2017/11/15.
 */

@RunWith(AndroidJUnit4.class)
public class MyDAOFileTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImpl dao = new StudentDAOFileImpl(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);

    }
    @Test
    public void TestUpdate1() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImpl dao = new StudentDAOFileImpl(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));

        Student[] stus = dao.getData();
        Student s = stus[1];
        s.name = "TT";
        dao.update(s);
        Student[] stus2 = dao.getData();
        assertEquals(stus2[1].name, "TT");
    }
    @Test
    public void TestDelete1() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImpl dao = new StudentDAOFileImpl(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        Student s = stus[1];
        dao.delete(s);
        Student[] check = dao.getData();
        assertEquals(2, check.length);
    }
    @Test
    public void TestGetOne1() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImpl dao = new StudentDAOFileImpl(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] check = dao.getData();
        Student s = dao.getOneStudent(check[1].id);
        assertEquals(s.name, "BB");
    }
}
