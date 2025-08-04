import CalculatorLLD.ArithmeticExpression;
import CalculatorLLD.Expression;
import CalculatorLLD.Number;
import CalculatorLLD.Operation;
import FileSystemLLD.Directory;
import FileSystemLLD.File;
import FileSystemLLD.FileSystem;

public class Main {
    public static void main(String[] args) {
        //file system
        Directory movieDirectory = new Directory("Movie");

        FileSystem avengers = new File("Avengers");
        Directory comedyDirectory = new Directory("Comedy");

        movieDirectory.addFile(avengers);
        movieDirectory.addFile(comedyDirectory);

        FileSystem hera_pheri = new File("Hera Pheri");

        comedyDirectory.addFile(hera_pheri);

        movieDirectory.ls();

        //calculator
        Number two = new Number(2);
        Number one = new Number(1);
        Number seven = new Number(7);

        ArithmeticExpression addExpression = new Expression(one, seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(two, addExpression, Operation.MULTIPLY);

        System.out.println(parentExpression.evaluate());
    }
}