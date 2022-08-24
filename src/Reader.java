import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Users/namnguyenvu/IdeaProjects/BaiTapATu9/src/statistics.txt
public class Reader {
    public static AccountManagement loadData(File file) throws FileNotFoundException {
        AccountManagement accountManagement = new AccountManagement();
        List<AccountData> employeesList = new ArrayList<>();
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            int numberOfLine = Integer.parseInt(line);
            for (int i = 1; i < numberOfLine + 1; i++) {
                line = scanner.nextLine();
                String[] integers = line.split(",");
                AccountData account = new AccountData(integers[0].trim(), Integer.parseInt(integers[1].trim()),
                            Integer.parseInt(integers[2].trim()), Integer.parseInt(integers[3].trim()));
                employeesList.add(account);
            }
        }
        accountManagement.accountList = employeesList;
        return accountManagement;
    }
}
