package com.armitage;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Day1 {

    public static int calculateEndPosition(List<String> input) throws Exception {

        int position = 50;

        for (String line : input) {

            if (line.isEmpty()) {
                break;
            }

            char directionChar = line.charAt(0);
            int distance = parseInt(line.substring(1));

            if (directionChar == 'L') {
                position -= distance;
            } else if (directionChar == 'R') {
                position += distance;
            } else {
                throw new Exception("Not a valid direction char");
            }

            position = position % 100;

            if (position < 0) {
                position += 100;
            }
        }

        return position;
    }

    public static int calculateTimesLandingOn0(List<String> input) throws Exception {

        int position = 50;
        int countOfLandingOn0 = 0;

        for (String line : input) {

            if (line.isEmpty()) {
                break;
            }

            char directionChar = line.charAt(0);
            int distance = parseInt(line.substring(1));

            if (directionChar == 'L') {
                position -= distance;
            } else if (directionChar == 'R') {
                position += distance;
            } else {
                throw new Exception("Not a valid direction char");
            }

            position = position % 100;

            if (position < 0) {
                position += 100;

            } else if (position == 0) {
                countOfLandingOn0++;
            }
        }

        return countOfLandingOn0;
    }

    public static int calculateTimesPassing0(List<String> input) throws Exception {

        int position = 50;
        int countOfPassing0 = 0;

        for (String line : input) {

            if (line.isEmpty()) {
                break;
            }

            char directionChar = line.charAt(0);
            int distance = parseInt(line.substring(1));

            if (directionChar == 'L') {
                position -= distance;
            } else if (directionChar == 'R') {
                position += distance;
            } else {
                throw new Exception("Not a valid direction char");
            }

            // if is negative and was not previously 0 then it's just passed 0
            if (position <= 0 && (distance + position) > 0) {
                countOfPassing0++;
            }

            countOfPassing0 += abs(position) / 100;
            position = position % 100;

            if (position < 0) {
                position += 100;
            }
        }

        return countOfPassing0;
    }
}
