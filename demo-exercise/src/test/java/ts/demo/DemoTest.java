package ts.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoTest {
    String id;
    String address1;
    String address2;

    public static void main(String[] args) {
        List<DemoTest> list = Arrays.asList(new DemoTest());
        Map<String, String> collect = list.stream()
                .collect(Collectors.toMap(DemoTest::getId, t -> t.address1 != null ? t.address1 : t.address1));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
