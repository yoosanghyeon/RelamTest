package yoosanghyeon.relamtest.data;

import io.realm.RealmObject;

/**
 * Created by yoosanghyeon on 2017-07-30.
 */

public class TestData extends RealmObject {

    String name;

    public TestData() {
    }

    public TestData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
