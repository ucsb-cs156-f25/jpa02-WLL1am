package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.beans.Transient;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        Team t = new Team();
        t.setName("testName");
        t.addMember("testMember");
        assertTrue(t.equals(t));
    }

    @Test
    public void equals_different_class() {
        Team t = new Team();
        t.setName("testName");
        t.addMember("testMember");
        String str = "testString";
        assertFalse(t.equals(str));
    }

    @Test
    public void equals_same_name_and_members() {
        Team t1 = new Team();
        t1.setName("A");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team();
        t2.setName("A");
        t2.addMember("Alice");
        t2.addMember("Bob");
        assertTrue(t1.equals(t2));
    }

    @Test
    public void equals_same_name_diff_members() {
        Team t1 = new Team();
        t1.setName("A");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team();
        t2.setName("A");
        t2.addMember("Alice");
        t2.addMember("Charlie");
        assertFalse(t1.equals(t2));
    }

    @Test
    public void equals_diff_name_same_members() {
        Team t1 = new Team();
        t1.setName("A");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team();
        t2.setName("B");
        t2.addMember("Alice");
        t2.addMember("Bob");
        assertFalse(t1.equals(t2));
    }



    @Test
    public void hashCode_returns_same_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
