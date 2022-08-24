import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterAccountReader {
    public static AccountManagement loadData(File file) throws FileNotFoundException {
        AccountManagement accountManagement = new AccountManagement();
        List<MasterAccountSecurity> masterAccountSecurityList = new ArrayList<>();
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            int numberOfLine = Integer.parseInt(line);
            for (int i = 1; i < numberOfLine + 1; i++) {
                line = scanner.nextLine();
                String[] integers = line.split(",");
                MasterAccountSecurity account = new MasterAccountSecurity(integers[0].trim(), integers[1].trim());
                masterAccountSecurityList.add(account);
            }
        }
        accountManagement.masterAccountSecurityList = masterAccountSecurityList;
        return accountManagement;
    }
}
