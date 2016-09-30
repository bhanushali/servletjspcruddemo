<%-- 
    Document   : employeeList
    Created on : Sep 26, 2016, 3:27:08 PM
    Author     : MRuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.niit.entity.Employee" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee List will come here!</h1>
        
        <table>
            <tr>
                <th>
                    Employee Id
                </th>
                <th>
                    Employee Name
                </th>
                <th>
                    Department
                </th>
                <th colspan="2"></th>
            </tr>
            <%
                // got the employess from the request object
                List<Employee> employees = (List<Employee>)request.getAttribute("employees");                
                
                if(employees == null) {
            %>
                <tr>    
                    <td colspan="3">Not able to fetch any employee</td>
                </tr>

            <%
                }
                else {
                
                for(Employee emp : employees) {
                
            %>
            <tr>
                <td><%= emp.getId()%></td>
                <td><%= emp.getEmployeeName()%></td>
                <td><%= emp.getDepartment()%></td> 
                <td><a href="EmployeeController.do?operation=edit&id=<%= emp.getId()%>">Edit</a></td> 
                <td><a href="EmployeeController.do?operation=delete&id=<%= emp.getId()%>">Delete</a></td> 
            </tr>            
            
            <%
                } 
              }
            %>
            
        </table>
        
        <a href="EmployeeController.do?operation=create">Create New Employee</a>
        
        
    </body>
</html>
