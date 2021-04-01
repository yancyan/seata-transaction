package com.star.account.domain.enums;

/**
 * 账户类型
 */
public enum AccountType {
    /**
     * 普通
     */
    NORMAL,

    /**
     * 押金
     */
    DEPOSIT,

    /**
     * 积分
     */
    BONUS_POINT;

    public static AccountType valueOf(int ordinal) {
        AccountType[] values = AccountType.values();
        if (ordinal >= values.length) {
            return null;
        } else {
            return values[ordinal];
        }
    }

}
