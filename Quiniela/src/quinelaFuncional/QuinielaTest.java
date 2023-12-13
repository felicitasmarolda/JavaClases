package quinelaFuncional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuinielaTest {
    Quiniela quiniela = new Quiniela();
    int betNumber1 = 1111;
    int betNumber2 = 2222;
    int betNumber3 = 0000;
    int betNumber4 = 1123;
    int betNumber5 = 123;
    int betNumber6 = 22;
    Gambler uniqua = new Gambler("Uniqua");
    Gambler tasha = new Gambler("Tasha");
    Gambler austin = new Gambler("Austin");
    Gambler pablo = new Gambler("Pablo");
    Gambler tyrone = new Gambler("Tyrone");
    @Before public void setUp(){
        quiniela = new Quiniela();
        betNumber1 = 1111;
        betNumber2 = 2222;
        betNumber3 = 0000;
        betNumber4 = 1123;
        betNumber5 = 123;
        betNumber6 = 22;
    }
    @Test
    public void test00NewQuinielaHazNoMoney() {
        assertEquals(0, quiniela.getMoneyPozo());
    }
    @Test public void test01QuinielaCanRegisterMoneyFromOneBetOnHeadNumber(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertEquals(100, quiniela.getMoneyPozo());
    }
    @Test public void test02QuinielaCanRegisterMoneyFromOneBetOnFirstFiveNumbers(){
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        assertEquals(200, quiniela.getMoneyPozo());
    }
    @Test public void test03QuinielaCanRegisterMoneyFromBetOnFirstTenNumbers(){
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        assertEquals(300, quiniela.getMoneyPozo());
    }
    @Test public void test04QuinielaCanRegisterMoneyFromBetOnLastThreeDigitsOfFirstNumber(){
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        assertEquals(400, quiniela.getMoneyPozo());
    }
    @Test public void test05QuinielaCanRegisterMoneyFromBetOnLastTwoDigitsOfFirstNumber(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        assertEquals(500, quiniela.getMoneyPozo());
    }
    @Test public void test06QuinielaCanRegisterMoneyFromBetOnHeadNumberAndFirstFiveNumbers(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        assertEquals(300, quiniela.getMoneyPozo());
    }
    @Test public void test07QuinielaCanRegisterMoneyFromBetOnHeadNumberAndFirstTenNumbers(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        assertEquals(400, quiniela.getMoneyPozo());
    }
    @Test public void test08QuinielaCanRegisterMoneyFromBetOnHeadNumberAndLastThreeDigitsOfFirstNumber(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        assertEquals(500, quiniela.getMoneyPozo());
    }
    @Test public void test09QuinielaCanCloseBetsWithNoBets(){
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(0, quiniela.getMoneyPozo());
    }
    @Test public void test10QuinielaCanCloseBetsWithOneBetOnHeadNumberAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(100, quiniela.getMoneyPozo());
        assertEquals(2000, quiniela.getReward(uniqua));
    }
    @Test public void test11QuinielaCanCloseBetsWithOneBetOnFirstFiveNumbersAndReward(){
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(200, quiniela.getMoneyPozo());
        assertEquals(2800, quiniela.getReward(tasha));
    }
    @Test public void test12QuinielaCanCloseBetsWithOneBetOnFirstTenNumbersAndReward(){
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(300, quiniela.getMoneyPozo());
        assertEquals(3000, quiniela.getReward(austin));
    }
    @Test public void test13QuinielaCanCloseBetsWithOneBetOnLastThreeDigitsOfFirstNumberAndReward(){
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        quiniela.closeBets(1123,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(400, quiniela.getMoneyPozo());
        assertEquals(3600, quiniela.getReward(pablo));
    }
    @Test public void test14QuinielaCanCloseBetsWithOneBetOnLastTwoDigitsOfFirstNumberAndReward(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        quiniela.closeBets(1122,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(500, quiniela.getMoneyPozo());
        assertEquals(1000, quiniela.getReward(tyrone));
    }
    @Test public void test15QuinielaCanCloseBetsWithOneBetOnHeadNumberAndFirstFiveNumbersAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(300, quiniela.getMoneyPozo());
        assertEquals(2000, quiniela.getReward(uniqua));
        assertEquals(2800, quiniela.getReward(tasha));
    }
    @Test public void test16QuinielaCanCloseBetsWithOneBetOnHeadNumberAndFirstTenNumbersAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(400, quiniela.getMoneyPozo());
        assertEquals(2000, quiniela.getReward(uniqua));
        assertEquals(3000, quiniela.getReward(austin));
    }
    @Test public void test17QuinielaCanCloseBetsWithOneBetOnHeadNumberAndLastThreeDigitsOfFirstNumberAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber4);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        quiniela.closeBets(1123,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(500, quiniela.getMoneyPozo());
        assertEquals(2000, quiniela.getReward(uniqua));
        assertEquals(3600, quiniela.getReward(pablo));
    }
    @Test public void test18QuinielaCanCloseAndReturnBetsOnHeadNumberThatDidNotWin(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.closeBets(2222,3333,4444,5555,6666,7777,8888,9999,1111,0000);
        assertEquals(100, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(uniqua));
    }
    @Test public void test19QuinielaCanCloseAndReturnBetsOnFirstFiveNumbersThatDidNotWin(){
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        quiniela.closeBets(1111,3333,4444,5555,6666,7777,8888,9999,2222,0000);
        assertEquals(200, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(tasha));
    }
    @Test public void test20QuinielaCanCloseAndReturnBetsOnFirstTenNumbersThatDidNotWin(){
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        quiniela.closeBets(1111,2222,4444,5555,6666,7777,8888,9999,3333,0400);
        assertEquals(300, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(austin));
    }
    @Test public void test21QuinielaCanCloseAndReturnBetsOnLastThreeDigitsOfFirstNumberThatDidNotWin(){
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(400, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(pablo));
    }
    @Test public void test22QuinielaCanCloseAndReturnBetsOnLastTwoDigitsOfFirstNumberThatDidNotWin(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(500, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(tyrone));
    }
    @Test public void test23QuinielaCanCloseAndReturnRewardsFromMultipleBets(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(1500, quiniela.getMoneyPozo());
        assertEquals(2000, quiniela.getReward(uniqua));
        assertEquals(2800, quiniela.getReward(tasha));
        assertEquals(3000, quiniela.getReward(austin));
        assertEquals(0, quiniela.getReward(pablo));
        assertEquals(0, quiniela.getReward(tyrone));
    }
    @Test public void test24QuinielaCanCloseAndReturnRewardsFromMultipleBetsWithSomeBetsNotWinning(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        quiniela.betWithFirstTenNumbers(austin,300,betNumber1);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        quiniela.closeBets(2222,3333,4444,5555,6666,7777,8888,9999,1111,0000);
        assertEquals(1500, quiniela.getMoneyPozo());
        assertEquals(0, quiniela.getReward(uniqua));
        assertEquals(2800, quiniela.getReward(tasha));
        assertEquals(3000, quiniela.getReward(austin));
        assertEquals(0, quiniela.getReward(pablo));
        assertEquals(1000, quiniela.getReward(tyrone));
    }
    @Test public void test25PersonCanNotCheckForRewardIfTheyDidNotBet(){
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertThrowsLike(() -> quiniela.getReward(uniqua), "Person did not bet");
    }
    @Test public void test26PersonCanNotCheckForRewardIfTheyDidNotBetEvenIfSomeoneElseDid(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertThrowsLike(() -> quiniela.getReward(tasha), "Person did not bet");
    }
    @Test public void test27GamblerCanNotBetTwiceWithTheSameType(){
        quiniela.betWithHeadNumber(tyrone,100,betNumber1);
        assertThrowsLike(() -> quiniela.betWithHeadNumber(tyrone,100,betNumber1), "This gambler has already bet");
    }
    @Test public void test28GamblerCanNotBetTwiceWithDifferentTypes(){
        quiniela.betWithHeadNumber(tyrone,100,betNumber1);
        assertThrowsLike(() -> quiniela.betWithFirstFiveNumbers(tyrone,100,betNumber2), "This gambler has already bet");
    }
    @Test public void test29CanNotBetWhenQuinielaIsClosed(){
        quiniela.closeBets(1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertThrowsLike(() -> quiniela.betWithHeadNumber(tyrone,100,betNumber1), "Can not bet when quiniela is closed");
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }


}
