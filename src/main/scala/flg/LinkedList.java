package flg;

public class LinkedList {


/*
        [2, -1, 4, 5, 6]


        [2, -1, 4, 5, 6][2, -1, 4, 5, 6][2, -1, 4, 5, 6]

        0 = 2,
        2 = 4

        [2, -1, 4, 5, 6][2, -1, 4, 5, 6][2, -1, 4, 5, 6]
        1 = -1

        false


        [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]
        0 = 1

        [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]
        1 = 2

        [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]
        3 = 2

        [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]

        1 = 1

    acc = []
    O(~N)

    currPos = ?

    f = 1
    s = 1
            [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]

    f = 3 = 2
    s = 1 = 2
            [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]

    f = 1 = 2
    s = 3 = 2
            [1, 2, -1, 2, 2] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]

    f = 0 = 1
    s = 0 = 1
            [1, 2, -1, 2, 666] [1, 2, -1, 2, 2] [1, 2, -1, 2, 2]


            [2, 2, -1, 2, 666, 2]
    f = 0 = 2
    s = 0 = 2


            [2, 2, -1, 2, 666, 2]
    fs
            f = 2 = -1
false


    public boolean checkCycle([int] input) {
        if ///
        int l = input.length

        for(int start = 0; start < l; start++) {
            int f = start
            int s = start


            isSlowNext = true
            while (true) {
                f = (f + input[f]) % l
                if (input[f] <= 0) return false

                f = (f + input[f]) % l
                if (input[f] <= 0) return false
                s = (s + input[s]) % l

                if (f == s) return true
            }

        }

        return false
    }
*/

//~ O(N^2)

}
