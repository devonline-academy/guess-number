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

package academy.devonline.guessnumber.component.config;

import academy.devonline.guessnumber.model.config.UserInterface;

import static academy.devonline.guessnumber.model.config.UserInterface.CONSOLE;
import static academy.devonline.guessnumber.model.config.UserInterface.GUI;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        UserInterface userInterface = null;
        for (final String arg : args) {
            if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because user interface already set: '%s'!%n",
                            arg, userInterface
                    );
                }
            } else {
                System.err.printf("Unsupported command line argument: '%s'%n", arg);
            }
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        return new CommandLineArguments(userInterface);
    }

    /**
     * @author devonline
     * @link http://devonline.academy/java
     */
    public static class CommandLineArguments {

        private final UserInterface userInterface;

        private CommandLineArguments(final UserInterface userInterface) {
            this.userInterface = userInterface;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
