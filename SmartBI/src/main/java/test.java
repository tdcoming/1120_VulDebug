import utils.CoreUtil;

import java.io.UnsupportedEncodingException;
import static utils.CoreUtil.getRMIdecode;

public class test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String plaintext = "UserService checkVersion [\"2023-03-31 18:56:53\"]";
        String rmIencode = CoreUtil.getRMIencode(plaintext);
        System.out.println(rmIencode);

        String data = "zDp4Wp4gRip iIpiGZp4DRw6 /JV/uuu7uNf7NfN1/u71'/NOJM/NOJN/uu/JT";
        getRMIdecode(data);

    }
}