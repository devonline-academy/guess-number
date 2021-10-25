/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package academy.devonline.guessnumber.component;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class Game {

    private final NumberGenerator numberGenerator;

    private final DataPrinter dataPrinter;

    private final UserInputReader userInputReader;

    private final GameOverHandler gameOverHandler;

    public Game(final NumberGenerator numberGenerator,
                final DataPrinter dataPrinter,
                final UserInputReader userInputReader,
                final GameOverHandler gameOverHandler) {
        this.numberGenerator = numberGenerator;
        this.dataPrinter = dataPrinter;
        this.userInputReader = userInputReader;
        this.gameOverHandler = gameOverHandler;
    }

    public void play() {
        final int number = numberGenerator.generate();
        while (true) {
            final int userCase = userInputReader.getUserInput();
            if (number > userCase) {
                dataPrinter.printInfoMessage("number > " + userCase + ". Try again:");
            } else if (number < userCase) {
                dataPrinter.printInfoMessage("number < " + userCase + ". Try again:");
            } else {
                dataPrinter.printInfoMessage("Congratulations, you guessed the number!");
                gameOverHandler.gameOver();
                break;
            }
        }
    }
}
