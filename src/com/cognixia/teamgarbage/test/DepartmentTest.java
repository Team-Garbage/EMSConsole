package com.cognixia.teamgarbage.test;

import com.cognixia.teamgarbage.main.Department;
import com.cognixia.teamgarbage.main.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

        public class DepartmentTest {

            @Test
            void test() {
                Department sales = new Department("Sales", 10000);
                Department finance = new Department("Finance", 20000);
                Department humanResources = new Department("Human Resources", 10000);

                //testing sales variables
                assertEquals(sales.getBudget(), 10000);
                assertNotEquals(sales.getBudget(), 1500);
                assertEquals(sales.getDepartmentName(), "Sales");

                //testing sales against other Department variables
                assertNotEquals(sales, finance);
                assertEquals(sales.getEmployees(), finance.getEmployees());
                assertEquals(sales.getBudget(), humanResources.getBudget());

                //testing finance variables
                assertEquals(finance.getBudget(), 20000);
                assertNotEquals(finance.getDepartmentName(), "Human Resources");
                assertEquals(finance.getDepartmentName(), "Finance");

                //testing finance against other departments
                assertNotEquals(finance, sales);
                assertNotEquals(finance, humanResources);
                assertNotEquals(finance.getBudget(), humanResources.getBudget());
                assertEquals(finance.getEmployees(), humanResources.getEmployees());

                Manager manager = new Manager("Luke", "Bell", 0);
                finance.addEmployee(manager);
                finance.setBudget(10000);

                assertNotEquals(finance.getEmployees(), humanResources.getEmployees());
                assertEquals(finance.getBudget(), humanResources.getBudget());
            }

        }
