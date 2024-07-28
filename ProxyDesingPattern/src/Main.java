public class Main {
    public static void main(String[] args) {

        try{
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("Admin", new EmployeeDo());
            System.out.println("Operation Successful");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}