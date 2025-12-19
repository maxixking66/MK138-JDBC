package ir.maktabsharif138.jdbc;

import ir.maktabsharif138.jdbc.domains.BaseEntity;

public class JDBCApplication {

    static void main() {

        BaseEntity<Byte> byteInstance = new BaseEntity<>();
        byteInstance.setId((byte) 1);
        Byte id = byteInstance.getId();

        BaseEntity<Long> longInstance = new BaseEntity<>();
        longInstance.setId(1L);
        Long id1 = longInstance.getId();
    }

    public static void put(String key, Long value) {

    }
}

