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

package academy.devonline.guessnumber.component.console;

import academy.devonline.guessnumber.component.DataPrinter;
import academy.devonline.guessnumber.component.UserInputReader;

import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class ConsoleUserInputReader implements UserInputReader {

    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public int getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("Please type a number between 0 and 9:");
            final String line = new Scanner(System.in).nextLine();
            if (line.length() == 1) {
                final char ch = line.charAt(0);
                if (ch >= '0' && ch <= '9') {
                    return Integer.parseInt(line);
                }
            }
        }
    }
}
