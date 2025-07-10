public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, EmployeeDo obj) throws Exception{
        System.out.println("Employee record added!!");
    }

    @Override
    public void delete(String client, int employeeID) throws Exception{
        System.out.println("Employee record removed!!");
    }

    @Override
    public EmployeeDo get(String client, int employeeID) throws Exception{
        System.out.println("Fetching from DB..");
        return new EmployeeDo();
    }
}
