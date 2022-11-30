/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enum;

import java.io.Serializable;

/**
 *
 * @author Esteb
 */
public enum eAttackType implements Serializable{
    BLOCK,
    CONTACT,
    AIR,
    IMPACT,
    MEDIUM_SCOPE,
    MULTIPLE_ATTACK;

    public static eAttackType getType(int i){
        switch(i) {
            case 0:
                return BLOCK;
            case 1:
                return CONTACT;
            case 2:
                return AIR;
            case 3:
                return IMPACT;
            case 4:
                return MEDIUM_SCOPE;
            case 5:
                return MULTIPLE_ATTACK;
            default:
                throw new Error("Attack type not found");

        }
    }
}
