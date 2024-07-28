public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDaoObj;

    EmployeeDaoProxy() {
        employeeDaoObj = new EmployeeDaoImpl();
    }
    @Override
    public void create(String client, EmployeeDo obj) throws Exception{
        if(client.equalsIgnoreCase("ADMIN")) {
            employeeDaoObj.create(client,obj);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, int employeeID) throws Exception{
        if(client.equalsIgnoreCase("ADMIN")) {
            employeeDaoObj.delete(client,employeeID);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeID) throws Exception{
        if(client.equalsIgnoreCase("ADMIN") || client.equalsIgnoreCase("USER")) {
            return employeeDaoObj.get(client,employeeID);
        }
        throw new Exception("Access Denied");
    }
}
