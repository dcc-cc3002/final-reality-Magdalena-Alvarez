package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest extends AbstractPlayerCharacterTest{
    private static final String knightName = "Johann";
    private static final String SWORD_NAME = "Slayer";
    private static final String ENEMY_NAME = "EMEMY";
    private static Knight testKnight;
    private Enemy enemytest;
    private final SwordWeapon swordTest= new SwordWeapon(SWORD_NAME);
    private final String axeName = "super Axe";
    private final String knifeName = "super Knife";
    private final AxeWeapon AxeTest= new AxeWeapon(axeName);
    private final KnifeWeapon knifeTest = new KnifeWeapon(knifeName);

    @BeforeEach
    void setUp(){
        basicSetUp();
        testKnight = new Knight(knightName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
    }
    @Test
    void constructorTest(){
        var expectedKnight = new Knight(knightName,turns);
        checkConstruction(expectedKnight,testKnight,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns),new Knight(ENEMY_NAME,turns));
    }

    @Test
    void equipTest(){
        checkEquippedWeapon(testKnight, swordTest);
        checkDead(testKnight, AxeTest,enemytest);
    }
    @Test
    void attackTest(){
        checkAttack(testKnight,swordTest,enemytest);
    }


    @Test
    void waitTurnTest() {
        testKnight.equip(knifeTest);
        checkWaitTurn(testKnight);
    }

}
