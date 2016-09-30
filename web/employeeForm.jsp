<%-- 
    Document   : employeeForm
    Created on : Sep 30, 2016, 2:56:30 PM
    Author     : MRuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.Employee" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Employee emp = (Employee)request.getAttribute("employee");
        %>
        <form action = "EmployeeController.do?operation=save">
            <table>
                <tr>
                    <td>Enter Employee Name: </td>
                    <td>
                        <input name = "employeeName" type="text" value="<%= emp.getEmployeeName() %>"/>
                        <input name = "id" type="hidden" value="<%= emp.getId() %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Enter Department Name: </td>
                    <td>
                        <input name = "department" type="text" value="<%= emp.getDepartment() %>"/>                        
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"/></td>
                </tr>
                
            </table>
            
            
            
            
        </form>
            
            
            
    </body>
</html>
