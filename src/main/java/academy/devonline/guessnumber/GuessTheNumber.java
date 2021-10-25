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

import java.util.Random;
import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GuessTheNumber {
    public static void main(final String[] args) {
        final int number = new Random().nextInt(10);
        while (true) {
            System.out.println("Please type a number between 0 and 9:");
            final int userCase = new Scanner(System.in).nextInt();
            if (number > userCase) {
                System.out.println("number > " + userCase + ". Try again:");
            } else if (number < userCase) {
                System.out.println("number < " + userCase + ". Try again:");
            } else {
                System.out.println("Congratulations, you guessed the number!");
                // Wait for enter pressed
                new Scanner(System.in).nextLine();
                break;
            }
        }
    }
}
