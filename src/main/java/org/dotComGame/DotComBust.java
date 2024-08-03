package org.dotComGame;

import java.util.ArrayList;
import java.util.List;

public class DotComBust {
    //   Объявляем и инициализируем переменные которые нам понадобятся
    private static final GameHelper helper = new GameHelper();
    private final ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;
    private final List<String> moves = new ArrayList<>();
    List<String> validMoves = new ArrayList<>();
    List<String> pastMoves = new ArrayList<>();

    {
        fillValidMoves();
    }


    /**
     * Нужен для тестов (геттер)
     */
    public int getNumOfGuesses() {
        return numOfGuesses;
    }

    /**
     * Очистка консоли и изменение таблицы ходов
     */
    public void clearConsoleAndTableChange() {
        String[][] newTable = new String[helper.getGridSize() / helper.getGridLength()][helper.getGridLength() + 1];
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        for (int j = 0; j < newTable.length; j++) {
            for (int i = 0; i < newTable[j].length; i++) {
                if (pastMoves.contains(helper.getAlphabet().charAt(j) + Integer.toString(i))) {
                    System.out.print("-- ");
                } else {
                    System.out.print("" + helper.getAlphabet().charAt(j) + i + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setDotComsList(DotCom arrayList) {
        dotComsList.add(arrayList);
    }

    /**
     * Добавление доступных ходов пользователя в ArrayList validMoves
     */
    public void fillValidMoves() {
        for (int i = 0; i < helper.getGridSize() / helper.getGridLength(); i++) {
            for (int j = 0; j <= helper.getGridLength(); j++) {
                validMoves.add("" + helper.getAlphabet().charAt(i) + j);
            }
        }
    }

    private void setUpGame() {
//        Создадим 3 сайта, присвоим им имена и добавим в ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

//       Выводим краткие инструкции для пользователя.
        System.out.println("Ваша цель - потопить три сайта:");
        System.out.println("Pets.com , eToys.com , Go2.com");
        System.out.println("Попытайтесь потопить из за минимальное количество ходов");
        System.out.println("Укажите одну из указанных ячеек:");
        for (int j = 0; j < helper.getGridLength(); j++) {
            for (int i = 0; i <= helper.getGridSize() / helper.getGridLength(); i++) {
                System.out.print("" + helper.getAlphabet().charAt(j) + i + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (DotCom dotComToSet : dotComsList) { // Повторяем с каждым объектом DotCom в списке
            ArrayList<String> newLocation = helper.placeDotCom(3); // Запрашиваем у вспомогательного объекта местонахождение сайтов
            dotComToSet.setLocationSells(newLocation); // Вызываем сеттер, что бы передать местонахождение сайтов полученные с помощью вспомогательного объекта
            System.out.print(dotComToSet);
            System.out.println(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) { // До тех пор пока список объектов DotCom не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход:"); // Получаем пользовательский ввод
            pastMoves.add(userGuess);
            clearConsoleAndTableChange();
            System.out.println(checkUserGuess(userGuess)); // Вызываем наш метод checkUserGuess
        }
        finishGame(); // Вызываем метод finishGame
    }

    public GameStatus checkUserGuess(String userGuess) {

        if (!validMoves.contains(userGuess)) {
            return GameStatus.UNCORRECT;
        }
        if (moves.contains(userGuess)) {
            return GameStatus.WAS;
        }
        moves.add(userGuess);

        numOfGuesses++; // Инкрементируем количество попыток которые сделал пользователь

        GameStatus gameStatus = GameStatus.MISS;
        for (DotCom dotComToTest : dotComsList) { // Повторяем это для всех объектов dotCom в списке
            gameStatus = dotComToTest.checkYourself(userGuess); // Просим DotCom проверить ход пользователя

            if (gameStatus == GameStatus.HIT) {
                break; // Преднамеренно заканчиваем цикл
            }
            if (gameStatus == GameStatus.KILL) {
                dotComsList.remove(dotComToTest); // Удаляем из списка потопленный сайт
                return GameStatus.KILL;
            }
            if (gameStatus == GameStatus.WAS) {
                numOfGuesses--;
                break;
            }
        }
        return gameStatus;
    }

    private void finishGame() {
//        Выводим сообщение о том как пользователь прошел игру (Статистику)
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        } else {
            System.out.println("Это заняло у вас много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust(); // Создаем новый объект
        game.setUpGame(); // Говорим игровому объекту подготовить игру
        game.startPlaying(); // Говорим игровому объекту начать основной игровой цикл.
    }
}
