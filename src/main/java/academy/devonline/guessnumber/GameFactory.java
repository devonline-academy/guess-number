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

package academy.devonline.guessnumber;

import academy.devonline.guessnumber.component.DataPrinter;
import academy.devonline.guessnumber.component.Game;
import academy.devonline.guessnumber.component.GameOverHandler;
import academy.devonline.guessnumber.component.NumberGenerator;
import academy.devonline.guessnumber.component.UserInputReader;
import academy.devonline.guessnumber.component.console.ConsoleDataPrinter;
import academy.devonline.guessnumber.component.console.ConsoleGameOverHandler;
import academy.devonline.guessnumber.component.console.ConsoleUserInputReader;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GameFactory {

    public GameFactory(final String[] args) {
    }

    public Game create() {
        final NumberGenerator numberGenerator = new NumberGenerator();
        final DataPrinter dataPrinter = new ConsoleDataPrinter();
        final UserInputReader userInputReader = new ConsoleUserInputReader(dataPrinter);
        final GameOverHandler gameOverHandler = new ConsoleGameOverHandler();
        return new Game(numberGenerator, dataPrinter, userInputReader, gameOverHandler);
    }
}
