package me.lzb.other.test.crh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZB
 */
public class EnumTest {


    public static List<String> build(Carriger[] aaa){
        for (Carriger c: aaa) {
            System.out.println(c.getType() + "<=============>" + c.getDesc());
        }
        return new ArrayList<>();
    }


    public static final Carriger[] aaa = {Carriger.TYPE_1};


    private enum Carriger{
        TYPE_1("T1", "1xxx"),
        TYPE_2("T2", "2xxx");

        private String type;
        private String desc;
        Carriger(String t1, String xxx) {
            this.type = t1;
            this.desc = xxx;
        }

        public String getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }
    }
}
