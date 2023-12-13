package quiniela;

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
        assertAfterBettingOnFiveNumbers(200);
    }
    @Test public void test03QuinielaCanRegisterMoneyFromBetOnFirstTenNumbers(){
        assertAfterBettingOnTenNumbers(300);
    }
    @Test public void test04QuinielaCanRegisterMoneyFromBetOnLastThreeDigitsOfFirstNumber(){
        assertAfterBettingOnTheLastThreeDigitsOfTheFirstNumber(400);
    }
    @Test public void test05QuinielaCanRegisterMoneyFromBetOnLastTwoDigitsOfFirstNumber(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        assertEquals(500, quiniela.getMoneyPozo());
    }
    @Test public void test06QuinielaCanRegisterMoneyFromBetOnHeadNumberAndFirstFiveNumbers(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertAfterBettingOnFiveNumbers(300);
    }
    @Test public void test07QuinielaCanRegisterMoneyFromBetOnHeadNumberAndFirstTenNumbers(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertAfterBettingOnTenNumbers(400);
    }
    @Test public void test08QuinielaCanRegisterMoneyFromBetOnHeadNumberAndLastThreeDigitsOfFirstNumber(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertAfterBettingOnTheLastThreeDigitsOfTheFirstNumber(500);
    }
    @Test public void test09QuinielaCanCloseBetsWithNoBets(){
        assertMoneyInPozoAfterClosingQuiniela(0,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }

    @Test public void test10QuinielaCanCloseBetsWithOneBetOnHeadNumberAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,100,2000,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }

    @Test public void test11QuinielaCanCloseBetsWithOneBetOnFirstFiveNumbersAndReward(){
        assertGetRewardAndMoneyInPozoAfterClosingQuinielaAndBettingWithFiveNumbers(2800);
    }

    @Test public void test12QuinielaCanCloseBetsWithOneBetOnFirstTenNumbersAndReward(){
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,austin,300,3000,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }
    @Test public void test13QuinielaCanCloseBetsWithOneBetOnLastThreeDigitsOfFirstNumberAndReward(){
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,pablo,400,3600,1123,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }
    @Test public void test14QuinielaCanCloseBetsWithOneBetOnLastTwoDigitsOfFirstNumberAndReward(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,tyrone,500,1000,1122,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }
    @Test public void test15QuinielaCanCloseBetsWithOneBetOnHeadNumberAndFirstFiveNumbersAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,300,2000,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(2800, quiniela.getReward(tasha));
    }
    @Test public void test16QuinielaCanCloseBetsWithOneBetOnHeadNumberAndFirstTenNumbersAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,400,2000,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(3000, quiniela.getReward(austin));
    }
    @Test public void test17QuinielaCanCloseBetsWithOneBetOnHeadNumberAndLastThreeDigitsOfFirstNumberAndReward(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber4);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,500,2000,1123,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertEquals(3600, quiniela.getReward(pablo));
    }
    @Test public void test18QuinielaCanCloseAndReturnBetsOnHeadNumberThatDidNotWin(){
        quiniela.betWithHeadNumber(pablo,100,betNumber1);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,pablo,100,0,2222,3333,4444,5555,6666,7777,8888,9999,1111,0000);
    }
    @Test public void test19QuinielaCanCloseAndReturnBetsOnFirstFiveNumbersThatDidNotWin(){
        assertGetRewardAndMoneyInPozoAfterClosingQuinielaAndBettingWithFiveNumbers(0);
    }
    @Test public void test20QuinielaCanCloseAndReturnBetsOnFirstTenNumbersThatDidNotWin(){
        quiniela.betWithFirstTenNumbers(austin,300,betNumber3);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,austin,300,0,1111,2222,3333,4444,5555,6666,7777,8888,9999,0400);
    }
    @Test public void test21QuinielaCanCloseAndReturnBetsOnLastThreeDigitsOfFirstNumberThatDidNotWin(){
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo,400,betNumber5);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,pablo,400,0,1111,2222,3333,4444,5555,6666,7777,8888,9999,0400);
    }
    @Test public void test22QuinielaCanCloseAndReturnBetsOnLastTwoDigitsOfFirstNumberThatDidNotWin(){
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone,500,betNumber6);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,tyrone,500,0,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }
    @Test public void test23QuinielaCanCloseAndReturnRewardsFromMultipleBets(){
        betWithAllFiveOptionsWithDifferentPeople(betNumber3);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,1500,2000,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
        assertGetRewardTashaAustinPabloTyrone(0);
    }

    @Test public void test24QuinielaCanCloseAndReturnRewardsFromMultipleBetsWithSomeBetsNotWinning(){
        betWithAllFiveOptionsWithDifferentPeople(betNumber1);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,uniqua,1500,0,2222,3333,4444,5555,6666,7777,8888,9999,1111,0000);
        assertGetRewardTashaAustinPabloTyrone(1000);
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
    @Test public void test30GamblerCanNotCheckForRewardIfQuinielaIsNotClosed(){
        quiniela.betWithHeadNumber(uniqua,100,betNumber1);
        assertThrowsLike(() -> quiniela.getReward(uniqua), "Can not get reward when quiniela is open");
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
    private void assertAfterBettingOnFiveNumbers(int expected) {
        quiniela.betWithFirstFiveNumbers(tasha, 200, betNumber2);
        assertEquals(expected, quiniela.getMoneyPozo());
    }
    private void assertAfterBettingOnTenNumbers(int expected) {
        quiniela.betWithFirstTenNumbers(austin, 300, betNumber3);
        assertEquals(expected, quiniela.getMoneyPozo());
    }
    private void assertAfterBettingOnTheLastThreeDigitsOfTheFirstNumber(int expected) {
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo, 400, betNumber5);
        assertEquals(expected, quiniela.getMoneyPozo());
    }
    private void assertMoneyInPozoAfterClosingQuiniela(int money, int ... winningNumbers) {
        quiniela.closeBets(winningNumbers);
        assertEquals(money, quiniela.getMoneyPozo());
    }
    private void assertGetRewardAndMoneyInPozoAfterClosingQuiniela(Quiniela quinielaX,Gambler name,int money, int rewardMoney, int ... winningNumbers) {
        assertMoneyInPozoAfterClosingQuiniela(money,winningNumbers);
        assertEquals(rewardMoney, quinielaX.getReward(name));
    }
    private void betWithAllFiveOptionsWithDifferentPeople(int betNumber3) {
        quiniela.betWithHeadNumber(uniqua, 100, betNumber1);
        quiniela.betWithFirstFiveNumbers(tasha, 200, betNumber2);
        quiniela.betWithFirstTenNumbers(austin, 300, betNumber3);
        quiniela.betWithLastThreeDigitsOfFirstNumber(pablo, 400, betNumber5);
        quiniela.betWithLastTwoDigitsOfFirstNumber(tyrone, 500, betNumber6);
    }
    private void assertGetRewardAndMoneyInPozoAfterClosingQuinielaAndBettingWithFiveNumbers(int rewardMoney) {
        quiniela.betWithFirstFiveNumbers(tasha,200,betNumber2);
        assertGetRewardAndMoneyInPozoAfterClosingQuiniela(quiniela,tasha,200,2800,1111,2222,3333,4444,5555,6666,7777,8888,9999,0000);
    }
    private void assertGetRewardTashaAustinPabloTyrone(int expected) {
        assertEquals(2800, quiniela.getReward(tasha));
        assertEquals(3000, quiniela.getReward(austin));
        assertEquals(0, quiniela.getReward(pablo));
        assertEquals(expected, quiniela.getReward(tyrone));
    }


}
