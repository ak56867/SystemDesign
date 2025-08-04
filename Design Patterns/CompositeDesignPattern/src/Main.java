public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movie");

        FileSystem avengers = new File("Avengers");
        Directory comedyDirectory = new Directory("Comedy");

        movieDirectory.addFile(avengers);
        movieDirectory.addFile(comedyDirectory);

        FileSystem hera_pheri = new File("Hera Pheri");

        comedyDirectory.addFile(hera_pheri);

        movieDirectory.ls();
    }
}