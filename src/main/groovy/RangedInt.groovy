class RangedInt {

    int min
    int max
    int value

    def RangedInt(int min, int max) {
        this.min = min
        this.max = max
    }

    def setValue(int value) {
        this.value = value
    }

    int getValue() {
         def result = value < max ? value : max
         this.value > min ? result : min
    }

}
