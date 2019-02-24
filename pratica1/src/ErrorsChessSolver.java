public class ErrorsChessSolver {

    public static void sizeError(){
        throw new ArithmeticException("Puzzle must be a square and with max size of 60x60!");
    }

    public static void puzzleCaseError(){
        throw new ArithmeticException("All the letters in puzzle must be upper case!");
    }

    // third error is what???

    public static void alphabeticCharsError(){
        throw new ArithmeticException("All words's characters must be alphabetic!");
    }

    public static void wordsSizeError(){
        throw new ArithmeticException("All words must have at least 3 characters!");
    }

    public static void duplicationInPuzzleError(){
        throw new ArithmeticException("All words must be in the puzzle and only once!");
    }

    public static void duplicatedOrRedundantWordsError(){
        throw new ArithmeticException("There cannot be duplicated or redundant words!");
    }
}
