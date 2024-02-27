package com.example.javaspringjpa.entity.type;

import java.util.Arrays;

public enum UserStatus {

    DELETED {
        @Override
        public int getValue() {
            return -1;
        }
    },
    WAITING {
        @Override
        public int getValue() {
            return 0;
        }
    },
    VERIFIED {
        @Override
        public int getValue() {
            return 1;
        }
    };

    public static UserStatus findByValue(int value) {
        return Arrays.stream(UserStatus.values())
                .filter(userStatus -> userStatus.getValue() == value)
                .findFirst()
                .orElseThrow();
    }

    public abstract int getValue();
}
