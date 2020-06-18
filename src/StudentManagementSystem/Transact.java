package StudentManagementSystem;

public class Transact {
    public static String TransactSQLInjection(String str)

    {

        return str.replaceAll(".*([';]+|(--)+).*", " ");

    }

}
