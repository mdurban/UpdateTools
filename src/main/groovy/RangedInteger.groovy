class RangedInteger {

    int min
    int max
    int value

    def RangedInteger(int min, int max) {
        this.min = min
        this.max = max
    }

    def setValue(int value) {
        this.value = value
    }

    int getValue() {
         def result = value < max ? value : max
         value > min ? result : min
    }

}
